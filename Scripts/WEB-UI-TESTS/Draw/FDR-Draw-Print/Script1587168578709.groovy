import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.testng.Assert
import com.functions.Uifunctions
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import com.kms.katalon.core.webui.driver.DriverFactory
import java.util.concurrent.TimeUnit;
import internal.GlobalVariable as GlobalVariable

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)

String drawdate = '09/30/2020'

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Draw/FDR-Print-Draw/Draw-Dashboard/expandBtn'), 3)

WebDriver driver = DriverFactory.getWebDriver()

List divs = driver.findElements(By.xpath("//*[@id='wrapper']/main/div/div/div/div/main/div/div[2]/div/child::*/following-sibling::*"))

driver.findElement(By.xpath("//*[@id='wrapper']/main/div/div/div/div/main/div/div[2]/div/child::*/following-sibling::div[position()=1]/div/div/div/div[2]/div/div/h3")).click()

for(int i=1;i<=divs.size();i++){
	
	if(driver.findElement(By.xpath("//*[@id='wrapper']/main/div/div/div/div/main/div/div[2]/div/child::*/following-sibling::div[position()="+i+"]/div/div/div/div[2]/div/div/h3")).getText()==drawdate){
		
		WebUI.delay(4)
		
		driver.findElement(By.xpath("//*[@id='wrapper']/main/div/div/div/div/main/div/div[2]/div/child::*/following-sibling::div[position()="+i+"]/div/div/div/div[2]/div/div/h3")).click()
		
		WebUI.delay(4)
		
		driver.findElement(By.xpath("//*[@id='wrapper']/main/div/div/div/div/main/div/div[2]/div/child::*/following-sibling::div[position()="+i+"]/div[2]/div/div/div/div/div/div[2]/ul/li/div/div[3]/div/a")).click()
		
		WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Draw/FDR-Print-Draw/Draw-Dashboard/drawDateHeader'), 3)
		
		WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Draw/FDR-Print-Draw/Draw-Dashboard/closedDrawStatusBtn'), 3)
		
		WebUI.click(findTestObject('Object Repository/FDR-Draw/FDR-Print-Draw/Draw-Dashboard/closedDrawStatusBtn'))
		
		WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Draw/FDR-Print-Draw/Draw-Dashboard/backToDashboard'), 3)
		
		WebUI.click(findTestObject('Object Repository/FDR-Draw/FDR-Print-Draw/Draw-Dashboard/backToDashboard'))
		
		WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Draw/FDR-Print-Draw/Draw-Dashboard/expandBtn'), 3)
		
//		driver.findElement(By.xpath("//*[@id='wrapper']/main/div/div/div/div/main/div/div[2]/div/child::*/following-sibling::div[position()=1]/div/div/div/div[2]/div/div/h3")).click() // minimizing 1st div
		
		driver.findElement(By.xpath("//*[@id='wrapper']/main/div/div/div/div/main/div/div[2]/div/child::*/following-sibling::div[position()="+i+"]/div/div/div/div[2]/div/div/h3")).click() //expanding draw date
		
		WebUI.delay(4)
		
		driver.findElement(By.xpath("//*[@id='wrapper']/main/div/div/div/div/main/div/div[2]/div/child::*/following-sibling::div[position()="+i+"]/div[2]/div/div/div/div/div/div[2]/ul/li/div/div[3]/div/button")).click() //finalize
		
		WebUI.delay(4)
		
		driver.findElement(By.xpath("//*[@id='wrapper']/main/div/div/div/div/main/div/div[2]/div/child::*/following-sibling::div[position()="+i+"]/div[2]/div/div/div/div/div/div[2]/ul/li/div/div[3]/div/button")).click() //validate
		
		WebUI.delay(4)
		
		driver.findElement(By.xpath("//*[@id='wrapper']/main/div/div/div/div/main/div/div[2]/div/child::*/following-sibling::div[position()="+i+"]/div[2]/div/div/div/div/div/div[2]/ul/li/div/div[3]/div/a")).click() //Print
		
		WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Draw/FDR-Print-Draw/Draw-Dashboard/printDrawdateHeader'), 3)
		
		List prints = driver.findElements(By.xpath("//*[@id='wrapper']/main/div/div/div/div/div[2]/div/div[1]/div/child::*")) // number of prints
		
			for(int j=1;j<=prints.size();j++){
		
						WebUI.delay(3)
				
						driver.findElement(By.xpath("//*[@id='wrapper']/main/div/div/div/div/div[2]/div/div[1]/div/child::div[position()="+j+"]/div/button")).click() // print button
				
						WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Draw/FDR-Print-Draw/Draw-Dashboard/printDrawdateHeader'), 3)
			}
		
		WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Draw/FDR-Print-Draw/Draw-Dashboard/allFormsPrintBtn'), 3)
		
		WebUI.click(findTestObject('Object Repository/FDR-Draw/FDR-Print-Draw/Draw-Dashboard/allFormsPrintBtn'))
		
		WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Draw/FDR-Print-Draw/Draw-Dashboard/expandBtn'), 3)
		
		break
	}
}

WebUI.delay(5)
