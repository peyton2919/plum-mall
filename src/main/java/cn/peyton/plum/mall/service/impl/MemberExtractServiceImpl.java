package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.mall.service.MemberExtractService;
import cn.peyton.plum.mall.mapper.MemberExtractMapper;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

/**
 * <h3> 用户提现 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
@Service("memberExtractService")
public class MemberExtractServiceImpl implements MemberExtractService {
	@Resource
	private MemberExtractMapper memberExtractMapper;

}
