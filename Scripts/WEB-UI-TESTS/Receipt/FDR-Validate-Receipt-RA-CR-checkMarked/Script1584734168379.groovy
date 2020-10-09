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

def newDepositId = org.apache.commons.lang.RandomStringUtils.randomNumeric(7)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Dashboard/createNew_ReceiptBatch_Button'), 3)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Dashboard/createNew_ReceiptBatch_Button'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/inputDrawDate'), 3)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/inputDrawDate'), Drawdate)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/payDate'), 3)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/payDate'), Paydate)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/deposit ID'), 5)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/deposit ID'), newDepositId )

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/receiptNotes'), 5)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-ReceiptBatch/receiptNotes'), Receiptnotes )

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/remittanceNo'), 5)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/remittanceNo'), Remittance )

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/controllerNo'), 5)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/controllerNo'), Controller )

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/buttonNext'), 5)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/buttonNext'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/colorRA'), 5)

String css_color_RA = WebUI.getCSSValue(findTestObject('FDR-Receipt/FDR-ReceiptBatch/colorRA'), 'color')

String css_color_CA = WebUI.getCSSValue(findTestObject('FDR-Receipt/FDR-ReceiptBatch/colorCA'), 'color')

WebUI.verifyEqual(css_color_RA, 'rgba(71, 185, 112, 1)')

if((css_color_RA=='rgba(71, 185, 112, 1)') && (css_color_CA=='rgba(71, 185, 112, 1)')){
	
	WebUI.verifyElementClickable(findTestObject('FDR-Receipt/FDR-ReceiptBatch/reviewButton'))
	
}else{

	WebUI.verifyElementNotClickable(findTestObject('FDR-Receipt/FDR-ReceiptBatch/reviewButton'))

}



