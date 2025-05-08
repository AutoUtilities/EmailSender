package org.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener,IRetryAnalyzer, IAnnotationTransformer
{

	@Override
	public void onFinish(ITestContext context)
	{
		if (System.getProperty("isReportSend") != null && System.getProperty("isReportSend").equalsIgnoreCase("yes")) {
		    try {
		        Class.forName("org.utility.EmailSender");
		        EmailSender.sendEmail();
		    } catch (ClassNotFoundException e) {
		        System.err.println("EmailSender class not found - email functionality disabled");
		    }
		}
	}

	@Override
	public boolean retry(ITestResult result)
	{
		// TODO Auto-generated method stub
		return false;
	}

	
}
