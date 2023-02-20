package com.myTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mypages.HomePage;
import com.mypages.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test(priority = 1)
	public void verifyloginpagetitletest() {
		String title = page.getInstance(LoginPage.class).getloginpagetitle();
		System.out.println(title);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(title, "Online Courses - Learn Anything, On Your Schedule | Udemy");
		soft.assertAll();
		
	}
	
	@Test(priority = 2)
	public void dologintest() throws Exception {
		HomePage homepage = page.getInstance(LoginPage.class).dologin("birpartapsinghbedi@gmail.com", "Bir$CaN$1");
		Thread.sleep(5000);
		String HPHeader = homepage.getHomePageHeader();
		System.out.println(HPHeader);
		Assert.assertEquals(HPHeader, "Let's start learning, Birpartap Singh");
	}
	
	

}
