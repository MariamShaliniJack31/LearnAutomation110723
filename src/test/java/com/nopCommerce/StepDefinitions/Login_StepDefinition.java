package com.nopCommerce.StepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.TimeoutException;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.nopCommerce.common.utils.ExtentReportUtil;
import com.nopCommerce.pages.*;
import org.openqa.selenium.WebDriver;

public class Login_StepDefinition extends ExtentReportUtil{
	
	protected Login_Page lp; 
	WebDriver driver;
	ExtentTest logInfo = null;
			
	public Login_StepDefinition() {
		lp = new Login_Page();
	}

	@Before
	public void cucumberBefore()
	{
		System.out.println("I am in Cucumber Before");
		count = count + 1;
		System.out.println(count);
	}
	
	@After
	public void cucumberAfter()
	{
		System.out.println("I am in Cucumber After");
		
	}
	
	@Given("^Open the \"([^\"]*)\" in browser$")
	public void open_the_in_browser(String arg1) throws Throwable {
		try {
			
			System.out.println("I am in Open Browser");
			lp.launchApplication();
			test = extent.createTest("Create Test : Michael Page Application Testing TC : "+ count);
			test = test.createNode(Scenario.class, "Create Node : Launched the Sample Application");
			logInfo = test.createNode(new GherkinKeyword("Given"), "Launched the Sample Application");
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
			
		}
	}

	@Given("^Open the \"([^\"]*)\" in browser as Admin$")
	public void open_the_in_browser_as_Admin(String arg1) throws Throwable {
		try {
			System.out.println("I am in Open Browser");
			
			lp.launchApplication();
			test = extent.createTest("Create Test : Michael Page Application Testing TC : " + count);
			test = test.createNode(Scenario.class, "TC : 1 Login as Admin");
			logInfo = test.createNode(new GherkinKeyword("Given"), "TC : 1 Login as Admin");
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
			
		}
	}

	@Given("^Open the \"([^\"]*)\" in browser as User$")
	public void open_the_in_browser_as_User(String arg1) throws Throwable {
		try {
			System.out.println("I am in Open Browser");
			lp.launchApplication();
			test = extent.createTest("Create Test : Michael Page Application Testing TC : " + count);
			test = test.createNode(Scenario.class, "TC : 2 Login as User");
			logInfo = test.createNode(new GherkinKeyword("Given"), "TC : 2 Login as User");
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
			
		}
	}
	
	@Given("^Login to application as Admin with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void login_to_application_as_Admin_with_and(String arg1, String arg2) throws Throwable {
		try {
			lp.enterText(arg1);
			lp.enterText(arg2);
			//test = test.createNode(Scenario.class, "Create Node : Login as Admin");
			logInfo = test.createNode(new GherkinKeyword("When"), "Login as Admin with UserName & PWD");
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}
	}

	@When("^I click on \"([^\"]*)\" button$")
	public void i_click_on_button(String arg1) throws Throwable {
	    try{
	    	lp.clickOnElement(arg1);
	    	//test = test.createNode(Scenario.class, "Create Node : "+arg1+ " Button");
	    	if (arg1.equalsIgnoreCase("logout"))
	    		lp.tearDown();
	    	logInfo = test.createNode(new GherkinKeyword("When"), "Click on "+arg1+ "  Button");
	    } catch (AssertionError | Exception e) {
	    	testStepHandle("FAIL", driver, logInfo, e);
	    }
	}

	@Then("^I verify \"([^\"]*)\" Title on HomePage$")
	public void i_verify_Title_on_HomePage(String arg1) throws Throwable {
	    try{
	    	lp.VerifyTitle(arg1);
	    	//test = test.createNode(Scenario.class, "Create Node : Check Page Title");
	    	logInfo = test.createNode(new GherkinKeyword("Then"), "TITTLE");
	    } catch (AssertionError | Exception e) {
	    	testStepHandle("FAIL", driver, logInfo, e);
	    }
	}
}
