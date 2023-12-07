package cn.peyton.plum.mall.service.sys.impl;

import cn.peyton.plum.core.anno.timestamp.AutoWriteTimestamp;
import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.core.utils.LogUtils;
import cn.peyton.plum.core.utils.StrUtils;
import cn.peyton.plum.mall.bo.UserBo;
import cn.peyton.plum.mall.mapper.sys.MenuMapper;
import cn.peyton.plum.mall.mapper.sys.RoleMapper;
import cn.peyton.plum.mall.mapper.sys.UserMapper;
import cn.peyton.plum.mall.param.sys.UserParam;
import cn.peyton.plum.mall.pojo.sys.Menu;
import cn.peyton.plum.mall.pojo.sys.User;
import cn.peyton.plum.mall.service.sys.UserService;
import cn.peyton.plum.mall.utils.MenuUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3> 系统用户 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("userService")
public class UserServiceImpl extends AbstractRealizeService<Long, User, UserParam> implements UserService {

    private final String CACHE_KEY = "USERSERVICEIMPL-ALL";

    @Resource
    private UserMapper userMapper;

    @Override
    public BaseConvertBo<User, UserParam> initBo() {
        return new UserBo();
    }

    @Override
    public IBaseMapper<Long, User> initMapper() {
        return userMapper;
    }

    @Resource
    private RoleMapper roleMapper;
    @Resource
    private MenuMapper menuMapper;

    public UserServiceImpl(){
        enabledCache = true;
        keyPrefix = this.getClass().getName();
        LogUtils.info(keyPrefix);
    }


    @AutoWriteTimestamp
    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserParam reg(UserParam param) {
        User user = param.convert();
        //判断插入数据成功，给用户参数对象赋值，其中把密码 设 空
        int result = userMapper.insertSelective(user);
        if(result > 0){
            System.out.println("添加对象操作,清空缓存");
            cache.removeAll();
        }
        return (result > 0) ? param.compat(user) : null;
    }

    @Override
    public boolean checkStatus(String keyword, String type, Integer status) {
        return userMapper.checkStatus(keyword, type, status) > 0;
    }

    @Override
    public UserParam login(String keyword, String password, String loginType) {
        User user = userMapper.login(keyword, password, loginType);
        return (null == user) ? null : new UserParam().compat(user);
    }

    @Override
    public UserParam findJoinById(Long shareId, Integer shareType) {
        String key = keyPrefix + "find_join_id"+ StrUtils.join(shareId,shareType);
        if (enabledCache){
            Object list = cache.get(key);
            if (null != list) {
                System.out.printf("从缓存获取到对象: key= %s;\n",key);
                return (UserParam)list;
            }
        }
        User user = userMapper.selectByPrimaryKey(shareId);
        if (null != user) {
            List<Menu> menus = menuMapper.selectMenuListByShareIdAndType(shareId, shareType);
            // 递归查找赋值
            user.setMenuList(MenuUtils.reorganize(menus));
            UserParam _param = new UserParam().compat(user);
            // 转换规则
            List<String> rules = new ArrayList<>();
            if (null != menus && menus.size() > 0) {
                for (Menu menu : menus) {
                    if(null != menu.getCondition() && !"".equals(menu.getCondition())){
                        rules.add(menu.getCondition() + "," + menu.getRouterMethod());
                    }
                }
                _param.setRuleNames(rules);
            }
            if (enabledCache) {
                System.out.printf("添加对象到缓存: key= %s;\n",key);
                cache.put(key,_param);
            }
            return _param;
        }
        return null;
    }

    @Override
    public Boolean condition(String known) {
        return userMapper.condition(known) > 0;
    }

    @Override
    public Boolean isPassword(Long id, String password) {
        return userMapper.isPassword(id, password) > 0;
    }
}
