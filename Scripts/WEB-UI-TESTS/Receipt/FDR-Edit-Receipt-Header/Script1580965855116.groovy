import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import org.openqa.selenium.WebElement as WebElement
import com.functions.Uifunctions as Uifunctions
import com.functions.editors as editors
import com.functions.validators as validators
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

def newDepositId = org.apache.commons.lang.RandomStringUtils.randomNumeric(7)

def newDepositId2 = org.apache.commons.lang.RandomStringUtils.randomNumeric(7)

editors.createReceipt(Drawdate, Paydate, newDepositId, Receiptnotes)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/Mose_over'), 2)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/Mose_over'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/3dots_icon'), 2)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/3dots_icon'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/edit-Icon'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/payDate'), 10)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/payDate'), Keys.chord(Keys.TAB, Keys.TAB))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/deposit_ID'), 5)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/deposit_ID'), Keys.chord(Keys.DELETE))

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/deposit_ID'), newDepositId2 + Keys.chord(Keys.TAB))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/receipt_Notes'), 5)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/receipt_Notes'), Keys.chord(Keys.DELETE))

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/receipt_Notes'), receiptnotes)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/receipt_Notes'), Keys.chord(Keys.TAB))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/next_Button'), 10)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/next_Button'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/Mose_over'), 2)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/Mose_over'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/depositId'), 2)

if (WebUI.getText(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/depositId')) == newDepositId2.toString()) {
	KeywordUtil.markPassed('DepositId edited successfully')}

else (FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/receiptsNotes'), 2)

if (WebUI.getText(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/receiptsNotes')) == receiptnotes) {
		KeywordUtil.markPassed('receiptsNotes edited successfully')}
	
else (FailureHandling.OPTIONAL)

WebUI.closeBrowser(FailureHandling.CONTINUE_ON_FAILURE)


