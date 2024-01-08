package cn.peyton.plum.mall.mapper.party;

import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.mapper.IUserMapper;
import cn.peyton.plum.mall.pojo.party.Supplier;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <h3> 供应商信息 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
public interface SupplierMapper extends IBaseMapper<Long, Supplier>, IUserMapper<Supplier> {

    /**
     * <h4>根据 id 简单查找 {外键}</h4>
     * <pre>
     *     `id`,`name`,`login_name`,`avatar`,`phone`,`create_time`
     * </pre>
     * @param id 主键
     * @return 供应商对象
     */
    Supplier selectByForeignKey(Long id);

    /**
     * <h4>下拉框查找</h4>
     * <pre>
     *     `id`,`username`,`email`,`login_name`,`avatar`,`phone`,`create_time`
     *     用于下拉框使用
     * </pre>
     * @return 供应商对象集合
     */
    List<Supplier> selectByDownList();

    /**
     * <h4>更新供应商基础信息Id</h4>
     * @param id 供应商Id
     * @param infoId 供应商基础信息Id
     * @return 受影响行数 > 0 成功
     */
    @Update("update tb_supplier set info_id = #{infoId} where id = #{id} and is_del = 1")
    int updateInfo(Long id, Long infoId);

    // ==================================== new create method ==================================== //

    /**
     * <h>更新状态</h>
     * @param id 主键Id
     * @param status 状态值 1 可用 0 禁用
     * @return 受影响行数 > 0 成功
     */
    @Update("update tb_supplier set status=#{status} where id=#{id} and is_del = 1")
    int upStatus(Long id, Integer status);
}
