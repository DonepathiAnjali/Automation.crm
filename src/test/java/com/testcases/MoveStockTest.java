package com.testcases;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.PageObjects.Homepage;
import com.PageObjects.Login_functionality;
import com.PageObjects.StockMove;
import com.PageObjects.moveStock;
import com.base.Testbase;

public class MoveStockTest extends Testbase {
	
	public MoveStockTest() throws Throwable {
		
		super();
		// TODO Auto-generated constructor stub
	}
	Login_functionality lf;
	
	Homepage h;
	
	moveStock m;
	
	StockMove sm;
	
	@BeforeMethod
	
	public void setup() throws Throwable {

		Initialization();
		lf = new Login_functionality(driver);
		h=new Homepage(driver);
		m=new moveStock(driver);
		sm=new StockMove(driver);
		lf.Dologin();

	}
	@Test(priority=1)
	public void warehouseToshowroom() throws Throwable
	{

		h.movestock();
		m.warehousetoshowroom();
		sm.verifyWareHousetoStockRoom();

	}
	@Test(priority=2)
	public void showroomtowarehouse() throws Throwable
	{

		h.movestock();
		m.showroomtowarehouse();
		sm.verifyStockRoomtoWareHouse();
	}
}

