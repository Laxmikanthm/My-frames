package base;

import base.test.BaseTest;
import execution.platform.Executors;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class CentralAppContext extends BaseTest {
	public String driverName = null;
	public ApplicationContext context;

	@BeforeSuite(alwaysRun = true)
	public void setupSuite1(ITestContext testContext) throws Exception {
		context = new FileSystemXmlApplicationContext("src/test/resources/CentralBeans.xml");
		System.out.println("NOOOOO Executors fetched...");
		executors = (Executors) context.getBean("executors");
		System.out.println("Executors fetched...");
		//driverName = testContext.getCurrentXmlTest().getParameter("driverName");
		BaseTest.EXPLICIT_WAIT_TIME = 3000;
	}

	@BeforeMethod
	public void getDriverName(ITestContext testContext) throws Exception
	{
		driverName = testContext.getCurrentXmlTest().getParameter("driverName");
	}
}
