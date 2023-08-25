package Com.Quickbase.pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteModal {
	private WebDriver driver;

	public DeleteModal(WebDriver dr) {
		driver = dr;
		PageFactory.initElements(dr, this);
	}

	@FindBy(xpath = ("//div[@class='css-0 e4e4n4p2']"))
	WebElement DeleteModalText;
	@FindBy(xpath = ("//div[@class='styledInputWrapper css-4jdkgy e1pxgqor0']/input"))
	WebElement TextFieldonDeleteModal;
	@FindBy(xpath = ("//button[text()=\"No, don't delete\"]"))
	WebElement Nodontdelete;

	public void TextOfDeleteModal() {
		String s = DeleteModalText.getText();
		System.out.println(s);
	}

	public void ClickTextField() {
		TextFieldonDeleteModal.click();
	}

	public void EntervalueTextFiel(String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(TextFieldonDeleteModal));
		TextFieldonDeleteModal.sendKeys(value);

	}

	public void ClickNodontdelete() {
		Nodontdelete.click();
	}

}
