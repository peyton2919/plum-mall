package cn.peyton.plum.mall.mapper.pub;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.pub.NoticeCategory;

import java.util.List;

/**
 * <h3> 公告类型 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface NoticeCategoryMapper extends IBaseMapper<Integer, NoticeCategory> {

    // ==================================== new create method ==================================== //

    /**
     * <h4>下拦框选择列表</h4>
     * @return 对象集合 {id,name}
     */
    List<NoticeCategory> selectByAll();

}
