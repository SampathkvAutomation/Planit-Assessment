package com.web.ui.PageObjectModel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.ui.base.PropertiesLoader;
import com.web.ui.base.TestBase;
import com.web.ui.base.WebCapabilities;

public class Home extends TestBase
{
   WebDriver driver;
	@FindBy(xpath="//a[@href='#/contact']")
	 WebElement contact;	

	@FindBy(xpath="//h1")
   private WebElement Header;	
	
	@FindBy(xpath="//a[@href='#/home']")
	private WebElement tab_Home;
	
	@FindBy(xpath="//a[text()='Start Shopping »']")
	private WebElement btn_shopping;
	
	
	public Home()
	{
		this.driver=getUiDriver();
		PageFactory.initElements(driver, this);
				
	}
	
	public Home openPage(String url)
	{
		getintDriver();
		login( url);
		return this;
	}

	public Home validatePage()
	{
		
		//IsVisible(Header);
		//Assert.assertEquals(Header.getText(),"Jupiter Toys");
		return this;
	}
	public Home goToContact()
	{
		
		uiClick(contact);
		return this;
	}
	


	public Contact validateContactPage()
	{
		Assert.assertEquals(getUiDriver().getCurrentUrl(),PropertiesLoader.getBaseUrl()+"/#/contact");
		
		return new Contact();
		
	}
	
	public Home GoToHome()
	{
		
		
		//IsEnabled(tab_Home);
		//tab_Home.click();
		//
		driver.get(PropertiesLoader.getBaseUrl()+"/#/home");
		return this;
	}
	
	public Home goToShop()
	{
		
		uiClick(btn_shopping);
		return this;
	}
	
	
	public Cart validateShoppingPage()
	{
		Assert.assertEquals(getUiDriver().getCurrentUrl(),PropertiesLoader.getBaseUrl()+"/#/shop");
		
		return new Cart();
		
	}


}