package com.PageObjects;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.Testbase;

public class StockMove extends Testbase
{

	public StockMove() throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//input[contains(@class,'form-control-sm')]")
	WebElement search;
	
	@FindBy(xpath="//table[@id='mydatatable']/tbody/tr/td[9]")
	List<WebElement> table;
	
	public StockMove(WebDriver driver)throws Throwable
	{
		PageFactory.initElements(driver,this);
	}
	public void verifyWareHousetoShowRoom()
	{
		search.sendKeys(props.getProperty("Note"));
		
		for(WebElement row:table)
		{
			String note=row.getText();
			
			if(note.equals(props.getProperty("Note")))
			{
				Assert.assertEquals(note,props.getProperty("Note"));
				
				break;
			}
		}
	}
	public void verifyStockRoomtoWareHouse()
	{
		search.sendKeys(props.getProperty("Notes"));
		
		for(WebElement row:table)
		{
			String notes=row.getText();
			
			if(notes.equals(props.getProperty("Notes")))
				
			{
				Assert.assertEquals(notes,props.getProperty("Notes"));
				
				break;
			}
		}
	}
}


