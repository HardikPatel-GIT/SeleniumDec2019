package kdf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Methods {
	WebDriver driver;
	public void openBrowser() {
		driver = new ChromeDriver();
	}
	public void maximizeBrowserWindow() {
		driver.manage().window().maximize();
	}
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void navigateToApp(String url) {
		driver.get(url);
	}
	public void enterUserInfo(String loc, String locValue, String userName) {
		if (loc.equals("id")) {
			driver.findElement(By.id(locValue)).sendKeys(userName);
		}
		else if (loc.equals("name")) {
			driver.findElement(By.name(locValue)).sendKeys(userName);
		}
	}
	//public void enterPassword(String locValue, String password) {
		//driver.findElement(By.id(locValue)).sendKeys(password);
	//}
	public void clickSignInBtn(String loc, String lovValue) {
		if (loc.equals("id")) {
			driver.findElement(By.id(lovValue)).click();
		}
		else if (loc.equals("name")) {
			driver.findElement(By.name(lovValue)).click();
		}
	}
	public String verifyErrorMsg(String locValue) {
		String errMsg = driver.findElement(By.cssSelector(locValue)).getText();
		return errMsg;
	}
	public void closeAppl() {
		driver.close();
	}

}
