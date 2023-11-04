package cn.peyton.plum.mall.controller;

import cn.peyton.plum.mall.service.MaterialGroupService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 素材分组 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
@RestController
public class MaterialGroupController {

	@Resource
	private MaterialGroupService materialGroupService;

}
