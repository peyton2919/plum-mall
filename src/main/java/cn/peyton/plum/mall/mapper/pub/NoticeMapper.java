package cn.peyton.plum.mall.mapper.pub;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.pub.Notice;

/**
 * <h3> 公告 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface NoticeMapper extends IBaseMapper<Long, Notice> {


    // ==================================== new create method ==================================== //
    /**
     * <h4>判断有没有关联分类</h4>
     * @param cateId 分类Id
     * @return 受影响的行数 有关联 大于 0
     */
    int joinGroup(Integer cateId);

}
