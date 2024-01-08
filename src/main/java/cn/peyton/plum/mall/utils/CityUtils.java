package cn.peyton.plum.mall.utils;

import cn.peyton.plum.mall.pojo.sys.City;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <h4>地区工具类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.utils.
 * @date 2024年01月07日 17:39
 * @version 1.0.0
 * </pre>
 */
public class CityUtils implements Serializable {

    /**
     * <h4>整理 地区</h4>
     * @param records pojo对象集合
     * @param pid 父级Id
     * @return param对象集合
     */
    public static List<City> reorganize(List<City> records,Integer pid) {
        if(null == records && records.size() == 0){
            return records;
        }
        return new CityUtils().getChildrens(records,pid);
    }


    /**
     * <h4>获取根目录</h4>
     * @param records 分类集合
     * @return
     */
    private List<City> getChildrens(List<City> records,Integer pid) {
        List<City> result = new ArrayList<>();
        for (City record : records) {
            // 获取根节点
            if (record.getPid() == pid) {
                result.add(getChildrens(record, records));
            }
        }
        return result;
    }

    /**
     * <h4>递归查找 菜单栏 子类</h4>
     * @param record 分类对象
     * @param records 分类对象集合
     * @return
     */
    private City getChildrens(City record, List<City> records) {
        List<City> childNodes = new ArrayList<>();
        for (City node : records) {
            // (node.getPid()+"").equals(record.getId()+"")
            if(node.getPid() == record.getId()){
                childNodes.add(getChildrens(node, records));
            }
        }
        record.setChildrens(childNodes);
        return record;
    }
}
