package com.nopCommerce.TestRunner;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopCommerce.common.utils.TestBase;
import com.nopCommerce.log4jutils.LogFile;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions( features = {"src/test/resources/Features"}, 
				glue = { "com.nopCommerce.StepDefinitions" }, 
				format = {"json:target/cucumber.json"},
				monochrome = true, 
				dryRun = false,
				plugin = {"pretty"}
				 )

public class nopCommerce_testrunner extends TestBase  {

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeSuite
	public void initialize() {
		
		try {
			PropertyConfigurator
					.configure(System.getProperty("user.dir") +"//src//main//resources//LogProperties/log4j.properties");
			Logger.getRootLogger().setLevel(Level.ALL);

			LogFile.APPLICATION_LOGS.debug("Starting the Suite");

		} catch (Throwable t) {
			t.printStackTrace();
			System.out.println("Unable to initialize the log file");
			LogFile.APPLICATION_LOGS.error("Error in initialize the Log file");
		}
	}

	@BeforeTest
	public void testSetUp() {
//		LoginTC.getLoginTCObject();
	}

	@BeforeClass(alwaysRun = true)
	public void classSetUp() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

	}

	@Test(groups = "cucumber", description = "Run Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		//LoginTC.CallBrowser();
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass(alwaysRun = true)
	public void classTearDown() throws Exception {
		testNGCucumberRunner.finish();
	}

	@AfterTest
	public void closeBrowser() {
		TestBase.tearDown();
	}

}