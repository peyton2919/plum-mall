package cn.peyton.plum.mall.pojo;


import java.io.Serializable;
/**
 * <h3> 订单购物详情 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class ShopOrderCartInfo implements Serializable {
	/**   */
	private Long id;
	/** 订单id  */
	private Long oid;
	/** 订单号  */
	private String orderId;
	/** 购物车id  */
	private Long cartId;
	/** 商品ID  */
	private Long productId;
	/** 购买东西的详细信息  */
	private String cartInfo;
	/** 唯一id  */
	private String uniqueCode;
	/** 是否能售后, 默认 1 {0不能 1 能}  */
	private Integer isAfterSales;

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
	 * @param oid 订单id 
	 */ 
	public void setOid(Long oid){
		this.oid = oid;
	}

	/** 
	 * @return 订单id 
	 */ 
	public Long getOid(){
		return oid;
	}

	/** 
	 * @param orderId 订单号 
	 */ 
	public void setOrderId(String orderId){
		this.orderId = orderId;
	}

	/** 
	 * @return 订单号 
	 */ 
	public String getOrderId(){
		return orderId;
	}

	/** 
	 * @param cartId 购物车id 
	 */ 
	public void setCartId(Long cartId){
		this.cartId = cartId;
	}

	/** 
	 * @return 购物车id 
	 */ 
	public Long getCartId(){
		return cartId;
	}

	/** 
	 * @param productId 商品ID 
	 */ 
	public void setProductId(Long productId){
		this.productId = productId;
	}

	/** 
	 * @return 商品ID 
	 */ 
	public Long getProductId(){
		return productId;
	}

	/** 
	 * @param cartInfo 购买东西的详细信息 
	 */ 
	public void setCartInfo(String cartInfo){
		this.cartInfo = cartInfo;
	}

	/** 
	 * @return 购买东西的详细信息 
	 */ 
	public String getCartInfo(){
		return cartInfo;
	}

	/** 
	 * @param uniqueCode 唯一id 
	 */ 
	public void setUniqueCode(String uniqueCode){
		this.uniqueCode = uniqueCode;
	}

	/** 
	 * @return 唯一id 
	 */ 
	public String getUniqueCode(){
		return uniqueCode;
	}

	/** 
	 * @param isAfterSales 是否能售后, 默认 1 {0不能 1 能} 
	 */ 
	public void setIsAfterSales(Integer isAfterSales){
		this.isAfterSales = isAfterSales;
	}

	/** 
	 * @return 是否能售后, 默认 1 {0不能 1 能} 
	 */ 
	public Integer getIsAfterSales(){
		return isAfterSales;
	}

}