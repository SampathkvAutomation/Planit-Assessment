package com.web.ui.PageObjectModel;


import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.web.ui.base.PropertiesLoader;
import com.web.ui.base.TestBase;
import com.web.ui.base.WebCapabilities;

public class Cart  extends TestBase
{

	@FindBy(xpath="//h4[text()='Stuffed Frog']//following::a[1]")
	private WebElement iCon_buyFrog;
	String Frog ="//h4[text()='Stuffed Frog']//following::a[1]";
	@FindBy(xpath="//h4[text()='Fluffy Bunny']//following::a[1]")
	private WebElement Icon_buyBunny;
	@FindBy(xpath="//h4[text()='Valentine Bear']//following::a[1]")
	private WebElement Icon_BuyValentine ;
	
	@FindBy(xpath="//a[@href='#/cart']")
	private WebElement tab_cart;
	
	@FindBy(xpath="//a[text()='Shopping']")
	private WebElement shoppingPage;
	
	@FindBy(xpath="//a[@href='#/contact']")
	private WebElement contact;
	
	@FindBy(xpath="//strong[@class='total ng-binding']")
	private WebElement total;
	
String cartStuffedFrog ="//td[text()=' Stuffed Frog']/following::td";
String cartFluffyBunny="//td[text()=' Fluffy Bunny']/following::td";
String cartValentineBear="//td[text()=' Valentine Bear']/following::td";

static float toysAllTotal=0;
public Cart buyToys()
{
	
	   WebElement buyFrog =fluentWait(Frog);
	for(int i=0;i<2;i++)
	{
		
 
	uiClick(buyFrog);
	}
	for(int i=0;i<5;i++)
	{
	uiClick(Icon_buyBunny);
	}
	for(int i=0;i<3;i++)
	{
	uiClick(Icon_BuyValentine);
	}
	
	return this;
}
	

public Cart goToCart()
{
  uiClick(tab_cart);
  
 
  
	return this;
}
		

public Cart checksubTotal()
{
	subTotalCheck(cartStuffedFrog);
	subTotalCheck(cartFluffyBunny);
	float total=subTotalCheck(cartValentineBear);
	
	Assert.assertTrue(getTotal()==total);
	return this;
	
}


public float subTotalCheck(String Element)
{
	WebElement  priceStuffedToy = fluentWait(Element+"[1]");
	float price = Float.valueOf(priceStuffedToy.getText().substring(1));
	WebElement  quantityStuffedToy = fluentWait(Element+"[2]/input");
	float quantity = Float.valueOf(quantityStuffedToy.getAttribute("value"));
	WebElement  subTotalStuffedToy = fluentWait(Element+"[3]");
	float SubTotal = Float.valueOf(subTotalStuffedToy.getText().substring(1));
	
float sub =price*quantity;
	System.out.println(price+"*"+quantity+"="+price*quantity);
	DecimalFormat df = new DecimalFormat("0.00");
	if(sub==SubTotal)
	{
		Assert.assertTrue(sub==SubTotal);
		toysAllTotal=toysAllTotal+sub;
	}
	else {
	df.setRoundingMode(RoundingMode.UP);	
    sub=Float.valueOf(df.format(sub));
    System.out.println(sub +" - " +SubTotal);
    
	Assert.assertTrue(sub==SubTotal);
	toysAllTotal=toysAllTotal+sub;
	
	}
	return toysAllTotal;
}

public float getTotal()
{
	
	float toysT=Float.valueOf(total.getText().substring(6));
	
	return toysT;
}
}
