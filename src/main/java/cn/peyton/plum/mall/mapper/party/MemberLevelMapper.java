package cn.peyton.plum.mall.mapper.party;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.party.MemberLevel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <h3> 会员等级 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface MemberLevelMapper extends IBaseMapper<Integer, MemberLevel> {
    /**
     * <h4>根据会员类型查找</h4>
     * @param type 会员类型, 默认 0 零售 1 批发
     * @return 会员类型集合
     */
    @Select("select id,name from tb_member_level where status =1 and member_type=#{type} order by seq desc")
    List<MemberLevel> selectBySelect(Integer type);
    // ==================================== new create method ==================================== //


}
