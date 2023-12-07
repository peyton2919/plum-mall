package cn.peyton.plum.mall.param.product;

import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.validator.constraints.Length;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.bo.ShopCategoryBo;
import cn.peyton.plum.mall.bo.ShopProductSkuDetailBo;
import cn.peyton.plum.mall.bo.ShopSkuBo;
import cn.peyton.plum.mall.bo.ShopSlideshowBo;
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
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class ShopProductParam implements Serializable {
    /**
     * 商品Id
     */
    private Long id;
    /**
     * 商品图片
     */
    @Length(min = 1,max = 250)
    private String cover;
    /**
     * 商品名称
     */
    @NotBlank(message = "名称不能为空")
    @Length(max = 60,min = 1)
    private String name;
    /**
     * 商品简介
     */
    @Length(min = 1,max = 120)
    private String info;
    /**
     * 关键字
     */
    @Length(min = 1,max = 120)
    private String keyword;
    /**
     * 运费模板Id
     */
    private Integer tempId;
    /**
     * 商品价格(批发)
     */
    private BigDecimal price;
    /** 最低价 {高于 正常要高于 vip 价} */
    private BigDecimal minPrice;

    /**
     * 会员价格
     */
    private BigDecimal vipPrice;
    /**
     * 市场价
     */
    private BigDecimal otPrice;
    /**
     * 成本价
     */
    private BigDecimal costPrice;
    /**
     * 邮费
     */
    private BigDecimal postage;
    /**
     * 单位名
     */
    private String unitName;
    /**
     * 排序取值范围0~9999，默认为0; 按大到小排序
     */
    private Short seq;
    /**
     * 销量, 默认 0
     */
    private Integer sales;
    /**
     * 库存, 默认 0
     */
    private Integer stock;
    /** 库存预警(默认0 不提示 >0 低于设置值 提示) */
    private Integer minStock;
    /** 是否审核 0审核中 1通过 2拒绝  */
    private Integer isCheck;

    /**
     * 浏览量(每浏览一次加 1)
     */
    private Integer browse;
    /**
     * 虚拟销量
     */
    private Integer ficti;
    /**
     * 重量
     */
    private BigDecimal weight;
    /**
     * 体积
     */
    private BigDecimal volume;

    /** 库存显示 默认 1显示 0隐藏  */
    private Integer stockDisplay;

    /**
     * 产品二维码地址(用户小程序海报)
     */
    private String codePath;
    /**
     * 产品描述
     */
    private String explain;
    /**
     * 规格 0单 1多
     */
    private Integer specType;
    /**
     * 商品属性索引值 (attr_value|attr_value[|....])
     */
    private String skus;
    /**
     * 状态（0：未上架，1：上架）
     */
    private Integer isShow;
    /**
     * 是否热卖
     */
    private Integer isHot;
    /**
     * 是否优惠
     */
    private Integer isBenefit;
    /**
     * 是否精品
     */
    private Integer isBest;
    /**
     * 是否新品
     */
    private Integer isNew;
    /**
     * 是否包邮
     */
    private Integer isPostage;
    /**
     * 是否删除
     */
    private Integer isDel;
    /**
     * 是否优品推荐, 默认0 {0 不是 1 是}
     */
    private Integer isGood;
    /**
     * 是否单独分佣, 默认 0 没有 1 有
     */
    private Integer isSub;
    /**
     * 获得积分
     */
    private Integer giveIntegral;
    /**
     * 是否开启积分兑换, 默认0 { 0没开启 1 开启}
     */
    private Integer isIntegral;
    /**
     * 需要多少积分兑换
     */
    private Integer integral;
    /**
     * 添加时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;
    /** 商品分类集合 */
    private List<ShopCategoryParam> categories;
    /** 商品轮播图集合 */
    private List<ShopSlideshowParam> slideshows;
    /** 商品多规格详细列表 */
    private List<ShopProductSkuDetailParam> productSkus;
    /** 商品多规格 提示列表 */
    private List<ShopSkuParam> shopSkus;

    //================================== Constructor =======================================//
    public ShopProductParam(){
        if (null == categories) {categories = new ArrayList<>();}
        if (null == slideshows) {slideshows = new ArrayList<>();}
        if (null == productSkus) {productSkus = new ArrayList<>();}
        if (null == shopSkus) {
            shopSkus = new ArrayList<>();}
    }
    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id 商品Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return 商品Id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param cover 商品图片
     */
    public void setCover(String cover) {
        this.cover = cover;
    }

    /**
     * @return 商品图片
     */
    public String getCover() {
        return cover;
    }

    /**
     * @param name 商品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param info 商品简介
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * @return 商品简介
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param keyword 关键字
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * @return 关键字
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param tempId 运费模板Id
     */
    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    /**
     * @return 运费模板Id
     */
    public Integer getTempId() {
        return tempId;
    }

    /**
     * @param price 商品价格(批发)
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return 商品价格(批发)
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param vipPrice 会员价格
     */
    public void setVipPrice(BigDecimal vipPrice) {
        this.vipPrice = vipPrice;
    }

    /**
     * @return 会员价格
     */
    public BigDecimal getVipPrice() {
        return vipPrice;
    }

    /**
     * @return 最低价 {高于 正常要高于 vip 价}
     */
    public BigDecimal getMinPrice() {
        return minPrice;
    }

    /**
     * @param minPrice 最低价 {高于 正常要高于 vip 价}
     */
    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    /**
     * @param otPrice 市场价
     */
    public void setOtPrice(BigDecimal otPrice) {
        this.otPrice = otPrice;
    }

    /**
     * @return 市场价
     */
    public BigDecimal getOtPrice() {
        return otPrice;
    }

    /**
     * @param costPrice 成本价
     */
    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    /**
     * @return 成本价
     */
    public BigDecimal getCostPrice() {
        return costPrice;
    }

    /**
     * @param postage 邮费
     */
    public void setPostage(BigDecimal postage) {
        this.postage = postage;
    }

    /**
     * @return 邮费
     */
    public BigDecimal getPostage() {
        return postage;
    }

    /**
     * @param unitName 单位名
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    /**
     * @return 单位名
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * @param seq 排序取值范围0~9999，默认为0; 按大到小排序
     */
    public void setSeq(Short seq) {
        this.seq = seq;
    }

    /**
     * @return 排序取值范围0~9999，默认为0; 按大到小排序
     */
    public Short getSeq() {
        return seq;
    }

    /**
     * @param sales 销量, 默认 0
     */
    public void setSales(Integer sales) {
        this.sales = sales;
    }

    /**
     * @return 销量, 默认 0
     */
    public Integer getSales() {
        return sales;
    }

    /**
     * @param stock 库存, 默认 0
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * @return 库存, 默认 0
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * @return 库存预警(默认0 不提示 >0 低于设置值 提示)
     */
    public Integer getMinStock() {
        return minStock;
    }

    /**
     * @param minStock 库存预警(默认0 不提示 >0 低于设置值 提示)
     */
    public void setMinStock(Integer minStock) {
        this.minStock = minStock;
    }

    /**
     * @return 是否审核 0审核中 1通过 2拒绝
     */
    public Integer getIsCheck() {
        return isCheck;
    }

    /**
     * @param isCheck 是否审核 0审核中 1通过 2拒绝
     */
    public void setIsCheck(Integer isCheck) {
        this.isCheck = isCheck;
    }


    /**
     * @param browse 浏览量(每浏览一次加 1)
     */
    public void setBrowse(Integer browse) {
        this.browse = browse;
    }

    /**
     * @return 浏览量(每浏览一次加 1)
     */
    public Integer getBrowse() {
        return browse;
    }

    /**
     * @param ficti 虚拟销量
     */
    public void setFicti(Integer ficti) {
        this.ficti = ficti;
    }

    /**
     * @return 虚拟销量
     */
    public Integer getFicti() {
        return ficti;
    }

    /**
     * @param codePath 产品二维码地址(用户小程序海报)
     */
    public void setCodePath(String codePath) {
        this.codePath = codePath;
    }

    /**
     * @return 产品二维码地址(用户小程序海报)
     */
    public String getCodePath() {
        return codePath;
    }

    /**
     * @param explain 产品描述
     */
    public void setExplain(String explain) {
        this.explain = explain;
    }

    /**
     * @return 产品描述
     */
    public String getExplain() {
        return explain;
    }

    /**
     * @param specType 规格 0单 1多
     */
    public void setSpecType(Integer specType) {
        this.specType = specType;
    }

    /**
     * @return 规格 0单 1多
     */
    public Integer getSpecType() {
        return specType;
    }

    /**
     * @param skus 商品属性索引值 (attr_value|attr_value[|....])
     */
    public void setSkus(String skus) {
        this.skus = skus;
    }

    /**
     * @return 商品属性索引值 (attr_value|attr_value[|....])
     */
    public String getSkus() {
        return skus;
    }

    /**
     * @param isShow 状态（0：未上架，1：上架）
     */
    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    /**
     * @return 状态（0：未上架，1：上架）
     */
    public Integer getIsShow() {
        return isShow;
    }

    /**
     * @param isHot 是否热卖
     */
    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    /**
     * @return 是否热卖
     */
    public Integer getIsHot() {
        return isHot;
    }

    /**
     * @param isBenefit 是否优惠
     */
    public void setIsBenefit(Integer isBenefit) {
        this.isBenefit = isBenefit;
    }

    /**
     * @return 是否优惠
     */
    public Integer getIsBenefit() {
        return isBenefit;
    }

    /**
     * @param isBest 是否精品
     */
    public void setIsBest(Integer isBest) {
        this.isBest = isBest;
    }

    /**
     * @return 是否精品
     */
    public Integer getIsBest() {
        return isBest;
    }

    /**
     * @param isNew 是否新品
     */
    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    /**
     * @return 是否新品
     */
    public Integer getIsNew() {
        return isNew;
    }

    /**
     * @param isPostage 是否包邮
     */
    public void setIsPostage(Integer isPostage) {
        this.isPostage = isPostage;
    }

    /**
     * @return 是否包邮
     */
    public Integer getIsPostage() {
        return isPostage;
    }
    /**
     * @param weight 重量
     */
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    /**
     * @return 重量
     */
    public BigDecimal getWeight() {
        return weight;
    }

    /**
     * @return 库存显示 默认 1显示 0隐藏
     */
    public Integer getStockDisplay() {
        return stockDisplay;
    }

    /**
     * @param stockDisplay 库存显示 默认 1显示 0隐藏
     */
    public void setStockDisplay(Integer stockDisplay) {
        this.stockDisplay = stockDisplay;
    }

    /**
     * @param volume 体积
     */
    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    /**
     * @return 体积
     */
    public BigDecimal getVolume() {
        return volume;
    }

    /**
     * @param isDel 是否删除
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * @return 是否删除
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * @param isGood 是否优品推荐, 默认0 {0 不是 1 是}
     */
    public void setIsGood(Integer isGood) {
        this.isGood = isGood;
    }

    /**
     * @return 是否优品推荐, 默认0 {0 不是 1 是}
     */
    public Integer getIsGood() {
        return isGood;
    }

    /**
     * @param isSub 是否单独分佣, 默认 0 没有 1 有
     */
    public void setIsSub(Integer isSub) {
        this.isSub = isSub;
    }

    /**
     * @return 是否单独分佣, 默认 0 没有 1 有
     */
    public Integer getIsSub() {
        return isSub;
    }

    /**
     * @param giveIntegral 获得积分
     */
    public void setGiveIntegral(Integer giveIntegral) {
        this.giveIntegral = giveIntegral;
    }

    /**
     * @return 获得积分
     */
    public Integer getGiveIntegral() {
        return giveIntegral;
    }

    /**
     * @param isIntegral 是否开启积分兑换, 默认0 { 0没开启 1 开启}
     */
    public void setIsIntegral(Integer isIntegral) {
        this.isIntegral = isIntegral;
    }

    /**
     * @return 是否开启积分兑换, 默认0 { 0没开启 1 开启}
     */
    public Integer getIsIntegral() {
        return isIntegral;
    }

    /**
     * @param integral 需要多少积分兑换
     */
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    /**
     * @return 需要多少积分兑换
     */
    public Integer getIntegral() {
        return integral;
    }

    /**
     * @param createTime 添加时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * @return 添加时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * @param updateTime 更新时间
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return 更新时间
     */
    public String getUpdateTime() {
        return updateTime;
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
     * <h4>对象转成ShopProduct对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,cover,name,info,keyword,tempId,price,vipPrice,otPrice,costPrice,postage,unitName,seq,sales,stock,
     * 	 browse,ficti,codePath,explain,specType,isShow,isHot,isBenefit,isBest,isNew,isPostage,isDel,isGood,isSub,
     * 	 giveIntegral,isIntegral,integral,createTime,updateTime]
     * </pre>
     */
    public ShopProduct convert() {
        ShopProduct shopProduct = new ShopProduct();
        shopProduct.setId(id);
        shopProduct.setCover(cover);
        shopProduct.setName(name);
        shopProduct.setInfo(info);
        shopProduct.setKeyword(keyword);
        shopProduct.setTempId(tempId);
        shopProduct.setPrice(price);
        shopProduct.setVipPrice(vipPrice);
        shopProduct.setMinPrice(minPrice);
        shopProduct.setOtPrice(otPrice);
        shopProduct.setCostPrice(costPrice);
        shopProduct.setPostage(postage);
        shopProduct.setUnitName(unitName);
        shopProduct.setSeq(seq);
        shopProduct.setSales(sales);
        shopProduct.setStock(stock);
        shopProduct.setBrowse(browse);
        shopProduct.setFicti(ficti);
        shopProduct.setWeight(weight);
        shopProduct.setVolume(volume);
        shopProduct.setStockDisplay(stockDisplay);
        shopProduct.setCodePath(codePath);
        shopProduct.setExplain(explain);
        shopProduct.setSpecType(specType);
        shopProduct.setSkus(skus);
        shopProduct.setIsShow(isShow);
        shopProduct.setIsHot(isHot);
        shopProduct.setIsBenefit(isBenefit);
        shopProduct.setIsBest(isBest);
        shopProduct.setIsNew(isNew);
        shopProduct.setIsPostage(isPostage);
        shopProduct.setIsDel(isDel);
        shopProduct.setIsGood(isGood);
        shopProduct.setIsSub(isSub);
        shopProduct.setGiveIntegral(giveIntegral);
        shopProduct.setIsIntegral(isIntegral);
        shopProduct.setIntegral(integral);
        shopProduct.setCreateTime(DateUtils.dateToTimestamp(createTime));
        shopProduct.setUpdateTime(DateUtils.dateToTimestamp(updateTime));
        shopProduct.setMinStock(minStock);
        shopProduct.setIsCheck(isCheck);
        shopProduct.setCategories(new ShopCategoryBo().reverse(categories));
        shopProduct.setSlideshows(new ShopSlideshowBo().reverse(slideshows));
        shopProduct.setProductSkus(new ShopProductSkuDetailBo().reverse(productSkus));
        shopProduct.setShopSkus(new ShopSkuBo().reverse(shopSkus));
        return shopProduct;
    }

    /**
     * <h4>ShopProduct对象转成ShopProductParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,cover,name,info,keyword,tempId,price,vipPrice,otPrice,costPrice,postage,unitName,seq,sales,stock,
     * 	 browse,ficti,codePath,explain,specType,isShow,isHot,isBenefit,isBest,isNew,isPostage,isDel,isGood,
     * 	 isSub,giveIntegral,isIntegral,integral,createTime,updateTime]
     * </pre>
     */
    public ShopProductParam compat(ShopProduct shopProduct) {
        if (null == shopProduct) {
            return new ShopProductParam();
        }
        this.setId(shopProduct.getId());
        this.setCover(shopProduct.getCover());
        this.setName(shopProduct.getName());
        this.setInfo(shopProduct.getInfo());
        this.setKeyword(shopProduct.getKeyword());
        this.setTempId(shopProduct.getTempId());
        this.setPrice(shopProduct.getPrice());
        this.setVipPrice(shopProduct.getVipPrice());
        this.setMinPrice(shopProduct.getMinPrice());
        this.setOtPrice(shopProduct.getOtPrice());
        this.setCostPrice(shopProduct.getCostPrice());
        this.setPostage(shopProduct.getPostage());
        this.setUnitName(shopProduct.getUnitName());
        this.setSeq(shopProduct.getSeq());
        this.setSales(shopProduct.getSales());
        this.setStock(shopProduct.getStock());
        this.setBrowse(shopProduct.getBrowse());
        this.setFicti(shopProduct.getFicti());
        this.setWeight(shopProduct.getWeight());
        this.setVolume(shopProduct.getVolume());
        this.setStockDisplay(shopProduct.getStockDisplay());
        this.setCodePath(shopProduct.getCodePath());
        this.setExplain(shopProduct.getExplain());
        this.setSpecType(shopProduct.getSpecType());
        this.setSkus(shopProduct.getSkus());
        this.setIsShow(shopProduct.getIsShow());
        this.setIsHot(shopProduct.getIsHot());
        this.setIsBenefit(shopProduct.getIsBenefit());
        this.setIsBest(shopProduct.getIsBest());
        this.setIsNew(shopProduct.getIsNew());
        this.setIsPostage(shopProduct.getIsPostage());
        this.setIsDel(shopProduct.getIsDel());
        this.setIsGood(shopProduct.getIsGood());
        this.setIsSub(shopProduct.getIsSub());
        this.setGiveIntegral(shopProduct.getGiveIntegral());
        this.setIsIntegral(shopProduct.getIsIntegral());
        this.setIntegral(shopProduct.getIntegral());
        this.setCreateTime(DateUtils.timestampToStrDate(shopProduct.getCreateTime()));
        this.setUpdateTime(DateUtils.timestampToStrDate(shopProduct.getUpdateTime()));
        this.setMinStock(shopProduct.getMinStock());
        this.setIsCheck(shopProduct.getIsCheck());
        this.setCategories(new ShopCategoryBo().adapter(shopProduct.getCategories()));
        this.setSlideshows(new ShopSlideshowBo().adapter(shopProduct.getSlideshows()));
        this.setProductSkus(new ShopProductSkuDetailBo().adapter(shopProduct.getProductSkus()));
        this.setShopSkus(new ShopSkuBo().adapter(shopProduct.getShopSkus()));
        return this;
    }
}
