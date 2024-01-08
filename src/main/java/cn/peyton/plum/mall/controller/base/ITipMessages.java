package cn.peyton.plum.mall.controller.base;

/**
 * <h4>提示信息相关</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.mall.controller.base.
 * @date 2023年12月30日 9:37
 * @version 1.0.0
 * </pre>
 */
public interface ITipMessages {

    String MSG = "提交信息有误,请确认后在提交";
    /**
     * 没找到数据...
     */
    String NO_DATA = "没找到相关数据";
    String FIND_DATA = "查找到相关数据";
    String DATA = "数据";
    String NO_NEED = "不需要";
    String DATA_LOADING_SUCCESS = "数据加载成功";
    String REPEAT = "已有重复记录,请重新输入";
    String JOIN_DATA = "关联其他数据,无法";
    String SORT = "排序";
    String STATUS = "状态";
    String SELECT = "请选择";
    String ERROR = "参数条件异常";
    String VERIFY = "审核";
    String PARAM = "[参数] ";
    String NULL = "为空";
    String TIP_ID = "Id";
    String ERROR_SIMPLE = "异常";
    String SEMICOLON = "; ";
    String DISABLED = "不可用";
    String GET_FINISHED = "已被领完";
    String RECEIVE = "已领取";

    String SUCCESS = "成功";
    String FAIL = "失败";
    String UPDATE = "更新";
    String CREATE = "创建";
    String DELETE = "删除";
    String ADD = "添加";
    String EDIT = "编辑";
    String MODIFY = "修改";
    String DETAIL = "详情";
    String BATCH = "批量";
    String OPERATE = "操作";
    String RESTORE = "恢复";
    String SUBMIT = "提交";
    String UPLOAD = "上传";

    String PARAM_TYPE_FAIL = "[参数] 类型错误";

    String SPEC_SINGLE = "单规格";
    String SPEC_MULTI = "多规格";
    String CATEGORY = "分类";
    String NAME = "名称";

    String TIP_PRODUCT = "商品";
    String TIP_SHOP_SKU = "规格";
    String TIP_SHOP_SKU_VALUE = "规格值";
    String TIP_SHOP_CART = "购物车";
    String TIP_SHOP_CATEGROY = "商品分类";
    String TIP_SHOP_COPON = "优惠券";
    String TIP_SHOP_ORDER = "订单";
    String TIP_SHOP_STOCK = "库存";
    String TIP_SHOP_SKU_RULE = "规则";

    String TIP_MATERIAL = "图片";
    String TIP_MATERIAL_GROUP = "图片分组";

    String TIP_MENU = "菜单";
    String TIP_AREA = "地区";

    String TIP_BRAND = "品牌";
    String TIP_INVOICE = "发票";
    String TIP_WAREHOUSE = "仓库";

    String TIP_MEMBER = "会员";
    String TIP_MEMBER_LEVEL = "请选择会员等级";
    String TIP_SHARE_BIND = "用户绑定";
    String TIP_SUPPLIER = "供应商";
    String TIP_SUPPLIER_INFO = "供应商基础信息";
    String TIP_USER_ADDRESS = "地址信息";


    interface ProductStatus {
        String NEW = "";
    }



}
