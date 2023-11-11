package cn.peyton.plum.mall.service;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.mall.param.UserAddressParam;
import cn.peyton.plum.mall.pojo.UserAddress;

/**
 * <h3> 用户地址{用户ID(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用)} Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:53
 * @version 1.0.0
 * </pre>
 */
public interface UserAddressService extends IBaseService<Long, UserAddress, UserAddressParam> {

}
