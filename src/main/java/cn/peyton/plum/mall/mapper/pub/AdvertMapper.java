package cn.peyton.plum.mall.mapper.pub;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.pub.Advert;

import java.util.List;

/**
 * <h3> 广告信息 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface AdvertMapper extends IBaseMapper<Long, Advert> {
    /**
     * <h4>单图查找</h4>
     * @return 对象
     */
    Advert selectByOne();

    /**
     * <h4>三图查找</h4>
     * @return 对象集合
     */
    List<Advert> selectByThree();

    /**
     * <h4>组合查找</h4>
     * @param imgType 图片类型  2:swiper: 轮播图; 3:导航：nav;
     * @param limit 随机返回的数量
     * @return 对象集合
     */
    List<Advert> selectBySwiperAndNav(Integer imgType,Integer limit);
    // ==================================== new create method ==================================== //


}
