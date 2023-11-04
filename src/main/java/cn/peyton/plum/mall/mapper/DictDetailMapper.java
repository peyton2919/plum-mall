package cn.peyton.plum.mall.mapper;

import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.mall.pojo.DictDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3> 数据字典详情 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public interface DictDetailMapper {
	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(DictDetail record);

	/**
	 * <h4>根据 主键 删除 对象</h4>
	 * @param id 主键
	 * @return 受影响的行数
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(DictDetail record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	DictDetail selectByPrimaryKey(Long id);


	/**
	 * <h4>分页查询(全部或关键字模糊查找)</h4>
	 * @param keyword 关键字, 当keyword = null 时为全部查询
	 * @param page 分页对象
	 * @return 对象集合
	 */
	List<DictDetail> selectByAllOrKeyword(@Param("keyword") String keyword, @Param("page") PageQuery page);


	/**
	 * <h4>根据对象条件查找</h4>
	 * @param record 对象
	 * @param page 分页对象
	 * @return 对象集合
	 */
	List<DictDetail> selectByObj(DictDetail record, @Param("page") PageQuery page);


	/**
	 * <h4>查找全部数量(全部或关键字模糊查找)</h4>
	 * @param keyword 关键字, 当keyword = null 时为全部查询
	 * @return 总条数
	 */
	int count(@Param("keyword") String keyword);

	/**
	 * <h4>判断是否重名</h4>
	 * @param record 对象
	 * @return 大于0 表示 重名
	 */
	int isRename(DictDetail record);

	/**
	 * <h4>更新状态</h4>
	 * @param id 主键
	 * @param status 状态值
	 * @return 受影响行数 大于0 表示 成功
	 */
	int upStatus(@Param("id")Long id, @Param("status") Integer status);

	// ==================================== new create method ==================================== //


}
