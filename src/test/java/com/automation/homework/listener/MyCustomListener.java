package com.automation.homework.listener;

import org.testng.*;

public class MyCustomListener implements ISuiteListener , ITestListener {
    @Override
    public void onStart(ISuite suite) {
        System.out.println("Start "+suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Stop "+suite.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart "+result.getTestName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess   "+result.getTestName());
        System.out.println("onTestSuccess   "+result.getMethod());

    }

    @Override
    public void onTestFailure(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
