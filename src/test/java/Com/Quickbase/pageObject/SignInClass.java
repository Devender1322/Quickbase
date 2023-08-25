package Com.Quickbase.pageObject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInClass {
	// create obect
	private WebDriver driver;

	// create constructor
	public SignInClass(WebDriver dr) {
		driver = dr;
		PageFactory.initElements(dr, this);
	}

	// identify web elements
	@FindBy(name = ("loginid"))
	WebElement loginid;
	@FindBy(xpath = ("//input[@type='password']"))
	WebElement password;
	@FindBy(id = ("signin"))
	WebElement signin;

	@FindBy(xpath = ("//div[@class='TblIcon20 icon-table File2']"))
	WebElement Project;

	// Actions on web elements
	public void EnterLoginID() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(loginid));
		loginid.sendKeys("pihoitraureipoi-7422@yopmail.com");
		
	}

	public void EnterPWD() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys("Sept@12345");
		
	}

	public void ClickSignIn() {
		signin.click();
	}

}
