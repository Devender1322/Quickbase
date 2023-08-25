package driver;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import Com.Quickbase.pageObject.SignInClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilitise.Readconfig;

public class BaseClass extends Readconfig  {
	Readconfig readconfig = new Readconfig();
	String url = readconfig.getbaseUrl();
	String browser = readconfig.getBrowser();
	public Logger logs; 
	
	@BeforeMethod
	public void setUp()  {

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "medge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;
		}

		driver.manage().window().maximize();
		logs = LogManager.getLogger("Quickbase");
		driver.get(url);
		logs.info("URL opened");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		SignInClass ftc = new SignInClass(driver);
		ftc.EnterLoginID();
		logs.info("Entered Login username/Id");
		ftc.EnterPWD();
		logs.info("Entered password");
		ftc.ClickSignIn();
		logs.info("clicked on Sign-in button");
	}
	
}
