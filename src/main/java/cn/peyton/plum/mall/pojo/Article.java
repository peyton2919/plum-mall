package cn.peyton.plum.mall.pojo;


import java.io.Serializable;
/**
 * <h3> 文章管理表 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class Article implements Serializable {
	/** 文章管理ID  */
	private Long id;
	/** 文章标题  */
	private String title;
	/** 文章作者  */
	private String author;
	/** 文章图片  */
	private String image;
	/** 文章简介  */
	private String synopsis;
	/** 文章内容  */
	private String content;
	/** 浏览次数,每点击一次加1  */
	private Integer visit;
	/** 排序，默认为0; 按大到小排序  */
	private Integer seq;
	/** 原文链接  */
	private String url;
	/** 添加时间  */
	private Integer createTime;
	/** 更新时间  */
	private Integer updateTime;
	/** 是否删除: 默认1(1：可用;0已删除)  */
	private Integer isDel;
	/** 产品关联id,默认0为没关联产品  */
	private Long productId;
	/** 素材id,多个用 `,` 分开  */
	private String mediaId;
	/** 是否发布 1-已发布 0-未发布  */
	private Integer isPub;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id 文章管理ID 
	 */ 
	public void setId(Long id){
		this.id = id;
	}

	/** 
	 * @return 文章管理ID 
	 */ 
	public Long getId(){
		return id;
	}

	/** 
	 * @param title 文章标题 
	 */ 
	public void setTitle(String title){
		this.title = title;
	}

	/** 
	 * @return 文章标题 
	 */ 
	public String getTitle(){
		return title;
	}

	/** 
	 * @param author 文章作者 
	 */ 
	public void setAuthor(String author){
		this.author = author;
	}

	/** 
	 * @return 文章作者 
	 */ 
	public String getAuthor(){
		return author;
	}

	/** 
	 * @param image 文章图片 
	 */ 
	public void setImage(String image){
		this.image = image;
	}

	/** 
	 * @return 文章图片 
	 */ 
	public String getImage(){
		return image;
	}

	/** 
	 * @param synopsis 文章简介 
	 */ 
	public void setSynopsis(String synopsis){
		this.synopsis = synopsis;
	}

	/** 
	 * @return 文章简介 
	 */ 
	public String getSynopsis(){
		return synopsis;
	}

	/** 
	 * @param content 文章内容 
	 */ 
	public void setContent(String content){
		this.content = content;
	}

	/** 
	 * @return 文章内容 
	 */ 
	public String getContent(){
		return content;
	}

	/** 
	 * @param visit 浏览次数,每点击一次加1 
	 */ 
	public void setVisit(Integer visit){
		this.visit = visit;
	}

	/** 
	 * @return 浏览次数,每点击一次加1 
	 */ 
	public Integer getVisit(){
		return visit;
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
	 * @param url 原文链接 
	 */ 
	public void setUrl(String url){
		this.url = url;
	}

	/** 
	 * @return 原文链接 
	 */ 
	public String getUrl(){
		return url;
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
	 * @param productId 产品关联id,默认0为没关联产品 
	 */ 
	public void setProductId(Long productId){
		this.productId = productId;
	}

	/** 
	 * @return 产品关联id,默认0为没关联产品 
	 */ 
	public Long getProductId(){
		return productId;
	}

	/** 
	 * @param mediaId 素材id,多个用 `,` 分开 
	 */ 
	public void setMediaId(String mediaId){
		this.mediaId = mediaId;
	}

	/** 
	 * @return 素材id,多个用 `,` 分开 
	 */ 
	public String getMediaId(){
		return mediaId;
	}

	/** 
	 * @param isPub 是否发布 1-已发布 0-未发布 
	 */ 
	public void setIsPub(Integer isPub){
		this.isPub = isPub;
	}

	/** 
	 * @return 是否发布 1-已发布 0-未发布 
	 */ 
	public Integer getIsPub(){
		return isPub;
	}

}
