package cn.peyton.plum.mall.utils;

import cn.peyton.plum.mall.pojo.product.ShopCategory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <h4>分类 工具类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.utils.
 * @date 2023年12月10日 9:43
 * @version 1.0.0
 * </pre>
 */
public class CategoryUtils implements Serializable {

    /**
     * <h4>整理 分类栏</h4>
     * @param categories pojo对象集合
     * @return param对象集合
     */
    public static List<ShopCategory> reorganize(List<ShopCategory> categories) {
        if(null == categories && categories.size() == 0){
            return categories;
        }
        return new CategoryUtils().getChildrens(categories);
    }

    /**
     * <h4>获取根目录</h4>
     * @param categories 分类集合
     * @return
     */
    private List<ShopCategory> getChildrens(List<ShopCategory> categories) {
        List<ShopCategory> result = new ArrayList<>();
        for (ShopCategory category : categories) {
            // 获取根节点
            if (category.getPid() == 0) {
                result.add(getChildrens(category, categories));
            }
        }
        return result;
    }

    /**
     * <h4>递归查找 菜单栏 子类</h4>
     * @param category 分类对象
     * @param categories 分类对象集合
     * @return
     */
    private ShopCategory getChildrens(ShopCategory category, List<ShopCategory> categories) {
        List<ShopCategory> childNodes = new ArrayList<>();
        for (ShopCategory node : categories) {

            if((node.getPid()+"").equals(category.getId()+"")){
                childNodes.add(getChildrens(node, categories));
            }
        }
        category.setChildrens(childNodes);
        return category;
    }
}
