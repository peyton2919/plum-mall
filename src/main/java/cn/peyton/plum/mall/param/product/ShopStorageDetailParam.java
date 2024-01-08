package cn.peyton.plum.mall.param.product;


import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.mall.pojo.product.ShopStorageDetail;

import java.io.Serializable;
/**
 * <h3> 商品入库明细 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月29日 20:47:02
 * @version 1.0.0
 * </pre>
*/
public class ShopStorageDetailParam implements Serializable {
	/**   */
	private Long id;
	/** 商品规格明细Id  */
	private Long stockId;
	/** 数量（存入商品数量）  */
	private Integer quantity;
	/** 创建时间  */
	private String createTime;

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
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}

	/** 
	 * @return 创建时间 
	 */ 
	public String getCreateTime(){
		return createTime;
	}

	/**
	 * <h4>对象转成ShopStorageDetail对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,psdId,quantity,createTime]
	 * </pre>
	 */
	public ShopStorageDetail convert(){ 
		ShopStorageDetail shopStorageDetail = new ShopStorageDetail();
		shopStorageDetail.setId(id);
		shopStorageDetail.setStockId(stockId);
		shopStorageDetail.setQuantity(quantity);
		shopStorageDetail.setCreateTime(DateUtils.dateToTimestamp(createTime));
		return shopStorageDetail;
	} 
	/**
	 * <h4>ShopStorageDetail对象转成ShopStorageDetailParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,psdId,quantity,createTime]
	 * </pre>
	 */
	public ShopStorageDetailParam compat(ShopStorageDetail shopStorageDetail){ 
		if(null == shopStorageDetail){
			return new ShopStorageDetailParam();
		}
		this.setId(shopStorageDetail.getId());
		this.setStockId(shopStorageDetail.getStockId());
		this.setQuantity(shopStorageDetail.getQuantity());
		this.setCreateTime(DateUtils.timestampToStrDate(shopStorageDetail.getCreateTime()));
		return this;
	} 
}
