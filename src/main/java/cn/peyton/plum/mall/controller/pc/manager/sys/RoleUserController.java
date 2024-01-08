package cn.peyton.plum.mall.controller.pc.manager.sys;

import cn.peyton.plum.mall.service.sys.RoleUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 用户角色关联 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
public class RoleUserController {

    @Resource
    private RoleUserService roleUserService;

}
