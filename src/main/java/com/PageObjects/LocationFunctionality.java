package com.PageObjects;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.base.Testbase;

public class LocationFunctionality extends Testbase
{

	public LocationFunctionality() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
	//addnew
	@FindBy(xpath="//i [contains(@class,'fa fa-plus')]")
	WebElement addnew;
	
	//search
	@FindBy(xpath="//input[contains(@class,'form-control-sm')]")
	WebElement search;
	
	//edit
	@FindBy(xpath="//i[contains(@class,'fa-pencil')]")
	WebElement edit;
	
	//delete
	@FindBy(xpath="//i[contains(@class,'fa-trash')]")
	WebElement delete;
	
	//yes
	@FindBy(xpath="//button[text()='Yes']")
	WebElement yes;
	
	//table
	@FindBy(xpath="//table[@id=\"mydatatable\"]/tbody/tr/td")
	
	List<WebElement> table;
	
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	
	public LocationFunctionality(WebDriver driver)throws Throwable
	{
		PageFactory.initElements(driver,this);
	}
	public LocationData addlocation() throws Throwable
	{

		jse.executeScript("arguments[0].click()",addnew);
		
		return new LocationData();

	}
	
	public LocationData editlocation() throws Throwable
	{
		search.sendKeys(props.getProperty("location"));
		
		jse.executeScript("arguments[0].click()",edit);
		
		return new LocationData();	
	}
	
	public LocationData deletecustomer()throws Throwable
	{
		search.sendKeys(props.getProperty("clocation"));
		
		jse.executeScript("arguments[0].click()",delete);
		
		yes.click();
		
		return new LocationData(); 	
	}
	
	public void verification()
	{
		search.sendKeys(props.getProperty("clocation"));
		
		for(WebElement row:table)
		{
			String Text=row.getText();
			
			System.out.println(Text);
			
			Assert.assertEquals(Text,"No matching records found");
		}
	}
	public static void click1() {
		// TODO Auto-generated method stub
		
	
	}
	
}

