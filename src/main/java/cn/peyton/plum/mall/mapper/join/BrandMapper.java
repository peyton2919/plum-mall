package cn.peyton.plum.mall.mapper.join;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.mall.pojo.join.Brand;

import java.util.List;

/**
 * <h3> 品牌 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface BrandMapper extends IBaseMapper<Long, Brand> {


    /**
     * <h4>下拉框查找</h4>
     * <pre>
     *     `id`,`logo`,`name`,`area`
     *     用于下拉框使用
     * </pre>
     * @return 品牌对象集合
     */
    List<Brand> selectByDownList();

    /**
     * <h4>根据主键查找对象 {外键}</h4>
     * <pre>
     *     `id`,`sup_id`,`logo`,`name`,`area`
     * </pre>
     * @param id 主键
     * @return 对象
     */
    Brand selectByForeignKey(Long id);

    /**
     * <h4>随机获取品牌</h4>
     * @param limit 需要返回的记录数
     * @return 集合
     */
    List<Brand> selectAndroidRandom(Integer limit);
    // ==================================== new create method ==================================== //


}
