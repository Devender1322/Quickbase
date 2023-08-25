package Com.Quickbase.testclass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import Com.Quickbase.pageObject.*;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BeforeAndAfter {

	WebDriver ldriver;

	@BeforeMethod
	public void SignIn() throws InterruptedException, IOException {
		String browser = "Chrome";
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ldriver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			ldriver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			ldriver = new EdgeDriver();
		} else {
			throw new IllegalArgumentException("No browser found");
		}
		// maximize the window
		ldriver.manage().window().maximize();

		// getUrl
		ldriver.get("https://login.quickbase.com/db/main?a=SignIn");

		// implicit wait
		ldriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// logger


		SignInClass ftc = new SignInClass(ldriver);
		ftc.EnterLoginID();
		Thread.sleep(5000);
		ftc.EnterPWD();
		ftc.ClickSignIn();
		Thread.sleep(5000);

	}

//	 close the broswers
	@AfterMethod
	public void Closebrowser() throws InterruptedException {
		ldriver.close();
		Thread.sleep(10000);
		ldriver.quit();


	}
}
