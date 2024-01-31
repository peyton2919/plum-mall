package cn.peyton.plum.mall.service.pub;

import cn.peyton.plum.core.inf.service.IBaseService;
import cn.peyton.plum.mall.param.pub.AdvertParam;
import cn.peyton.plum.mall.pojo.pub.Advert;

import java.util.List;

/**
 * <h3> 广告信息 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface AdvertService extends IBaseService<Long, Advert, AdvertParam> {
    /**
     *  <h4>删除</h4>
     * @param id 对象ID
     * @return
     */
    Boolean upDelete(Long id);

    /** ----------- android --------- */
    /**
     * <h4>单图查找</h4>
     * @return 对象
     */
    AdvertParam findByOne();

    /**
     * <h4>三图查找</h4>
     * @return 对象集合
     */
    List<AdvertParam> findByThree();

    /**
     * <h4>组合查找</h4>
     * @param imgType 图片类型  2:swiper: 轮播图; 3:导航：nav;
     * @param limit 随机返回的数量
     * @return 对象集合
     */
    List<AdvertParam> findBySwiperAndNav(Integer imgType,Integer limit);
}
