package com.testcases;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.PageObjects.Customer_Details;
import com.PageObjects.Customer_List;
import com.PageObjects.Homepage;
import com.PageObjects.Login_functionality;
import com.base.Testbase;

public class Customer_FunctionalityTest extends Testbase {

	Login_functionality lf;
	
	Homepage h;
	
	Customer_Details c;
	
	Customer_List cl;
	
	public Customer_FunctionalityTest() throws Throwable {
		
		super();
	}
	@BeforeMethod
	public void setup() throws Throwable {

		Initialization();
		
		lf = new Login_functionality(driver);
		
		h=new Homepage(driver);
		
		c=new  Customer_Details(driver);
		
		cl=new Customer_List(driver);
		
		lf.Dologin();
	}
	@Test(priority=1)
	public void addcustomer() throws Throwable
	{
		h.addcustomer();
		c.addcustomer();

	}
	@Test(priority=2)
	public void editcustomer() throws Throwable
	{
		h.editcustomer();
		cl.editcustomer();
	}
	@Test(priority=3)
	public void deletecustomer() throws Throwable
	{
		h.editcustomer();
		cl.deletecustomer();
	}
	@Test(priority=4)
	public void verify()
	{
		h.editcustomer();
		cl.verification();
	}
}

