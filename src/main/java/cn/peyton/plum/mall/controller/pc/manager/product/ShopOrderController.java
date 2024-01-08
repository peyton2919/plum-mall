package cn.peyton.plum.mall.controller.pc.manager.product;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.FormData;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.utils.DateUtils;
import cn.peyton.plum.core.utils.ExcelExportUtils;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Datetime;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.product.ShopOrderParam;
import cn.peyton.plum.mall.service.product.ShopOrderService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h3> 订单 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/order")
public class ShopOrderController extends PcController<ShopOrderParam>
        implements IBasePCController<Long, ShopOrderParam> {


    @Resource
    private ShopOrderService shopOrderService;
    @Token
    @Valid
    @PostMapping("/manager/all")
    public JSONResult<?> all(String keyword,
             @NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "最小为1")Integer pageNo) {
        return null;
    }
    // all 全部; nopay 待支付; noship 待发货; shiped 待收货; received 已收货; finish 已完成; closed 已关闭; refunding 退款中;
    @Token
    @Valid
    @PostMapping("/manager/search")
    @Override
    public JSONResult<?> list(Query query) {
        // tab 状态 {all, nopay, noship, shiped, received, finish, closed, refunding}
        // nopay: paid = 0
        // noship: status = 0
        // shiped: status = 1
        // received: status = 2
        // finish: status = 3
        // closed: status = 9
        // refunding: status = -1

        ShopOrderParam _param = new ShopOrderParam();
        if (null != query || null != query.getTab() || !"".equals(query.getTab())) {
            int status = covert(query.getTab());
            if ("nopay".equals(query.getTab())) {
                _param.setPaid(0);
            } else if (status > -2) {
                _param.setStatus(status);
            }
        }
        //_param.setName(query.getKeyword());
        // 其他处理判断
        return baseHandleList(_param, new PageQuery(query.getPageNo()), shopOrderService,null);
    }
    @Token
    @Valid
    @PostMapping("/manager/create")
    @Override
    public JSONResult<?> create(ShopOrderParam record) {
        return baseHandleCreate(record, null, shopOrderService, TIP_SHOP_ORDER);
    }
    @Token
    @Valid
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(ShopOrderParam record) {
        return baseHandleEdit(record, null, shopOrderService, TIP_SHOP_ORDER,UPDATE);
    }

    @Override
    public JSONResult<?> delete(Long id) {
        return null;
    }

    @Token
    @Valid
    @PostMapping("/manager/delete")
    public JSONResult<?> udpate(FormData data) {
        if (null == data || null == data.getLongs() || data.getLongs().size() == 0) {
            return JSONResult.fail(ERROR);
        }
        if (shopOrderService.updateIsDel(data.getLongs())) {
            return JSONResult.success(BATCH + DELETE + TIP_SHOP_ORDER + SUCCESS);
        }
        return JSONResult.fail(BATCH + DELETE + TIP_SHOP_ORDER + FAIL);
    }

    @Token
    @Valid
    @PostMapping("/manager/shipinfo")
    public JSONResult<?> shipInfo(Long id){

        return JSONResult.success();
    }


    @Token
    @Valid
    @PostMapping("/manager/export")
    public void export(@NotBlank(message = "订单类型不能为空")String tab,
                                     @Datetime String startTime, @Datetime String endTime, HttpServletResponse response) throws IOException {

        ShopOrderParam _param = new ShopOrderParam();
        if (null != tab || !"".equals(tab)) {
            int status = covert(tab);
            if ("nopay".equals(tab)) {
                _param.setPaid(0);
            } else if (status > -2) {
                _param.setStatus(status);
            }
        }
        List<ShopOrderParam> orders = shopOrderService.findSimpleByCondition(_param,
                DateUtils.dateToTimestamp(startTime), DateUtils.dateToTimestamp(endTime));

        List<String> headers = new ArrayList<>();
        headers.add("订单ID");
        headers.add("订单号");
        headers.add("收货地址");
        headers.add("商品信息");
        headers.add("支付信息");
        headers.add("支付信息");
        headers.add("下单时间");
        List<Map<Integer, Object>> data = new ArrayList<>();
        Map<Integer, Object> map = null;
        for (int i = 0; i < orders.size(); i++) {
            map = new HashMap<>();
            map.put(0, orders.get(i).getId());
            map.put(1, orders.get(i).getOrderNo());
            //map.put(2, orders.get(i).getMember().getUserAddresses().getAddress());
            map.put(3, orders.get(i).getItems().get(0).getProductSkuDetail().getProduct().getTitle());
            map.put(4, orders.get(i).getPaid() == 0 ? "未支付" : "已支付");
            map.put(5, intToStr(orders.get(i).getStatus()));
            map.put(6, orders.get(i).getCreateTime());
            data.add(map);
        }

        // todo
        // 导出 excel
        // 创建工作簿
        //Workbook workbook = new XSSFWorkbook();
        //HSSFWorkbook workbook = new HSSFWorkbook();
        //创建工作表
        //Sheet sheet = workbook.createSheet(tab);
        //// 创建表头
        //Row headerRow = sheet.createRow(0);
        //headerRow.createCell(0).setCellValue("订单ID");
        //headerRow.createCell(1).setCellValue("订单号");
        //headerRow.createCell(2).setCellValue("收货地址");
        //headerRow.createCell(3).setCellValue("商品信息");
        //headerRow.createCell(4).setCellValue("支付信息");
        //headerRow.createCell(5).setCellValue("发货信息");
        //headerRow.createCell(6).setCellValue("下单时间");
        //int index = 1;
        //for (ShopOrderParam order : orders) {
        //    Row row = sheet.createRow(index++);
        //    row.createCell(0).setCellValue(order.getId());
        //    row.createCell(1).setCellValue(order.getOrderNo());
        //    row.createCell(2).setCellValue(order.getMember().getAddress().getAddress());
        //    row.createCell(3).setCellValue(order.getItems().get(0).getProductSkuDetail().getProduct().getName());
        //    row.createCell(4).setCellValue(order.getPaid()==0?"未支付":"已支付");
        //    row.createCell(5).setCellValue(intToStr(order.getStatus()));
        //    row.createCell(6).setCellValue(order.getCreateTime());
        //}

        //Workbook workbook = ExcelExportUtils.createWorkbook(headers, data, 1, ("order-" + tab));
        //
        ////response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        //response.setCharacterEncoding("utf-8");
        //String fileName = URLEncoder.encode("order-"+tab, "UTF-8");
        ////下载文件的默认名称
        //response.setHeader("content-Type", "application/vnd.ms-excel");
        ////告诉浏览器用什么软件可以打开此文件
        //response.setHeader("content-disposition", "attachment; filename=" + fileName);
        //
        //OutputStream stream = response.getOutputStream();
        //workbook.write(stream);
        //stream.flush();
        //workbook.close();
        //stream.close();

        ExcelExportUtils.createWorkbook(headers, data, 1, ("order-" + tab),response);
    }

    private String intToStr(Integer status) {
        switch (status) {
            case 0:
                return "待发货";
            case 1:
                return "待收货";
            case 2:
                return "已收货";
            case 3:
                return "已完成";
        }
        return null;
    }


    /**
     * <h4>根据字符串返回状态码</h4>
     * @param tab
     * @return
     */
    private Integer covert(String tab) {
        if("noship".equals(tab)){
            return 0;
        }else if("shiped".equals(tab)){
            return 1;
        }else if("received".equals(tab)){
            return 2;
        }else if("finish".equals(tab)){
            return 3;
        }else if("closed".equals(tab)){
            return 9;
        }else if("refunding".equals(tab)){
            return -1;
        }
        return -2;
    }
}
