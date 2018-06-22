package com.aek.ebey.assets.web.report;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.Charsets;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aek.common.core.util.DateUtil;
import com.aek.common.core.util.ExcelUtils;
import com.aek.ebey.assets.core.util.SpringContextUtil;
import com.aek.ebey.assets.model.CodeInfo;
import com.aek.ebey.assets.service.CodeInfoService;
import com.google.gson.Gson;

public class ExcelUtil {
	private static final Logger logger = LogManager.getLogger(ExcelUtil.class);
	/**
	 * 机构模板文件sheet名称
	 */
	private static final String TENANT_TEMPLT_NAME = "导入模板";

	public static HSSFWorkbook getImportTemplt(Class<?> clazz) throws IOException {
		return getWorkbook(clazz, readData());
	}

	public static HSSFWorkbook getWorkbook(Class<?> clazz, AssetsExcelVo[] vos) throws IOException {
		int columnSize = 0;
		Field[] declaredFields = clazz.getDeclaredFields();
		List<Field> fields = new ArrayList<>();
		for (Field field : declaredFields) {
			if(field.getAnnotation(ExcelColumn.class)!=null){
				fields.add(field);
			}
		}
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		// title样式
		HSSFCellStyle titleStyle = getCommonStyle(workbook);
		// header样式
		HSSFCellStyle headerStyle = getHeaderCellStyle(workbook);

		HSSFSheet sheet = workbook.createSheet(TENANT_TEMPLT_NAME);
		sheet.setDefaultColumnWidth(26); // 默认宽度
		sheet.setDefaultRowHeightInPoints(20); // 默认高度
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, fields.size()-1)); // 合拼单元格

		HSSFPatriarch patr = (HSSFPatriarch) sheet.createDrawingPatriarch();
		int rowIndex = 0; // 行坐标
		// title 行
		HSSFRow titleRow = sheet.createRow((short) rowIndex++);
		String title = "1.第1、2行为固定结构，不可更改；第3～4行为示例，导入前请删除\n2.列标题不可修改，将鼠标移动到第2行单元格上，查看填写规则";
		titleRow.setHeightInPoints(40);
		HSSFCell titleCell = titleRow.createCell(0);
		titleCell.setCellValue(title);
		titleCell.setCellStyle(titleStyle);

		// header 行
		HSSFRow headerRow = sheet.createRow(rowIndex++);
		headerRow.setHeightInPoints(25); // 行宽
		for (int i = 0; i < fields.size(); i++) {
			Field field = fields.get(i);
			ExcelColumn annotation = field.getDeclaredAnnotation(ExcelColumn.class);
			if(annotation!=null){
				columnSize++;
				HSSFCell headCell = headerRow.createCell(i);
				headCell.setCellValue(annotation.title());
				headCell.setCellStyle(headerStyle);
				if(StringUtils.isNotBlank(annotation.baseDataType())){
					String baseDataType = annotation.baseDataType();
					CodeInfoService bean = SpringContextUtil.getBean(CodeInfoService.class);
					List<CodeInfo> codeList = bean.getCodeList(baseDataType);
					List<String> tl = new ArrayList<>();
					codeList.stream().forEach(e->tl.add(e.getCodeText()));
					// 设置下拉选
					ExcelUtils.setHSSFValidation(sheet, tl.toArray(new String[]{}), rowIndex, Integer.MAX_VALUE, annotation.value(), annotation.value());
				}
				if(StringUtils.isNotBlank(annotation.comment())){
					HSSFComment comment = patr.createComment(new HSSFClientAnchor(0, 0, 0, 0,
							(short) (rowIndex + annotation.value()), rowIndex, (short) (rowIndex + annotation.value() + 2), rowIndex + 2));
					comment.setString(new HSSFRichTextString(annotation.comment()));
					headCell.setCellComment(comment);
				}
			}
		}
		// content
		if (vos!=null) {
			HSSFCellStyle commonStyle = getCommonStyle(workbook);
			HSSFCellStyle errorStyle = getCommonStyle(workbook);
			errorStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			errorStyle.setFillForegroundColor(HSSFColor.RED.index);
			HSSFCellStyle moneyStyle = getCommonStyle(workbook);
			HSSFCellStyle dateStyle = getCommonStyle(workbook);
			HSSFDataFormat format = workbook.createDataFormat();
			moneyStyle.setDataFormat(format.getFormat("￥#,##0.00"));
			for (AssetsExcelVo vo : vos) {
				HSSFRow contentRow = sheet.createRow(rowIndex++);
				for (int i = 0; i < fields.size(); i++) {
					Field field = fields.get(i);
					ExcelColumn annotation = field.getDeclaredAnnotation(ExcelColumn.class);
					if(annotation!=null){
						HSSFCell contentCell = contentRow.createCell(annotation.value());
						try {
							setCellValue(contentCell, field, vo, annotation, workbook, commonStyle, moneyStyle, dateStyle);
							if(CollectionUtils.isNotEmpty(vo.getErrorCols())&&vo.getErrorCols().contains(annotation.value())){
								contentCell.setCellStyle(errorStyle);
							}
						} catch (Exception e) {
							logger.error("ex.", e);
						}
					}
				}
				if(CollectionUtils.isNotEmpty(vo.getErrorCols())){
					contentRow.setHeightInPoints(25*vo.getErrorCols().size());
				}else{
					contentRow.setHeightInPoints(25);
				}
				if(StringUtils.isNotBlank(vo.getMessage())){
					HSSFCell contentCell = contentRow.createCell(columnSize);
					HSSFCellStyle cellStyle2 = contentCell.getCellStyle();
					HSSFFont font = workbook.createFont();
					font.setFontName("宋体");
					font.setColor(HSSFColor.RED.index);
					font.setFontHeightInPoints((short) 10);
					cellStyle2.setWrapText(true); // 自动换行
					cellStyle2.setFont(font);
					cellStyle2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
					contentCell.setCellValue(vo.getMessage());
				}
			} 
		}
		return workbook;
	}

	private static AssetsExcelVo[] readData() throws IOException {
		InputStream input = null;
		AssetsExcelVo[] fromJson;
		try {
			input = ExcelUtil.class.getClassLoader().getResourceAsStream("data/asset.json");
			BufferedReader reader = new BufferedReader(new InputStreamReader(input, Charsets.toCharset("UTF-8")));
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();
			while (line != null) {
				sb.append(line);
				line = reader.readLine();
			}
			Gson gson = new Gson();
			String json = sb.toString();
			fromJson = gson.fromJson(json, AssetsExcelVo[].class);
		}finally {
			if(input!=null){
				input.close();
			}
		}
		return fromJson;
	}

	/**
	 * 机构导入excel title样式
	 * 
	 * @param workbook
	 * @return
	 */
	private static HSSFCellStyle getCommonStyle(HSSFWorkbook workbook) {

		HSSFCellStyle titleStyle = workbook.createCellStyle();

		HSSFFont titlefont = workbook.createFont();
		titlefont.setFontName("宋体");
		titlefont.setColor(HSSFColor.BLACK.index);
		titlefont.setFontHeightInPoints((short) 10);

		titleStyle.setWrapText(true); // 自动换行
		titleStyle.setFont(titlefont);
		titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
		// 设置边框
		titleStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		titleStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		titleStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		titleStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		return titleStyle;
	}

	/**
	 * 机构导入 excel header 样式
	 * 
	 * @param workbook
	 * @return
	 */
	private static HSSFCellStyle getHeaderCellStyle(HSSFWorkbook workbook) {
		HSSFCellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
		headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平居中

		// 背景边框
		headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);

		// 背景颜色
		headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		headerStyle.setFillForegroundColor(HSSFColor.ROYAL_BLUE.index);

		HSSFFont font = workbook.createFont();
		font.setFontName("微软雅黑");
		font.setColor(HSSFColor.WHITE.index);
		font.setFontHeightInPoints((short) 10); // 字体大小
		headerStyle.setFont(font);
		return headerStyle;
	}

	public static Map<Integer,Field> mapExcelColumn(Class<?> clazz){
		Map<Integer,Field> map = new HashMap<Integer,Field>();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			ExcelColumn annotation = field.getDeclaredAnnotation(ExcelColumn.class);
			if(annotation!=null){
				map.put(annotation.value(), field);
			}
		}
		return map;
	}
	
	public static Workbook getWorkbook(InputStream inputstream) throws InvalidFormatException, IOException{
		Workbook book = null;
		if (!(inputstream .markSupported())) {
            inputstream = new PushbackInputStream(inputstream, 8);
        }
        if (POIFSFileSystem.hasPOIFSHeader(inputstream)) {
            book = new HSSFWorkbook(inputstream);
        } else if (POIXMLDocument.hasOOXMLHeader(inputstream)) {
            book = new XSSFWorkbook(OPCPackage.open(inputstream));
        }
		return book;
	}

	public static Object getCellValue(Cell cell, Field field) {
		Type type = field.getGenericType();
		if (cell==null || cell.toString().trim().equals("")) {
			if(type==Long.class||type==Integer.class){
				return null;
			}else if(type==long.class||type==int.class){
				return 0;
			}
			return "";
		}
		Object cellValue = "";
		int cellType=cell.getCellType();
		if(cellType==Cell.CELL_TYPE_FORMULA){ //表达式类型
			FormulaEvaluator evaluator = cell.getRow().getSheet().getWorkbook().getCreationHelper().createFormulaEvaluator();
			cellType=evaluator.evaluate(cell).getCellType();
		}
		switch (cellType) {
		case Cell.CELL_TYPE_STRING:
			String val = cell.getStringCellValue().trim();
			if(StringUtils.isEmpty(val)){
				if(type==long.class){
					cellValue = 0;
				}else if(type==Long.class){
					cellValue = null;
				}else{
					cellValue = "";
				}
			}else{
				if(type==Long.class||type==long.class){
					cellValue = Long.valueOf(val);
				}else{
					cellValue = val;
				}
			}
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_NUMERIC:
			ExcelColumn annotation = field.getDeclaredAnnotation(ExcelColumn.class);
			if(annotation!=null&&annotation.relFieldType()==Date.class&&StringUtils.isNotBlank(annotation.relField())){
				cellValue = cell.getDateCellValue();
			} else if(type==Date.class){
				cellValue = cell.getDateCellValue();
			} else if(type==String.class){
				DecimalFormat df=null;
				if(annotation!=null&&annotation.relField().equals("price")){
					df = new DecimalFormat("0.00");
				}else{
					 df = new DecimalFormat("0");
				}
				cellValue = df.format(cell.getNumericCellValue());
			}else if(type==Long.class||type==long.class){
				cellValue = ((Double)(cell.getNumericCellValue()*100)).longValue();
			}  
			break;
		default:
			cellValue = "";
			break;
		}
		return cellValue;
	}

	public static void setCellValue(Cell cell, Field field, Object obj, ExcelColumn anno, HSSFWorkbook workbook, HSSFCellStyle cellStyle, HSSFCellStyle moneyStyle, HSSFCellStyle dateStyle) throws IllegalArgumentException, IllegalAccessException {
		field.setAccessible(true);
		cell.setCellStyle(cellStyle);
		Object valObj = field.get(obj);
		if(valObj==null){
			return ;
		}
		Type type = field.getGenericType();
		if(anno!=null&&StringUtils.isNotBlank(anno.format())&&anno.format().equals("money")){
			cell.setCellStyle(moneyStyle);
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			try {
				BigDecimal bg = new BigDecimal(valObj.toString()).setScale(2);
				cell.setCellValue(bg.doubleValue());
			} catch (Exception e) {
				cell.setCellValue(valObj.toString());
			}
		}else if(anno!=null&&StringUtils.isNotBlank(anno.baseDataType())){
			cell.setCellType(Cell.CELL_TYPE_STRING);
			cell.setCellValue(valObj.toString());
		}else if(type==Date.class){
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellStyle(dateStyle);
			short fmt = workbook.createDataFormat().getFormat(DateUtil.DATE_PATTERN.YYYY_MM_DD);
			cellStyle.setDataFormat(fmt);
			cell.setCellValue((Date)valObj);
		}else if(type==Integer.class||type==int.class){
			cell.setCellType(Cell.CELL_TYPE_NUMERIC);
			cell.setCellValue((Integer)valObj);
		}else{
			HSSFCellStyle textStyle = cellStyle;
			HSSFDataFormat format = workbook.createDataFormat();
			textStyle.setDataFormat(format.getFormat("@"));
			cell.setCellStyle(textStyle);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			cell.setCellValue((String)valObj);
		}
	}
}
