package Com.Quickbase.testclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import org.testng.annotations.*;
import Com.Quickbase.pageObject.*;

public class Testcases extends BeforeAndAfter {

	@Test(priority = 1)

	public void test1() throws InterruptedException, AWTException {
		HomePage ftc = new HomePage(ldriver);
		ProjectManagerHome pmh = new ProjectManagerHome(ldriver);
		DefaultReportPage DR = new DefaultReportPage(ldriver);
		ftc.ClickSimple();
		pmh.ClickProject();
		DR.ClickFirstCheckbox();
		DR.ClickSecondCheckbox();
		DR.ClickthirdCheckbox();
		DR.ClickAllCheckbox();
		DR.ClickStatus();
		DR.EnterStatus("In-pro");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		DR.VerifyInPro();
		Thread.sleep(10000);
		DR.RemoveStatus();
		Thread.sleep(10000);
		DR.ClickStatus();
		DR.EnterStatus("Com");
		robot.keyPress(KeyEvent.VK_ENTER);
		DR.VerifyCompleted();
		Thread.sleep(10000);
		DR.RemoveStatus();
		Thread.sleep(10000);
		DR.ClickStatus();
		DR.EnterStatus("On");
		robot.keyPress(KeyEvent.VK_ENTER);
		DR.VerifyOnHold();
		Thread.sleep(10000);
		DR.RemoveStatus();

	}

	@Test(priority = 5)

	public void test2() throws AWTException {
		HomePage ftc = new HomePage(ldriver);
		DeleteModal dm = new DeleteModal(ldriver);
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
		HomePage ftc = new HomePage(ldriver);
		ProjectManagerHome pmh = new ProjectManagerHome(ldriver);
		threedotsondefaultreport tdd = new threedotsondefaultreport(ldriver);
		ftc.ClickSimple();
		pmh.ClickProject();
		tdd.HoverOnProjectcolumn();
		tdd.ThreeDotsOnProjectcolumn();
		Thread.sleep(10000);
		tdd.Modalelements();
		tdd.ClickZtoAOnProjectcolumn();
		tdd.ModalClosed();
		Thread.sleep(10000);
		tdd.HoverOnActualcolumn();
		tdd.ThreeDotsOnActualcolumn();
		tdd.ModalelementsForActualDate();
		tdd.ClickGLETOnActualcolumn();
		tdd.AcModalClosed();

	}

	@Test(priority = 3)
	public void test4() throws InterruptedException, AWTException {
		HomePage ftc = new HomePage(ldriver);
		HelpModal hm = new HelpModal(ldriver);
		NewSupportCase nsc = new NewSupportCase(ldriver);
		ftc.ClickHelp();
		hm.ClickhelpMySupportCasesLink();
		ArrayList<String> newTb = new ArrayList<String>(ldriver.getWindowHandles());
		ldriver.switchTo().window(newTb.get(1));
		hm.ClicknewCaseButton();
		nsc.DragNewSupportCaseModal();
		nsc.AddAttachment();
		nsc.CancelbtnOnSupCase();
		nsc.ModalClosed();
	}

	@Test(priority = 4)

	public void test5() throws InterruptedException {
		HomePage ftc = new HomePage(ldriver);
		CustomerManager cm = new CustomerManager(ldriver);
		CustomerManagerSettings cms = new CustomerManagerSettings(ldriver);
		CustomerManagerTableSettings cmts = new CustomerManagerTableSettings(ldriver);
		CopyTableModal ctm = new CopyTableModal(ldriver);
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
		ldriver.navigate().back();
		cmts.DeleteNewlyTable();
		cmts.Textfield();
		cmts.DeleteTableButton();

	}
}
