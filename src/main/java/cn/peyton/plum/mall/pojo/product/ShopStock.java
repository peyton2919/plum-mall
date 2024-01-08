package cn.peyton.plum.mall.pojo.product;


import java.io.Serializable;

/**
 * <h3> 商品库存汇总 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月29日 20:46:35
 * @version 1.0.0
 * </pre>
*/
public class ShopStock implements Serializable {
	/**   */
	private Long id;
	/** 商品规格明细Id */
	private Long psdId;
	/** 是否显示库存 默认 1显示 0隐藏   */
	private Integer isShow;
	/** 库存预警(默认0 不提示 >0 低于设置值 提示)  */
	private Integer minStock;
	/** 总进货量  */
	private Integer total;
	/** 总支出(商品)与订单数量成正比  */
	private Integer payCount;


	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id  
	 */ 
	public void setId(Long id){
		this.id = id;
	}

	/** 
	 * @return  
	 */ 
	public Long getId(){
		return id;
	}

	/**
	 * @return 商品规格明细Id
	 */
	public Long getPsdId() {
		return psdId;
	}

	/**
	 * @param psdId 商品规格明细Id
	 */
	public void setPsdId(Long psdId) {
		this.psdId = psdId;
	}

	/** 
	 * @param isShow 是否显示库存 默认 1显示 0隐藏  
	 */ 
	public void setIsShow(Integer isShow){
		this.isShow = isShow;
	}

	/** 
	 * @return 是否显示库存 默认 1显示 0隐藏  
	 */ 
	public Integer getIsShow(){
		return isShow;
	}

	/** 
	 * @param minStock 库存预警(默认0 不提示 >0 低于设置值 提示) 
	 */ 
	public void setMinStock(Integer minStock){
		this.minStock = minStock;
	}

	/** 
	 * @return 库存预警(默认0 不提示 >0 低于设置值 提示) 
	 */ 
	public Integer getMinStock(){
		return minStock;
	}

	/** 
	 * @param total 总进货量 
	 */ 
	public void setTotal(Integer total){
		this.total = total;
	}

	/** 
	 * @return 总进货量 
	 */ 
	public Integer getTotal(){
		return total;
	}

	/** 
	 * @param payCount 总支出(商品)与订单数量成正比 
	 */ 
	public void setPayCount(Integer payCount){
		this.payCount = payCount;
	}

	/** 
	 * @return 总支出(商品)与订单数量成正比 
	 */ 
	public Integer getPayCount(){
		return payCount;
	}


}
