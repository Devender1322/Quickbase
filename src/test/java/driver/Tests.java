package driver;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import org.testng.annotations.*;
import Com.Quickbase.pageObject.*;

public class Tests extends BaseClass {

	@Test(priority = 1)

	public void test1() throws InterruptedException, AWTException {
		test=reports.createTest("Verify the user can change the passowrd");

		HomePage ftc = new HomePage(driver);
		ProjectManagerHome pmh = new ProjectManagerHome(driver);
		DefaultReportPage DR = new DefaultReportPage(driver);
		ftc.ClickSimple();
		pmh.ClickProject();
		logs.info("Clicked on Project icon");
		DR.ClickFirstCheckbox();
		DR.ClickSecondCheckbox();
		DR.ClickthirdCheckbox();
		DR.ClickAllCheckbox();
		DR.ClickStatus();
		DR.EnterStatus("In-pro");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		DR.VerifyInPro();
		DR.RemoveStatus();
		DR.ClickStatus();
		DR.EnterStatus("Com");
		robot.keyPress(KeyEvent.VK_ENTER);
		DR.VerifyCompleted();
		DR.RemoveStatus();
		DR.ClickStatus();
		DR.EnterStatus("On");
		robot.keyPress(KeyEvent.VK_ENTER);
		DR.VerifyOnHold();
		DR.RemoveStatus();

	}

	@Test(priority = 5)

	public void test2() throws AWTException {
		test=reports.createTest("Verify the user can change the passowrd");

		HomePage ftc = new HomePage(driver);
		DeleteModal dm = new DeleteModal(driver);
		ftc.HoverSimple();
		ftc.ClickThreeDot();
		ftc.VerifyDeletebtnOnHomepage();
		ftc.ClickDeletebtnOnHomepage();
		dm.TextOfDeleteModal();
		dm.ClickTextField();
		dm.EntervalueTextFiel("YES");
		dm.ClickNodontdelete();
		ftc.HoverIcons();
		ftc.HoverDetails();
		ftc.ClickDetails();
		ftc.ClickIcons();

	}

	@Test(priority = 2)
	public void test3() throws InterruptedException {
		test=reports.createTest("Verify the user can click on Simple project icon");
		HomePage ftc = new HomePage(driver);
		ProjectManagerHome pmh = new ProjectManagerHome(driver);
		threedotsondefaultreport tdd = new threedotsondefaultreport(driver);
		ftc.ClickSimple();
		pmh.ClickProject();
		tdd.HoverOnProjectcolumn();
		tdd.ThreeDotsOnProjectcolumn();
		tdd.Modalelements();
		tdd.ClickZtoAOnProjectcolumn();
		tdd.ModalClosed();
		tdd.HoverOnActualcolumn();
		tdd.ThreeDotsOnActualcolumn();
		tdd.ModalelementsForActualDate();
		tdd.ClickGLETOnActualcolumn();
		tdd.AcModalClosed();

	}

	@Test(priority = 3)
	public void test4() throws InterruptedException, AWTException {
		test=reports.createTest("Test4");

		HomePage ftc = new HomePage(driver);
		HelpModal hm = new HelpModal(driver);
		NewSupportCase nsc = new NewSupportCase(driver);
		ftc.ClickHelp();
		hm.ClickhelpMySupportCasesLink();
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
		hm.ClicknewCaseButton();
		nsc.DragNewSupportCaseModal();
		nsc.AddAttachment();
		nsc.CancelbtnOnSupCase();
		nsc.ModalClosed();
	}

	@Test(priority = 4)

	public void test5() throws InterruptedException {
		test=reports.createTest("Verify the user can change the passowrd");

		HomePage ftc = new HomePage(driver);
		CustomerManager cm = new CustomerManager(driver);
		CustomerManagerSettings cms = new CustomerManagerSettings(driver);
		CustomerManagerTableSettings cmts = new CustomerManagerTableSettings(driver);
		CopyTableModal ctm = new CopyTableModal(driver);
		ftc.ClickCustomerManager();
		cm.CustomerManagerTooltip();
		cm.ClickSettingbtn();
		cms.OverviewTooltip();
		cms.ScrollTable();
		cms.ClickTable();
		cmts.tableTooltip();
		cmts.SearchTable("Test");
		cmts.SearchTableClear();
		cmts.SearchTable("Time");
		cmts.clearsearchTable();
		cmts.VerifySearchIsCleard();
		cmts.CopytableTooltip();
		cmts.MovetableTooltip();
		cmts.DeletetableTooltip();
		cmts.ClickCopyTable();
		ctm.Copytabletitle();
		ctm.CopyOfTableName();
		ctm.TableDescription("Test");
		ctm.ScrollDown();
		ctm.AcessDropdown();
		Thread.sleep(10000);
		ctm.ClickCopyBtn();
		ctm.ClickCopiedTable();
		driver.navigate().back();
		cmts.DeleteNewlyTable();
		cmts.Textfield();
		cmts.DeleteTableButton();

	}
}
