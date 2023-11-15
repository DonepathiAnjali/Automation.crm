package com.PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.Utils;
import com.base.Testbase;

public class Homepage extends Testbase{
	
	public Homepage() throws Throwable {
		
		super();
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//i[contains(@class,'fa-houzz')]")
	WebElement Inventory;
	
	@FindBy(xpath="//ul[@class='treeview-menu']/li/a[text()='All Inventory']")
	WebElement AllInventory;
	
	@FindBy(xpath="//ul[@class='treeview-menu']/li/a[contains(text(),'Move Stock')]")
	WebElement Movestock;
	
	@FindBy(xpath="//i[contains(@class,'fa-database')]")
	WebElement master; 
	
	@FindBy(xpath="//a[@href='/Master/Usertypes']")
	WebElement usertype;

	private WebElement customer;

	private WebElement addcustomer;

	private WebElement allcustomer;
	
	public Homepage(WebDriver driver)throws Throwable
    {
    	PageFactory.initElements(driver,this);
    }
    public  AddToInventory inventory() throws Throwable
    {
    	Utils.moveToElement(Inventory);
    	
    	AllInventory.click();	 
    	
		return  new AddToInventory();
		
    }
    
    public void movestock()
    
    {
    	Utils.moveToElement(Inventory);
    	
    	Movestock.click();
    }
 
	public void usertype() {
		
    	Utils.moveToElement(master);
    	
    	usertype.click();
	}
	
	
	
	public void addcustomer()
	
	{
		Utils.moveToElement(customer);
		addcustomer.click();
	}
	public void editcustomer()
	{
		Utils.moveToElement(customer);
		allcustomer.click();
	}
	
 
	
	public  Location location() throws Throwable
	
	{
		Utils.moveToElement(master);
		
		LocationFunctionality.click1();
		
		return  new Location(0, 0, 0);
	
	}
	public Condition_functionality Condition ()throws Throwable
	{
		Utils.moveToElement(master);
		
		Condition_functionality.click();
		
		return new Condition_functionality();
  }
	
}