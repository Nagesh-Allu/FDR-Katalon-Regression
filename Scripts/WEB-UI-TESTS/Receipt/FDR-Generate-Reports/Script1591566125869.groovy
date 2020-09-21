import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.junit.After

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Dashboard/reportButton'), 2)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Dashboard/reportButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Report-Generation/FDR-Report-Dashboard/receiptTransactionRequests'), 5, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FDR-Receipt/FDR-Report-Generation/FDR-Report-Dashboard/receiptTransactionRequests'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/inputDrawDate'), 3, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('FDR-Receipt/FDR-Report-Generation/FDR-Report-Dashboard/button_Cancel'), 3, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FDR-Receipt/FDR-Report-Generation/FDR-Report-Dashboard/button_Cancel'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-Report-Generation/FDR-Report-Dashboard/FDR-Monthly-Receipts/monthlyReceiptLabel'), 3)

String monthlyReceiptLabel = WebUI.getText(findTestObject('Object Repository/FDR-Receipt/FDR-Report-Generation/FDR-Report-Dashboard/FDR-Monthly-Receipts/monthlyReceiptLabel'))

assert monthlyReceiptLabel == 'Monthly Receipt Report for Federal Reporting (Defined by Draw Date)'

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-Report-Generation/FDR-Report-Dashboard/FDR-Monthly-Receipts/monthlyReceiptBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-Receipt/FDR-Report-Generation/FDR-Report-Dashboard/FDR-Monthly-Receipts/monthlyReceiptBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-Report-Generation/FDR-Report-Dashboard/FDR-Monthly-Receipts/monthlyReceiptSummaryHeader'), 3)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-Report-Generation/FDR-Report-Dashboard/FDR-Monthly-Receipts/monthDropdown'), 3)

WebUI.click(findTestObject('Object Repository/FDR-Receipt/FDR-Report-Generation/FDR-Report-Dashboard/FDR-Monthly-Receipts/monthDropdown'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-Report-Generation/FDR-Report-Dashboard/FDR-Monthly-Receipts/monthOption'), 3)

WebUI.click(findTestObject('Object Repository/FDR-Receipt/FDR-Report-Generation/FDR-Report-Dashboard/FDR-Monthly-Receipts/monthOption'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Report-Generation/FDR-Report-Dashboard/button_backToDashboard'), 3, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FDR-Receipt/FDR-Report-Generation/FDR-Report-Dashboard/button_backToDashboard'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-Report-Generation/FDR-Report-Dashboard/FDR-Daily-Processing-Receipts/dailyProcessingReceiptsLabel'), 3)

String dailyReceiptLabel = WebUI.getText(findTestObject('Object Repository/FDR-Receipt/FDR-Report-Generation/FDR-Report-Dashboard/FDR-Daily-Processing-Receipts/dailyProcessingReceiptsLabel'))

assert dailyReceiptLabel == 'Daily Receipt Report (Defined by Processing Date)'

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-Report-Generation/FDR-Report-Dashboard/FDR-Daily-Processing-Receipts/dailyProcessingReceiptsBtn'), 1)

WebUI.click(findTestObject('Object Repository/FDR-Receipt/FDR-Report-Generation/FDR-Report-Dashboard/FDR-Daily-Processing-Receipts/dailyProcessingReceiptsBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-Report-Generation/FDR-Report-Dashboard/FDR-Daily-Processing-Receipts/dailyProcessingReceiptHeader'), 3)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Report-Generation/FDR-Report-Dashboard/button_backToDashboard'), 1, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FDR-Receipt/FDR-Report-Generation/FDR-Report-Dashboard/button_backToDashboard'))

WebUI.delay(2)






