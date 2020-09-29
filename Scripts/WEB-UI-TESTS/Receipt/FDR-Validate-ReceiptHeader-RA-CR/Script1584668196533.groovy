import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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

import com.functions.editors as editors
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil


def d = new Date().plus(1)

def dd = new Date().plus(2)

servicedatefrom = d.format('MM/dd/yyyy')

servicedateto = dd.format('MM/dd/yyyy')

def newDepositId = org.apache.commons.lang.RandomStringUtils.randomNumeric(7)

editors.createReceipt(Drawdate, Paydate, newDepositId, Receiptnotes)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/3dots_icon'), 2)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/3dots_icon'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/edit-Icon'), FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/remmitanceAdviceInput'), 2, FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/remmitanceAdviceInput'), remmitanceAdvice)
WebUI.verifyElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/controllerReceiptInput'), 2, FailureHandling.STOP_ON_FAILURE)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/controllerReceiptInput'), controllerReceipt)
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/next_Button'), 2)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/next_Button'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/Mose_over'), 2)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/Mose_over'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/remmitanceAdviceView'),2)
if(WebUI.getText(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/remmitanceAdviceView')) == remmitanceAdvice){
	KeywordUtil.markPassed('Remmitance Advice verified successfully')
}

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/controllerReceiptView'),2)
if(WebUI.getText(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/controllerReceiptView')) == controllerReceipt){
	KeywordUtil.markPassed('Remmitance Advice verified successfully')
}