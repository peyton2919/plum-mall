package cn.peyton.plum.mall.pojo.sys;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3> 城市表 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月27日 09:58:27
 * @version 1.0.0
 * </pre>
*/
public class City implements Serializable {
	/**   */
	private Integer id;
	/** 省市级别  */
	private Integer level;
	/** 父级id(最高为0)  */
	private Integer pid;
	/** 区号  */
	private String areaCode;
	/** 名称  */
	private String name;
	/** 合并名称  */
	private String mergerName;
	/** 经度  */
	private String lng;
	/** 纬度  */
	private String lat;
	/** 是否启用, 默认 1 启用 0 禁用  */
	private Integer status;

	/** 城市子类集合 */
	private List<City> childrens;


	//================================== Constructor =======================================//
	public City() {
		if (null == childrens) {childrens = new ArrayList<>();}
	}
	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id  
	 */ 
	public void setId(Integer id){
		this.id = id;
	}

	/** 
	 * @return  
	 */ 
	public Integer getId(){
		return id;
	}

	/** 
	 * @param level 省市级别 
	 */ 
	public void setLevel(Integer level){
		this.level = level;
	}

	/** 
	 * @return 省市级别 
	 */ 
	public Integer getLevel(){
		return level;
	}

	/** 
	 * @param pid 父级id(最高为0) 
	 */ 
	public void setPid(Integer pid){
		this.pid = pid;
	}

	/** 
	 * @return 父级id(最高为0) 
	 */ 
	public Integer getPid(){
		return pid;
	}

	/** 
	 * @param areaCode 区号 
	 */ 
	public void setAreaCode(String areaCode){
		this.areaCode = areaCode;
	}

	/** 
	 * @return 区号 
	 */ 
	public String getAreaCode(){
		return areaCode;
	}

	/** 
	 * @param name 名称 
	 */ 
	public void setName(String name){
		this.name = name;
	}

	/** 
	 * @return 名称 
	 */ 
	public String getName(){
		return name;
	}

	/** 
	 * @param mergerName 合并名称 
	 */ 
	public void setMergerName(String mergerName){
		this.mergerName = mergerName;
	}

	/** 
	 * @return 合并名称 
	 */ 
	public String getMergerName(){
		return mergerName;
	}

	/** 
	 * @param lng 经度 
	 */ 
	public void setLng(String lng){
		this.lng = lng;
	}

	/** 
	 * @return 经度 
	 */ 
	public String getLng(){
		return lng;
	}

	/** 
	 * @param lat 纬度 
	 */ 
	public void setLat(String lat){
		this.lat = lat;
	}

	/** 
	 * @return 纬度 
	 */ 
	public String getLat(){
		return lat;
	}

	/** 
	 * @param status 是否启用, 默认 1 启用 0 禁用 
	 */ 
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 
	 * @return 是否启用, 默认 1 启用 0 禁用 
	 */ 
	public Integer getStatus(){
		return status;
	}
	/**
	 * @return 城市子类集合
	 */
	public List<City> getChildrens() {
		return childrens;
	}

	/**
	 * @param childrens 城市子类集合
	 */
	public void setChildrens(List<City> childrens) {
		this.childrens = childrens;
	}
}
