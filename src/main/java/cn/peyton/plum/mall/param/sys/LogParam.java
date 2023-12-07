package cn.peyton.plum.mall.param.sys;


import cn.peyton.plum.mall.pojo.sys.Log;

import java.io.Serializable;

/**
 * <h3> 日志信息 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:24
 * @version 1.0.0
 * </pre>
 */
public class LogParam implements Serializable {
    /**
     *
     */
    private Long id;
    /**
     * 类型 0：异常
     */
    private Integer type;
    /**
     * 基于type后指定的对象id，比如用户、权限、角色等表的主键
     */
    private Long targetId;
    /**
     * 旧值
     */
    private String oldValue;
    /**
     * 新值
     */
    private String newValue;
    /**
     * 操作者
     */
    private String operator;
    /**
     * 最后一次更新的时间
     */
    private Integer operateTime;
    /**
     * 最后一次更新者的ip地址
     */
    private String operateIp;
    /**
     * 当前是否复原过，默认 0：没有，1：复原过
     */
    private Integer status;

    //================================== Constructor =======================================//

    //================================== Method =======================================//


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * @param type 类型 0：异常
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return 类型 0：异常
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param targetId 基于type后指定的对象id，比如用户、权限、角色等表的主键
     */
    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    /**
     * @return 基于type后指定的对象id，比如用户、权限、角色等表的主键
     */
    public Long getTargetId() {
        return targetId;
    }

    /**
     * @param oldValue 旧值
     */
    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    /**
     * @return 旧值
     */
    public String getOldValue() {
        return oldValue;
    }

    /**
     * @param newValue 新值
     */
    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    /**
     * @return 新值
     */
    public String getNewValue() {
        return newValue;
    }

    /**
     * @param operator 操作者
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * @return 操作者
     */
    public String getOperator() {
        return operator;
    }

    /**
     * @param operateTime 最后一次更新的时间
     */
    public void setOperateTime(Integer operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * @return 最后一次更新的时间
     */
    public Integer getOperateTime() {
        return operateTime;
    }

    /**
     * @param operateIp 最后一次更新者的ip地址
     */
    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp;
    }

    /**
     * @return 最后一次更新者的ip地址
     */
    public String getOperateIp() {
        return operateIp;
    }

    /**
     * @param status 当前是否复原过，默认 0：没有，1：复原过
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return 当前是否复原过，默认 0：没有，1：复原过
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * <h4>对象转成Log对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,type,targetId,oldValue,newValue,operator,operateTime,operateIp,status]
     * </pre>
     */
    public Log convert() {
        Log log = new Log();
        log.setId(id);
        log.setType(type);
        log.setTargetId(targetId);
        log.setOldValue(oldValue);
        log.setNewValue(newValue);
        log.setOperator(operator);
        log.setOperateTime(operateTime);
        log.setOperateIp(operateIp);
        log.setStatus(status);
        return log;
    }

    /**
     * <h4>Log对象转成LogParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,type,targetId,oldValue,newValue,operator,operateTime,operateIp,status]
     * </pre>
     */
    public LogParam compat(Log log) {
        if (null == log) {
            return new LogParam();
        }
        this.setId(log.getId());
        this.setType(log.getType());
        this.setTargetId(log.getTargetId());
        this.setOldValue(log.getOldValue());
        this.setNewValue(log.getNewValue());
        this.setOperator(log.getOperator());
        this.setOperateTime(log.getOperateTime());
        this.setOperateIp(log.getOperateIp());
        this.setStatus(log.getStatus());
        return this;
    }
}
