package com.qa.tests.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class LandingPO {
	private WebDriver driver;
	
	@FindBy(how=How.XPATH, using="/html/body/div[1]/div[1]/div/div/div/div/div/form/div[4]/div[2]/div/div/div[1]/div/div/div[1]/div/div[1]/div/div/div/input[1]")						
	private WebElement textField_1;
	
	@FindBy(how=How.XPATH, using="/html/body/div[1]/div[1]/div/div/div/div/div/form/div[4]/div[2]/div/div/div[1]/div/div/div[1]/div/div[2]/div/div/div/div/div/div/input[2]")
	private WebElement calendarEntryField;
	

	@FindBy(how=How.XPATH, using="/html/body/div[1]/div[1]/div/div/div/div/div/form/div[4]/div[2]/div/div/div[1]/div/div/div[1]/div/div[2]/div/div/div/div/div/div/div/button")
	private WebElement calendarIconButton;
	
	
	@FindBy(how=How.XPATH, using="/html/body/div[1]/div[1]/div/div/div/div/div/form/div[4]/div[2]/div/div/div[1]/div/div/div[2]/div/div/div/div/div/textarea")
	private WebElement textField_2;
	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"ddm-form-submit\"]")
	private WebElement submitButton;
	
	@FindBy(how=How.XPATH, using="/html/body/div[1]/div[1]/div/div/div/div/div/form/div[1]/div/div/div/button")
	private WebElement changeLanguageButton;
		
	
	public LandingPO(WebDriver _driver) {
		this.driver=_driver;
		PageFactory.initElements( _driver, this); 	
	}
	
	

	public void enterFavoriteSoccerPlayer(String arg1) {
		this.textField_1.click();
		this.textField_1.sendKeys(arg1);
	}
	
	public void verifyErrorValidationMessageAtPosition1(String expectedErrorMessage) throws Exception {
		try {
			WebElement actualErrorMessagePosition=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/form/div[4]/div[2]/div/div/div[1]/div/div/div[1]/div/div[1]/div/div/div/span[2]/div"));
			String actualErrorMessage=actualErrorMessagePosition.getText();
			if(!actualErrorMessage.equals(expectedErrorMessage)) {
				throw new Exception(actualErrorMessage.toString()+" is different from "+ expectedErrorMessage.toString()); 
			}
		}catch(Exception e) {
			throw e;
		}
	} 
	
	

	public void enterCalendarDate(String arg1) {
		this.calendarEntryField.click();
		this.calendarEntryField.sendKeys(arg1);
	}
	
	public void verifyErrorValidationCalendar(String expectedErrorMessage) throws Exception {
		try {
			WebElement actualErrorMessagePosition=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/form/div[4]/div[2]/div/div/div[1]/div/div/div[1]/div/div[2]/div/div/div/span[2]/div"));
			String actualErrorMessage=actualErrorMessagePosition.getText();
			if(!actualErrorMessage.equals(expectedErrorMessage)) {
				throw new Exception(actualErrorMessage.toString()+" is different from "+ expectedErrorMessage.toString()); 
			}
		}catch(Exception e) {
			throw e;
		}
	} 
	

	public void enterReasonYouJoinTestingArea(String arg1) {
		this.textField_2.click();
		this.textField_2.sendKeys(arg1);
	}
	
	public void verifyErrorValidationMessageAtPosition2(String expectedErrorMessage) throws Exception {
		try {
			WebElement actualErrorMessagePosition=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/form/div[4]/div[2]/div/div/div[1]/div/div/div[2]/div/div/div/div/div/span[2]/div"));
			String actualErrorMessage=actualErrorMessagePosition.getText();
			if(!actualErrorMessage.equals(expectedErrorMessage)) {
				throw new Exception(actualErrorMessage.toString()+" is different from "+ expectedErrorMessage.toString()); 
			}
		}catch(Exception e) {
			throw e;
		}
	} 
	
	public InfoSubmitedConfirmPagePO pushSubmitButton() throws Exception{
		try {
			this.submitButton.click();
			Thread.sleep(6000);
			driver.findElement(By.xpath("//*[contains(text(),'Success')]"));
			driver.findElement(By.xpath("//*[contains(text(),'Your request completed successfully')]"));

		}catch(Exception e) {
			throw e;
		}
		return new InfoSubmitedConfirmPagePO(this.driver);	
	}
	
	public void pushSubmitButtonMissingData() throws Exception{
		try {
			this.submitButton.click();
			Thread.sleep(2000);
		}catch(Exception e) {
			throw e;
		}
	}
	
	

	public LandingPageBrasilPO pushChangeLanguageButton() throws Exception{
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(changeLanguageButton).click()
														.build()
														.perform();
			
			
			Thread.sleep(2000);
			
			WebElement buttonMenu=driver.findElement(By.xpath("//*[contains(text(),'Brasil')]"));
			builder.moveToElement(buttonMenu).click()
									.build()
									.perform();
			
			Thread.sleep(5000);
			return new LandingPageBrasilPO(this.driver);
		}catch(Exception e) {
			throw e;
		}
	}
	
	
	public InfoSubmitedConfirmPagePO pushSubmitButtonWrongMethod() throws Exception{
		try {
			this.submitButton.click();
			Thread.sleep(6000);
			driver.findElement(By.xpath("//*[contains(text(),'Look for wrong message')]"));
		}catch(Exception e) {
			throw e;
		}
		
		return new InfoSubmitedConfirmPagePO(this.driver);	
	}
	
}
