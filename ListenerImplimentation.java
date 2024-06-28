package commonUtils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplimentation implements ITestListener {

	
	ExtentReports report ;
	ExtentTest test ;
	
	JavaUtil ju =new JavaUtil() ;
	WebDriverUtil wu = new WebDriverUtil() ;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
		String methodName = result.getMethod().getMethodName() ;
		Reporter.log(methodName+"Test Execution is Started",true) ;
		test=report.createTest(methodName) ;
		
//		ExtentSparkReporter reporter =new ExtentSparkReporter("./extentreport/"+ju.getRandomNumbers()+"report.html") ;
//		reporter.config().setDocumentTitle("vtigercrm1") ;
//		reporter.config().setTheme(Theme.DARK) ;
//		reporter.config().setReportName("demo") ;
//		
//		//ExtentReports r1 = new ExtentReports() ;
//		report=new ExtentReports() ;
//		report.attachReporter(reporter) ;
//		report.setSystemInfo("OS","window") ;
//		report.setSystemInfo("Browser", "Chrome") ;
//		report.setSystemInfo("Browser version", "122") ;
//		report.setSystemInfo("Author", "Varsha") ;
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		String methodName = result.getMethod().getMethodName() ;
		//Reporter.log(methodName+"Test Execution is Passed",true) ;
		test.log(Status.PASS, "Test Execution is Passed") ;
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		String msg = result.getThrowable().toString() ;
		String methodName = result.getMethod().getMethodName() ;
		Reporter.log(methodName+"Test Execution is Failed"+" "+msg,true) ;
		test.log(Status.FAIL, "Test Execution is Fail ") ;
		
		try {
			String path = wu.screenShot(BaseClass.sdriver,methodName+" Contact" ) ;
			test.addScreenCaptureFromPath(path) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
		String methodName = result.getMethod().getMethodName() ;
		Reporter.log(methodName+"Test Execution is Skipped",true) ;
		test.log(Status.SKIP, "Test Execution is Skip") ;
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
		//String methodName = result.getMethod().getMethodName() ;
		Reporter.log("To Start Execution",true) ;
		ExtentSparkReporter reporter =new ExtentSparkReporter("./extentreport/"+ju.getRandomNumbers()+"report.html") ;
		reporter.config().setDocumentTitle("vtigercrm1") ;
		reporter.config().setTheme(Theme.DARK) ;
		reporter.config().setReportName("demo") ;
		
		//ExtentReports r1 = new ExtentReports() ;
		report=new ExtentReports() ;
		report.attachReporter(reporter) ;
		report.setSystemInfo("OS","window") ;
		report.setSystemInfo("Browser", "Chrome") ;
		report.setSystemInfo("Browser version", "122") ;
		report.setSystemInfo("Author", "Varsha") ;
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		//String methodName = result.getMethod().getMethodName() ;
		Reporter.log("To Finish Execution",true) ;
		report.flush();
	}
	

	
}
