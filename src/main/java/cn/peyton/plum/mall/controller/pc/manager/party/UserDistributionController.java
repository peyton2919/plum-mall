package cn.peyton.plum.mall.controller.pc.manager.party;

import cn.peyton.plum.mall.service.party.UserDistributionService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 用户分销关联(包含: 会员Id、供应商Id、员工Id等,配合share_type一起使用) Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
public class UserDistributionController {

    @Resource
    private UserDistributionService userDistributionService;

}
