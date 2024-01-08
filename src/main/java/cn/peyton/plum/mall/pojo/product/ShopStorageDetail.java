package cn.peyton.plum.mall.pojo.product;


import java.io.Serializable;
/**
 * <h3> 商品入库明细 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月29日 20:47:02
 * @version 1.0.0
 * </pre>
*/
public class ShopStorageDetail implements Serializable {
	/**   */
	private Long id;
	/** 商品规格明细Id  */
	private Long stockId;
	/** 数量（存入商品数量）  */
	private Integer quantity;
	/** 创建时间  */
	private Integer createTime;

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
	 * @param stockId 商品规格明细Id
	 */ 
	public void setStockId(Long stockId){
		this.stockId = stockId;
	}

	/** 
	 * @return 商品规格明细Id 
	 */ 
	public Long getStockId(){
		return stockId;
	}

	/** 
	 * @param quantity 数量（存入商品数量） 
	 */ 
	public void setQuantity(Integer quantity){
		this.quantity = quantity;
	}

	/** 
	 * @return 数量（存入商品数量） 
	 */ 
	public Integer getQuantity(){
		return quantity;
	}

	/** 
	 * @param createTime 创建时间 
	 */ 
	public void setCreateTime(Integer createTime){
		this.createTime = createTime;
	}

	/** 
	 * @return 创建时间 
	 */ 
	public Integer getCreateTime(){
		return createTime;
	}

}
