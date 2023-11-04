package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.mall.service.DictService;
import cn.peyton.plum.mall.mapper.DictMapper;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

/**
 * <h3> 数据字典 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
@Service("dictService")
public class DictServiceImpl implements DictService {
	@Resource
	private DictMapper dictMapper;

}
