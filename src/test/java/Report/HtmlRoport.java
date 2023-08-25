package Report;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class HtmlRoport {
    public ExtentSparkReporter htmlReport;
    public static ExtentReports reports;
    public ExtentTest test;
    public static WebDriver driver;
    
    @BeforeTest
    public void startreport() {
    	Date cdate = new Date();
		String myfileName = cdate.toString().replace(" ", "-").replace(":", "-");
		System.out.println(myfileName);
		
        htmlReport=new ExtentSparkReporter("D:\\EclipseFiles\\Quickbase\\Report\\"+myfileName+".html");
        reports=new ExtentReports();
        reports.attachReporter(htmlReport);
        //configuration to change the look and feel
        htmlReport.config().setDocumentTitle("Devender ki report");
        htmlReport.config().setReportName(" Report");
        htmlReport.config().setTheme(Theme.DARK);
        htmlReport.config().setTimeStampFormat("EEEE,MMMM dd,yyyy,hh:mm a '('zzz')'");

    }

    @AfterMethod
    public void getTestresult(ITestResult result) {
//        driver.close();
        if (result.getStatus()==ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ",ExtentColor.RED));

        } else if((result.getStatus()==ITestResult.SUCCESS)) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ",ExtentColor.GREEN));

        }
        else if((result.getStatus()==ITestResult.SKIP)) {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ",ExtentColor.BLACK));

        }
        driver.quit();
    }
    @AfterTest
    public void tearDown() {
        reports.flush();
  
    }
    

}
