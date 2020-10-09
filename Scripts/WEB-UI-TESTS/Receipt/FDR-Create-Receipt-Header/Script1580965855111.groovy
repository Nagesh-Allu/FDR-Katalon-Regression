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

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Dashboard/createNew_ReceiptBatch_Button'), 3)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Dashboard/createNew_ReceiptBatch_Button'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/inputDrawDate'), 3)

WebUI.setText(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/inputDrawDate'), Drawdate)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/payDate'), 3)

WebUI.setText(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/payDate'), Paydate)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/deposit ID'), 10)

def depositId = org.apache.commons.lang.RandomStringUtils.randomNumeric(7)

WebUI.setText(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/deposit ID'), depositId )

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/receiptNotes'), 10)

WebUI.setText(findTestObject('FDR-Receipt/FDR-ReceiptBatch/receiptNotes'), Receiptnotes )

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/buttonNext'), 10)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/buttonNext'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/pDrawDate'), 2)
	
if(WebUI.getText(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/pDrawDate')) == findTestData('Receipt/FDR-ReceiptHeaderTestData').getValue(1,1)) {
	
	KeywordUtil.markPassed("Valid DrawDate")
}

else (FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/payDate'), 2)

if(WebUI.getText(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/payDate')) == findTestData('Receipt/FDR-ReceiptHeaderTestData').getValue(2,1)) {
	KeywordUtil.markPassed("Valid PayDate")
}

else (FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/depositId'), 2)

if(WebUI.getText(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/depositId')) == depositId) {
	KeywordUtil.markPassed("Valid DepositId")
}

else (FailureHandling.OPTIONAL)

WebUI.closeBrowser(FailureHandling.CONTINUE_ON_FAILURE)

