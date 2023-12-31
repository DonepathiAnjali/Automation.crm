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
	//Inventory
	@FindBy(xpath="//i[contains(@class,'fa-houzz')]")
	WebElement Inventory;
	//all inventory
	@FindBy(xpath="//ul[@class='treeview-menu']/li/a[text()='All Inventory']")
	WebElement AllInventory;
	//movestock
	@FindBy(xpath="//ul[@class='treeview-menu']/li/a[contains(text(),'Move Stock')]")
	WebElement Movestock;
	//master
	@FindBy(xpath="//i[contains(@class,'fa-database')]")
	WebElement master; 

	//customer
	@FindBy(xpath="//i[contains(@class,'fa-users')]")
	WebElement customer;
	//all customers
	@FindBy(linkText="All Customers")
	WebElement allcustomer;
	//add customer
	@FindBy(linkText="Add Customer")
	WebElement addcustomer;
	//usertype
		@FindBy(xpath="//a[@href='/Master/Usertypes']")
		WebElement usertype;
	//holiday
		@FindBy(linkText="Holidays")
		WebElement holidays;
		
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

    
   
    

    public   moveStock movestock() throws Throwable

    {
    	Utils.moveToElement(Inventory);
    	
    	Movestock.click();
		return new moveStock();
		 
    }
 


		

	public  UserType usertype() throws Throwable {
  

    	Utils.moveToElement(master);
    	
    	usertype.click();
    	
		return new UserType();
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
	
	public ShiftData Shifts() throws Throwable
	
	{
		Utils.moveToElement(master);
		
		ShiftData.click();
		
		return new ShiftData();
		
	}
	public CompanyData company1() throws Throwable
	{
		Utils.moveToElement(master);
		CompanyData.click();
		return new CompanyData();
  }
	public void company() {
		// TODO Auto-generated method stub
		
	}}
