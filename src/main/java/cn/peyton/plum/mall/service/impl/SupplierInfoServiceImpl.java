package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.mall.service.SupplierInfoService;
import cn.peyton.plum.mall.mapper.SupplierInfoMapper;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

/**
 * <h3> 供应商基础信息 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
@Service("supplierInfoService")
public class SupplierInfoServiceImpl implements SupplierInfoService {
	@Resource
	private SupplierInfoMapper supplierInfoMapper;

}
