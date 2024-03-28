package cn.peyton.plum.mall.service.join;

import cn.peyton.plum.core.inf.service.base.IRealizeService;
import cn.peyton.plum.mall.param.join.BrandParam;
import cn.peyton.plum.mall.pojo.join.Brand;

import java.util.List;

/**
 * <h3> 品牌 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
public interface BrandService extends IRealizeService<Long, Brand, BrandParam> {
    /**
     *  <h4>删除</h4>
     * @param id 对象ID
     * @return
     */
    Boolean upDelete(Long id);

    /**
     * <h4>下拉框查找</h4>
     * <pre>
     *     `id`,`logo`,`name`,`area`
     *     用于下拉框使用
     * </pre>
     * @return 品牌对象集合
     */
    List<BrandParam> findByDownList();

    /**
     * <h4>随机获取品牌</h4>
     * @param limit 需要返回的记录数
     * @return 集合
     */
    List<BrandParam> findAndroidRandom(Integer limit);
}
