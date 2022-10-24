package com.web.ui.PageObjectModel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.web.ui.base.PropertiesLoader;
import com.web.ui.base.TestBase;
import com.web.ui.base.WebCapabilities;

public class Contact  extends TestBase
{
	@FindBy(xpath="//a[@href='#/contact']")
	private WebElement contact;
	
	final String btnSubmit="//a[text()='Submit']";
	@FindBy(xpath=btnSubmit)
	private WebElement btn_Submit;
	
	@FindBy(xpath="//strong[text()='We welcome your feedback']/ancestor::div[1]")
	private WebElement msg_MainError;
	
	@FindBy(xpath="//input[@id='forename']/following::span[1]")
	private WebElement forNameCheck;
	
	@FindBy(xpath="//label[@for='forename']")
	private WebElement forNameColor;
	
	@FindBy(xpath="//label[@for='email']")
	private WebElement emailColor;
	
	@FindBy(xpath="//span[@id='email-err']")
	private WebElement emailError;	
		
	@FindBy(xpath="//*[@id='message-err']")
	private WebElement messageError;

	@FindBy(xpath="//label[@for='message']")
	private WebElement messageColor;


	@FindBy(xpath="//input[@id='forename']")
	private WebElement tx_Name;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement tx_Email;
	
	@FindBy(xpath="//textarea[@id='message']")
	private WebElement tx_Message;
	
	@FindBy(xpath="//a[@href='#/home']")
	private WebElement tab_Home;
	
	String success= "//*[@class='alert alert-success']";
	
	String forName="Sampath";
	
	public Home validateContactPage()
	{
		Assert.assertEquals(getUiDriver().getTitle(),PropertiesLoader.getBaseUrl()+"/#/contact");
		return new Home();
	}
	
	public Contact pressSubmit()
	{
		
		WebElement submitBtn = fluentWait(btnSubmit);
		IsEnabled(submitBtn);
		submitBtn.click();
		
		return this;
	}
	
	public Contact CheckMandatoryFields(String Expected,String fornameError,String expectedmessageErr )
	{
		Assert.assertEquals(Expected,msg_MainError.getText());
		Assert.assertEquals(fornameError,forNameCheck.getText());
		Assert.assertEquals(expectedmessageErr,messageError.getText());
		Assert.assertEquals("rgba(185, 74, 72, 1)",forNameColor.getCssValue("color"));
		Assert.assertEquals("rgba(185, 74, 72, 1)",emailColor.getCssValue("color"));
		Assert.assertEquals("rgba(185, 74, 72, 1)",messageColor.getCssValue("color"));
		
        return this ;
    }
	
	public Contact enterMadatoryValues() 
	{
		IsVisible(tx_Name);
		tx_Name.sendKeys(forName);
		IsVisible(tx_Email);
		tx_Email.sendKeys("kvsampathvg@gmail.com");
		IsVisible(tx_Message);
		tx_Message.sendKeys("Sample Message");
	
		return this;
	}

	public Contact validateNoError()
	{
		
		Assert.assertEquals(forNameColor.getCssValue("color"),"rgba(51, 51, 51, 1)");
	
		Assert.assertEquals(emailColor.getCssValue("color"),"rgba(51, 51, 51, 1)");
		
		Assert.assertEquals(messageColor.getCssValue("color"),"rgba(51, 51, 51, 1)");
		return this;
	}
	

	public Contact GoToHome()
	{
		tab_Home.click();
		return this;
	}
	
	public Contact VerifytheSubmission()
	{

		WebElement alertsucces = fluentWait(success);
	

		
	Assert.assertEquals(alertsucces.getText(),"Thanks "+forName+", we appreciate your feedback.");
		
		return this;
		
	}
	
	public Contact pressSubmitTroubleShoot()
	{
		
       WebElement submitBtn = fluentWait(btnSubmit);

Actions builder = new Actions(driver);
builder.moveToElement(submitBtn).click(submitBtn);
builder.perform();

		return this;
	}
}