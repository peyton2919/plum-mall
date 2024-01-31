package cn.peyton.plum.mall.controller.android.platform;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.cipher.BaseCipher;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.users.IUser;
import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.utils.IpUtils;
import cn.peyton.plum.core.validator.Regulation;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.controller.base.AndroidController;
import cn.peyton.plum.mall.param.party.MemberParam;
import cn.peyton.plum.mall.service.party.MemberService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.controller.android.platform.
 * @date 2024年01月27日 9:37
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/api")
public class ApiLoginController extends AndroidController {


    @Resource
    private MemberService memberService;

    @Valid
    @PostMapping("/login")
    public JSONResult<?> login(@NotBlank(message = "用户名不能为空！") String keyword,
                               @NotBlank(message = "密码不能为空！") String password,
                               HttpServletRequest request) {
        MemberParam member = new MemberParam();
        member.setLoginType(IUser.LOGIN_TYPE_ACCOUNT);
        if (Regulation.regex(Regulation.REGEX_EMAIL_ALL ,keyword)){
            member.setLoginType(IUser.LOGIN_TYPE_EMAIL);
        } else if ((Regulation.regex(Regulation.REGEX_PHONE, keyword))) {
            member.setLoginType(IUser.LOGIN_TYPE_PHONE);
        }
        // 判断是否可用 ,返回 true 表示应该用户被禁用
        if(memberService.checkStatus(keyword,member.getLoginType(),STATUS_0)){
            return JSONResult.fail("该用户已被禁用,请联系管理员。");
        }

        // 根据用户邮箱/手机号/账号 登录 ; 返回 为空表示 应该用户账号密码不正确 ;
        String _tmp = BaseCipher.encoderMD5(password, KEY_MEMBER_PASSWORD_ENCODER);
        MemberParam _param =  memberService.login(keyword, _tmp, member.getLoginType());
        if(null == _param){
            return JSONResult.fail("用户名称或密码错误。");
        }

        // 更新最后登录 IP
        member.setId(_param.getId());
        member.setLastIp(IpUtils.getRemoteIp(request));
        member.setLastLoginTime(DateUtils.timestampToStrDate(new Date()));
        if(!memberService.updateLastLogin(member)){
            return JSONResult.fail("用户登录异常,请联系管理员。");
        }
        _param.setUserType(IUser.TYPE_MEMBER);
        _param.setLoginType(member.getLoginType());
        _param.setToken(saveToken(_param));

        return JSONResult.success("用户登录成功", _param);
    }

    // 用户退出
    @Token
    @PostMapping("/logout")
    public JSONResult<?> logout() {
        if(verifyToken()){
            return JSONResult.success("退出成功");
        }
        return JSONResult.fail("非法 Token");
    }
}
