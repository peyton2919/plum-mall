package cn.peyton.plum.mall.service.party;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.mall.param.party.ContactParam;
import cn.peyton.plum.mall.pojo.party.Contact;

/**
 * <h3> 通讯录 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月11日 20:51:29
 * @version 1.0.0
 * </pre>
*/
public interface ContactService extends IBaseService<Integer, Contact, ContactParam> {

    /**
     * <h4>根据分组Id 判断是否被使用</h4>
     * @param groupId 分组Id
     * @return true 表示 分组 被使用不能删除
     */
    Boolean isContactGroup(Integer groupId);

}
