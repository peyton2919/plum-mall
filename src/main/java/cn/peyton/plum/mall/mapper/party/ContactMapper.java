package cn.peyton.plum.mall.mapper.party;


import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.party.Contact;
import org.apache.ibatis.annotations.Select;

/**
 * <h3> 通讯录 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月11日 20:51:29
 * @version 1.0.0
 * </pre>
*/
public interface ContactMapper extends IBaseMapper<Integer, Contact> {

    /**
     * <h4>根据分组Id 判断是否被使用</h4>
     * @param groupId 分组Id
     * @return 行数 > 0 表示 分组 被使用不能删除
     */
    @Select("select count(id) from tb_contact where group_id = #{groupId}")
    int isContactGroup(Integer groupId);

}
