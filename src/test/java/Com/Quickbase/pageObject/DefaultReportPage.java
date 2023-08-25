package Com.Quickbase.pageObject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.asserts.SoftAssert;

import net.bytebuddy.asm.Advice.Return;

public class DefaultReportPage {
	private WebDriver driver;

	// create constructor
	public DefaultReportPage(WebDriver dr) {
		driver = dr;
		PageFactory.initElements(dr, this);
	}

	@FindBy(xpath = ("//label[@for='checkboxForActionCell-6']"))
	WebElement FirstCheckbox;
	@FindBy(xpath = ("//label[@for='checkboxForActionCell-6']/.//span"))
	WebElement FirstCheckboxisSelected;

	@FindBy(xpath = ("//label[@for='checkboxForActionCell-4']"))
	WebElement SecondCheckbox;
	@FindBy(xpath = ("//label[@for='checkboxForActionCell-4']/.//span"))
	WebElement SecondCheckboxisSelected;
	@FindBy(xpath = ("//label[@for='checkboxForActionCell-1']"))
	WebElement thirdCheckbox;
	@FindBy(xpath = ("//label[@for='checkboxForActionCell-1']/.//span"))
	WebElement thirdCheckboxisSelected;
	@FindBy(xpath = ("//label[@for='1']"))
	WebElement AllCheckbox;
	@FindBy(xpath = ("//label[@for='1']/.//span"))
	WebElement AllCheckboxisSelected;
	@FindBy(id = ("dynamicFilterButton_28"))
	WebElement status;
	@FindBy(xpath = ("//div[@class='itemPickerV2__input']/input"))
	WebElement Searchstatus;
	@FindBy(xpath = ("//div[@class='css-owk5qr itemPickerV2__multi-value__remove']"))
	WebElement Removestatus;
	@FindBy(xpath = ("//div[text()='In-Progress']"))
	WebElement VerifyInPro;
	@FindBy(xpath = ("//div[text()='Completed']"))
	WebElement VerifyCompleted;
	@FindBy(xpath = ("//div[text()='On Hold']"))
	WebElement VerifyOnHold;

	public void ClickFirstCheckbox() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(FirstCheckbox));
		boolean isSelected = FirstCheckbox.isSelected();
		if (isSelected == false) {
			FirstCheckbox.click();
			String s = FirstCheckboxisSelected.getAttribute("innerHTML");
			Assert.assertEquals("Deselect record", s);
			System.out.println(s);
		}
	}

	public void ClickSecondCheckbox() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(SecondCheckbox));
		boolean isSelected = SecondCheckbox.isSelected();
		if (isSelected == false) {
			SecondCheckbox.click();
			String s = SecondCheckboxisSelected.getAttribute("innerHTML");
			Assert.assertEquals("Deselect record", s);
			System.out.println(s);
		}
	}

	public void ClickthirdCheckbox() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(thirdCheckbox));
		boolean isSelected = thirdCheckbox.isSelected();
		if (isSelected == false) {
			thirdCheckbox.click();
			String s = thirdCheckboxisSelected.getAttribute("innerHTML");
			Assert.assertEquals("Deselect record", s);
			System.out.println(s);
		}
	}

	public void ClickAllCheckbox() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(AllCheckbox));
		boolean isSelected = AllCheckbox.isSelected();
		if (isSelected == false) {
			AllCheckbox.click();
			String s = AllCheckboxisSelected.getAttribute("innerHTML");
			Assert.assertEquals("Deselect all on this page", s);
			System.out.println(s);
		}

	}

	public void ClickStatus() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(status));
		status.click();
	}

	public void EnterStatus(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(Searchstatus));
		Searchstatus.sendKeys(value);

	}

	public void RemoveStatus() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(Searchstatus));
		Removestatus.click();

	}

	public void VerifyInPro() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(VerifyInPro));
	
		Assert.assertNotNull(VerifyInPro, "Projects filtered by 'In-Progress' status not found");
		List<WebElement> Status = driver.findElements(By.xpath("//td[@role='gridcell']//div[text()='In-Progress']"));
        List<String> StatusList = new ArrayList<String>();

        for (WebElement StatusInPro : Status) {
        	StatusList.add(StatusInPro.getText());
            System.out.println(StatusList);
        }
        Assert.assertTrue(!StatusList.isEmpty(), " In-Progress' status not found");
        for (String project : StatusList) {
            Assert.assertTrue(project.contains("In-Progress"), "Project not in 'In-Progress' status: " + project);
        }
	}

	public void VerifyCompleted() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(VerifyInPro));
		List<WebElement> Status = driver.findElements(By.xpath("//td[@role='gridcell']//div[text()='Completed']"));
        List<String> StatusList = new ArrayList<String>();

        for (WebElement StatusCompl : Status) {
        	StatusList.add(StatusCompl.getText());
            System.out.println(StatusList);
        }
        Assert.assertTrue(!StatusList.isEmpty(), " Completed' status not found");
        for (String project : StatusList) {
            Assert.assertTrue(project.contains("Completed"), "Completed' status not found: " + project);
        }

	}

	public void VerifyOnHold() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(VerifyOnHold));
		List<WebElement> Status = driver.findElements(By.xpath("//td[@role='gridcell']//div[text()='On Hold']"));
        List<String> StatusList = new ArrayList<String>();

        for (WebElement StatusForOnHold : Status) {
        	StatusList.add(StatusForOnHold.getText());
            System.out.println(StatusList);
        }
        Assert.assertTrue(!StatusList.isEmpty(), " On Hold' status not found");
        for (String project : StatusList) {
            Assert.assertTrue(project.contains("On Hold"), "On Hold' status not found " + project);
        }

	}

}
