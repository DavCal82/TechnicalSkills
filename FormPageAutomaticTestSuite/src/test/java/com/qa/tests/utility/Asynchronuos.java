package com.qa.tests.utility;


import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.time.Duration;

import javax.imageio.ImageIO;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;



public class Asynchronuos {
	
	private static WebDriver driver;
	
	public static void waitImplicit(int timeout) throws Exception{
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			throw e;
		}
	}

	
	public static void waitForWebElementPresent(WebDriver driver_, String xpath) throws Exception{
		driver=driver_;
		Thread.sleep(2500);
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		
	}
	
/*	
	public static void waitExplicitToastMessageIsPresent(WebDriver driver_, String message, int secondsToWait) throws Exception {
		driver=driver_;
		secondsToWait=secondsToWait*1000;
		try {
			Thread.sleep(secondsToWait);
			driver.findElement(By.xpath("//*[contains(text(),'"+message+"')]"));
		}
		catch(Exception e) {
			throw e;
		}
		
	}
*/
	
	
		
	public static void RegisterError(WebDriver driver_,String TestName, String TimeOfExecution, Exception e_in) throws Exception {
		driver=driver_;
	    String folderPrefix1=".//Fails_Folder//"+TestName+"//";
		String folderPrefix2=".//Report//Screenshot//"+TestName+"//";
		try {
			//save the screenshot taken in destination path
			File directory1 = new File(folderPrefix1);
		    if (! directory1.exists()){
		        directory1.mkdir();
		    }
		    File directory2 = new File(folderPrefix2);
		    if (! directory2.exists()){
		        directory2.mkdir();
		    }
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			
			ImageIO.write(image, "png", new File(folderPrefix1+TimeOfExecution+".png"));
			File fileErrorStackTrace1 = new File(folderPrefix1+TimeOfExecution+".log");
			PrintStream ps1 = new PrintStream(fileErrorStackTrace1);
			e_in.printStackTrace(ps1);
			
			ImageIO.write(image, "png", new File(folderPrefix2+TestName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/*

	public static void mostraNotificaPopUp(WebDriver driver_,String messaggio) throws Exception{
		try {
			driver=driver_;
			JavascriptExecutor js = (JavascriptExecutor)driver;
			String messaggioPopup = "alert(\""+messaggio+"\")";
			js.executeScript(messaggioPopup);
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
		}catch(Exception e) {
			throw e;
		}
	}
	*/


}
