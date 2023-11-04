package cn.peyton.plum.mall.param;

import cn.peyton.plum.mall.pojo.ShopProductSkuDetail;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * <h3> 商品规格详细表 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class ShopProductSkuDetailParam implements Serializable {
	/**   */
	private Long id;
	/** 商品ID  */
	private Long productId;
	/** 商品属性索引值 (attr_value|attr_value[|....])  */
	private String skus;
	/** 属性对应的库存  */
	private Integer stock;
	/** 销量  */
	private Integer sales;
	/** 封面图片  */
	private String cover;
	/** 唯一值  */
	private String uniqueCode;
	/** 商品条码  */
	private String barCode;
	/** 商品价格(批发)  */
	private BigDecimal price;
	/** 会员价格  */
	private BigDecimal vipPrice;
	/** 市场价  */
	private BigDecimal otPrice;
	/** 成本价  */
	private BigDecimal costPrice;
	/** 重量  */
	private BigDecimal weight;
	/** 体积  */
	private BigDecimal volume;
	/** 一级返佣  */
	private BigDecimal brokerage;
	/** 二级返佣  */
	private BigDecimal brokerageTwo;
	/** 拼团价  */
	private BigDecimal pinkPrice;
	/** 拼团库存  */
	private Integer pinkStock;
	/** 秒杀价  */
	private BigDecimal seckillPrice;
	/** 秒杀库存  */
	private Integer seckillStock;
	/** 需要多少积分兑换  */
	private Integer integral;
	/** 仓库Id  */
	private Integer warehouseId;
	/** 仓库说明  */
	private String warehouseExplain;

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
	 * @param skus 商品属性索引值 (attr_value|attr_value[|....]) 
	 */ 
	public void setSkus(String skus){
		this.skus = skus;
	}

	/** 
	 * @return 商品属性索引值 (attr_value|attr_value[|....]) 
	 */ 
	public String getSkus(){
		return skus;
	}

	/** 
	 * @param stock 属性对应的库存 
	 */ 
	public void setStock(Integer stock){
		this.stock = stock;
	}

	/** 
	 * @return 属性对应的库存 
	 */ 
	public Integer getStock(){
		return stock;
	}

	/** 
	 * @param sales 销量 
	 */ 
	public void setSales(Integer sales){
		this.sales = sales;
	}

	/** 
	 * @return 销量 
	 */ 
	public Integer getSales(){
		return sales;
	}

	/** 
	 * @param cover 封面图片 
	 */ 
	public void setCover(String cover){
		this.cover = cover;
	}

	/** 
	 * @return 封面图片 
	 */ 
	public String getCover(){
		return cover;
	}

	/** 
	 * @param uniqueCode 唯一值 
	 */ 
	public void setUniqueCode(String uniqueCode){
		this.uniqueCode = uniqueCode;
	}

	/** 
	 * @return 唯一值 
	 */ 
	public String getUniqueCode(){
		return uniqueCode;
	}

	/** 
	 * @param barCode 商品条码 
	 */ 
	public void setBarCode(String barCode){
		this.barCode = barCode;
	}

	/** 
	 * @return 商品条码 
	 */ 
	public String getBarCode(){
		return barCode;
	}

	/** 
	 * @param price 商品价格(批发) 
	 */ 
	public void setPrice(BigDecimal price){
		this.price = price;
	}

	/** 
	 * @return 商品价格(批发) 
	 */ 
	public BigDecimal getPrice(){
		return price;
	}

	/** 
	 * @param vipPrice 会员价格 
	 */ 
	public void setVipPrice(BigDecimal vipPrice){
		this.vipPrice = vipPrice;
	}

	/** 
	 * @return 会员价格 
	 */ 
	public BigDecimal getVipPrice(){
		return vipPrice;
	}

	/** 
	 * @param otPrice 市场价 
	 */ 
	public void setOtPrice(BigDecimal otPrice){
		this.otPrice = otPrice;
	}

	/** 
	 * @return 市场价 
	 */ 
	public BigDecimal getOtPrice(){
		return otPrice;
	}

	/** 
	 * @param costPrice 成本价 
	 */ 
	public void setCostPrice(BigDecimal costPrice){
		this.costPrice = costPrice;
	}

	/** 
	 * @return 成本价 
	 */ 
	public BigDecimal getCostPrice(){
		return costPrice;
	}

	/** 
	 * @param weight 重量 
	 */ 
	public void setWeight(BigDecimal weight){
		this.weight = weight;
	}

	/** 
	 * @return 重量 
	 */ 
	public BigDecimal getWeight(){
		return weight;
	}

	/** 
	 * @param volume 体积 
	 */ 
	public void setVolume(BigDecimal volume){
		this.volume = volume;
	}

	/** 
	 * @return 体积 
	 */ 
	public BigDecimal getVolume(){
		return volume;
	}

	/** 
	 * @param brokerage 一级返佣 
	 */ 
	public void setBrokerage(BigDecimal brokerage){
		this.brokerage = brokerage;
	}

	/** 
	 * @return 一级返佣 
	 */ 
	public BigDecimal getBrokerage(){
		return brokerage;
	}

	/** 
	 * @param brokerageTwo 二级返佣 
	 */ 
	public void setBrokerageTwo(BigDecimal brokerageTwo){
		this.brokerageTwo = brokerageTwo;
	}

	/** 
	 * @return 二级返佣 
	 */ 
	public BigDecimal getBrokerageTwo(){
		return brokerageTwo;
	}

	/** 
	 * @param pinkPrice 拼团价 
	 */ 
	public void setPinkPrice(BigDecimal pinkPrice){
		this.pinkPrice = pinkPrice;
	}

	/** 
	 * @return 拼团价 
	 */ 
	public BigDecimal getPinkPrice(){
		return pinkPrice;
	}

	/** 
	 * @param pinkStock 拼团库存 
	 */ 
	public void setPinkStock(Integer pinkStock){
		this.pinkStock = pinkStock;
	}

	/** 
	 * @return 拼团库存 
	 */ 
	public Integer getPinkStock(){
		return pinkStock;
	}

	/** 
	 * @param seckillPrice 秒杀价 
	 */ 
	public void setSeckillPrice(BigDecimal seckillPrice){
		this.seckillPrice = seckillPrice;
	}

	/** 
	 * @return 秒杀价 
	 */ 
	public BigDecimal getSeckillPrice(){
		return seckillPrice;
	}

	/** 
	 * @param seckillStock 秒杀库存 
	 */ 
	public void setSeckillStock(Integer seckillStock){
		this.seckillStock = seckillStock;
	}

	/** 
	 * @return 秒杀库存 
	 */ 
	public Integer getSeckillStock(){
		return seckillStock;
	}

	/** 
	 * @param integral 需要多少积分兑换 
	 */ 
	public void setIntegral(Integer integral){
		this.integral = integral;
	}

	/** 
	 * @return 需要多少积分兑换 
	 */ 
	public Integer getIntegral(){
		return integral;
	}

	/** 
	 * @param warehouseId 仓库Id 
	 */ 
	public void setWarehouseId(Integer warehouseId){
		this.warehouseId = warehouseId;
	}

	/** 
	 * @return 仓库Id 
	 */ 
	public Integer getWarehouseId(){
		return warehouseId;
	}

	/** 
	 * @param warehouseExplain 仓库说明 
	 */ 
	public void setWarehouseExplain(String warehouseExplain){
		this.warehouseExplain = warehouseExplain;
	}

	/** 
	 * @return 仓库说明 
	 */ 
	public String getWarehouseExplain(){
		return warehouseExplain;
	}

	/**
	 * <h4>对象转成ShopProductSkuDetail对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,productId,skus,stock,sales,cover,uniqueCode,barCode,price,vipPrice,otPrice,costPrice,weight,volume,brokerage,brokerageTwo,pinkPrice,pinkStock,seckillPrice,seckillStock,integral,warehouseId,warehouseExplain]
	 * </pre>
	 */
	public ShopProductSkuDetail convert(){
		ShopProductSkuDetail shopProductSkuDetail = new ShopProductSkuDetail(); 
		shopProductSkuDetail.setId(id);
		shopProductSkuDetail.setProductId(productId);
		shopProductSkuDetail.setSkus(skus);
		shopProductSkuDetail.setStock(stock);
		shopProductSkuDetail.setSales(sales);
		shopProductSkuDetail.setCover(cover);
		shopProductSkuDetail.setUniqueCode(uniqueCode);
		shopProductSkuDetail.setBarCode(barCode);
		shopProductSkuDetail.setPrice(price);
		shopProductSkuDetail.setVipPrice(vipPrice);
		shopProductSkuDetail.setOtPrice(otPrice);
		shopProductSkuDetail.setCostPrice(costPrice);
		shopProductSkuDetail.setWeight(weight);
		shopProductSkuDetail.setVolume(volume);
		shopProductSkuDetail.setBrokerage(brokerage);
		shopProductSkuDetail.setBrokerageTwo(brokerageTwo);
		shopProductSkuDetail.setPinkPrice(pinkPrice);
		shopProductSkuDetail.setPinkStock(pinkStock);
		shopProductSkuDetail.setSeckillPrice(seckillPrice);
		shopProductSkuDetail.setSeckillStock(seckillStock);
		shopProductSkuDetail.setIntegral(integral);
		shopProductSkuDetail.setWarehouseId(warehouseId);
		shopProductSkuDetail.setWarehouseExplain(warehouseExplain);
		return shopProductSkuDetail;
	} 
	/**
	 * <h4>ShopProductSkuDetail对象转成ShopProductSkuDetailParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,productId,skus,stock,sales,cover,uniqueCode,barCode,price,vipPrice,otPrice,costPrice,weight,volume,brokerage,brokerageTwo,pinkPrice,pinkStock,seckillPrice,seckillStock,integral,warehouseId,warehouseExplain]
	 * </pre>
	 */
	public ShopProductSkuDetailParam compat(ShopProductSkuDetail shopProductSkuDetail){ 
		if(null == shopProductSkuDetail){
			return new ShopProductSkuDetailParam();
		}
		this.setId(shopProductSkuDetail.getId());
		this.setProductId(shopProductSkuDetail.getProductId());
		this.setSkus(shopProductSkuDetail.getSkus());
		this.setStock(shopProductSkuDetail.getStock());
		this.setSales(shopProductSkuDetail.getSales());
		this.setCover(shopProductSkuDetail.getCover());
		this.setUniqueCode(shopProductSkuDetail.getUniqueCode());
		this.setBarCode(shopProductSkuDetail.getBarCode());
		this.setPrice(shopProductSkuDetail.getPrice());
		this.setVipPrice(shopProductSkuDetail.getVipPrice());
		this.setOtPrice(shopProductSkuDetail.getOtPrice());
		this.setCostPrice(shopProductSkuDetail.getCostPrice());
		this.setWeight(shopProductSkuDetail.getWeight());
		this.setVolume(shopProductSkuDetail.getVolume());
		this.setBrokerage(shopProductSkuDetail.getBrokerage());
		this.setBrokerageTwo(shopProductSkuDetail.getBrokerageTwo());
		this.setPinkPrice(shopProductSkuDetail.getPinkPrice());
		this.setPinkStock(shopProductSkuDetail.getPinkStock());
		this.setSeckillPrice(shopProductSkuDetail.getSeckillPrice());
		this.setSeckillStock(shopProductSkuDetail.getSeckillStock());
		this.setIntegral(shopProductSkuDetail.getIntegral());
		this.setWarehouseId(shopProductSkuDetail.getWarehouseId());
		this.setWarehouseExplain(shopProductSkuDetail.getWarehouseExplain());
		return this;
	} 
}
