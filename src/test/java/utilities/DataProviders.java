package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {
	//dataprovider1

	@DataProvider(name = "dp")
	public Object[][] getData() throws IOException {

		String filename = ".\\testData\\LetsShop_LoginTestData.xlsx";
		ExcelUtils excelutils = new ExcelUtils(filename);
		int totalrows = excelutils.getRowCount("Sheet1");
		System.out.println(totalrows);
		int totalcolms = excelutils.getCellCount("Sheet1", 1);
		System.out.println(totalcolms);
		
		Object logindata[][] = new Object[totalrows][totalcolms];

		for (int i=1; i<=totalrows; i++) {
		
			for (int j=0; j<totalcolms; j++) {
				
				logindata[i-1][j] = excelutils.getCellData("Sheet1", i, j);	
			}
		}

		return logindata;
	}
	
	//dataprovider2
	
	//dataprovider3

}
