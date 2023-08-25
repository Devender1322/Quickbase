package Com.Quickbase.pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThTest {
	WebDriver driver;

	public ThTest(WebDriver dr) {
		driver = dr;
		PageFactory.initElements(dr, this);
	}

	@FindBy(xpath = "//span[text()='Project Name']")
	WebElement ProjectName;
	@FindBy(xpath = "//*[@id=\"th-hybrid-table-report_1688103256973_-4_1376-16\"]/span/section/div/button")
	WebElement ProjectTableThreedots;

	@FindBy(linkText = "Group Z to A")
	WebElement GroupZtoA;
	@FindBy(xpath = "//*[@id=\"th-hybrid-table-report_1688103256973_-4_1376-45\"]/span/section/div/button/span/svg")
	WebElement ActualStartDateThreedots;
	@FindBy(linkText = "Group latest to earliest")
	WebElement Grouplatestearliest;

	public void HoverProjectName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(ProjectName));
		Actions A = new Actions(driver);
		A.moveToElement(ProjectName).perform();
	}

	public void ClickThreeDot() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(ProjectTableThreedots));
		ProjectTableThreedots.click();
	}

	public void ClickGroupZtoA() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(GroupZtoA));
		GroupZtoA.click();
	}

}
