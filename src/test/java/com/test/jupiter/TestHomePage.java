package com.test.jupiter;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.web.ui.PageObjectModel.Contact;
import com.web.ui.PageObjectModel.Home;
import com.web.ui.base.PropertiesLoader;
import com.web.ui.base.TestBase;

import org.testng.Assert;



import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.support.ui.Wait;

public class TestHomePage extends TestBase
{	/*
	 * Author: Sampath K V
	 * 
	 * 
	 */
	@BeforeClass	
	public void setup()
	{
		
	((Home) new Home()).
	openPage(PropertiesLoader.getBaseUrl()).
	validatePage();
		
	}
	
	@Test(enabled=true,priority=1,groups= {"JupiterPage"},
     description="Validate Mandatory field Checks  ")
//	Test case 1:
//
//		1.	From the home page go to contact page
//		2.	Click submit button
//		3.	Verify error messages
//		4.	Populate mandatory fields
//		5.	Validate errors are gone

	public void checkMandatoryFields() throws InterruptedException
	{
		String expectederrorMessage="We welcome your feedback - but we won't get it unless you complete the form correctly.";
		String fornameError="Forename is required";
		String expectedmessageErr="Message is required";
		((Home) new Home()).validatePage().
		goToContact().
		validateContactPage().
		pressSubmit().
		CheckMandatoryFields(expectederrorMessage,fornameError,expectedmessageErr).
		enterMadatoryValues().
		validateNoError();
		
	}

	@Test(enabled=true,priority=2,groups= {"JupiterPage"},
		     description="Validate Submission with Madatory fields ")
//	Test case 2:
//
//		1.	From the home page go to contact page
//		2.	Populate mandatory fields
//		3.	Click submit button
//		4.	Validate successful submission message

			public void verifySubmission()  
			{
		  ((Home)  new Home()).
		  GoToHome().
		  validatePage().
		  goToContact().
		  validateContactPage().
		  enterMadatoryValues().
		  pressSubmitTroubleShoot().
		  VerifytheSubmission();
			
			}
	
	@Test(enabled=true,priority=3,groups= {"JupiterPage"},
		     description="Validate Shopping Cart ")
	
	public void VerifyCart()  
	{
		
		  ((Home)  new Home()).
		  GoToHome().
		  validatePage().
		  goToShop().
		  validateShoppingPage().
		  buyToys().
		  goToCart().
		  checksubTotal();

		
	}
	@AfterTest	public void tearDown()
	{
		closeBrowser();
	}
	
	

}
