package cn.peyton.plum.mall.dto;

import cn.peyton.plum.mall.param.pub.AdvertParam;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <h4>广告 DTO 类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.dto.
 * @date 2024年01月19日 21:50
 * @version 1.0.0
 * </pre>
 */
public class AdvertDto implements Serializable {

    /**
     * <h4>三图广告过滤</h4>
     * @param data 数据 100条以内
     * @return 三图广告
     */
    public static List<AdvertParam> filter(List<AdvertParam> data) {
        List<AdvertParam> leftAdverts = new ArrayList<>();
        List<AdvertParam> topAdverts = new ArrayList<>();
        List<AdvertParam> bottomAdverts = new ArrayList<>();
        List<AdvertParam> result = new ArrayList<>();
        if (null == data || data.size() == 0) {
            return data;
        }
        for (AdvertParam ap : data) {
            if (ap.getLocation().intValue() == 0) {
                leftAdverts.add(ap);
            }
            if (ap.getLocation().intValue() == 1) {
                topAdverts.add(ap);
            }
            if (ap.getLocation().intValue() == 2) {
                bottomAdverts.add(ap);
            }
        }
        Random random = new Random();
        int index = random.nextInt(leftAdverts.size());
        result.add(leftAdverts.get(index));
        index = random.nextInt(topAdverts.size());
        result.add(topAdverts.get(index));
        index = random.nextInt(bottomAdverts.size());
        result.add(bottomAdverts.get(index));
        return result;
    }
}
