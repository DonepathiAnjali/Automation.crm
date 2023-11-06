package com.testcases;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.PageObjects.Homepage;
import com.PageObjects.Login_functionality;
import com.PageObjects.StockMove;
import com.base.Testbase;

public class MoveStockTest extends Testbase {
	public MoveStockTest(WebDriver driver) throws Throwable {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 Login_functionality lf;
	 Homepage h;
	 MoveStockTest m;
	 StockMove sm;
	 @BeforeMethod
	 public void setup() throws Throwable {

			Initialization();
			 lf = new Login_functionality(driver);
			 h=new Homepage(driver);
			 m=new MoveStockTest(driver);
			 sm=new StockMove(driver);
			 lf.Dologin();
			  
	 }
	 @Test(priority=1)
	 public void wareHouseToshowRoom() throws Throwable
	 {
		 
		 h.movestock();
		 m.wareHouseToshowRoom();
		 sm.verifyWareHousetoShowRoom();
		 
	 }
	 @Test(priority=2)
	 public void showRoomtowareHouse() throws Throwable
	 {
		  
		 h.movestock();
		 m.showRoomtowareHouse();
		 sm.verifyStockRoomtoWareHouse();
	 }
}