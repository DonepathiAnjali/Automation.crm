package com.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PageObjects.Login_functionality;
import com.base.Testbase;

public class Holidays_Test extends Testbase {
	
	com.PageObjects.Holidays_Functionality hf;
	
	Login_functionality lf;
	
	public Holidays_Test() throws Throwable    {
		
		super();

	}
	
	@BeforeMethod
	public void setup() throws Throwable {
		
		Initialization();
		
		lf=new Login_functionality(driver);
		
		lf.Dologin();
		
		hf=new com.PageObjects.Holidays_Functionality(driver);
	}
	
	@Test
	public void validateaddnew() {
		
		hf.verifyHolidays();
	}
}