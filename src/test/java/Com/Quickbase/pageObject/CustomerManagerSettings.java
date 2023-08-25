
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

public class CustomerManagerSettings {
	WebDriver driver;

	public CustomerManagerSettings(WebDriver dr) {
		driver = dr;
		PageFactory.initElements(dr, this);
	}

	@FindBy(xpath = ("//div[text()='Overview']"))
	WebElement OverviewTooltip;
	@FindBy(id = ("appSettingsNav_tables"))
	WebElement Table;

	public void OverviewTooltip() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(OverviewTooltip));
		Actions a = new Actions(driver);
		a.moveToElement(OverviewTooltip).perform();
		String sd = OverviewTooltip.getText();
		System.out.println("TOoltip is " + sd);
		SoftAssert sf = new SoftAssert();
		String atext = "Overview";
		AssertJUnit.assertEquals(atext, sd);
		sf.assertAll();
	}

	public void ScrollTable() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(Table));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Table);
	}

	public void ClickTable() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(Table));
		Table.click();
	}

}
