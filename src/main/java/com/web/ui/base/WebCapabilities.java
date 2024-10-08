package com.web.ui.base;

import java.io.File;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class WebCapabilities 
{
	
	
	public static WebDriver driver =null;
	public void getintDriver()
	{
		
  String path = System.getProperty("user.dir")+File.separator+PropertiesLoader.getChromeDriver();

  System.setProperty("webdriver.chrome.driver",path);
	 driver = new ChromeDriver();
	 PageFactory.initElements(driver, this);
					 
					
	}
	
	public WebDriver getUiDriver()		
	{
	return this.driver;	
	}
	
	public void login(String url)
	{
		driver.navigate().to(url);
	}	
	
    public WebElement fluentWait(String Elements)
	{    
    	 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
		.withTimeout(Duration.ofSeconds(30)) 			
		.pollingEvery(Duration.ofSeconds(3)) 			
		.ignoring(NoSuchElementException.class);
    	 
		 WebElement elementStaled = wait.until(new Function<WebDriver, WebElement>(){			
			public WebElement apply(WebDriver driver ) 
			{		
			return driver.findElement(By.xpath(Elements));
						
			}
			});
		return elementStaled;
	}
    
    public WebElement IsVisible(WebElement Elements)
   	{    
       	 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
   		.withTimeout(Duration.ofSeconds(40)) 			
   		.pollingEvery(Duration.ofSeconds(3)) 			
   		.ignoring(NoSuchElementException.class);
       	 
   		 WebElement elementStaled = wait.until(new Function<WebDriver, WebElement>(){			
   			public WebElement apply(WebDriver driver ) 
   			{		
   				
   				Elements.isDisplayed();
   			return Elements;
   						
   			}
   			});
   		return elementStaled;
   	}
    
    
    public void IsEnabled(WebElement Elements)
   	{    
       	 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
   		.withTimeout(Duration.ofSeconds(30)) 			
   		.pollingEvery(Duration.ofSeconds(3)) 			
   		.ignoring(NoSuchElementException.class);
       	 
   		 WebElement elementStaled = wait.until(new Function<WebDriver, WebElement>(){			
   			public WebElement apply(WebDriver driver ) 
   			{		
   				
   				Elements.isEnabled();
   			return Elements;
   						
   			}
   			});
   		
   	}
    
    
    public void validateTheColor(WebElement Element,String Color)
    {
    	Assert.assertEquals(Element.getCssValue("color"),Color);
    }
    
    public void uiClick(WebElement element)
    {
    	element.click();
    }
    public void closeBrowser()
    {
    	
    	driver.quit();
    }
}
