package cn.peyton.plum.mall.param;

import cn.peyton.plum.mall.pojo.ShopProduct;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * <h3> 商品信息 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class ShopProductParam implements Serializable {
	/** 商品id  */
	private Long id;
	/** 商品图片  */
	private String image;
	/** 轮播图  */
	private String sliderImage;
	/** 商品名称  */
	private String name;
	/** 商品简介  */
	private String info;
	/** 关键字  */
	private String keyword;
	/** 产品分类id  */
	private Integer cateId;
	/** 商品价格(批发)  */
	private BigDecimal price;
	/** 会员价格  */
	private BigDecimal vipPrice;
	/** 市场价  */
	private BigDecimal otPrice;
	/** 成本价  */
	private BigDecimal costPrice;
	/** 邮费  */
	private BigDecimal postage;
	/** 单位名  */
	private String unitName;
	/** 排序，默认为0; 按大到小排序  */
	private Integer seq;
	/** 销量, 默认 0  */
	private Integer sales;
	/** 库存, 默认 0  */
	private Integer stock;
	/** 状态（0：未上架，1：上架）  */
	private Integer isShow;
	/** 是否热卖  */
	private Integer isHot;
	/** 是否优惠  */
	private Integer isBenefit;
	/** 是否精品  */
	private Integer isBest;
	/** 是否新品  */
	private Integer isNew;
	/** 产品描述  */
	private String explain;
	/** 添加时间  */
	private Integer createTime;
	/** 更新时间  */
	private Integer updateTime;
	/** 是否包邮  */
	private Integer isPostage;
	/** 是否删除  */
	private Integer isDel;
	/** 获得积分  */
	private Integer giveIntegral;
	/** 是否优品推荐, 默认0 {0 不是 1 是}  */
	private Integer isGood;
	/** 虚拟销量  */
	private Integer ficti;
	/** 浏览量(每浏览一次加 1)  */
	private Integer browse;
	/** 产品二维码地址(用户小程序海报)  */
	private String codePath;
	/** 是否单独分佣, 默认 0 没有 1 有  */
	private Integer isSub;
	/** 运费模板ID  */
	private Integer tempId;
	/** 规格 0单 1多  */
	private Integer specType;
	/** 是否开启积分兑换, 默认0 { 0没开启 1 开启}  */
	private Integer isIntegral;
	/** 需要多少积分兑换  */
	private Integer integral;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id 商品id 
	 */ 
	public void setId(Long id){
		this.id = id;
	}

	/** 
	 * @return 商品id 
	 */ 
	public Long getId(){
		return id;
	}

	/** 
	 * @param image 商品图片 
	 */ 
	public void setImage(String image){
		this.image = image;
	}

	/** 
	 * @return 商品图片 
	 */ 
	public String getImage(){
		return image;
	}

	/** 
	 * @param sliderImage 轮播图 
	 */ 
	public void setSliderImage(String sliderImage){
		this.sliderImage = sliderImage;
	}

	/** 
	 * @return 轮播图 
	 */ 
	public String getSliderImage(){
		return sliderImage;
	}

	/** 
	 * @param name 商品名称 
	 */ 
	public void setName(String name){
		this.name = name;
	}

	/** 
	 * @return 商品名称 
	 */ 
	public String getName(){
		return name;
	}

	/** 
	 * @param info 商品简介 
	 */ 
	public void setInfo(String info){
		this.info = info;
	}

	/** 
	 * @return 商品简介 
	 */ 
	public String getInfo(){
		return info;
	}

	/** 
	 * @param keyword 关键字 
	 */ 
	public void setKeyword(String keyword){
		this.keyword = keyword;
	}

	/** 
	 * @return 关键字 
	 */ 
	public String getKeyword(){
		return keyword;
	}

	/** 
	 * @param cateId 产品分类id 
	 */ 
	public void setCateId(Integer cateId){
		this.cateId = cateId;
	}

	/** 
	 * @return 产品分类id 
	 */ 
	public Integer getCateId(){
		return cateId;
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
	 * @param postage 邮费 
	 */ 
	public void setPostage(BigDecimal postage){
		this.postage = postage;
	}

	/** 
	 * @return 邮费 
	 */ 
	public BigDecimal getPostage(){
		return postage;
	}

	/** 
	 * @param unitName 单位名 
	 */ 
	public void setUnitName(String unitName){
		this.unitName = unitName;
	}

	/** 
	 * @return 单位名 
	 */ 
	public String getUnitName(){
		return unitName;
	}

	/** 
	 * @param seq 排序，默认为0; 按大到小排序 
	 */ 
	public void setSeq(Integer seq){
		this.seq = seq;
	}

	/** 
	 * @return 排序，默认为0; 按大到小排序 
	 */ 
	public Integer getSeq(){
		return seq;
	}

	/** 
	 * @param sales 销量, 默认 0 
	 */ 
	public void setSales(Integer sales){
		this.sales = sales;
	}

	/** 
	 * @return 销量, 默认 0 
	 */ 
	public Integer getSales(){
		return sales;
	}

	/** 
	 * @param stock 库存, 默认 0 
	 */ 
	public void setStock(Integer stock){
		this.stock = stock;
	}

	/** 
	 * @return 库存, 默认 0 
	 */ 
	public Integer getStock(){
		return stock;
	}

	/** 
	 * @param isShow 状态（0：未上架，1：上架） 
	 */ 
	public void setIsShow(Integer isShow){
		this.isShow = isShow;
	}

	/** 
	 * @return 状态（0：未上架，1：上架） 
	 */ 
	public Integer getIsShow(){
		return isShow;
	}

	/** 
	 * @param isHot 是否热卖 
	 */ 
	public void setIsHot(Integer isHot){
		this.isHot = isHot;
	}

	/** 
	 * @return 是否热卖 
	 */ 
	public Integer getIsHot(){
		return isHot;
	}

	/** 
	 * @param isBenefit 是否优惠 
	 */ 
	public void setIsBenefit(Integer isBenefit){
		this.isBenefit = isBenefit;
	}

	/** 
	 * @return 是否优惠 
	 */ 
	public Integer getIsBenefit(){
		return isBenefit;
	}

	/** 
	 * @param isBest 是否精品 
	 */ 
	public void setIsBest(Integer isBest){
		this.isBest = isBest;
	}

	/** 
	 * @return 是否精品 
	 */ 
	public Integer getIsBest(){
		return isBest;
	}

	/** 
	 * @param isNew 是否新品 
	 */ 
	public void setIsNew(Integer isNew){
		this.isNew = isNew;
	}

	/** 
	 * @return 是否新品 
	 */ 
	public Integer getIsNew(){
		return isNew;
	}

	/** 
	 * @param explain 产品描述 
	 */ 
	public void setExplain(String explain){
		this.explain = explain;
	}

	/** 
	 * @return 产品描述 
	 */ 
	public String getExplain(){
		return explain;
	}

	/** 
	 * @param createTime 添加时间 
	 */ 
	public void setCreateTime(Integer createTime){
		this.createTime = createTime;
	}

	/** 
	 * @return 添加时间 
	 */ 
	public Integer getCreateTime(){
		return createTime;
	}

	/** 
	 * @param updateTime 更新时间 
	 */ 
	public void setUpdateTime(Integer updateTime){
		this.updateTime = updateTime;
	}

	/** 
	 * @return 更新时间 
	 */ 
	public Integer getUpdateTime(){
		return updateTime;
	}

	/** 
	 * @param isPostage 是否包邮 
	 */ 
	public void setIsPostage(Integer isPostage){
		this.isPostage = isPostage;
	}

	/** 
	 * @return 是否包邮 
	 */ 
	public Integer getIsPostage(){
		return isPostage;
	}

	/** 
	 * @param isDel 是否删除 
	 */ 
	public void setIsDel(Integer isDel){
		this.isDel = isDel;
	}

	/** 
	 * @return 是否删除 
	 */ 
	public Integer getIsDel(){
		return isDel;
	}

	/** 
	 * @param giveIntegral 获得积分 
	 */ 
	public void setGiveIntegral(Integer giveIntegral){
		this.giveIntegral = giveIntegral;
	}

	/** 
	 * @return 获得积分 
	 */ 
	public Integer getGiveIntegral(){
		return giveIntegral;
	}

	/** 
	 * @param isGood 是否优品推荐, 默认0 {0 不是 1 是} 
	 */ 
	public void setIsGood(Integer isGood){
		this.isGood = isGood;
	}

	/** 
	 * @return 是否优品推荐, 默认0 {0 不是 1 是} 
	 */ 
	public Integer getIsGood(){
		return isGood;
	}

	/** 
	 * @param ficti 虚拟销量 
	 */ 
	public void setFicti(Integer ficti){
		this.ficti = ficti;
	}

	/** 
	 * @return 虚拟销量 
	 */ 
	public Integer getFicti(){
		return ficti;
	}

	/** 
	 * @param browse 浏览量(每浏览一次加 1) 
	 */ 
	public void setBrowse(Integer browse){
		this.browse = browse;
	}

	/** 
	 * @return 浏览量(每浏览一次加 1) 
	 */ 
	public Integer getBrowse(){
		return browse;
	}

	/** 
	 * @param codePath 产品二维码地址(用户小程序海报) 
	 */ 
	public void setCodePath(String codePath){
		this.codePath = codePath;
	}

	/** 
	 * @return 产品二维码地址(用户小程序海报) 
	 */ 
	public String getCodePath(){
		return codePath;
	}

	/** 
	 * @param isSub 是否单独分佣, 默认 0 没有 1 有 
	 */ 
	public void setIsSub(Integer isSub){
		this.isSub = isSub;
	}

	/** 
	 * @return 是否单独分佣, 默认 0 没有 1 有 
	 */ 
	public Integer getIsSub(){
		return isSub;
	}

	/** 
	 * @param tempId 运费模板ID 
	 */ 
	public void setTempId(Integer tempId){
		this.tempId = tempId;
	}

	/** 
	 * @return 运费模板ID 
	 */ 
	public Integer getTempId(){
		return tempId;
	}

	/** 
	 * @param specType 规格 0单 1多 
	 */ 
	public void setSpecType(Integer specType){
		this.specType = specType;
	}

	/** 
	 * @return 规格 0单 1多 
	 */ 
	public Integer getSpecType(){
		return specType;
	}

	/** 
	 * @param isIntegral 是否开启积分兑换, 默认0 { 0没开启 1 开启} 
	 */ 
	public void setIsIntegral(Integer isIntegral){
		this.isIntegral = isIntegral;
	}

	/** 
	 * @return 是否开启积分兑换, 默认0 { 0没开启 1 开启} 
	 */ 
	public Integer getIsIntegral(){
		return isIntegral;
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
	 * <h4>对象转成ShopProduct对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,image,sliderImage,name,info,keyword,cateId,price,vipPrice,otPrice,costPrice,postage,unitName,seq,sales,stock,isShow,isHot,isBenefit,isBest,isNew,explain,createTime,updateTime,isPostage,isDel,giveIntegral,isGood,ficti,browse,codePath,isSub,tempId,specType,isIntegral,integral]
	 * </pre>
	 */
	public ShopProduct convert(){ 
		ShopProduct shopProduct = new ShopProduct();
		shopProduct.setId(id);
		shopProduct.setImage(image);
		shopProduct.setSliderImage(sliderImage);
		shopProduct.setName(name);
		shopProduct.setInfo(info);
		shopProduct.setKeyword(keyword);
		shopProduct.setCateId(cateId);
		shopProduct.setPrice(price);
		shopProduct.setVipPrice(vipPrice);
		shopProduct.setOtPrice(otPrice);
		shopProduct.setCostPrice(costPrice);
		shopProduct.setPostage(postage);
		shopProduct.setUnitName(unitName);
		shopProduct.setSeq(seq);
		shopProduct.setSales(sales);
		shopProduct.setStock(stock);
		shopProduct.setIsShow(isShow);
		shopProduct.setIsHot(isHot);
		shopProduct.setIsBenefit(isBenefit);
		shopProduct.setIsBest(isBest);
		shopProduct.setIsNew(isNew);
		shopProduct.setExplain(explain);
		shopProduct.setCreateTime(createTime);
		shopProduct.setUpdateTime(updateTime);
		shopProduct.setIsPostage(isPostage);
		shopProduct.setIsDel(isDel);
		shopProduct.setGiveIntegral(giveIntegral);
		shopProduct.setIsGood(isGood);
		shopProduct.setFicti(ficti);
		shopProduct.setBrowse(browse);
		shopProduct.setCodePath(codePath);
		shopProduct.setIsSub(isSub);
		shopProduct.setTempId(tempId);
		shopProduct.setSpecType(specType);
		shopProduct.setIsIntegral(isIntegral);
		shopProduct.setIntegral(integral);
		return shopProduct;
	} 
	/**
	 * <h4>ShopProduct对象转成ShopProductParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,image,sliderImage,name,info,keyword,cateId,price,vipPrice,otPrice,costPrice,postage,unitName,seq,sales,stock,isShow,isHot,isBenefit,isBest,isNew,explain,createTime,updateTime,isPostage,isDel,giveIntegral,isGood,ficti,browse,codePath,isSub,tempId,specType,isIntegral,integral]
	 * </pre>
	 */
	public ShopProductParam compat(ShopProduct shopProduct){ 
		if(null == shopProduct){
			return new ShopProductParam();
		}
		this.setId(shopProduct.getId());
		this.setImage(shopProduct.getImage());
		this.setSliderImage(shopProduct.getSliderImage());
		this.setName(shopProduct.getName());
		this.setInfo(shopProduct.getInfo());
		this.setKeyword(shopProduct.getKeyword());
		this.setCateId(shopProduct.getCateId());
		this.setPrice(shopProduct.getPrice());
		this.setVipPrice(shopProduct.getVipPrice());
		this.setOtPrice(shopProduct.getOtPrice());
		this.setCostPrice(shopProduct.getCostPrice());
		this.setPostage(shopProduct.getPostage());
		this.setUnitName(shopProduct.getUnitName());
		this.setSeq(shopProduct.getSeq());
		this.setSales(shopProduct.getSales());
		this.setStock(shopProduct.getStock());
		this.setIsShow(shopProduct.getIsShow());
		this.setIsHot(shopProduct.getIsHot());
		this.setIsBenefit(shopProduct.getIsBenefit());
		this.setIsBest(shopProduct.getIsBest());
		this.setIsNew(shopProduct.getIsNew());
		this.setExplain(shopProduct.getExplain());
		this.setCreateTime(shopProduct.getCreateTime());
		this.setUpdateTime(shopProduct.getUpdateTime());
		this.setIsPostage(shopProduct.getIsPostage());
		this.setIsDel(shopProduct.getIsDel());
		this.setGiveIntegral(shopProduct.getGiveIntegral());
		this.setIsGood(shopProduct.getIsGood());
		this.setFicti(shopProduct.getFicti());
		this.setBrowse(shopProduct.getBrowse());
		this.setCodePath(shopProduct.getCodePath());
		this.setIsSub(shopProduct.getIsSub());
		this.setTempId(shopProduct.getTempId());
		this.setSpecType(shopProduct.getSpecType());
		this.setIsIntegral(shopProduct.getIsIntegral());
		this.setIntegral(shopProduct.getIntegral());
		return this;
	} 
}
