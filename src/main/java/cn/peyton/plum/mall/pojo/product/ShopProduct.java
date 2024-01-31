package cn.peyton.plum.mall.pojo.product;

import cn.peyton.plum.mall.pojo.join.Brand;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3> 商品信息 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月29日 20:45:56
 * @version 1.0.0
 * </pre>
*/
public class ShopProduct implements Serializable {
	/** 商品Id  */
	private Long id;
	/** 商品图片  */
	private String cover;
	/** 商品名称  */
	private String title;
	/** 商品简介  */
	private String info;
	/** 关键字  */
	private String keyword;
	/** 运费模板Id  */
	private Integer tempId;
	/** 市场价格  */
	private BigDecimal price;
	/** 最低价 {高于 正常要高于 vip 价}  */
	private BigDecimal minPrice;
	/** 邮费  */
	private BigDecimal postage;
	/** 单位名  */
	private String unitName;
	/** 排序取值范围0~9999，默认为0; 按大到小排序  */
	private Short seq;
	/** 虚拟销量  */
	private Integer ficti;
	/** 产品二维码地址(用户小程序海报)  */
	private String codePath;
	/** 产品描述  */
	private String explain;
	/** 浏览量(每浏览一次加 1)  */
	private Integer browse;
	/** 规格 0单 1多  */
	private Integer specType;
	/** 商品属性索引值 (attr_value|attr_value[|....])  */
	private String skus;
	/** 操作提示 默认0,0,0[规格|spec, 轮播图|slideshow, 详情|info],0 表示 未操作 1 表示操作过  */
	private String operate;
	/** 是否审核 0审核中 1通过 2拒绝  */
	private Integer isCheck;
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
	/** 是否包邮  */
	private Integer isPostage;
	/** 是否删除  */
	private Integer isDel;
	/** 是否优品推荐, 默认0 {0 不是 1 是}  */
	private Integer isGood;
	/** 是否单独分佣, 默认 0 没有 1 有  */
	private Integer isSub;
	/** 商品的好评率(评论时操作该字段) */
	private BigDecimal goodRate;
	/** 商品评论数量 */
	private Integer commentCount;
	/** 总销量(订单操作该字段) */
	private Integer saleCount;

	/** 添加时间  */
	private Integer createTime;
	/** 更新时间  */
	private Integer updateTime;
	/** 品牌 Id */
	private Long brandId;
	/** 品牌 对象 */
	private Brand brand;

	/** 商品分类集合 */
	private List<ShopCategory> categories;
	/** 商品轮播图集合 */
	private List<ShopSlideshow> slideshows;
	/** 商品多规格详细列表 */
	private List<ShopProductSkuDetail> productSkus;

	/** 商品多规格 提示列表 */
	private List<ShopSku> shopSkus;


	/** 评论集合 */
	private List<ShopProductReply> hotComments;

	/** 热门推荐集合 */
	private List<ShopProduct> hotList;



	//================================== Constructor =======================================//
	public ShopProduct() {
		if (null == categories) {categories = new ArrayList<>();}
		if (null == slideshows) {slideshows = new ArrayList<>();}
		if (null == productSkus) {productSkus = new ArrayList<>();}
		if (null == shopSkus) { shopSkus = new ArrayList<>();}
		if (null == hotComments) {hotComments = new ArrayList<>();}
		if (null == hotList) {hotList = new ArrayList<>();}
		if (null == brand) { brand = new Brand();}
	}
	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id 商品Id 
	 */ 
	public void setId(Long id){
		this.id = id;
	}

	/** 
	 * @return 商品Id 
	 */ 
	public Long getId(){
		return id;
	}

	/** 
	 * @param cover 商品图片 
	 */ 
	public void setCover(String cover){
		this.cover = cover;
	}

	/** 
	 * @return 商品图片 
	 */ 
	public String getCover(){
		return cover;
	}

	/** 
	 * @param title 商品名称 
	 */ 
	public void setTitle(String title){
		this.title = title;
	}

	/** 
	 * @return 商品名称 
	 */ 
	public String getTitle(){
		return title;
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
	 * @param tempId 运费模板Id 
	 */ 
	public void setTempId(Integer tempId){
		this.tempId = tempId;
	}

	/** 
	 * @return 运费模板Id 
	 */ 
	public Integer getTempId(){
		return tempId;
	}

	/** 
	 * @param price 市场价格 
	 */ 
	public void setPrice(BigDecimal price){
		this.price = price;
	}

	/** 
	 * @return 市场价格 
	 */ 
	public BigDecimal getPrice(){
		return price;
	}

	/** 
	 * @param minPrice 最低价 {高于 正常要高于 vip 价} 
	 */ 
	public void setMinPrice(BigDecimal minPrice){
		this.minPrice = minPrice;
	}

	/** 
	 * @return 最低价 {高于 正常要高于 vip 价} 
	 */ 
	public BigDecimal getMinPrice(){
		return minPrice;
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
	 * @param seq 排序取值范围0~9999，默认为0; 按大到小排序 
	 */ 
	public void setSeq(Short seq){
		this.seq = seq;
	}

	/** 
	 * @return 排序取值范围0~9999，默认为0; 按大到小排序 
	 */ 
	public Short getSeq(){
		return seq;
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
	 * @param operate 操作提示 默认0,0,0[规格|spec, 轮播图|slideshow, 详情|info],0 表示 未操作 1 表示操作过 
	 */ 
	public void setOperate(String operate){
		this.operate = operate;
	}

	/** 
	 * @return 操作提示 默认0,0,0[规格|spec, 轮播图|slideshow, 详情|info],0 表示 未操作 1 表示操作过 
	 */ 
	public String getOperate(){
		return operate;
	}

	/** 
	 * @param isCheck 是否审核 0审核中 1通过 2拒绝 
	 */ 
	public void setIsCheck(Integer isCheck){
		this.isCheck = isCheck;
	}

	/** 
	 * @return 是否审核 0审核中 1通过 2拒绝 
	 */ 
	public Integer getIsCheck(){
		return isCheck;
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
	 * @return 商品的好评率(评论时操作该字段)
	 */
	public BigDecimal getGoodRate() {
		return goodRate;
	}

	/**
	 * @param goodRate 商品的好评率(评论时操作该字段)
	 */
	public void setGoodRate(BigDecimal goodRate) {
		this.goodRate = goodRate;
	}

	/**
	 * @return 商品评论数量
	 */
	public Integer getCommentCount() {
		return commentCount;
	}

	/**
	 * @param commentCount 商品评论数量
	 */
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	/**
	 * @return 总销量(订单操作该字段)
	 */
	public Integer getSaleCount() {
		return saleCount;
	}

	/**
	 * @param saleCount 总销量(订单操作该字段)
	 */
	public void setSaleCount(Integer saleCount) {
		this.saleCount = saleCount;
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
	 * @return 品牌 Id
	 */
	public Long getBrandId() {
		return brandId;
	}

	/**
	 * @param brandId 品牌 Id
	 */
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	/**
	 * @return 品牌 对象
	 */
	public Brand getBrand() {
		return brand;
	}

	/**
	 * @param brand 品牌 对象
	 */
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	/**
	 * @return 商品分类集合
	 */
	public List<ShopCategory> getCategories() {
		return categories;
	}

	/**
	 * @param categories 商品分类集合
	 */
	public void setCategories(List<ShopCategory> categories) {
		this.categories = categories;
	}

	/**
	 * @return 商品轮播图集合
	 */
	public List<ShopSlideshow> getSlideshows() {
		return slideshows;
	}

	/**
	 * @param slideshows 商品轮播图集合
	 */
	public void setSlideshows(List<ShopSlideshow> slideshows) {
		this.slideshows = slideshows;
	}

	/**
	 * @return 商品多规格详细列表
	 */
	public List<ShopProductSkuDetail> getProductSkus() {
		return productSkus;
	}

	/**
	 * @param productSkus 商品多规格详细列表
	 */
	public void setProductSkus(List<ShopProductSkuDetail> productSkus) {
		this.productSkus = productSkus;
	}


	/**
	 * @return 商品多规格 提示列表
	 */
	public List<ShopSku> getShopSkus() {
		return shopSkus;
	}

	/**
	 * @param shopSkus 商品多规格 提示列表
	 */
	public void setShopSkus(List<ShopSku> shopSkus) {
		this.shopSkus = shopSkus;
	}

	/**
	 * @return 评论集合
	 */
	public List<ShopProductReply> getHotComments() {
		return hotComments;
	}

	/**
	 * @param hotComments 评论集合
	 */
	public void setHotComments(List<ShopProductReply> hotComments) {
		this.hotComments = hotComments;
	}

	/**
	 * @return 热门推荐集合
	 */
	public List<ShopProduct> getHotList() {
		return hotList;
	}

	/**
	 * @param hotList 热门推荐集合
	 */
	public void setHotList(List<ShopProduct> hotList) {
		this.hotList = hotList;
	}
}
