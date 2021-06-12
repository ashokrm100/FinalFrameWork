package com.DemoGuru.Utility;

import java.io.FileInputStream;

import org.apache.poi.hssf.model.RowBlocksReader;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	XSSFWorkbook excel;
	XSSFSheet sheet;
	XSSFCell cell;
	XSSFRow row;
	FileInputStream fis;
	String path;
	public ExcelUtility(String path) {
		// TODO Auto-generated constructor stub
		this.path=path;
			}

	public Integer getRowCount(String sheetname)
	{
		int rows=0;
		try {
		fis=new FileInputStream(path);
		excel = new XSSFWorkbook(fis);
		sheet= excel.getSheet(sheetname);
		rows=sheet.getLastRowNum();
		excel.close();
		fis.close();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return rows;
	}
	
	public Integer getCellCount(int rownum,String sheetname)
	{
		int cols=0;
		
		
		try
		{
			fis=new FileInputStream(path);
			excel= new XSSFWorkbook(fis);
			sheet=excel.getSheet(sheetname);
			cols=sheet.getRow(rownum).getLastCellNum();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return cols;
	}
	
	public String excelContent(String sheetname, int rownum, int cellnum) 
	{
		
		String data=null;
		try {
		fis=new FileInputStream(path);
		excel = new XSSFWorkbook(fis);
		sheet = excel.getSheet(sheetname);
		data = sheet.getRow(rownum).getCell(cellnum).toString();
		excel.close();
		fis.close();		
				
		}catch(Exception e) {
			
		}
		
		return data;
	}
	
	
	

}
