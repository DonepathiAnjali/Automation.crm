package com.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PageObjects.Homepage;
import com.PageObjects.Login_functionality;
import com.Utils.Utils;
import com.base.Testbase;

public class AddToInventoryTest extends Testbase {

	public AddToInventoryTest() throws Throwable {

		super();
		// TODO Auto-generated constructor stub
	}

	private final String Sheetname="AddProduct";

	Login_functionality lf;

	Homepage h; 

	AddToInventoryTest i;


	@BeforeMethod

	public void setup() throws Throwable {

		Initialization();

		lf = new Login_functionality(driver);

		h=new Homepage(driver);

		i=new AddToInventoryTest();	


	}
	@DataProvider
	public Object[][] getdata() throws IOException{

		return Utils.readDataFromExcel("AddProduct");
	}
	
	@Test(dataProvider="getdata",dataProviderClass=AddToInventoryTest.class)
	
	public void addProduct(String Category,String ModelNumber,String Title,String ItemDescription,String Brand,String Height,String Width,String Breadth,String Color,String InventoryStatus,String InventoryCondition,String InventoryLocation,String RDate,String ActPrice,String Mrp,String HSNcode,String RName,String PODetails,String InvoiceNo,String quantity) throws Throwable
	{
		lf.Dologin();

		h.inventory();

		i.addProduct(Category,ModelNumber,Title,ItemDescription,Brand,Height,Width,Breadth,Color,InventoryStatus,InventoryCondition,InventoryLocation,RDate,ActPrice,Mrp,HSNcode,RName,PODetails,InvoiceNo,quantity); 

		String url=driver.getCurrentUrl();

		Assert.assertEquals(url,"http://empirehome.myprojectsonline.co.in/Inventory/All");
	}

}