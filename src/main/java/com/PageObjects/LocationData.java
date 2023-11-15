package com.PageObjects;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Testbase;

public class LocationData  extends Testbase
{

	public LocationData() throws Throwable {
		
		super();
		// TODO Auto-generated constructor stub
	}
	//location name
	@FindBy(id="LocationName")
	WebElement locationname;
	
	//save
	@FindBy(xpath="//button[contains(@class,'btn-success')]")
	WebElement save;
	
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	
	public LocationData(WebDriver driver)throws Throwable
	{
		PageFactory.initElements(driver,this);
	}
	
	public  LocationData addlocation() throws Throwable
	{
		locationname.sendKeys(props.getProperty("location"));

		jse.executeScript("arguments[0].click()",save);
		
		return new LocationData();
	}
	
	public  LocationData editlocation() throws Throwable
	{
		locationname.clear();
		
		locationname.sendKeys(props.getProperty("clocation"));
		
		jse.executeScript("arguments[0].click()",save);
		
		return new LocationData();

	}
}

