package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.CategoryBean;
import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dao.UniformDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ApachePOIExcelReadAddProducts;
import com.training.readexcel.ApachePOIExcelReadAddProductsInvalid;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "db-inputs1")
	public Object [][] getDBData1() {

		List<CategoryBean> list1 = new UniformDAO().getLogins(); 
		
		Object[][] result = new Object[list1.size()][]; 
		int count = 0; 
		for(CategoryBean temp : list1){
			Object[]  obj = new Object[4]; 
			obj[0] = temp.getcategoryname(); 
			obj[1] = temp.getdescription(); 
			obj[2] = temp.getmetatagtitle();
			obj[3] = temp.getmetatagdescription(); 
			
			
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\LekhaYuvaraj\\Documents\\automation testing\\TestData\\ComplexTestData.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "excel-inputs-products")
	public Object[][] getExcelData1(){
		String fileName ="C:\\Users\\LekhaYuvaraj\\Documents\\automation testing\\TestData\\ComplexTestData.xlsx"; 
		return new ApachePOIExcelReadAddProducts().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "excel-inputs-products-invalid")
	public Object[][] getExcelData2(){
		String fileName ="C:\\Users\\LekhaYuvaraj\\Documents\\automation testing\\TestData\\ComplexTestData.xlsx"; 
		return new ApachePOIExcelReadAddProductsInvalid().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
