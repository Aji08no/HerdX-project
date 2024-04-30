package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    ExtentReports report=ExtentReport.report();
    ExtentTest extent;

    @Override
    public void onTestStart(ITestResult result) {
        extent = report.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        extent.log(Status.PASS,"Success");

    }
    @Override
    public void onTestFailure(ITestResult result) {
        extent.fail(result.getThrowable());

    }
    @Override
    public void onTestSkipped(ITestResult result) {

    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }
    @Override
    public void onStart(ITestContext context)  {

    }
    @Override
    public void onFinish(ITestContext context)  {
        report.flush();

    }



}
