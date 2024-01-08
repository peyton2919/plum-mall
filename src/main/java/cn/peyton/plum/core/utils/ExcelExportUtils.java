package cn.peyton.plum.core.utils;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.utils.
 * @date 2023年12月17日 18:28
 * @version 1.0.0
 * </pre>
 */
public final class ExcelExportUtils implements Serializable {

    public static void createWorkbook(List<String> headers, List<Map<Integer,Object>> data, Integer type,
                                          String name, HttpServletResponse response) {
        //  工作簿
        Workbook workbook = getWorkbookByType(type);
        if (null == headers || headers.size() == 0) {
            return;
        }
        // 工作表(单)
        Sheet sheet = workbook.createSheet(name);
        // 创建表头
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.size(); i++) {
            headerRow.createCell(i).setCellValue(headers.get(i));
        }
        int index = 1;
        for (Map<Integer, Object> map : data) {
            Row row = sheet.createRow(index++);
            int col = 0;
            for (int i = 0; i < headers.size(); i++) {
                row.createCell(col).setCellValue(null != map.get(i) ? map.get(i).toString() : "");
                col++;
            }
        }
        OutputStream stream = null;
        try {
            String fileName = URLEncoder.encode(name, "UTF-8");
            //设置响应的信息
            response.reset();
            response.setCharacterEncoding("utf-8");
            //下载文件的默认名称
            response.setHeader("content-type", "application/vnd.ms-excel");
            //告诉浏览器用什么软件可以打开此文件
            response.setHeader("content-disposition", "attachment; filename=" + fileName);
            response.setHeader("Pragma", "no-cache");
            //设置浏览器接受类型为流
            response.setContentType("application/octet-stream;charset=UTF-8");

            stream = response.getOutputStream();
            workbook.write(stream);
            stream.flush();
        } catch (IOException e) {

        }finally {
            try {
                if (null != workbook) {
                    workbook.close();
                }
                if (null != stream) {
                    stream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    /**
     * <h4>根据所给的type获取对应的工作簿 0-HSSFWorkbook 其他-XSSFWorkbook</h4>
     * @param type 0 为 xls; 1 为 xlsx;默认 0
     * @return
     */
    private static Workbook getWorkbookByType(Integer type) {
        if(type == null || type == 0)
            return new HSSFWorkbook();
        else
            return new XSSFWorkbook();
    }

    /**
     * <h4>根据type获取对应文件后缀 0-xls 其他xlsx 默认为xls</h4>
     * @param type 0 为 xls; 1 为 xlsx;默认 0
     * @return
     */
    private static String getExtensionByType(Integer type) {
        if(type == null || type == 0)
            return ".xls";
        else
            return ".xlsx";
    }
}
