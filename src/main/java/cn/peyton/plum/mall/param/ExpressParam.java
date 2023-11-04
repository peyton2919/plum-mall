package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.Express;

import java.io.Serializable;
/**
 * <h3> 快递公司表 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class ExpressParam implements Serializable {
	/** 快递公司id  */
	private Integer id;
	/** 快递公司简称  */
	private String code;
	/** 快递公司全称  */
	private String name;
	/** 排序，默认为0; 按大到小排序  */
	private Integer seq;
	/** 是否显示: 默认：1{1 显示 0 不显示}  */
	private Integer isShow;
	/** 创建时间  */
	private Integer createTime;
	/** 是否删除: 默认1(1：可用;0已删除)  */
	private Integer isDel;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id 快递公司id 
	 */ 
	public void setId(Integer id){
		this.id = id;
	}

	/** 
	 * @return 快递公司id 
	 */ 
	public Integer getId(){
		return id;
	}

	/** 
	 * @param code 快递公司简称 
	 */ 
	public void setCode(String code){
		this.code = code;
	}

	/** 
	 * @return 快递公司简称 
	 */ 
	public String getCode(){
		return code;
	}

	/** 
	 * @param name 快递公司全称 
	 */ 
	public void setName(String name){
		this.name = name;
	}

	/** 
	 * @return 快递公司全称 
	 */ 
	public String getName(){
		return name;
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
	 * @param isShow 是否显示: 默认：1{1 显示 0 不显示} 
	 */ 
	public void setIsShow(Integer isShow){
		this.isShow = isShow;
	}

	/** 
	 * @return 是否显示: 默认：1{1 显示 0 不显示} 
	 */ 
	public Integer getIsShow(){
		return isShow;
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
	 * <h4>对象转成Express对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,code,name,seq,isShow,createTime,isDel]
	 * </pre>
	 */
	public Express convert(){
		Express express = new Express(); 
		express.setId(id);
		express.setCode(code);
		express.setName(name);
		express.setSeq(seq);
		express.setIsShow(isShow);
		express.setCreateTime(createTime);
		express.setIsDel(isDel);
		return express;
	} 
	/**
	 * <h4>Express对象转成ExpressParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,code,name,seq,isShow,createTime,isDel]
	 * </pre>
	 */
	public ExpressParam compat(Express express){ 
		if(null == express){
			return new ExpressParam();
		}
		this.setId(express.getId());
		this.setCode(express.getCode());
		this.setName(express.getName());
		this.setSeq(express.getSeq());
		this.setIsShow(express.getIsShow());
		this.setCreateTime(express.getCreateTime());
		this.setIsDel(express.getIsDel());
		return this;
	} 
}
