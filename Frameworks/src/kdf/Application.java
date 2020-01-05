package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.GenericMethods;

public class Application {
	
	@Test
	public void verifyInvalidCredentials() throws IOException {
		Methods mt = new Methods();
		
		String[][] data = GenericMethods.getData("C:\\Users\\hpadmin\\Desktop\\SeleniumDec19\\TestData.xlsx", "Sheet2");
		
		for(int i = 1; i < data.length; i++) {
			String keyword = data[i][3];
			//making code changes after release 1.1
			switch (keyword) {
			case "openBrowser":
				mt.openBrowser();
				break;
			case "maxBrowser":
				mt.maximizeBrowserWindow();
				break;
			case "impWait":
				mt.implicitWait();
				break;
			case "navigateToApp":
				mt.navigateToApp(data[i][6]);
				break;
			case "enterUserID":
				mt.enterUserInfo(data[i][4],data[i][5], data[i][6]);
				break;
			case "enterPassword":
				mt.enterUserInfo(data[i][4],data[i][5], data[i][6]);
				break;
			case "clickSignIn":
				mt.clickSignInBtn(data[i][4],data[i][5]);
				break;
			case "verifyMsg":
				String actualMsg = mt.verifyErrorMsg(data[i][5]);
				String expectedMsg = data[i][6];
				Assert.assertEquals(expectedMsg, actualMsg);
				break;
			case "closeApp":
				mt.closeAppl();
				break;
				
			}
			
		}
		
		
		
		
		
	}

}
