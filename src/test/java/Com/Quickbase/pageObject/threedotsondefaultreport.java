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

public class threedotsondefaultreport {

	WebDriver driver;

	public threedotsondefaultreport(WebDriver dr) {
		driver = dr;
		PageFactory.initElements(dr, this);

	}

	@FindBy(xpath = ("//th[@tabindex='-1']//span/span/div/span/button/span[text()='Project Name']"))
	WebElement HoverOnProjectcolumn;
	@FindBy(xpath = ("//th[@tabindex='-1']//span/section/div/button[@type='button']"))
	WebElement ThreeDotsOnProjectcolumn;
	@FindBy(xpath = ("//button[text()='Group Z to A']"))
	WebElement ZtoAOnProjectcolumn;
	@FindBy(xpath = ("//button[text()='Group A to Z']"))
	WebElement AtoZOnProjectcolumn;
	@FindBy(xpath = ("//button[text()='Hide column']"))
	WebElement HideOnProjectcolumn;
	@FindBy(xpath = ("//button[text()='Show more columns']"))
	WebElement ShowOnProjectcolumn;
	@FindBy(xpath = ("//button[text()='Move field to new related table']"))
	WebElement MoveOnProjectcolumn;
	@FindBy(xpath = ("//a[text()='Field properties']"))
	WebElement FieldsProjectcolumn;
	@FindBy(xpath = ("//th[@tabindex='-1']//span/span/div/span/button/span[text()='Actual Start Date']"))
	WebElement HoverOnActualcolumn;
	@FindBy(xpath = ("//table[@role='grid']//th[8]/span/section/div/button[@type='button']"))
	WebElement ThreeDotsOnActualcolumn;
	@FindBy(xpath = ("//button[text()='Group earliest to latest']"))
	WebElement GELOnActualcolumn;
	@FindBy(xpath = ("//button[text()='Group latest to earliest']"))
	WebElement GLETOnActualcolumn;

	public void HoverOnProjectcolumn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(HoverOnProjectcolumn));
		Actions builder = new Actions(driver);
		builder.moveToElement(HoverOnProjectcolumn).perform();

	}

	public void ThreeDotsOnProjectcolumn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(ThreeDotsOnProjectcolumn));
		ThreeDotsOnProjectcolumn.click();
	}

	public void Modalelements() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(ThreeDotsOnProjectcolumn));
		String s = ZtoAOnProjectcolumn.getText();
		System.out.println("Options that are displayed on modal- ");
		System.out.println(s);
		SoftAssert sf = new SoftAssert();
		String atext = "Group Z to A";
		AssertJUnit.assertEquals(atext, s);
		String s1 = AtoZOnProjectcolumn.getText();
		System.out.println(s1);
		String atext1 = "Group A to Z";
		AssertJUnit.assertEquals(atext1, s1);
		String s2 = HideOnProjectcolumn.getText();
		System.out.println(s2);
		String atext2 = "Hide column";
		AssertJUnit.assertEquals(atext2, s2);
		String s3 = ShowOnProjectcolumn.getText();
		System.out.println(s3);

		String atext3 = "Show more columns";
		AssertJUnit.assertEquals(atext3, s3);
		String s4 = MoveOnProjectcolumn.getText();
		System.out.println(s4);

		String atext4 = "Move field to new related table";
		AssertJUnit.assertEquals(atext4, s4);
		String s5 = FieldsProjectcolumn.getText();
		System.out.println(s5);
		String atext5 = "Field properties";
		AssertJUnit.assertEquals(atext5, s5);

		sf.assertAll();

	}

	public void ClickZtoAOnProjectcolumn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(ZtoAOnProjectcolumn));
		ZtoAOnProjectcolumn.click();

	}

	public void ModalClosed() {
		try {
			ZtoAOnProjectcolumn.isDisplayed();
			System.out.println("Modal does not close");

		} catch (Exception e) {

			System.out.println("Modal got closed");
		}
	}

	public void HoverOnActualcolumn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(HoverOnActualcolumn));
		Actions builder = new Actions(driver);
		builder.moveToElement(HoverOnActualcolumn).perform();

	}

	public void ThreeDotsOnActualcolumn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(ThreeDotsOnActualcolumn));
		ThreeDotsOnActualcolumn.click();

	}

	public void ModalelementsForActualDate() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(ThreeDotsOnActualcolumn));
		String s = GELOnActualcolumn.getText();
		System.out.println("Options that are displayed on modal- ");
		System.out.println(s);
		SoftAssert sf = new SoftAssert();
		String atext = "Group earliest to latest";
		
		AssertJUnit.assertEquals(atext, s);
		String s1 = GLETOnActualcolumn.getText();
		System.out.println(s1);
		String atext1 = "Group latest to earliest";
		AssertJUnit.assertEquals(atext1, s1);

		String s2 = HideOnProjectcolumn.getText();
		System.out.println(s2);
		String atext2 = "Hide column";
		AssertJUnit.assertEquals(atext2, s2);
		
		String s3 = ShowOnProjectcolumn.getText();
		System.out.println(s3);
		String atext3 = "Show more columns";
		AssertJUnit.assertEquals(atext3, s3);
		
		String s4 = MoveOnProjectcolumn.getText();
		System.out.println(s4);
		String atext4 = "Move field to new related table";
		AssertJUnit.assertEquals(atext4, s4);
		
		String s5 = FieldsProjectcolumn.getText();
		System.out.println(s5);
		String atext5 = "Field properties";
		AssertJUnit.assertEquals(atext5, s5);

		sf.assertAll();

	}

	public void ClickGLETOnActualcolumn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(GLETOnActualcolumn));
		GLETOnActualcolumn.click();

	}

	public void AcModalClosed() {

		try {
			GLETOnActualcolumn.isDisplayed();
			System.out.println("Modal does not close");

		} catch (Exception e) {

			System.out.println("Modal got closed");
		}
	}

}
