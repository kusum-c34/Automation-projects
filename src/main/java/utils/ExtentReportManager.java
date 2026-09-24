package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

    public class ExtentReportManager {

        private static ExtentReports extent;

        public static ExtentReports getReportInstance() {

            if (extent == null) {

                ExtentSparkReporter spark =
                        new ExtentSparkReporter("test-output/ExtentReport.html");

                extent = new ExtentReports();
                extent.attachReporter(spark);

                extent.setSystemInfo("Tester", "Kusum");
                extent.setSystemInfo("Project", "QA Automation Project");
                extent.setSystemInfo("Browser", "Chrome");
                extent.setSystemInfo("Framework", "Selenium + TestNG + POM");
            }

            return extent;
        }
    }

