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


import org.openqa.selenium.Keys as Keys

//WebUI.callTestCase(findTestCase('WEB-UI-TESTS/SysAdmin/SystemAdmin-Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/SysAdmin-Dashboard/maintainReferenceDataBtn'))

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/reference-data'))

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), 'Account')

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/accountReference/accountDetail/accountRefClick'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Account/addAccountbtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-Account/addAccountbtn'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Account/accountCode'), 3)

def accountCode = org.apache.commons.lang.RandomStringUtils.randomNumeric(7)

WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-Account/accountCode'), accountCode)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Account/accountName'), 3)

def accountName = org.apache.commons.lang.RandomStringUtils.randomAlphabetic(10)

WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-Account/accountName'), accountName)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Account/addAccountConfirmbtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-Account/addAccountConfirmbtn'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-Account/editAccountEllipsis'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-Account/editAccountEllipsis'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-Account/editAccountBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-Account/editAccountBtn'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-Account/editAccountLabel'), 3)

String editAccountLabel = WebUI.getText(findTestObject('FDR-System-Admin/FDR-Edit-Account/editAccountLabel'))

assert editAccountLabel == 'Edit Account'

def editAccountCode = org.apache.commons.lang.RandomStringUtils.randomNumeric(7)

def editAccountName = org.apache.commons.lang.RandomStringUtils.randomAlphabetic(10)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Account/accountCode'), 3)

WebUI.doubleClick(findTestObject('FDR-System-Admin/FDR-Add-Account/accountCode'))

WebUI.sendKeys(findTestObject('FDR-System-Admin/FDR-Add-Account/accountCode'), Keys.chord(Keys.BACK_SPACE))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Account/accountCode'), 3)

WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-Account/accountCode'), editAccountCode)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Account/accountName'), 3)

WebUI.doubleClick(findTestObject('FDR-System-Admin/FDR-Add-Account/accountName'))

WebUI.sendKeys(findTestObject('FDR-System-Admin/FDR-Add-Account/accountName'), Keys.chord(Keys.BACK_SPACE))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Account/accountName'), 3)

WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-Account/accountName'), editAccountName)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-Account/editSaveBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-Account/editSaveBtn'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-ReferencePage/accountReference/accountDetail/accountHeader'), 3)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Account/backToAccountsPage'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-Account/backToAccountsPage'))

if(WebUI.verifyElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/firstRowOfRefData'), 2)) {
	WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/firstRowOfRefData'))
	WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-ReferencePage/accountReference/accountDetail/accountHeader'), 3)
	String label = WebUI.getText(findTestObject('FDR-System-Admin/FDR-ReferencePage/accountReference/accountDetail/accountCode'))
	print label
	assert label == 'ACCOUNT CODE'
	
}
