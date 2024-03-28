package cn.peyton.plum.mall.service.join.impl;

import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.mall.DO.ArrearDo;
import cn.peyton.plum.mall.vo.ArrearVo;

import java.io.Serializable;

/**
 * <h4>欠款转换类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.service.join.impl.
 * @date 2024年02月09日 10:03
 * @version 1.0.0
 * </pre>
 */
public class ArrearVoToDo implements Serializable {

    /**
     * <h4>VO 转 DO</h4>
     * @param vo 欠款vo对象
     * @return 欠款 Do对象
     */
    public static ArrearDo convert(ArrearVo vo) {
        ArrearDo arrear = new ArrearDo();
        if (null == vo) {
            return arrear;
        }
        arrear.setMemberId(vo.getMemberId());
        arrear.setOid(vo.getOid());
        arrear.setStatus(vo.getStatus());
        if (null != vo.getRepayType()) {
            arrear.setRepayType((vo.getRepayType() == -1)?null:vo.getRepayType());
        }
        arrear.setMoney(vo.getMoney());
        arrear.setMinMoney(vo.getMinMoney());
        arrear.setMaxMoney(vo.getMaxMoney());
        arrear.setActualPayment(vo.getActualPayment());
        arrear.setTime(vo.getTime());
        arrear.setTimeInterval(vo.getTimeInterval());
        arrear.setMode(vo.getMode());
        arrear.setStartTime(DateUtils.dateToTimestamp(vo.getStartTime()));
        arrear.setEndTime(DateUtils.dateToTimestamp(vo.getEndTime()));
        return arrear;
    }
}
