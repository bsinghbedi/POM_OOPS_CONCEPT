package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
	
	//page locators
	private By emailid = By.cssSelector("#form-group--1");
	private By password = By.cssSelector("#form-group--3");
	private By loginbutton = By.xpath("//body[@id='udemy']/div[2]/preceding::button[3]");
	private By header = By.cssSelector("h2#auth-to-udemy-title");
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//public getters
	/**
	 * @return the emailid
	 */
	public WebElement getEmailid() {
		return getElement(emailid);
	}


	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		return getElement(password);
	}

	/**
	 * @return the loginbutton
	 */
	public WebElement getLoginbutton() {
		return getElement(loginbutton);
	}

	/**
	 * @return the header
	 */
	public WebElement getHeader() {
		return getElement(header);
	}

	public String getloginpagetitle() {
		return getPageTitle();
	}
	
	public HomePage dologin(String username, String pwd) {
		waitForElementPresent(emailid);
		getEmailid().sendKeys(username);
		getPassword().sendKeys(pwd);
		getLoginbutton().click();
		return getInstance(HomePage.class);
		
	}
	
	
	
	

}
