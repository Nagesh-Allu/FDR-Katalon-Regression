 /* /* Project Name : FDR
  * FDRPM-2938- TC-5 - End to End FDR User Flow - System Admin Reference Data - Katalon Scripts
 * TestCase Name: FDR-E2E-FDR-2938-SYSTEM ADMIN REFERENCE Data
 * List of Voucher Functions are used :
 * Author : Nagesh Allu
 * Creation Date:10/23/2020
 * def Datasheet=findTestData('FDR_E2E-REGRESSION-TESTS-DATA/FDR-E2E-FDR-8209-VOUCHER-APPROVAL-DATA') 
 /*List of Import packages and libraries*/ 
 import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
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
import com.etoe.voucherFunctions as VF
import com.etoe.commonFunctions as CF
import com.kms.katalon.core.testdata.ExcelData as ExcelData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.global.functions.DrawDate as GF

// Execute Login function,Set role to SuperUser (Path-->Keywords\com\etoe--commonFunctions)
'1.  Login to FDR as a Sys Admin'

CF.login(GlobalVariable.superUserAccnt, GlobalVariable.superUserPwd)
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
// calling createVoucherHeader function from VouchersFunctions.groovy

// Calling Logout function
CF.logout()





