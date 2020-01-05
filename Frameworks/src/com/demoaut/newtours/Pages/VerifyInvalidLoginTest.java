package com.demoaut.newtours.Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.GenericMethods;

public class VerifyInvalidLoginTest {
	WebDriver driver;
	@BeforeClass
	public void openApp() {
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/");
	}
	
	@Test
	public void verifyInvalidCredential() throws IOException{
		Login lp = new Login(driver);
		SignOn so = new SignOn(driver);
		
		String[][] data = GenericMethods.getData("C:\\Users\\hpadmin\\Desktop\\SeleniumDec19\\book.xlsx", "Sheet1");
		
		for (int i = 0;i<data.length;i++) {
		lp.appLogin(data[i][0], data[i][1]);
		boolean signOnVisible = so.signOnLinkVisibility();
		Assert.assertTrue(signOnVisible);
		driver.navigate().back();
		}
	}
	
	@AfterClass
	public void closeApp() {
		driver.close();
	}
}
