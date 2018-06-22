package com.aek.ebey.assets.core.easypoi.style;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.export.styler.AbstractExcelExportStyler;
import org.jeecgframework.poi.excel.export.styler.IExcelExportStyler;

/**
 * 自定义样式
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  Shuangwf
 * @version  1.0, 2017年4月25日
 */
public class ExcelExportStatisticStyler extends AbstractExcelExportStyler implements IExcelExportStyler
{
    
    public ExcelExportStatisticStyler(Workbook workbook)
    {
        super.createStyles(workbook);
    }
    
    @Override
    public CellStyle getHeaderStyle(short color)
    {
        CellStyle titleStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 12);
        font.setFontName("微软雅黑");
        font.setFontHeightInPoints((short) 10); //设置字体大小
        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        titleStyle.setFont(font);//选择需要用到的字体格式
        
        titleStyle.setBorderLeft((short) 1); // 左边框
        titleStyle.setBorderRight((short) 1); // 右边框
        titleStyle.setBorderBottom((short) 1);
        titleStyle.setBorderTop((short) 1);
        titleStyle.setAlignment(CellStyle.ALIGN_LEFT);
        titleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        titleStyle.setWrapText(true);
        return titleStyle;
    }
    
    @Override
    public CellStyle stringNoneStyle(Workbook workbook, boolean isWarp)
    {
        CellStyle style = workbook.createCellStyle();
        style.setBorderLeft((short) 1); // 左边框
        style.setBorderRight((short) 1); // 右边框
        style.setBorderBottom((short) 1);
        style.setBorderTop((short) 1);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setDataFormat(STRING_FORMAT);
        if (isWarp)
        {
            style.setWrapText(true);
        }
        return style;
    }
    
    @Override
    public CellStyle getTitleStyle(short color)
    {
        CellStyle titleStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("微软雅黑");
        font.setFontHeightInPoints((short) 10); //设置字体大小
        font.setColor(IndexedColors.WHITE.getIndex());
        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        titleStyle.setFont(font);//选择需要用到的字体格式
        titleStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        titleStyle.setBorderLeft((short) 1); // 左边框
        titleStyle.setBorderRight((short) 1); // 右边框
        titleStyle.setBorderBottom((short) 1);
        titleStyle.setBorderTop((short) 1);
        titleStyle.setAlignment(CellStyle.ALIGN_CENTER);
        titleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        titleStyle.setWrapText(true);
        return titleStyle;
    }
    
    @Override
    public CellStyle stringSeptailStyle(Workbook workbook, boolean isWarp)
    {
        return isWarp ? stringNoneWrapStyle : stringNoneStyle;
    }
    
}
