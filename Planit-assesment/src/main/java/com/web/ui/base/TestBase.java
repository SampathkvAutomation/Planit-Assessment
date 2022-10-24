package com.web.ui.base;

import org.openqa.selenium.support.PageFactory;

public class TestBase extends WebCapabilities
{

	
	public TestBase()
	{
		PageFactory.initElements(driver, this);
	}
}
