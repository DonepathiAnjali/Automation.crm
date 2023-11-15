package com.PageObjects;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utils.Utils;
import com.base.Testbase;

public class AddToInventory extends Testbase {

	public AddToInventory() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
	//addnew
	@FindBy(xpath="//a[@href='/Inventory/InventoryData?CategoryId=0&SubCategoryId=0']")
	WebElement Addnewelement;
	//category
	@FindBy(id="catDD")
	WebElement category;
	//sub category
	@FindBy(id="subcatDD")
	WebElement sub_category;
	//Inventory status
	@FindBy(id="InventoryStatusId")
	WebElement Inventory_Status;
	//Inventory condition
	@FindBy(id="InventoryConditonId")
	WebElement Inventory_Condition;
	//Inventory location
	@FindBy(id="InventoryLocationId")
	WebElement Inventory_Location;
	//MRP Factory
	@FindBy(id="factor")
	WebElement MRP_Factory;
	//modelNo
	@FindBy(name="ModelNumber")
	WebElement ModelNo;
	//title
	@FindBy(xpath="//div[@class='form-group']/textarea[@name='Title']")
	WebElement title;
	//Item description
	@FindBy(xpath="//div[@class='form-group']/textarea[@name='ItemDescription']")
	WebElement ItemDes;
	//brand
	@FindBy(name="Brand")
	WebElement brand;
	//Height
	@FindBy(name="Height")
	WebElement height;
	//width
	@FindBy(name="Width")
	WebElement width;
	//breadth
	@FindBy(name="Breadth")
	WebElement breadth;
	//color
	@FindBy(name="ColorName")
	WebElement color;
	//recieved Date
	@FindBy(id="RecievedDate")
	WebElement date;
	//actual price
	@FindBy(id="actual")
	WebElement Aprice;
	//HsN code
	@FindBy(name="HSNCode")
	WebElement hsncode;
	//rackname
	@FindBy(name="RackName")
	WebElement rackname;
	//poddetails
	@FindBy(name="PODetails")
	WebElement POdetails;
	//invoice no
	@FindBy(name="InvoiceNumber")
	WebElement INo;
	//quantity
	@FindBy(name="Qty")
	WebElement Quantity;
	//color image
	@FindBy(xpath="//div[@class='form-group']/input[@name='ColorImageUploaded']")
	WebElement colorI;
	//primary image upload
	@FindBy(name="ProductMainImageUploaded")
	WebElement PMImage;
	//product Other image Upload
	@FindBy(name="ProductOtherImagesUploaded")
	WebElement POImage;
	//save
	@FindBy(xpath="//button[text()=' Save']")
	WebElement savebtn;
	public  AddToInventory(WebDriver driver)throws Throwable
	{
		PageFactory.initElements(driver,this);
	}
public void AddProductToInventory(String Category,String ModelNumber,String Title,String ItemDescription,String Brand,String Height,String Width,String Breadth,String Color,String InventoryStatus,String InventoryCondition,String InventoryLocation,String RDate,String ActPrice,String Mrp,String HSNcode,String RName,String PODetails,String InvoiceNo,String quantity) throws AWTException, InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Utils.waitForElement(Addnewelement);
	js.executeScript("arguments[0].click()",Addnewelement);
	Utils.dropdownBy(Category,category);
	ModelNo.sendKeys(ModelNumber); 
	title.sendKeys(Title);
	ItemDes.sendKeys(ItemDescription);
	brand.sendKeys(Brand);
	height.sendKeys(Height);
	width.sendKeys(Width);
	breadth.sendKeys(Breadth);
	color.sendKeys(Color);
	js.executeScript("arguments[0].click()",colorI);
	Utils.fileupload("C:\\Users\\pc\\Downloads\\color.jpg");
	Utils.dropdownBy(InventoryStatus,Inventory_Status);
	Utils.dropdownBy(InventoryCondition,Inventory_Condition);
	Utils.dropdownBy(InventoryLocation,Inventory_Location);
	date.sendKeys(RDate);
	Aprice.sendKeys(ActPrice);
	Utils.dropdownBy(Mrp,MRP_Factory);
	hsncode.sendKeys(HSNcode);
	rackname.sendKeys(RName);
	POdetails.sendKeys(PODetails);
	INo.sendKeys(InvoiceNo);
	Quantity.clear();
	Quantity.sendKeys(quantity);
	js.executeScript("arguments[0].click()",PMImage);
	Utils.fileupload("C:\\Users\\pc\\Downloads\\lamp2.jpg");
	js.executeScript("arguments[0].click()",POImage);
	Utils.fileupload("C:\\Users\\pc\\Downloads\\lamp1.jpg");
	savebtn.click();
	}

}
