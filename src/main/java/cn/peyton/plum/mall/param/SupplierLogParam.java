package cn.peyton.plum.mall.param;


import cn.peyton.plum.mall.pojo.SupplierLog;

import java.io.Serializable;
/**
 * <h3> 供应商日志 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月03日 23:02:39
 * @version 1.0.0
 * </pre>
*/
public class SupplierLogParam implements Serializable {
	/**   */
	private Long id;
	/** 供应商编号  */
	private Long supplierId;
	/** 旧值  */
	private String oldValue;
	/** 新值  */
	private String newValue;
	/** 最后一次更新者的ip地址  */
	private String operateIp;
	/** 创建时间  */
	private Integer createTime;
	/** 当前是否复原过，默认 0：没有，1：复原过  */
	private Integer status;

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
	 * @param supplierId 供应商编号 
	 */ 
	public void setSupplierId(Long supplierId){
		this.supplierId = supplierId;
	}

	/** 
	 * @return 供应商编号 
	 */ 
	public Long getSupplierId(){
		return supplierId;
	}

	/** 
	 * @param oldValue 旧值 
	 */ 
	public void setOldValue(String oldValue){
		this.oldValue = oldValue;
	}

	/** 
	 * @return 旧值 
	 */ 
	public String getOldValue(){
		return oldValue;
	}

	/** 
	 * @param newValue 新值 
	 */ 
	public void setNewValue(String newValue){
		this.newValue = newValue;
	}

	/** 
	 * @return 新值 
	 */ 
	public String getNewValue(){
		return newValue;
	}

	/** 
	 * @param operateIp 最后一次更新者的ip地址 
	 */ 
	public void setOperateIp(String operateIp){
		this.operateIp = operateIp;
	}

	/** 
	 * @return 最后一次更新者的ip地址 
	 */ 
	public String getOperateIp(){
		return operateIp;
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
	 * @param status 当前是否复原过，默认 0：没有，1：复原过 
	 */ 
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 
	 * @return 当前是否复原过，默认 0：没有，1：复原过 
	 */ 
	public Integer getStatus(){
		return status;
	}

	/**
	 * <h4>对象转成SupplierLog对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,supplierId,oldValue,newValue,operateIp,createTime,status]
	 * </pre>
	 */
	public SupplierLog convert(){
		SupplierLog supplierLog = new SupplierLog(); 
		supplierLog.setId(id);
		supplierLog.setSupplierId(supplierId);
		supplierLog.setOldValue(oldValue);
		supplierLog.setNewValue(newValue);
		supplierLog.setOperateIp(operateIp);
		supplierLog.setCreateTime(createTime);
		supplierLog.setStatus(status);
		return supplierLog;
	} 
	/**
	 * <h4>SupplierLog对象转成SupplierLogParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,supplierId,oldValue,newValue,operateIp,createTime,status]
	 * </pre>
	 */
	public SupplierLogParam compat(SupplierLog supplierLog){ 
		if(null == supplierLog){
			return new SupplierLogParam();
		}
		this.setId(supplierLog.getId());
		this.setSupplierId(supplierLog.getSupplierId());
		this.setOldValue(supplierLog.getOldValue());
		this.setNewValue(supplierLog.getNewValue());
		this.setOperateIp(supplierLog.getOperateIp());
		this.setCreateTime(supplierLog.getCreateTime());
		this.setStatus(supplierLog.getStatus());
		return this;
	} 
}
