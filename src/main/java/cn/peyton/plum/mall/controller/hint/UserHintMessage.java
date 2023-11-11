package cn.peyton.plum.mall.controller.hint;

import cn.peyton.plum.mall.controller.base.PcController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.controller.hint.
 * @date 2023年11月11日 19:10
 * @version 1.0.0
 * </pre>
 */
@Controller
public class UserHintMessage extends PcController {

    @Value(value = "${user.password} ${base.not.null}")
    protected String PASSWORD_NOT_NULL;
    @Value(value = "${user.phone} ${base.not.null}")
    protected String PHONE_NOT_NOLL;
}
