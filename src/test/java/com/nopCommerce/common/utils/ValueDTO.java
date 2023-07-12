package com.nopCommerce.common.utils;

import java.io.File;
import jxl.Sheet;
import jxl.Workbook;

public class ValueDTO {

	private String URL;
	private String username;
	private String password;
	private String client;
	private String chromedriverpath;
	private String geckodriver;
	private String Iepath;
	private String email;
	private String firefoxprofilepath;
	private String chromeprofilepath;
	private String webDriverObj;
	private String languageSelection;
	private String browserStatus;
	private String browserStatusvalue;
	private String SITURl;
	private String JobDetailsPageURl;
	private String similarJobURl;
	private String inactiveJobURL;
	private String notCAJobURL;
	private String gmailAddress;
	private String gmailPwd;
	private String jobCCDetailPageUrl;
	private String usernameLinkedIn;
	private String passwordLinkedIn;
	private String passwordUnlock;
	private String frenchJobUrl;
	private String webFormUrl;
	private String prscvformpageForFrenchJobURL;
	private String PRSgeneralcvpageURl;
	private String homePageUrl;
	private String clientProfileURL;
	private String logoJobDetailURL;
	private String usernameLinkedIn1;
	private String passwordLinkedIn1;
	private String gmailURL;
	
	public String getGmailURL() {
		return gmailURL;
	}

	public void setGmailURL(String gmailURL) {
		this.gmailURL = gmailURL;
	}
	public String getlogoJobDetailURL() {
		return logoJobDetailURL;
	}

	public void setlogoJobDetailURL(String logoJobDetailURL) {
		this.logoJobDetailURL = logoJobDetailURL;
	}

	public String getclientProfileURL() {
		return clientProfileURL;
	}

	public void setclientProfileURL(String clientProfileURL) {
		this.clientProfileURL = clientProfileURL;
	}

	public String getPRSgeneralcvpageURl() {
		return PRSgeneralcvpageURl;
	}

	public void setPRSgeneralcvpageURl(String pRSgeneralcvpageURl) {
		this.PRSgeneralcvpageURl = pRSgeneralcvpageURl;
	}

	public String getPrscvformpageForFrenchJobURL() {
		return prscvformpageForFrenchJobURL;
	}

	public void setPrscvformpageForFrenchJobURL(String prscvformpageForFrenchJobURL) {
		this.prscvformpageForFrenchJobURL = prscvformpageForFrenchJobURL;
	}

	public String getGmailAddress() {
		return gmailAddress;
	}

	public void setGmailAddress(String gmailAddress) {
		this.gmailAddress = gmailAddress;
	}

	public String getGmailPwd() {
		return gmailPwd;
	}

	public void setGmailPwd(String gmailPwd) {
		this.gmailPwd = gmailPwd;
	}

	public String getLanguageSelection() {
		return languageSelection;
	}

	public void setLanguageSelection(String languageSelection) {
		this.languageSelection = languageSelection;
	}

	public String getBrowserStatus() {
		return browserStatus;
	}

	public void setBrowserStatus(String browserStatus) {
		this.browserStatus = browserStatus;
	}

	public String getbrowserStatusvalueType() {
		return browserStatusvalue;
	}

	public void setbrowserStatusvalueType(String value) {
		this.browserStatusvalue = value;
	}

	public String getWebDriverObj() {
		return webDriverObj;
	}

	public void setWebDriverObj(String webDriverObj) {
		this.webDriverObj = webDriverObj;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getChromedriverpath() {
		return chromedriverpath;
	}

	public void setChromedriverpath(String chromedriverpath) {
		this.chromedriverpath = chromedriverpath;
	}

	public String getGeckodriverpath() {
		return geckodriver;
	}

	public void setGeckodriverpath(String geckodriver) {
		this.geckodriver = geckodriver;
	}

	public String getIepath() {
		return Iepath;
	}

	public void setIepath(String Iepath) {
		this.Iepath = Iepath;
	}

	public String getFirefoxProfilePath() {
		return firefoxprofilepath;
	}

	public void setFirefoxProfilePath(String firefoxprofilepath) {
		this.firefoxprofilepath = firefoxprofilepath;
	}

	public String getChromeProfilePath() {
		return chromeprofilepath;
	}

	public void setChromeProfilePath(String chromeprofilepath) {
		this.chromeprofilepath = chromeprofilepath;
	}

	public String getURL() {
		return URL;
	}

//	public void setURl(String URL) {
//		this.URL = URL;
//	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSITURl() {
		return SITURl;
	}

	public void setSITURl(String SITuRl) {
		SITURl = SITuRl;
	}

	public String getJobDetailsPageURl() {
		return JobDetailsPageURl;
	}

	public void setJobDetailsPageURl(String JobDetailsPageuRl) {
		JobDetailsPageURl = JobDetailsPageuRl;
	}

	public String getsimilarJobURl() {
		return similarJobURl;
	}

	public void setsimilarJobURl(String similarJobURl) {
		this.similarJobURl = similarJobURl;
	}

	public String getinactiveJobURL() {
		return inactiveJobURL;
	}

	public void setinactiveJobURL(String inactiveJobURL) {
		this.inactiveJobURL = inactiveJobURL;
	}

	public String getnotCAJobURL() {
		return notCAJobURL;
	}

	public void setnotCAJobURL(String notCAJobURL) {
		this.notCAJobURL = notCAJobURL;
	}

	public String getJobCCDetailPageUrl() {
		return jobCCDetailPageUrl;
	}

	public void setJobCCDetailPageUrl(String jobCCDetailPageUrl) {
		this.jobCCDetailPageUrl = jobCCDetailPageUrl;
	}

	public String getUsernameLinkedIn() {
		return usernameLinkedIn;
	}

	public void setUsernameLinkedIn(String username) {
		this.usernameLinkedIn = username;
	}

	public String getPasswordLinkedIn() {
		return passwordLinkedIn;
	}

	public void setPasswordLinkedIn(String password) {
		this.passwordLinkedIn = password;
	}

	public String getPasswordUnlock() {
		return passwordUnlock;

	}

	public void setPasswordUnlock(String password) {
		this.passwordUnlock = password;
	}

	public String getfrenchJobUrl() {
		return frenchJobUrl;
	}

	public void setFrenchJobUrl(String frenchJobUrl) {
		this.frenchJobUrl = frenchJobUrl;
	}

	public String getWebFormUrl() {
		return webFormUrl;
	}

	public void setWebFormUrl(String webFormUrl) {
		this.webFormUrl = webFormUrl;
	}

	public String gethomePageUrl() {
		return homePageUrl;
	}

	public void sethomePageUrl(String homePageUrl) {
		this.homePageUrl = homePageUrl;
	}
	public String getUsernameLinkedIn1() {
		return usernameLinkedIn1;
	}

	public void setUsernameLinkedIn1(String username) {
		this.usernameLinkedIn1 = username;
	}

	public String getPasswordLinkedIn1() {
		return passwordLinkedIn1;
	}

	public void setPasswordLinkedIn1(String password) {
		this.passwordLinkedIn1 = password;
	}
	

	public ValueDTO() {
		try {
			Workbook wb;
			File file = new File("./src/test/resources/TestDataFiles/Test Data.xls");
			Sheet sh, sh1;
			wb = Workbook.getWorkbook(file);
			sh = wb.getSheet("Input Sheet");
			sh1 = wb.getSheet("Tech Config");

			this.URL = sh.getCell(0, 2).getContents();
			this.username = sh.getCell(1, 3).getContents();
			this.password = sh.getCell(2, 3).getContents();
			this.webDriverObj = sh.getCell(3, 2).getContents();
			this.email = sh.getCell(4, 2).getContents();
			this.browserStatusvalue = sh.getCell(5, 2).getContents();
			this.languageSelection = sh.getCell(6, 2).getContents();
			this.gmailAddress = sh.getCell(7, 2).getContents();
			this.gmailPwd = sh.getCell(8, 2).getContents();
			this.SITURl = sh.getCell(0, 3).getContents();
			this.JobDetailsPageURl = sh.getCell(0, 4).getContents();
			this.similarJobURl = sh.getCell(0, 5).getContents();
			this.inactiveJobURL = sh.getCell(0, 6).getContents();
			this.notCAJobURL = sh.getCell(0, 7).getContents();
			this.jobCCDetailPageUrl = sh.getCell(0, 8).getContents();
			this.usernameLinkedIn = sh.getCell(9, 2).getContents();
			this.passwordLinkedIn = sh.getCell(10, 2).getContents();
			this.frenchJobUrl = sh.getCell(0, 9).getContents();
			this.frenchJobUrl = sh.getCell(0, 9).getContents();
			this.webFormUrl = sh.getCell(0, 10).getContents();
			this.prscvformpageForFrenchJobURL = sh.getCell(0, 11).getContents();
			this.PRSgeneralcvpageURl = sh.getCell(0, 12).getContents();
			this.homePageUrl = sh.getCell(0, 13).getContents();
			this.clientProfileURL = sh.getCell(0, 14).getContents();
			this.logoJobDetailURL = sh.getCell(0, 15).getContents();			
			this.chromedriverpath = sh1.getCell(0, 1).getContents();		
			this.firefoxprofilepath = sh1.getCell(1, 1).getContents();
			this.geckodriver = sh1.getCell(1, 2).getContents();
			this.chromeprofilepath = sh1.getCell(2, 1).getContents();
			this.Iepath = sh1.getCell(3, 1).getContents();
			this.usernameLinkedIn1 = sh.getCell(12, 2).getContents();
			this.passwordLinkedIn1 = sh.getCell(13, 2).getContents();
			this.gmailURL = sh.getCell(0, 16).getContents();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
