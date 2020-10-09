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

def d = new Date().plus(1)

def dd = new Date().plus(2)

servicedatefrom = d.format('MM/dd/yyyy')

servicedateto = dd.format('MM/dd/yyyy')

originalwarrantdate = dd.format('MM/dd/yyyy')

def newDepositId = org.apache.commons.lang.RandomStringUtils.randomNumeric(7)

editors.createReceipt(Drawdate, Paydate, newDepositId, ReceiptNotes, Remittance, Controller)

editors.createReceiptline(ReceiptID, SupplierID, DepositDate)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Fix/reviewButton'), 5)

WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Fix/reviewButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/button_Submitforapproval'), 2)

WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/button_Submitforapproval'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Dashboard/filterValidatebatch'), 2)

WebUI.waitForElementClickable(findTestObject('FDR-Receipt/FDR-Receipt-Dashboard/filterValidatebatch'),
	10)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Dashboard/filterValidatebatch'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Dashboard/buttonValidate'), 2)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Dashboard/buttonValidate'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/button_Reject'), 5)

WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/button_Reject'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/incorrectDrawDate'), 5)

WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/incorrectDrawDate'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/button_RejectReceiptBatch'), 2)

WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/button_RejectReceiptBatch'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Fix/clearButton'), 5)

WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Fix/clearButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Fix/fixBatchButton'), 5)

WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Fix/fixBatchButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Fix/fixButton'), 5)

WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Fix/fixButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

String instructionsLabel = 'INSTRUCTIONS FOR FIXING THIS RECEIPT'

WebUI.verifyElementText(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Fix/instructionsLabel'), instructionsLabel, FailureHandling.STOP_ON_FAILURE)

String instructionsIncorrectDrawDate = 'Incorrect Draw Date'

WebUI.verifyElementText(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Fix/instructionsIncorrectDrawDate'), instructionsIncorrectDrawDate, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Fix/reviewButton'), 5)

WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Fix/reviewButton'))



