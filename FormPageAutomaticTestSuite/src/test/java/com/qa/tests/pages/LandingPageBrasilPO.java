package com.qa.tests.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;


public class LandingPageBrasilPO {

	private WebDriver driver;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"ddm-form-submit\"]")
	private WebElement submitButton;
	
	
	public LandingPageBrasilPO(WebDriver _driver) {
		this.driver=_driver;
		PageFactory.initElements( _driver, this); 	
	}
	
	

	public void enterFavoriteSoccerPlayer(String arg1) {
		//WebElement textField_1= driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/form/div[4]/div[2]/div/div/div[1]/div/div/div[1]/div/div[1]/div/div/div/input[1]"));	
		WebElement textField_1= driver.findElement(By.cssSelector("input[class='form-control ddm-field-text']"));
		textField_1.click();
		textField_1.sendKeys(arg1);
	}
	
	public void enterCalendarDate(String arg1) {
		//WebElement calendarEntryField= driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/form/div[4]/div[2]/div/div/div[1]/div/div/div[1]/div/div[2]/div/div/div/div/div/div/input[2]"));	
		WebElement calendarEntryField= driver.findElement(By.cssSelector("input[class='form-control input-group-inset input-group-inset-after']"));
		calendarEntryField.click();
		calendarEntryField.sendKeys(arg1);
	}
	
	public void enterReasonYouJoinTestingArea(String arg1) throws Exception {
		
		
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			String jsTextInfield = "document.getElementsByClassName('ddm-field-text form-control')[1].click"; 
			js.executeScript(jsTextInfield);
			Thread.sleep(2000);
			jsTextInfield = "document.getElementsByClassName('ddm-field-text form-control')[1].value='" + arg1+"'"; 
			js.executeScript(jsTextInfield);
			this.submitButton.click();
			Thread.sleep(6000);
			WebElement textField_2= driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/div/form/div[4]/div[2]/div/div/div[1]/div/div/div[2]/div/div/div/div/div/textarea"));	
			textField_2.click();
			textField_2.sendKeys(arg1);
		}catch(Exception e) {
			throw e;
		}
		//Actions builder = new Actions(driver);
		//WebElement textField_2= driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/form/div[4]/div[2]/div/div/div[1]/div/div/div[2]/div/div/div/div/div/textarea"));	
		//WebElement textField_2= driver.findElement(By.xpath("//*[@id=\"ddmFormI6NIGLEH\"]/div[2]/div/div/div[1]/div/div/div[2]/div/div/div/div/div/textarea"));
		//WebElement textField_2= driver.findElement(By.cssSelector("input[class='ddm-field-text form-control']"));
		
		//WebElement textField_2= driver.findElement(By.xpath("//*[contains(text(),'Porque')]"));	
		//builder.moveToElement(textField_2).click().build().perform();
		
		//textField_2.click();
		//textField_2.sendKeys(arg1);
		
		
		
		//Actions actionProvider = new Actions(driver);
		//actionProvider.moveToElement(textField_2).build().perform();
	}
	
	
	public InfoSubmitedConfirmPageBrasilPO pushSubmitButton() throws Exception{
		try {
			this.submitButton.click();
			Thread.sleep(6000);
			driver.findElement(By.xpath("//*[contains(text(),'Success')]"));
			driver.findElement(By.xpath("//*[contains(text(),'Your request completed successfully')]"));

		}catch(Exception e) {
			throw e;
		}
		return new InfoSubmitedConfirmPageBrasilPO(this.driver);	
	}
	
	
}
