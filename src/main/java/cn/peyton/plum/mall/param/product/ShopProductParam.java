package cn.peyton.plum.mall.param.product;

import cn.peyton.plum.core.anno.img.ImageHostPath;
import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.constraints.*;
import cn.peyton.plum.mall.bo.*;
import cn.peyton.plum.mall.param.join.BrandParam;
import cn.peyton.plum.mall.pojo.product.ShopProduct;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3> 商品信息 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月29日 20:45:56
 * @version 1.0.0
 * </pre>
*/
@ImageHostPath(name = "cover")
public class ShopProductParam implements Serializable {
	/** 商品Id  */
	private Long id;
	/** 商品图片  */
	@NotBlank(message = "封面图不能为空")
	@Length(min = 1,max = 510)
	private String cover;
	/** 商品标题  */
	@NotBlank(message = "名称不能为空")
	@Length(max = 60,min = 1)
	private String title;
	/** 商品简介  */
	@NotBlank(message = "商品简介不能为空")
	@Length(min = 1,max = 120)
	private String info;
	/** 关键字  */
	@NotBlank(message = "关键字不能为空")
	@Length(min = 1,max = 120)
	private String keyword;
	/** 运费模板Id  */
	@Min(value = 1,message = "运费模板Id 要大于等于 1")
	private Integer tempId;
	/** 市场价格  */
	@NotBlank(message = "市场价格不能为空")
	@MinDecimal(value = 0.01,message = "市场价格不能小于0.01元")
	private BigDecimal price;
	/** 最低价 {高于 正常要高于 vip 价}  */
	@NotBlank(message = "最低价格不能为空")
	@MinDecimal(value = 0.01,message = "最低价格不能小于0.01元")
	private BigDecimal minPrice;
	/** 邮费  */
	@MinDecimal(value = 0.01,message = "邮费不能小于0.01元")
	private BigDecimal postage;
	/** 单位名  */
	@Length(min = 1,max = 18)
	private String unitName;
	/** 排序取值范围0~9999，默认为0; 按大到小排序  */
	@Size(min = 0,max = 9999)
	private Short seq;
	/** 虚拟销量  */
	@Min(value = 1,message = "销量最小为1")
	private Integer ficti;
	/** 产品二维码地址(用户小程序海报)  */
	@Length(min=1,max = 510)
	private String codePath;
	/** 产品描述  */
	private String explain;
	/** 浏览量(每浏览一次加 1)  */
	private Integer browse;
	/** 规格 0单 1多  */
	@Size(min = 0,max = 1)
	private Integer specType;
	/** 商品属性索引值 (attr_value|attr_value[|....])  */
	private String skus;
	/** 操作提示 默认0,0,0[规格|spec, 轮播图|slideshow, 详情|info],0 表示 未操作 1 表示操作过  */
	@Length(min = 1,max = 30)
	private String operate;
	/** 是否审核 0审核中 1通过 2拒绝  */
	@Size(min = 0,max = 1)
	private Integer isCheck;
	/** 状态（0：未上架，1：上架）  */
	@Size(min = 0,max = 1)
	private Integer isShow;
	/** 是否热卖  */
	@Size(min = 0,max = 1)
	private Integer isHot;
	/** 是否优惠  */
	@Size(min = 0,max = 1)
	private Integer isBenefit;
	/** 是否精品  */
	@Size(min = 0,max = 1)
	private Integer isBest;
	/** 是否新品  */
	@Size(min = 0,max = 1)
	private Integer isNew;
	/** 是否包邮  */
	@Size(min = 0,max = 1)
	private Integer isPostage;
	/** 是否优品推荐, 默认0 {0 不是 1 是}  */
	@Size(min = 0,max = 1)
	private Integer isGood;
	/** 是否删除: 默认1 (1：可用;0已删除)  */
	private Integer isDel;
	/** 是否单独分佣, 默认 0 没有 1 有  */
	@Size(min = 0,max = 1)
	private Integer isSub;
	/** 添加时间  */
	@Date
	private String createTime;
	/** 更新时间  */
	@Date
	private String updateTime;
	/** 商品的好评率(评论时操作该字段) */
	private BigDecimal goodRate;
	/** 商品评论数量 */
	private Integer commentCount;
	/** 总销量(订单操作该字段) */
	private Integer saleCount;

	/** 品牌 Id */
	@Min(value = 1,message = "请选择品牌")
	private Long brandId;
	/** 品牌 对象 */
	private BrandParam brand;

	/** 商品分类集合 */
	private List<ShopCategoryParam> categories;
	/** 商品轮播图集合 */
	private List<ShopSlideshowParam> slideshows;
	/** 商品多规格详细列表 */
	private List<ShopProductSkuDetailParam> productSkus;
	/** 商品多规格 提示列表 */
	private List<ShopSkuParam> shopSkus;
	/** 评论集合 */
	private List<ShopProductReplyParam> hotComments;
	/** 热门推荐集合 */
	private List<ShopProductParam> hotList;

	//================================== Constructor =======================================//
	public ShopProductParam(){
		if (null == categories) {categories = new ArrayList<>();}
		if (null == slideshows) {slideshows = new ArrayList<>();}
		if (null == productSkus) {productSkus = new ArrayList<>();}
		if (null == shopSkus) { shopSkus = new ArrayList<>();}
		if (null == hotComments) {hotComments = new ArrayList<>();}
		if (null == hotList) {hotList = new ArrayList<>();}
		if (null == brand) { brand = new BrandParam();}
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
	 * @return 是否删除: 默认1 (1：可用;0已删除)
	 */
	public Integer getIsDel() {
		return isDel;
	}

	/**
	 * @param isDel 是否删除: 默认1 (1：可用;0已删除)
	 */
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	/** 
	 * @param createTime 添加时间 
	 */ 
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}

	/** 
	 * @return 添加时间 
	 */ 
	public String getCreateTime(){
		return createTime;
	}

	/** 
	 * @param updateTime 更新时间 
	 */ 
	public void setUpdateTime(String updateTime){
		this.updateTime = updateTime;
	}

	/** 
	 * @return 更新时间 
	 */ 
	public String getUpdateTime(){
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
	public BrandParam getBrand() {
		return brand;
	}

	/**
	 * @param brand 品牌 对象
	 */
	public void setBrand(BrandParam brand) {
		this.brand = brand;
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
	 * @return 商品分类集合
	 */
	public List<ShopCategoryParam> getCategories() {
		return categories;
	}

	/**
	 * @param categories 商品分类集合
	 */
	public void setCategories(List<ShopCategoryParam> categories) {
		this.categories = categories;
	}

	/**
	 * @return 商品轮播图集合
	 */
	public List<ShopSlideshowParam> getSlideshows() {
		return slideshows;
	}

	/**
	 * @param slideshows 商品轮播图集合
	 */
	public void setSlideshows(List<ShopSlideshowParam> slideshows) {
		this.slideshows = slideshows;
	}

	/**
	 * @return 商品多规格详细列表
	 */
	public List<ShopProductSkuDetailParam> getProductSkus() {
		return productSkus;
	}

	/**
	 * @param productSkus 商品多规格详细列表
	 */
	public void setProductSkus(List<ShopProductSkuDetailParam> productSkus) {
		this.productSkus = productSkus;
	}
	/**
	 * @return 商品多规格 提示列表
	 */
	public List<ShopSkuParam> getShopSkus() {
		return shopSkus;
	}

	/**
	 * @param shopSkus 商品多规格 提示列表
	 */
	public void setShopSkus(List<ShopSkuParam> shopSkus) {
		this.shopSkus = shopSkus;
	}
	/**
	 * @return 评论集合
	 */
	public List<ShopProductReplyParam> getHotComments() {
		return hotComments;
	}

	/**
	 * @param hotComments 评论集合
	 */
	public void setHotComments(List<ShopProductReplyParam> hotComments) {
		this.hotComments = hotComments;
	}

	/**
	 * @return 热门推荐集合
	 */
	public List<ShopProductParam> getHotList() {
		return hotList;
	}

	/**
	 * @param hotList 热门推荐集合
	 */
	public void setHotList(List<ShopProductParam> hotList) {
		this.hotList = hotList;
	}


	/**
	 * <h4>对象转成ShopProduct对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,cover,title,info,keyword,tempId,price,minPrice,postage,unitName,seq,ficti,codePath,explain,browse,specType,skus,operate,isCheck,isShow,isHot,isBenefit,isBest,isNew,isPostage,isDel,isGood,isSub,createTime,updateTime]
	 * </pre>
	 */
	public ShopProduct convert(){
		ShopProduct shopProduct = new ShopProduct(); 
		shopProduct.setId(id);
		shopProduct.setCover(cover);
		shopProduct.setTitle(title);
		shopProduct.setInfo(info);
		shopProduct.setKeyword(keyword);
		shopProduct.setTempId(tempId);
		shopProduct.setPrice(price);
		shopProduct.setMinPrice(minPrice);
		shopProduct.setPostage(postage);
		shopProduct.setUnitName(unitName);
		shopProduct.setSeq(seq);
		shopProduct.setFicti(ficti);
		shopProduct.setCodePath(codePath);
		shopProduct.setExplain(explain);
		shopProduct.setBrowse(browse);
		shopProduct.setSpecType(specType);
		shopProduct.setSkus(skus);
		shopProduct.setOperate(operate);
		shopProduct.setIsCheck(isCheck);
		shopProduct.setIsShow(isShow);
		shopProduct.setIsHot(isHot);
		shopProduct.setIsBenefit(isBenefit);
		shopProduct.setIsBest(isBest);
		shopProduct.setIsNew(isNew);
		shopProduct.setIsPostage(isPostage);
		shopProduct.setIsGood(isGood);
		shopProduct.setIsSub(isSub);
		shopProduct.setIsDel(isDel);
		shopProduct.setGoodRate(goodRate);
		shopProduct.setCommentCount(commentCount);
		shopProduct.setSaleCount(saleCount);
		shopProduct.setBrandId(brandId);
		shopProduct.setBrand(brand.convert());
		shopProduct.setCreateTime(DateUtils.dateToTimestamp(createTime));
		shopProduct.setUpdateTime(DateUtils.dateToTimestamp(updateTime));
		shopProduct.setCategories(new ShopCategoryBo().reverse(categories));
		shopProduct.setSlideshows(new ShopSlideshowBo().reverse(slideshows));
		shopProduct.setProductSkus(new ShopProductSkuDetailBo().reverse(productSkus));
		shopProduct.setShopSkus(new ShopSkuBo().reverse(shopSkus));
		shopProduct.setHotComments(new ShopProductReplyBo().reverse(hotComments));
		shopProduct.setHotList(new ShopProductBo().reverse(hotList));
		return shopProduct;
	} 
	/**
	 * <h4>ShopProduct对象转成ShopProductParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,cover,title,info,keyword,tempId,price,minPrice,postage,unitName,seq,ficti,codePath,explain,browse,specType,skus,operate,isCheck,isShow,isHot,isBenefit,isBest,isNew,isPostage,isDel,isGood,isSub,createTime,updateTime]
	 * </pre>
	 */
	public ShopProductParam compat(ShopProduct shopProduct){ 
		if(null == shopProduct){
			return new ShopProductParam();
		}
		this.setId(shopProduct.getId());
		this.setCover(shopProduct.getCover());
		this.setTitle(shopProduct.getTitle());
		this.setInfo(shopProduct.getInfo());
		this.setKeyword(shopProduct.getKeyword());
		this.setTempId(shopProduct.getTempId());
		this.setPrice(shopProduct.getPrice());
		this.setMinPrice(shopProduct.getMinPrice());
		this.setPostage(shopProduct.getPostage());
		this.setUnitName(shopProduct.getUnitName());
		this.setSeq(shopProduct.getSeq());
		this.setFicti(shopProduct.getFicti());
		this.setCodePath(shopProduct.getCodePath());
		this.setExplain(shopProduct.getExplain());
		this.setBrowse(shopProduct.getBrowse());
		this.setSpecType(shopProduct.getSpecType());
		this.setSkus(shopProduct.getSkus());
		this.setOperate(shopProduct.getOperate());
		this.setIsCheck(shopProduct.getIsCheck());
		this.setIsShow(shopProduct.getIsShow());
		this.setIsHot(shopProduct.getIsHot());
		this.setIsBenefit(shopProduct.getIsBenefit());
		this.setIsBest(shopProduct.getIsBest());
		this.setIsNew(shopProduct.getIsNew());
		this.setIsPostage(shopProduct.getIsPostage());
		this.setIsGood(shopProduct.getIsGood());
		this.setIsSub(shopProduct.getIsSub());
		this.setIsDel(shopProduct.getIsDel());
		this.setGoodRate(shopProduct.getGoodRate());
		this.setCommentCount(shopProduct.getCommentCount());
		this.setSaleCount(shopProduct.getSaleCount());
		this.setBrandId(shopProduct.getBrandId());
		this.setBrand(new BrandBo().compat(shopProduct.getBrand()));
		this.setCreateTime(DateUtils.timestampToStrDate(shopProduct.getCreateTime()));
		this.setUpdateTime(DateUtils.timestampToStrDate(shopProduct.getUpdateTime()));
		this.setCategories(new ShopCategoryBo().adapter(shopProduct.getCategories()));
		this.setSlideshows(new ShopSlideshowBo().adapter(shopProduct.getSlideshows()));
		this.setProductSkus(new ShopProductSkuDetailBo().adapter(shopProduct.getProductSkus()));
		this.setShopSkus(new ShopSkuBo().adapter(shopProduct.getShopSkus()));
		this.setHotComments(new ShopProductReplyBo().adapter(shopProduct.getHotComments()));
		this.setHotList(new ShopProductBo().adapter(shopProduct.getHotList()));
		return this;
	} 
}
