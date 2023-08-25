package Com.Quickbase.pageObject;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.asserts.SoftAssert;

public class HomePage {
	private WebDriver driver;

	// create constructor
	public HomePage(WebDriver dr) {
		driver = dr;
		PageFactory.initElements(dr, this);
	}

	@FindBy(xpath = ("//p[text()='Simple Project Manager']"))
	WebElement SimpleProjectManager;
	@FindBy(xpath = ("//div[@class='appsIconView css-12m5ds3 e49tjrp0']/div[3]/a[1]/button[1]/div[1]/span"))
	WebElement ClickThreedot;
	@FindBy(xpath = ("//li[text()='Delete']"))
	WebElement DeletebtnOnHomepage;
	@FindBy(xpath = ("//li[text()='Hide']"))
	WebElement HidebtnOnHomepage;
	@FindBy(id = ("helpMenu"))
	WebElement helpMenu;
	@FindBy(xpath = ("//div[text()='Help']"))
	WebElement helptooltip;
	@FindBy(xpath = ("//div[@data-tip='Icons']"))
	WebElement Icons;
	@FindBy(xpath = ("//div[@aria-label='Details']"))
	WebElement Details;
	@FindBy(xpath = ("//table[@role='grid']"))
	WebElement GridDetails;
	@FindBy(className = ("userApps"))
	WebElement UserIcon;
	@FindBy(xpath = ("//p[text()='Customer Manager']"))
	WebElement CustomerManager;

	public void ClickSimple() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(SimpleProjectManager));
		SimpleProjectManager.click();
	}

	public void HoverSimple() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(SimpleProjectManager));
		Actions A = new Actions(driver);
		A.moveToElement(SimpleProjectManager).perform();
	}

	public void ClickThreeDot() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(ClickThreedot));
		ClickThreedot.click();
	}

	public void ClickHelp() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(helpMenu));
		Actions A = new Actions(driver);
		A.moveToElement(helpMenu).perform();
		WebDriverWait waint = new WebDriverWait(driver, Duration.ofSeconds(25));
		waint.until(ExpectedConditions.visibilityOf(helptooltip));
		String ActText = helptooltip.getText();
		SoftAssert a = new SoftAssert();
		String ExpText = "Help";
		System.out.println("Tooltip is " + ActText);
		AssertJUnit.assertEquals(ActText, ExpText);
		a.assertAll();
		helpMenu.click();
	}

	public void VerifyDeletebtnOnHomepage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(DeletebtnOnHomepage));
		boolean ww = DeletebtnOnHomepage.isDisplayed();
		if (ww) {
			System.out.println("Delete button is Displayed");
			Assert.assertTrue(true);

		} else {
			System.out.println("Delete button is Displayed");
			Assert.assertTrue(false);
		}
	}

	public void VerifyHidebtnOnHomepage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(HidebtnOnHomepage));
		boolean ww = HidebtnOnHomepage.isDisplayed();
		if (ww) {
			System.out.println("Hide button is Displayed");
			Assert.assertTrue(true);

		} else {
			System.out.println("Hide button is Displayed");
			Assert.assertTrue(false);
		}
	}

	public void ClickDeletebtnOnHomepage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(DeletebtnOnHomepage));
		DeletebtnOnHomepage.click();
	}

	public void ClickIcons() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(Details));
		Icons.click();
		SoftAssert a = new SoftAssert();
		String ExpText = "userApps";
		String ActText = UserIcon.getAttribute("class");
		System.out.println("Layout is as " + ActText);
		AssertJUnit.assertEquals(ActText, ExpText);
		a.assertAll();
	}

	public void HoverIcons() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(Icons));
		Actions a = new Actions(driver);
		a.moveToElement(Icons);
		String s = Icons.getAttribute("data-tip");
		Assert.assertEquals("Icons", s);
		System.out.println(s);
	}

	public void HoverDetails() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(Details));
		Actions a = new Actions(driver);
		a.moveToElement(Details);
		String s = Details.getAttribute("data-tip");
		Assert.assertEquals("Details", s);
		System.out.println(s);
	}

	public void ClickDetails() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(Details));
		Details.click();
		SoftAssert a = new SoftAssert();
		String ExpText = "grid";
		String ActText = GridDetails.getAttribute("role");
		System.out.println("Layout is as " + ActText);
		AssertJUnit.assertEquals(ActText, ExpText);
		a.assertAll();

	}

	public void ClickCustomerManager() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(CustomerManager));
		CustomerManager.click();
	}
}
