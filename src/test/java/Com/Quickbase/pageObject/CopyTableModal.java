package Com.Quickbase.pageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.asserts.SoftAssert;

public class CopyTableModal {
	WebDriver driver;

	public CopyTableModal(WebDriver dr) {
		driver = dr;
		PageFactory.initElements(dr, this);

	}

	@FindBy(xpath = ("//span[@id='ui-id-3']"))
	WebElement CopyTableModal;
	@FindBy(xpath = ("//input[@name='createNewTableName']"))
	WebElement CopyOfTableName;
	@FindBy(xpath = ("//textarea[@name='createNewTableDesc']"))
	WebElement TableDescription;
	@FindBy(xpath = ("//select[@name='access']"))
	WebElement AccessButton;
	@FindBy(xpath = ("//button[text()='Copy']"))
	WebElement CopyButton;
	@FindBy(linkText = ("Copy of test"))
	WebElement CopiedTable;

	public void Copytabletitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(CopyTableModal));
		String sd = CopyTableModal.getText();
		System.out.println("Title is " + sd);
		SoftAssert sf = new SoftAssert();
		String atext = "Copy Table";
		AssertJUnit.assertEquals(atext, sd);
		sf.assertAll();

	}

	public void CopyOfTableName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(CopyOfTableName));
		String sd = CopyOfTableName.getAttribute("value");
		System.out.println("Title is " + sd);
		SoftAssert sf = new SoftAssert();
		String atext = "Copy of test";
		AssertJUnit.assertEquals(atext, sd);
		sf.assertAll();

	}

	public void TableDescription(String s) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(TableDescription));
		TableDescription.sendKeys(s);

	}

	public void ScrollDown() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(CopyButton));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", CopyButton);
	}

	public void AcessDropdown() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(AccessButton));
		Select sd = new Select(AccessButton);
		sd.selectByValue("view");

	}

	public void ClickCopyBtn() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(CopyButton));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", CopyButton);
	}

	public void ClickCopiedTable() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(CopiedTable));
		String sd = CopiedTable.getText();
		System.out.println("Created Table is: " + sd);
		SoftAssert sf = new SoftAssert();
		String atext = "Copy of test";
		AssertJUnit.assertEquals(atext, sd);
		sf.assertAll();

	}
}
