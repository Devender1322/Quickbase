package Com.Quickbase.pageObject;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class HelpModal {

	WebDriver driver;

	public HelpModal(WebDriver dr) {
		driver = dr;
		PageFactory.initElements(dr, this);
	}

	@FindBy(id = ("helpMySupportCasesLink"))
	WebElement helpMySupportCasesLink;
	@FindBy(className = ("FS-H2"))
	WebElement VerifyHelpmodaltitle;
	@FindBy(id = ("newCaseButton"))
	WebElement newCaseButton;

	public void ClickhelpMySupportCasesLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(helpMySupportCasesLink));
		SoftAssert a = new SoftAssert();
		String expt = "What do you need help with?";
		String act = VerifyHelpmodaltitle.getText();
		System.out.println(act);
		assertEquals(act, expt);
		a.assertAll();
		helpMySupportCasesLink.click();

	}

	public void ClicknewCaseButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(newCaseButton));
		newCaseButton.click();
	}
}
