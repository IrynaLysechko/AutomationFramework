package com.epam.testng.listeners;

import com.epam.allure.AllureAttach;
import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j2
public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.debug("Test class started: " + iTestResult.getTestClass().getName());
        log.debug("Test started: " + iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.debug("Test success: " + iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.error(iTestResult.getTestClass().getName());
        AllureAttach.takeScreenshotToAttachOnAllureReport();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.debug("Test skipped: " + iTestResult.getName());
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

