package com.myTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.mypages.BasePage;
import com.mypages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	WebDriver driver;
	public Page page;
	Properties prop;
	ChromeOptions options;
	FirefoxOptions options1;
	
	@BeforeMethod
	@Parameters(value={"browser"})
	public void setupTest(String browser) throws IOException {
		
		
		options= new ChromeOptions();
		options1 = new FirefoxOptions();
		
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			options.addArguments("−−incognito");
			driver.manage().window().maximize();
		}else if(browser.equals("ff")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options1);
			options1.addArguments("--private");
			driver.manage().window().maximize();
		}else {
			System.out.println("driver doesn't match in xml file ........");
		}
		
		prop = new Properties();
		FileInputStream path =new FileInputStream(System.getProperty("user.dir")+"\\config\\configprop");
		prop.load(path);
		
		driver.get(prop.getProperty("url"));
		
		page = new BasePage(driver);
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
}
