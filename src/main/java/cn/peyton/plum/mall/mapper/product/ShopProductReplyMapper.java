package cn.peyton.plum.mall.mapper.product;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.mall.pojo.product.ShopProductReply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3> 商品评论 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface ShopProductReplyMapper extends IBaseMapper<Long, ShopProductReply> {


    /**
     * <h4>根据商品Id 外键 查找</h4>
     * @param productId 商品Id
     * @return
     */
    List<ShopProductReply> selectForeignKeyByProductId(Long productId);

    /**
     * <h4>根据商品Id 查找</h4>
     * @param productId 商品Id
     * @param page 分页对象
     * @param tab 选项内容 "" 全部; good 好评; middle 中评; bad 差评;
     * @return
     */
    List<ShopProductReply> selectByProductId(Long productId, PageQuery page,String tab);

    /**
     * <h4>根据商品Id 获取评论数量</h4>
     * @param productId 商品Id
     * @return
     */
    int countByProductId(Long productId);

    /**
     * <h4>删除 对象 {更新 is_del=0}</h4>
     * @param id 主键
     * @return 受影响的行数 > 0 成功
     */
    int updateIsDel(Long id);

    /**
     * <h4>更新管理员回复</h4>
     * @param id 主键Id
     * @param content 管理员回复内容
     * @param time 管理员回复时间
     * @return 受影响的行数 > 0 成功
     */
    int updateReview(@Param("id") Long id, @Param("content") String content, @Param("time") Integer time);

    // ==================================== new create method ==================================== //


}
