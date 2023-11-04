package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.Brand;

import java.io.Serializable;
/**
 * <h3> 品牌信息 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class BrandParam implements Serializable {
	/** 编号  */
	private Long id;
	/** 供应商编号  */
	private Long supId;
	/** 品牌LOGO 图片大小120px*60px  */
	private String logo;
	/** 品牌名称  */
	private String name;
	/** 所属地区  */
	private String area;
	/** 排序，默认为0; 按大到小排序  */
	private Integer seq;
	/** 是否删除: 默认1(1：可用;0已删除)  */
	private Integer isDel;
	/** 品牌描述  */
	private String explain;
	/** 创建时间  */
	private Integer createTime;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id 编号 
	 */ 
	public void setId(Long id){
		this.id = id;
	}

	/** 
	 * @return 编号 
	 */ 
	public Long getId(){
		return id;
	}

	/** 
	 * @param supId 供应商编号 
	 */ 
	public void setSupId(Long supId){
		this.supId = supId;
	}

	/** 
	 * @return 供应商编号 
	 */ 
	public Long getSupId(){
		return supId;
	}

	/** 
	 * @param logo 品牌LOGO 图片大小120px*60px 
	 */ 
	public void setLogo(String logo){
		this.logo = logo;
	}

	/** 
	 * @return 品牌LOGO 图片大小120px*60px 
	 */ 
	public String getLogo(){
		return logo;
	}

	/** 
	 * @param name 品牌名称 
	 */ 
	public void setName(String name){
		this.name = name;
	}

	/** 
	 * @return 品牌名称 
	 */ 
	public String getName(){
		return name;
	}

	/** 
	 * @param area 所属地区 
	 */ 
	public void setArea(String area){
		this.area = area;
	}

	/** 
	 * @return 所属地区 
	 */ 
	public String getArea(){
		return area;
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
	 * @param isDel 是否删除: 默认1(1：可用;0已删除) 
	 */ 
	public void setIsDel(Integer isDel){
		this.isDel = isDel;
	}

	/** 
	 * @return 是否删除: 默认1(1：可用;0已删除) 
	 */ 
	public Integer getIsDel(){
		return isDel;
	}

	/** 
	 * @param explain 品牌描述 
	 */ 
	public void setExplain(String explain){
		this.explain = explain;
	}

	/** 
	 * @return 品牌描述 
	 */ 
	public String getExplain(){
		return explain;
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

	/**
	 * <h4>对象转成Brand对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,supId,logo,name,area,seq,isDel,explain,createTime]
	 * </pre>
	 */
	public Brand convert(){
		Brand brand = new Brand(); 
		brand.setId(id);
		brand.setSupId(supId);
		brand.setLogo(logo);
		brand.setName(name);
		brand.setArea(area);
		brand.setSeq(seq);
		brand.setIsDel(isDel);
		brand.setExplain(explain);
		brand.setCreateTime(createTime);
		return brand;
	} 
	/**
	 * <h4>Brand对象转成BrandParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,supId,logo,name,area,seq,isDel,explain,createTime]
	 * </pre>
	 */
	public BrandParam compat(Brand brand){ 
		if(null == brand){
			return new BrandParam();
		}
		this.setId(brand.getId());
		this.setSupId(brand.getSupId());
		this.setLogo(brand.getLogo());
		this.setName(brand.getName());
		this.setArea(brand.getArea());
		this.setSeq(brand.getSeq());
		this.setIsDel(brand.getIsDel());
		this.setExplain(brand.getExplain());
		this.setCreateTime(brand.getCreateTime());
		return this;
	} 
}
