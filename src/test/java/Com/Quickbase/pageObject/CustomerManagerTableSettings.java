package Com.Quickbase.pageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.asserts.SoftAssert;

public class CustomerManagerTableSettings {

	WebDriver driver;

	public CustomerManagerTableSettings(WebDriver dr) {
		driver = dr;
		PageFactory.initElements(dr, this);

	}

	@FindBy(xpath = ("//div[text()='Tables']"))
	WebElement tableTooltip;
	@FindBy(id = ("tablesSearch"))
	WebElement tablesSearch;
	@FindBy(xpath = ("//span[@id='scopeItems']/label/span/a"))
	WebElement clearsearch;
	@FindBy(css = ("#tablesSearch"))
	WebElement VerifySearchIsCleard;
	@FindBy(css = (".AppScopeItem .clearsearch"))
	WebElement CrossButton;
	@FindBy(xpath = ("//tr[@id='0']/td/span[1]/a[1]"))
	WebElement CopyTable;
	@FindBy(xpath = ("//tr[@id='0']/td/span[1]/a[2]"))
	WebElement MoveTable;
	@FindBy(xpath = ("//tr[@id='0']/td/span[1]/a[3]"))
	WebElement DeleteTable;
	@FindBy(xpath = ("//tr[@id='7']/td[8]/span/a[3]"))
	WebElement DeleteNewlyTable;
	@FindBy(id = ("typeYesField"))
	WebElement Textfield;
	@FindBy(xpath = ("//button[text()='Delete Table']"))
	WebElement DeleteTableButton;

	public void tableTooltip() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(tableTooltip));
		Actions a = new Actions(driver);
		a.moveToElement(tableTooltip).perform();
		String sd = tableTooltip.getAttribute("data-original-title");
		System.out.println("TOoltip is " + sd);
		SoftAssert sf = new SoftAssert();
		String atext = "Tables";
		AssertJUnit.assertEquals(atext, sd);
		sf.assertAll();
	}

	public void SearchTable(String S) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(tablesSearch));
		tablesSearch.sendKeys(S);
	}

	public void SearchTableClear() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(tablesSearch));
		tablesSearch.clear();
	}

	public void clearsearchTable() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(CrossButton));
		CrossButton.click();
	}

	public void VerifySearchIsCleard() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(VerifySearchIsCleard));
		String sd = VerifySearchIsCleard.getAttribute("class");
		System.out.println("TOoltip is " + sd);
		SoftAssert sf = new SoftAssert();
		String atext = "clearableInput DoSearch UserInput WithPadding Empty";
		AssertJUnit.assertEquals(atext, sd);
		sf.assertAll();
	}

	public void CopytableTooltip() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(CopyTable));
		Actions a = new Actions(driver);
		a.moveToElement(CopyTable).perform();
		String sd = CopyTable.getAttribute("title");
		System.out.println("TOoltip is " + sd);
		SoftAssert sf = new SoftAssert();
		String atext = "Copy this table";
		AssertJUnit.assertEquals(atext, sd);
		sf.assertAll();
	}

	public void MovetableTooltip() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(MoveTable));
		Actions a = new Actions(driver);
		a.moveToElement(MoveTable).perform();
		String sd = MoveTable.getAttribute("title");
		System.out.println("TOoltip is " + sd);
		SoftAssert sf = new SoftAssert();
		String atext = "Move this table to a new app";
		AssertJUnit.assertEquals(atext, sd);
		sf.assertAll();
	}

	public void DeletetableTooltip() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(DeleteTable));
		Actions a = new Actions(driver);
		a.moveToElement(DeleteTable).perform();
		String sd = DeleteTable.getAttribute("title");
		System.out.println("TOoltip is " + sd);
		SoftAssert sf = new SoftAssert();
		String atext = "Permanently delete this table";
		AssertJUnit.assertEquals(atext, sd);
		sf.assertAll();
	}

	public void ClickCopyTable() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(CopyTable));
		CopyTable.click();
	}

	public void DeleteNewlyTable() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(DeleteNewlyTable));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", DeleteNewlyTable);
	}

	public void Textfield() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(Textfield));
		Textfield.sendKeys("YES");
	}

	public void DeleteTableButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(DeleteTableButton));
		DeleteTableButton.click();
		if (DeleteTableButton.isDisplayed() == true) {
			System.out.println("Modal does not close");
		} else {
			System.out.println("Modal got closed");
		}
	}
}
