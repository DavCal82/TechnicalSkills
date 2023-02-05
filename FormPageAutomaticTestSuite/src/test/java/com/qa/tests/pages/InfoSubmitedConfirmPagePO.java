package com.qa.tests.pages;

//import com.qa.tests.utility.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class InfoSubmitedConfirmPagePO {
	private WebDriver driver;
	@FindBy(how=How.XPATH, using="/html/body/div[1]/div[1]/div/div/div/div/div/div[2]/h2")
	private WebElement thankYouSection;
	
	@FindBy(how=How.XPATH, using="/html/body/div[1]/div[1]/div/div/div/div/div/div[2]/p")
	private WebElement messageExtended;
	
	@FindBy(how=How.XPATH, using="/html/body/div[1]/div[1]/div/div/div/div/div/div[2]/div/button")
	private WebElement submitAgainButton;
	
	public InfoSubmitedConfirmPagePO(WebDriver _driver) {
		this.driver=_driver;
		PageFactory.initElements( _driver, this); 	
	}
	
	public LandingPO pushSubmitAgainButton() throws Exception{
		try {
			this.submitAgainButton.click();
			Thread.sleep(6000);}catch(Exception e) {
			throw e;
		}
		
		return new LandingPO(this.driver);	
	}
	
	public void checkThankYouMessagePresence(String expectedMessage) throws Exception{
		try {
			String actualMessage = thankYouSection.getText();
			if(!actualMessage.equals(expectedMessage)) {
				throw new Exception(actualMessage.toString()+" is different from "+ expectedMessage.toString()); 
			}
		}catch(Exception e) {
			throw e;
		}	
	}
	
	public void checkMessageExtendedPresence(String expectedMessage) throws Exception{
		try {
			String actualMessage = messageExtended.getText();
			if(!actualMessage.equals(expectedMessage)) {
				throw new Exception(actualMessage.toString()+" is different from "+ expectedMessage.toString()); 
			}
		}catch(Exception e) {
			throw e;
		}	
	}
	
}
