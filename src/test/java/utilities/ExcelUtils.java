package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public FileInputStream fs;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String filename;

	public ExcelUtils(String filename) {

		this.filename = filename;
	}

	public int getRowCount(String sheetname) throws IOException {
		fs = new FileInputStream(filename);
		workbook = new XSSFWorkbook(fs);
		sheet = workbook.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fs.close();
		return rowcount;
	}

	public int getCellCount(String sheetname, int rownum) throws IOException {
		fs = new FileInputStream(filename);
		workbook = new XSSFWorkbook(fs);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		workbook.close();
		fs.close();
		return cellcount;
	}

	public String getCellData(String sheetname, int rownum, int cellnum) throws IOException {

		fs = new FileInputStream(filename);
		workbook = new XSSFWorkbook(fs);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);

		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data = "";
		}
		workbook.close();
		fs.close();
		return data;
	}

	public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {
		File xlfile = new File(filename);
		if (!xlfile.exists()) // If file not exists then create new file
		{
			workbook = new XSSFWorkbook();
			fo = new FileOutputStream(filename);
			workbook.write(fo);
		}

		fs = new FileInputStream(filename);
		workbook = new XSSFWorkbook(fs);

		if (workbook.getSheetIndex(sheetName) == -1) // If sheet not exists then create new Sheet
			workbook.createSheet(sheetName);
		sheet = workbook.getSheet(sheetName);

		if (sheet.getRow(rownum) == null) // If row not exists then create new Row
			sheet.createRow(rownum);
		row = sheet.getRow(rownum);

		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(filename);
		workbook.write(fo);
		workbook.close();
		fs.close();
		fo.close();
	}

	public void fillGreenColor(String sheetName, int rownum, int colnum) throws IOException {
		fs = new FileInputStream(filename);
		workbook = new XSSFWorkbook(fs);
		sheet = workbook.getSheet(sheetName);

		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);

		style = workbook.createCellStyle();

		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		workbook.write(fo);
		workbook.close();
		fs.close();
		fo.close();
	}

	public void fillRedColor(String sheetName, int rownum, int colnum) throws IOException {
		fs = new FileInputStream(filename);
		workbook = new XSSFWorkbook(fs);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);

		style = workbook.createCellStyle();

		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		workbook.write(fo);
		workbook.close();
		fs.close();
		fo.close();
	}

}
