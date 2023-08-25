package Com.Quickbase.pageObject;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.asserts.SoftAssert;

public class NewSupportCase {
	WebDriver driver;

	public NewSupportCase(WebDriver dr) {
		driver = dr;
		PageFactory.initElements(dr, this);
	}

	@FindBy(xpath = ("//div[@id='qbDialog']"))
	WebElement NewSupportCaseModal;
	@FindBy(id = ("btn-add-attachment"))
	WebElement AddAttachments;
	@FindBy(xpath = ("//div[@class='inputSection']/a"))
	WebElement VerifyAttachment;

	@FindBy(xpath = ("//button[text()='Cancel']"))
	WebElement CancelbtnOnSupCase;

	public void DragNewSupportCaseModal() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(NewSupportCaseModal));
		Actions A = new Actions(driver);
		A.dragAndDropBy(NewSupportCaseModal, 0, 0).build().perform();

	}

	public void AddAttachment() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(AddAttachments));
		AddAttachments.sendKeys("D:\\qas_logo.jpg");
		SoftAssert s = new SoftAssert();
		String e = "Clear Attachment";
		String a = VerifyAttachment.getText();
		System.out.println(a);
		assertEquals(a, e);
		s.assertAll();

	}

	public void CancelbtnOnSupCase() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(CancelbtnOnSupCase));
		CancelbtnOnSupCase.click();
	}

	public void ModalClosed() {
		if (CancelbtnOnSupCase.isDisplayed() == true) {
			System.out.println("Modal does not close");
		} else {
			System.out.println("Modal got closed");
		}
	}
}
