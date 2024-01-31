package cn.peyton.plum.mall.mapper.join;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.join.ShopArrearPool;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;

/**
 * <h3> 欠款汇总 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2024年01月30日 11:33:43
 * @version 1.0.0
 * </pre>
*/
public interface ShopArrearPoolMapper extends IBaseMapper<Long, ShopArrearPool> {

    /**
     * <h4>根据会员Id 查找 对象</h4>
     * @param memberId 会员Id
     * @return 对象
     */
    ShopArrearPool selectByMemberId(Long memberId);

    /**
     * <h4>计算总欠款余额</h4>
     * @return 总欠金额
     */
    @Select("select sum(balance) from tb_shop_arrear_pool where status=0")
    BigDecimal calcBalance();
}
