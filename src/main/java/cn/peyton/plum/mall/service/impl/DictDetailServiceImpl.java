package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.mall.service.DictDetailService;
import cn.peyton.plum.mall.mapper.DictDetailMapper;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

/**
 * <h3> 数据字典详情 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
@Service("dictDetailService")
public class DictDetailServiceImpl implements DictDetailService {
	@Resource
	private DictDetailMapper dictDetailMapper;

}
