package cn.peyton.plum.mall.pojo;


import java.io.Serializable;
/**
 * <h3> 公告表 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class Notice implements Serializable {
	/**   */
	private Long id;
	/** 创建者ID  */
	private Long createId;
	/** 创建者类型:默认 0 {0 管理员 1 员工 2 供应商}  */
	private Integer createType;
	/** 公告标题  */
	private String title;
	/** 公告内容  */
	private String content;
	/** 排序: 数值越大越靠前  */
	private Integer seq;
	/** 是否删除: 默认1(1：可用;0已删除)  */
	private Integer isDel;
	/** 创建时间  */
	private Integer createTime;

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
	 * @param createId 创建者ID 
	 */ 
	public void setCreateId(Long createId){
		this.createId = createId;
	}

	/** 
	 * @return 创建者ID 
	 */ 
	public Long getCreateId(){
		return createId;
	}

	/** 
	 * @param createType 创建者类型:默认 0 {0 管理员 1 员工 2 供应商} 
	 */ 
	public void setCreateType(Integer createType){
		this.createType = createType;
	}

	/** 
	 * @return 创建者类型:默认 0 {0 管理员 1 员工 2 供应商} 
	 */ 
	public Integer getCreateType(){
		return createType;
	}

	/** 
	 * @param title 公告标题 
	 */ 
	public void setTitle(String title){
		this.title = title;
	}

	/** 
	 * @return 公告标题 
	 */ 
	public String getTitle(){
		return title;
	}

	/** 
	 * @param content 公告内容 
	 */ 
	public void setContent(String content){
		this.content = content;
	}

	/** 
	 * @return 公告内容 
	 */ 
	public String getContent(){
		return content;
	}

	/** 
	 * @param seq 排序: 数值越大越靠前 
	 */ 
	public void setSeq(Integer seq){
		this.seq = seq;
	}

	/** 
	 * @return 排序: 数值越大越靠前 
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

}
