import org.openqa.selenium.WebDriver

import com.kazurayam.ks.driver.chrome4testing.ChromeForTestingDriverFactory
import com.kazurayam.ks.driver.chrome4testing.Installation
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

TestObject makeTestObject(String id, String xpath) {
	TestObject tObj = new TestObject(id)
	tObj.addProperty("xpath", ConditionType.EQUALS, xpath)
	return tObj	
}

// specify the path information of browser and driver binaries
ChromeForTestingDriverFactory df =
	new ChromeForTestingDriverFactory(Installation.mac_116_0_5793_0_mac_x64)

// open a window of "Chrome for Testing"
WebDriver driver = df.newChromeForTestingDriver()

// tell Katalon Studio to use this WebDriver instance so that the WebUI keyword can work with it
DriverFactory.changeWebDriver(driver)

// your ordinary katalon life begins here

WebUI.navigateToUrl("http://localhost:3000/")

TestObject dt1Locator = makeTestObject("dt1", "//div[@id='e2d-officer_movements']/table/tbody/tr[1]/td[9]")
TestObject dt2Locator = makeTestObject("dt2", "//div[@id='e2d-officer_movements']/table/tbody/tr[2]/td[9]")
WebUI.verifyElementPresent(dt1Locator, 10);
WebUI.verifyElementPresent(dt2Locator, 10);
WebUI.comment("dt1=${WebUI.getText(dt1Locator)}")
WebUI.comment("dt2=${WebUI.getText(dt2Locator)}")

WebUI.closeBrowser()