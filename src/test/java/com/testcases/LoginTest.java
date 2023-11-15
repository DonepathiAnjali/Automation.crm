package com.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.PageObjects.Login_functionality;
import com.Utils.Utils;
import com.base.Testbase;

public class LoginTest extends Testbase {
	
	private final String Sheetname="Login";
	
	Login_functionality lf;
	

	public LoginTest() throws Throwable {
		super();
	}

	@BeforeMethod

	public void setup() throws Throwable {

		Initialization();

		lf = new Login_functionality(driver);

	}

	@Test

	public void Verifylogin() throws Throwable {

		lf.Dologin();

		String url = driver.getCurrentUrl();

		Assert.assertEquals("http://empirehome.myprojectsonline.co.in/EmpireHome/", url);


	}


	@Test (dataProvider = "Data",dataProviderClass = LoginTest.class)   
	public void verifyloginwithExcel(String Username, String Password) throws Throwable {

		lf.Dologinwithexcel(Username, Password);

		String url = driver.getCurrentUrl();

		Assert.assertEquals("http://empirehome.myprojectsonline.co.in/EmpireHome/", url);

	}

	@DataProvider

	public Object[][] Data() throws IOException{
		
		return Utils.readDataFromExcel(Sheetname);

	}




	@AfterMethod

	public void teardown() {

		//driver.close();

	}

}
