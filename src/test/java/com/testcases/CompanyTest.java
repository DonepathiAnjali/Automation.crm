package com.testcases;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	import com.PageObjects.CompanyData;
	import com.PageObjects.Homepage;
	import com.PageObjects.Login_functionality;
	import com.base.Testbase;

	public class CompanyTest extends Testbase{

		public CompanyTest() throws Throwable {
			
			super();
			// TODO Auto-generated constructor stub
		}
		Login_functionality l;
		
		Homepage h;
		
		CompanyTest c;
		
		CompanyData cd;
		
	    @BeforeMethod
	    public void setup() throws Throwable
	    {
	    	Initialization();
	    	
	    	 h=new Homepage(driver);
	    	 
	    	 c=new CompanyTest();
	    	 
	    	 cd=new CompanyData(driver);
	    	 
	    	 l=new Login_functionality(driver);
	    }
	    @Test(priority=1)
	    
	    public void editcompany() throws Throwable
	    {
	    	l.Dologin();
	    	
	    	
	    	
	    	c.editcompany();
	    	
	    	cd.editcompany();
	    }
	    @Test(priority=2)
	    public void verify() throws Throwable
	    {
	    	l.Dologin();
	    	
	    	
	    	
	    	c.verify();
	    }
	    @AfterMethod
	    public void teardown()
	    {
	    	driver.quit();
	    }
	}

