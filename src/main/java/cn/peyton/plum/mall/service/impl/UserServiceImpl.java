package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.core.anno.timestamp.AutoWriteTimestamp;
import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractAppRealizeService;
import cn.peyton.plum.core.utils.LogUtils;
import cn.peyton.plum.mall.bo.UserBo;
import cn.peyton.plum.mall.mapper.MenuMapper;
import cn.peyton.plum.mall.mapper.RoleMapper;
import cn.peyton.plum.mall.mapper.UserMapper;
import cn.peyton.plum.mall.param.UserParam;
import cn.peyton.plum.mall.pojo.User;
import cn.peyton.plum.mall.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class UserServiceImpl extends AbstractAppRealizeService<Long, User, UserParam> implements UserService {

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
        keyProfix = this.getClass().getName();
        LogUtils.info(keyProfix);
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
        if (cache.get(CACHE_KEY + shareType + shareId) != null) {
            System.out.println("从缓存中读到数据");
            return (UserParam) cache.get(CACHE_KEY + shareType + shareId);
        }

        User user = userMapper.selectByPrimaryKey(shareId);
        // todo 后期 需要配置缓存
        if (null != user) {
            user.setRole(roleMapper.selectByShareIdAndType(shareId,shareType));
            user.setMenuList(menuMapper.selectMenuListByShareIdAndType(shareId,shareType));
            UserParam _param = new UserParam().compat(user);
            cache.put(CACHE_KEY + shareType + shareId, _param);
            return _param;
        }
        return null;
    }
}
