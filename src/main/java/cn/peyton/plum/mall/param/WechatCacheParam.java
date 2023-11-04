package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.WechatCache;

import java.io.Serializable;
/**
 * <h3> 微信缓存表 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class WechatCacheParam implements Serializable {
	/**   */
	private String key;
	/** 缓存数据  */
	private String result;
	/** 缓存时间  */
	private Integer createTime;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param key  
	 */ 
	public void setKey(String key){
		this.key = key;
	}

	/** 
	 * @return  
	 */ 
	public String getKey(){
		return key;
	}

	/** 
	 * @param result 缓存数据 
	 */ 
	public void setResult(String result){
		this.result = result;
	}

	/** 
	 * @return 缓存数据 
	 */ 
	public String getResult(){
		return result;
	}

	/** 
	 * @param createTime 缓存时间 
	 */ 
	public void setCreateTime(Integer createTime){
		this.createTime = createTime;
	}

	/** 
	 * @return 缓存时间 
	 */ 
	public Integer getCreateTime(){
		return createTime;
	}

	/**
	 * <h4>对象转成WechatCache对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [key,result,createTime]
	 * </pre>
	 */
	public WechatCache convert(){
		WechatCache wechatCache = new WechatCache(); 
		wechatCache.setKey(key);
		wechatCache.setResult(result);
		wechatCache.setCreateTime(createTime);
		return wechatCache;
	} 
	/**
	 * <h4>WechatCache对象转成WechatCacheParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [key,result,createTime]
	 * </pre>
	 */
	public WechatCacheParam compat(WechatCache wechatCache){ 
		if(null == wechatCache){
			return new WechatCacheParam();
		}
		this.setKey(wechatCache.getKey());
		this.setResult(wechatCache.getResult());
		this.setCreateTime(wechatCache.getCreateTime());
		return this;
	} 
}
