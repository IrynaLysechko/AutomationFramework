package com.epam.testng.listeners;

import com.epam.report.allure.AllureAttach;
import com.epam.factory.DriverManager;
import com.epam.report.allure.AllureReportLog4j2Appender;
import com.epam.report.reportportal.LoggerUtils;
import io.qameta.allure.Allure;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j2
public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    }

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.error("Test failure: " + iTestResult.getMethod().getMethodName());
        byte[] screenShoot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
        LoggerUtils.log(screenShoot, "Failure test screenshot");
        AllureAttach.takeScreenshotToAttachOnAllureReport();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.debug("Test skipped: " + iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }
}

