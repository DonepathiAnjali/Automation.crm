package com.Utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Testbase;
import com.google.common.collect.Table.Cell;

public class Utils extends Testbase {
	    
		 
		public static Object moveToElement;
		public Utils(WebDriver driver) throws Throwable {
			super();
			// TODO Auto-generated constructor stub
		}
		 
		 public static Object[][] readDataFromExcel(String sheetname) throws IOException {
			    FileInputStream fis = new FileInputStream("./src/main/java/com/testdata/AddInventory.xlsx");
			    XSSFWorkbook workbook = new XSSFWorkbook(fis);
			    XSSFSheet sheet = workbook.getSheet(sheetname);

			    int numRows = sheet.getPhysicalNumberOfRows();
			    int numCols = sheet.getRow(0).getLastCellNum();

			    List<Object[]> dataRows = new ArrayList<>();

			    for (int i = 1; i < numRows; i++) {  
			        XSSFRow row = sheet.getRow(i);
			        Object[] rowData = new Object[numCols];
			        boolean isEmptyRow = true;

			        for (int j = 0; j < numCols; j++) {
			            XSSFCell cell = row.getCell(j);
			            if (cell != null) {
			                DataFormatter format = new DataFormatter();
			                rowData[j] = format.formatCellValue(cell);
			                if (!cell.toString().trim().isEmpty()) {
			                    isEmptyRow = false;
			                }
			            }
			        }

			        if (!isEmptyRow) {
			            dataRows.add(rowData);
			        }
			    }

			    Object[][] data = dataRows.toArray(new Object[0][]);

			    return data;
			}

		 
		//select by value
	    public static void dropdown(WebElement wb,String value)
	    {
	    	Select sel=new Select(wb);
	    	sel.selectByValue(value);
	    }
	    //select by index
	    public static void dropdown(WebElement wb,int index)
	    {
	    	Select sel=new Select(wb);
	    	sel.selectByIndex(index);
	    }
	    //select y visible text
	    public static void dropdownBy(String text,WebElement wb)
	    {	
	    	Select sel=new Select(wb);
	    	sel.selectByVisibleText(text);
	    }
	    public static void moveToElement(WebElement wb)
	    {
	    	Actions A=new Actions(driver);
	    	A.moveToElement(wb).click().perform();
	    }
	   public static void waitForElement(WebElement wb)
	   {
		   WebDriverWait wait=new WebDriverWait(driver,30);
		   wait.until(ExpectedConditions.elementToBeClickable(wb));
		   
	   }
	   public static void fileuploadata(String filepath) throws AWTException
	   {
		   
		   StringSelection path=new StringSelection(filepath);//select
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path,null);
			Robot r=new Robot();
			r.delay(5000);
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V); 
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
	   }
	}