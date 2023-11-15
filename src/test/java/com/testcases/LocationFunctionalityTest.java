package com.testcases;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.PageObjects.Homepage;
import com.PageObjects.LocationData;
import com.PageObjects.LocationFunctionality;
import com.PageObjects.Login_functionality;
import com.base.Testbase;

public class LocationFunctionalityTest extends Testbase{

	public LocationFunctionalityTest() throws Throwable {

		super();
	}
	Login_functionality lf;
	
	Homepage h;
	
	LocationFunctionality l;
	
	LocationData ltd;
	
	@BeforeMethod
	public void setup() throws Throwable
	{
		Initialization();
		
		lf=new Login_functionality(driver);
		
		h=new Homepage(driver);
		
		l=new LocationFunctionality(driver);
		
		ltd=new LocationData(driver);
		
		lf.Dologin();
	}
	@Test(priority=1)
	public void addlocation() throws Throwable
	{
		h.location();
		
		l.addlocation();
		
		ltd.addlocation();
	}
	
	@Test(priority=2)
	
	public void editcustomer() throws Throwable
	{
		h.location();
		
		l.editlocation();
		
		ltd.editlocation();
	}
	
	@Test(priority=3)
	
	public void deletecustomer() throws Throwable
	{
		h.location();
		
		l.deletecustomer();
	}
	
	@Test(priority=4)
	
	public void verify() throws Throwable
	{
		h.location();
		
		l.verification();
	}
}

