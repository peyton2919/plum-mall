package cn.peyton.plum.mall.service.impl;

import cn.peyton.plum.mall.service.UserLogService;
import cn.peyton.plum.mall.mapper.UserLogMapper;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

/**
 * <h3> 用户日志 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
@Service("userLogService")
public class UserLogServiceImpl implements UserLogService {
	@Resource
	private UserLogMapper userLogMapper;

}
