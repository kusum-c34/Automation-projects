package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ExtentReportManager;

public class BaseTest {

    protected WebDriver driver;

    protected static ExtentReports extent =
            ExtentReportManager.getReportInstance();

    protected ExtentTest test;

    @BeforeMethod
    public void setUp(ITestResult result) {

        // Create test in Extent Report
        test = extent.createTest(
                result.getMethod().getMethodName()
        );

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(
                java.time.Duration.ofSeconds(10)
        );

        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test passed successfully!");
        }
        else if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test failed: " + result.getThrowable());
        }
        else {
            test.skip("Test skipped");
        }

        if (driver != null) {
            driver.quit();
        }

        extent.flush();
    }
}