package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.ShopProductRule;

import java.io.Serializable;
/**
 * <h3> 商品规则(规格)值表 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class ShopProductRuleParam implements Serializable {
	/**   */
	private Integer id;
	/** 规格名称  */
	private String ruleName;
	/** 规格值:[{detail:[黑色,白色],value:颜色},{detail:[111,112],value:尺寸},...]  */
	private String ruleValue;
	/** 创建时间  */
	private Integer createTime;
	/** 是否删除: 默认1(1：可用;0已删除)  */
	private Integer isDel;

	//================================== Constructor =======================================//

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
	 * @param ruleName 规格名称 
	 */ 
	public void setRuleName(String ruleName){
		this.ruleName = ruleName;
	}

	/** 
	 * @return 规格名称 
	 */ 
	public String getRuleName(){
		return ruleName;
	}

	/** 
	 * @param ruleValue 规格值:[{detail:[黑色,白色],value:颜色},{detail:[111,112],value:尺寸},...] 
	 */ 
	public void setRuleValue(String ruleValue){
		this.ruleValue = ruleValue;
	}

	/** 
	 * @return 规格值:[{detail:[黑色,白色],value:颜色},{detail:[111,112],value:尺寸},...] 
	 */ 
	public String getRuleValue(){
		return ruleValue;
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
	 * <h4>对象转成ShopProductRule对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,ruleName,ruleValue,createTime,isDel]
	 * </pre>
	 */
	public ShopProductRule convert(){
		ShopProductRule shopProductRule = new ShopProductRule(); 
		shopProductRule.setId(id);
		shopProductRule.setRuleName(ruleName);
		shopProductRule.setRuleValue(ruleValue);
		shopProductRule.setCreateTime(createTime);
		shopProductRule.setIsDel(isDel);
		return shopProductRule;
	} 
	/**
	 * <h4>ShopProductRule对象转成ShopProductRuleParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,ruleName,ruleValue,createTime,isDel]
	 * </pre>
	 */
	public ShopProductRuleParam compat(ShopProductRule shopProductRule){ 
		if(null == shopProductRule){
			return new ShopProductRuleParam();
		}
		this.setId(shopProductRule.getId());
		this.setRuleName(shopProductRule.getRuleName());
		this.setRuleValue(shopProductRule.getRuleValue());
		this.setCreateTime(shopProductRule.getCreateTime());
		this.setIsDel(shopProductRule.getIsDel());
		return this;
	} 
}
