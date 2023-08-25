package Com.Quickbase.pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.asserts.SoftAssert;

public class CustomerManager {
	private WebDriver driver;

	public CustomerManager(WebDriver dr) {
		driver = dr;
		PageFactory.initElements(dr, this);
	}

	@FindBy(xpath = ("//div[@data-original-title='Customer Manager']"))
	WebElement CustomerManagerDashboard;
	@FindBy(id = ("settingsButton"))
	WebElement settingsButton;

	public void CustomerManagerTooltip() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(CustomerManagerDashboard));
		Actions a = new Actions(driver);
		a.moveToElement(CustomerManagerDashboard).perform();
		String sd = CustomerManagerDashboard.getText();
		System.out.println("TOoltip is " + sd);
		SoftAssert sf = new SoftAssert();
		String atext = "Customer Manager";
		AssertJUnit.assertEquals(atext, sd);
		sf.assertAll();
	}

	public void ClickSettingbtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(settingsButton));

		settingsButton.click();
	}

}
