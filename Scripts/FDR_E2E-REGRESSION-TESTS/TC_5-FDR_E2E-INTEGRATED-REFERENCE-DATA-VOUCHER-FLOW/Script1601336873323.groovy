 /* Project Name : FDR
 * END_END_TC_5-FDR_E2E-FDR-2938-SYSTEM ADMIN REFERENCE DATA
 * Requriment:https://ca-mmisds.atlassian.net/browse/FDRPM-2938
 * Test Scenario : Validate Account Number in Voucher-Distribution line after added a New Account as a System Admin role. 
 * Author : Nagesh Allu
 * Creation Date: 10/20/2020
 * Revision History:
 * 		1) Added ObjectRepository--> AccWarningMsg in FDR-VoucherEntry/DistributionLine
		2) Upated resumeButton Xpath--> FDR-Dashboard-VouchersTable--> //*[contains(@aria-label,'Resume Voucher 1')]//*[text()='Resume']
*****************************************************************************************************************/
//List of Import packages and libraries
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
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.etoe.voucherFunctions as VF
import com.etoe.commonFunctions as CF
import com.kms.katalon.core.testdata.ExcelData as ExcelData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys

// Execute Login function,Set role to SuperUser (Path-->Keywords\com\etoe--commonFunctions)
'1. Login as a SuperUser'
CF.login(GlobalVariable.superUserAccnt, GlobalVariable.superUserPwd)
'2. click on ReferenceData button'
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/FDR-System-Admin/SysAdmin-Dashboard/maintainReferenceDataBtn'))
'3.Clcik on Reference data and chose account'
WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/reference-data'))
WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), 'Account')
WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/accountReference/accountDetail/accountRefClick'))
'4. Click on Account Button'
WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Account/addAccountbtn'), 3)
'5.Clcik on Add Account'
WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-Account/addAccountbtn'))
WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Account/accountCode'), 3)
def accountCode = org.apache.commons.lang.RandomStringUtils.randomNumeric(7)
'6. Create a Account Code'
WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-Account/accountCode'), accountCode)
WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Account/accountName'), 3)
def accountName = org.apache.commons.lang.RandomStringUtils.randomAlphabetic(10)
'7.Enter Account Name'
WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-Account/accountName'),accountName)
WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Account/addAccountConfirmbtn'), 3)
'8. Click Add Account Button'
WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-Account/addAccountConfirmbtn'))

//********************************************************
WebUI.click(findTestObject('Object Repository/FDR-Dashboard/appLogo'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/FDR-System-Admin/SysAdmin-Dashboard/maintainReferenceDataBtn'))
WebUI.setText(findTestObject('FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), 'alt account')
WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/altAccountReference/altAccountReview/altAccount'))
WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/addAltAccountBtn'), 3)
WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/addAltAccountBtn'))
def altAccountCode = org.apache.commons.lang.RandomStringUtils.randomNumeric(10)
def altAccountName = org.apache.commons.lang.RandomStringUtils.randomAlphabetic(10)
WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/altAccountCode'), 3)
WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/altAccountCode'), altAccountCode)
WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/altAccountName'), 3)
WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/altAccountName'), altAccountName)
WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/accountName'), 3)

//WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/accountName'))
WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/accountName'), 3)
WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/accountName'))
WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/accountName'), accountName)
WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-AltAccount/accountNameOption'), 3)
WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-AltAccount/accountNameOption'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/confirmAltAccountBtn'), 5)
WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/confirmAltAccountBtn'))
//WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-AltAccount/saveAltAccountBtn'))

//findTestObject('Object Repository/FDR-System-Admin/FDR-Add-AltAccount/accountName')
//*********************************************************
// Login Funtion as a "Account Specific Role (Path -->Keywords\com\etoe--commonFunctions)
'9.Click Loign to switch the role to accountsPayableProcessor'
CF.selectRole('accountsPayableProcessor')
'10. click on FixFilterButton in the dashboard'
WebUI.click(findTestObject('FDR-Dashboard/Filters/fixFilterButton'))
'11. Click on ResumeFilterButton'
WebUI.click(findTestObject('Object Repository/FDR-Dashboard/Filters/resumeFilterButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

if (WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/VouhcersTable/fixButton'), 5)) {
    WebUI.click(findTestObject('FDR-Dashboard/VouhcersTable/fixButton'))
} else {
    WebUI.click(findTestObject('Object Repository/FDR-Dashboard/VouhcersTable/resumeButton'))
}

'12.Invoice line expand Button'
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
WebUI.mouseOver(findTestObject('FDR-EditVoucher/DLHover'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

'13.Click on DistributionEdit Icon'
WebUI.click(findTestObject('FDR-EditVoucher/DLEditIcon'))
WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/DLEditClick'), 2)
WebUI.click(findTestObject('FDR-EditVoucher/DLEditClick'))
'14. click on Account tab'

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/account'))
//WebUI.clearText(findTestObject('FDR-VoucherEntry/DistributionLine/account'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
'14. Click on the Accounts Dropdown and verify it contains account number "xxxxxx" that the sys Admin added in the dashboard'

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/account'), Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/account'), Keys.chord(Keys.BACK_SPACE))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/account'), accountCode)
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/account'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/DistributionLine/altAccount'),2)
WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/altAccount'))
WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/altAccount'), altAccountCode)
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/altAccount'), Keys.chord(Keys.DOWN, Keys.ENTER))

'15.Click save Button'
WebUI.click(findTestObject('Object Repository/FDR-EditVoucher/dlSaveButton'))
WebUI.click(findTestObject('Object Repository/FDR-VoucherEntry/VoucherHeader/reviewButton'))
WebUI.click(findTestObject('Object Repository/FDR-Vouchers-States/Resume/submitForApproval'))
WebUI.click(findTestObject('FDR-Dashboard/Filters/clearFilterButton'))
WebUI.click(findTestObject('Object Repository/FDR-Dashboard/appLogo'))
'16.Calling Logout Function'
CF.logout()

