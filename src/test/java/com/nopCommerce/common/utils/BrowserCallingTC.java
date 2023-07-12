package com.nopCommerce.common.utils;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import com.nopCommerce.log4jutils.LogFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserCallingTC extends TestBase {

	public void browserSelection() {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		String os = System.getProperty("os.name").toLowerCase();
		System.out.println("OS = " + os);

		if ("firefox".equalsIgnoreCase(Dto.getWebDriverObj())) {

			File profileDirectory = new File(Dto.getFirefoxProfilePath());
			FirefoxProfile fxProfile = new FirefoxProfile(profileDirectory);
			fxProfile.setAcceptUntrustedCertificates(false);
			fxProfile.setAssumeUntrustedCertificateIssuer(true);
			fxProfile.setPreference("xpinstall.signatures.required", false);
			fxProfile.setPreference("network.cookie.cookieBehavior", 1);
			fxProfile.setPreference("browser.download.folderList", 2);
			fxProfile.setPreference("browser.download.manager.showWhenStarting", false);
			//fxProfile.setPreference("browser.download.dir", MichaelpageConstants.DOWNLOAD_PATH + "\\");
			fxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
			fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
					"application/pdf,application/ms-excel,text/csv,image/jpeg,image/svg+xml,image/png,application/csv,application/vnd.ms-excel,application/octet-stream");

			FirefoxOptions options = new FirefoxOptions();
			//capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("moz:firefoxOptions", options);
			capabilities.setCapability(FirefoxDriver.PROFILE, fxProfile);
			capabilities.setCapability("marionette", true);

			WebDriverManager.firefoxdriver().arch64().setup();

			if (Dto.getbrowserStatusvalueType().equalsIgnoreCase("Headless")) {
				options.setHeadless(true);
				driver = new FirefoxDriver(options);
				System.out.println("Running in Firefox Headless Browser");
				LogFile.APPLICATION_LOGS.info("Running in Firefox Headless Browser");
				Reporter.log("Running in Firefox Headless Browser");

			} else {
				driver = new FirefoxDriver();
				LogFile.APPLICATION_LOGS.info("Running in Firefox Browser");
				Reporter.log("Running in Firefox Browser");
				System.out.println("Running in Firefox Browser");
			}

		} else if ("ie".equalsIgnoreCase(Dto.getWebDriverObj())) {

			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability("ignoreZoomSetting", true);
			capabilities.setCapability("nativeEvents", true);
			capabilities.setCapability("unexpectedAlertBehaviour", "accept");
			capabilities.setCapability("ignoreProtectedModeSettings", true);
			capabilities.setCapability("disable-popup-blocking", true);
			capabilities.setCapability("enablePersistentHover", true);
			capabilities.setCapability("IntroduceInstabilityByIgnoringProtectedModeSettings", true);
			capabilities.setCapability("requireWindowFocus", false);

			WebDriverManager.iedriver().arch32().setup();

			driver = new InternetExplorerDriver();
			System.out.println("Running in IE Browser");
			LogFile.APPLICATION_LOGS.info("Running in IE Browser");
			Reporter.log("Running in IE Browser");

		} else if ("chrome".equalsIgnoreCase(Dto.getWebDriverObj())) {
//			String chromeProfile = Dto.getChromeProfilePath();
//			Map<String, Object> prefs = new HashMap<String, Object>();
//			ChromeOptions options = new ChromeOptions();
//			options.setExperimentalOption("useAutomationExtension", false);
//			options.addArguments("--headless");
//			options.addArguments("--no-sandbox");
//			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//			options.addArguments("--disable-gpu");
//			options.setExperimentalOption("useAutomationExtension", false);
//			options.addArguments("--disable-dev-shm-usage");
//			options.addArguments("--dns-prefetch-disable");
//			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//			options.addArguments("--disable-extensions");
//			options.addArguments("test-type");
//			options.addArguments("start-maximized");
//			options.addArguments("--js-flags=--expose-gc");
//			options.addArguments("--enable-precise-memory-info");
//			options.addArguments("--disable-popup-blocking");
//			options.addArguments("--disable-default-apps");
//			options.addArguments("disable-infobars");
//			options.addArguments("--window-size=1920,1080");
//			prefs.put("credentials_enable_service", false);
//			prefs.put("profile.password_manager_enabled", false);
//			prefs.put("profile.default_content_settings.cookies", 2);
//			options.setExperimentalOption("prefs", prefs);
//			String[] switches = { "user-data-dir=" + chromeProfile };
//			capabilities.setCapability("chrome.switches", "--disable-extensions");
//			capabilities.setCapability("chrome.switches", switches);
//			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//			capabilities.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true);
//			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//			capabilities.setCapability("cssSelectorsEnabled", true);

			if (Dto.getbrowserStatusvalueType().equalsIgnoreCase("Head")) {
				//WebDriverManager.chromedriver().version("83.0").setup();
				
				WebDriverManager.chromedriver().arch64().setup();;
				driver = new ChromeDriver();
			}
			
//			if (Dto.getbrowserStatusvalueType().equalsIgnoreCase("Headless")) {
//				driver = new ChromeDriver(options);
//				System.out.println("Running in Chrome Headless Browser");
//				LogFile.APPLICATION_LOGS.info("Running in Chrome Headless Browser");
//				Reporter.log("Running in Chrome Headless Browser");
//
//			} else {
//				driver = new ChromeDriver();
//				LogFile.APPLICATION_LOGS.info("Running in Chrome Browser");
//				Reporter.log("Running in Chrome Browser");
//				System.out.println("Running in Chrome Browser");
//			}

		} else if ("Edge".equalsIgnoreCase(Dto.getWebDriverObj())) {

//			System.setProperty("webdriver.edge.driver",
//					MichaelpageConstants.EdgeDriverFilePath + "MicrosoftWebDriver.exe");
			driver = new EdgeDriver();

		} else {
			System.out.println("Invalid Browser");
			Reporter.log("Enter Valid browser name");
			LogFile.APPLICATION_LOGS.error("Enter Valid browser name");
		}

		driver.manage().window().maximize();

	}

}