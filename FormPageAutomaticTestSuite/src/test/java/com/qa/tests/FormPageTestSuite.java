package com.qa.tests;

import java.sql.Timestamp;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.qa.tests.pages.*;
import com.qa.tests.utility.Asynchronuos;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FormPageTestSuite {
	
	private WebDriver driver;
	private String baseUrl;
	private String xPathReferenceLandingPage="/html/body/div[1]/div[1]/div/div/div/div/div/form/div[4]/div[1]/h1";
	
	@Before
	public void runBeforeTestMethod() {
		
		System.setProperty("webdriver.chrome.driver","lib\\chromedriver.exe");
		driver = new ChromeDriver();
        
        baseUrl="https://forms.liferay.com/web/forms/shared/-/form/122548";
        driver.manage().window().maximize();
     
	} 
	
	@After
	public void runAfterTestMethod() {
		driver.quit();
    } 
	@Test	
	public void t001_HappyPath() throws Exception{
		try{
			driver.get(baseUrl);
			Asynchronuos.waitForWebElementPresent(driver,xPathReferenceLandingPage);
			LandingPO landingPage=new LandingPO(driver);
			landingPage.enterFavoriteSoccerPlayer("Ronaldinho");
			landingPage.enterCalendarDate("01012000");
			landingPage.enterReasonYouJoinTestingArea("I'm applying for the role of senior QA Tester");
			InfoSubmitedConfirmPagePO confirmPage =landingPage.pushSubmitButton();
			confirmPage.checkThankYouMessagePresence("Thank you.");
			confirmPage.checkMessageExtendedPresence("Your information was successfully received. Thank you for filling out the form.");
			landingPage=confirmPage.pushSubmitAgainButton();
			Asynchronuos.waitForWebElementPresent(driver,xPathReferenceLandingPage);
		}
		catch(Exception e){
			String currentExecutionTime = new Timestamp(System.currentTimeMillis()).toString().replace(" ", "_").replace("-", "").replace(":", "").replace(".", "");
			String currentTestName=Thread.currentThread().getStackTrace()[1].toString().replace("com.qa.tests.FormPageTestSuite.","").split("[\\(||//)]")[0].toString();			
			Asynchronuos.RegisterError(driver,currentTestName,currentExecutionTime, e);
			Assert.fail("Exception " + e);
		}
		
	}

	@Test	
	public void t002_MissingDataInTextFiled1() throws Exception{
		try{
			driver.get(baseUrl);
			Asynchronuos.waitForWebElementPresent(driver,xPathReferenceLandingPage);
			LandingPO landingPage=new LandingPO(driver);
			//landingPage.enterFavoriteSoccerPlayer("");
			landingPage.enterCalendarDate("01012000");
			landingPage.enterReasonYouJoinTestingArea("I'm applying for the role of senior QA Tester");
			landingPage.pushSubmitButtonMissingData();
			landingPage.verifyErrorValidationMessageAtPosition1("This field is required.");
		}
		catch(Exception e){
			String currentExecutionTime = new Timestamp(System.currentTimeMillis()).toString().replace(" ", "_").replace("-", "").replace(":", "").replace(".", "");
			String currentTestName=Thread.currentThread().getStackTrace()[1].toString().replace("com.qa.tests.FormPageTestSuite.","").split("[\\(||//)]")[0].toString();			
			Asynchronuos.RegisterError(driver,currentTestName,currentExecutionTime, e);
			Assert.fail("Exception " + e);
		}
		
	}
	
	
	@Test	
	public void t003_MissingDataInCalendar() throws Exception{
		try{
			driver.get(baseUrl);
			Asynchronuos.waitForWebElementPresent(driver,xPathReferenceLandingPage);
			LandingPO landingPage=new LandingPO(driver);
			landingPage.enterFavoriteSoccerPlayer("Ronaldinho");
			landingPage.enterReasonYouJoinTestingArea("I'm applying for the role of senior QA Tester");
			landingPage.pushSubmitButtonMissingData();
			landingPage.verifyErrorValidationCalendar("This field is required.");
		}
		catch(Exception e){
			String currentExecutionTime = new Timestamp(System.currentTimeMillis()).toString().replace(" ", "_").replace("-", "").replace(":", "").replace(".", "");
			String currentTestName=Thread.currentThread().getStackTrace()[1].toString().replace("com.qa.tests.FormPageTestSuite.","").split("[\\(||//)]")[0].toString();			
			Asynchronuos.RegisterError(driver,currentTestName,currentExecutionTime, e);
			Assert.fail("Exception " + e);
		}
		
	}
	

	@Test	
	public void t004_MissingDataInTextFiled2() throws Exception{
		try{
			driver.get(baseUrl);
			Asynchronuos.waitForWebElementPresent(driver,xPathReferenceLandingPage);
			LandingPO landingPage=new LandingPO(driver);
			landingPage.enterFavoriteSoccerPlayer("Ronaldinho");
			landingPage.enterCalendarDate("01012000");
			landingPage.pushSubmitButtonMissingData();
			landingPage.verifyErrorValidationMessageAtPosition2("This field is required.");
		}
		catch(Exception e){
			String currentExecutionTime = new Timestamp(System.currentTimeMillis()).toString().replace(" ", "_").replace("-", "").replace(":", "").replace(".", "");
			String currentTestName=Thread.currentThread().getStackTrace()[1].toString().replace("com.qa.tests.FormPageTestSuite.","").split("[\\(||//)]")[0].toString();			
			Asynchronuos.RegisterError(driver,currentTestName,currentExecutionTime, e);
			Assert.fail("Exception " + e);
		}
		
	}
	
	@Test	
	public void t005_ChangeLanguageHappyPath() throws Exception{
		try{
			driver.get(baseUrl);
			Asynchronuos.waitForWebElementPresent(driver,xPathReferenceLandingPage);
			LandingPO landingPage=new LandingPO(driver);
			LandingPageBrasilPO landingPageBrasil= landingPage.pushChangeLanguageButton();
			landingPageBrasil.enterFavoriteSoccerPlayer("Ronaldinho");
			landingPageBrasil.enterCalendarDate("01012000");
			landingPageBrasil.enterReasonYouJoinTestingArea("Applying for the role of senior QA Tester");
			InfoSubmitedConfirmPageBrasilPO confirmPageBrasil =landingPageBrasil.pushSubmitButton();
			confirmPageBrasil.checkThankYouMessagePresence("Obrigado");
			landingPageBrasil=confirmPageBrasil.pushSubmitAgainButton();
			Asynchronuos.waitForWebElementPresent(driver,"/html/body/div[1]/div[1]/div/div/div/div/div/form/div[4]/div[1]/h1");
		}
		catch(Exception e){
			String currentExecutionTime = new Timestamp(System.currentTimeMillis()).toString().replace(" ", "_").replace("-", "").replace(":", "").replace(".", "");
			String currentTestName=Thread.currentThread().getStackTrace()[1].toString().replace("com.qa.tests.FormPageTestSuite.","").split("[\\(||//)]")[0].toString();			
			Asynchronuos.RegisterError(driver,currentTestName,currentExecutionTime, e);
			Assert.fail("Exception " + e);
		}
		
	}
	

}
