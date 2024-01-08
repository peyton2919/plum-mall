package cn.peyton.plum.mall.param.product;


import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.Size;
import cn.peyton.plum.mall.pojo.product.ShopStock;

import java.io.Serializable;

/**
 * <h3> 商品库存汇总 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月29日 20:46:35
 * @version 1.0.0
 * </pre>
*/
public class ShopStockParam implements Serializable {
	/**   */
	private Long id;
	/** 是否显示库存 默认 1显示 0隐藏   */
	@Size(min = 0,max = 1)
	private Integer isShow;
	/** 库存预警(默认0 不提示 >0 低于设置值 提示)  */
	@Min(message = "最小值为0")
	private Integer minStock;
	/** 总进货量  */
	private Integer total;
	/** 总支出(商品)与订单数量成正比  */
	private Integer payCount;
	/** 商品规格明细Id */
	private Long psdId;


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
	 * <h4>对象转成ShopStock对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,psdId,isShow,minStock,total,payCount]
	 * </pre>
	 */
	public ShopStock convert(){
		ShopStock shopStock = new ShopStock();
		shopStock.setId(id);
		shopStock.setPsdId(psdId);
		shopStock.setIsShow(isShow);
		shopStock.setMinStock(minStock);
		shopStock.setTotal(total);
		shopStock.setPayCount(payCount);
		return shopStock;
	} 
	/**
	 * <h4>ShopStock对象转成ShopStockParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,psdId,isShow,minStock,total,payCount]
	 * </pre>
	 */
	public ShopStockParam compat(ShopStock shopStock){
		if(null == shopStock){
			return new ShopStockParam();
		}
		this.setId(shopStock.getId());
		this.setPsdId(shopStock.getPsdId());
		this.setIsShow(shopStock.getIsShow());
		this.setMinStock(shopStock.getMinStock());
		this.setTotal(shopStock.getTotal());
		this.setPayCount(shopStock.getPayCount());
		return this;
	} 
}
