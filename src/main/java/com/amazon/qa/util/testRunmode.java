package com.amazon.qa.util;

import com.amazon.qa.base.TestBase;

public class testRunmode extends TestBase{
	
	//Excel sheet load karne
	public static ExcelReader excel =new ExcelReader(System.getProperty("user.dir")+"\\src\\main\\java\\com\\amazon\\qa\\testdata\\Suite.xlsx");
	
	public static boolean isExecutable(String TestcaseName ){
		
		//check the output excelsheet
		String sheetName="Suite";
		int rows=excel.getRowCount(sheetName);
		for(int rownum=2;rownum<=rows;rownum++)
		{
			if(excel.getCellData(sheetName, "tcid", rownum).equals("TestcaseName")){
				if(excel.getCellData(sheetName, "runmod", rownum).equals("Y")){
					return true;
					
				}else
					
					return false;
					
				}
			}
		
		      return false;
		}
		
		
	
	
	    public static void main(String[] args) {
		System.out.println(isExecutable("TestcaseName"));

	}

}
