import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import org.openqa.selenium.Keys as Keys
import com.googlecode.javacpp.annotation.Index as Index
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.sun.jna.platform.win32.Advapi32Util.Account as Account
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.click(findTestObject('FDR-SignIn/SignInEmail'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('FDR-SignIn/SignInEmail'), 'fdr.test10@dhcs.ca.gov')

WebUI.waitForElementVisible(findTestObject('FDR-SignIn/SignInEmailNext'), 2)

WebUI.click(findTestObject('FDR-SignIn/SignInEmailNext'))

WebUI.click(findTestObject('FDR-SignIn/SignInEmailPassword'))

WebUI.setText(findTestObject('FDR-SignIn/SignInEmailPassword'), 'Password13')

WebUI.click(findTestObject('FDR-SignIn/SignInButton'))

WebUI.navigateToUrl('https://fdr.cammis-mod-dev.dhcs.ca.gov/vouchers/27/entry')

def invoicetype = org.apache.commons.lang.RandomStringUtils.randomNumeric(3)

WebUI.setText(findTestObject('FDR-VoucherEntry-old/VoucherEntryObjects/input_InvoiceDescription'), invoicetype)

def d = new Date().plus(1)

intDate = d.format('MM/dd/yyyy')

WebUI.takeScreenshot('failing')

WebUI.waitForElementVisible(findTestObject('FDR-VoucherEntry-old/VoucherEntryObjects/invoiceDate'), 2)

WebUI.click(findTestObject('FDR-VoucherEntry-old/VoucherEntryObjects/invoiceDate'))

WebUI.setText(findTestObject('FDR-VoucherEntry-old/VoucherEntryObjects/invoiceDate'), intDate)

WebUI.click(findTestObject('FDR-VoucherEntry-old/VoucherEntryObjects/input_InvoiceDescription'))

WebUI.click(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/button_Add_Entry'))

WebUI.click(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/button_carret'))

WebUI.click(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/button_AddLine'))

def d1 = new Date().plus(1)

def d2 = new Date().plus(2)

intDate1 = d1.format('MM/dd/yyyy')

intDate2 = d2.format('MM/dd/yyyy')

WebUI.click(findTestObject('FDR-Dashboard-old/Dashboard-objects/serviceDateFrom'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard-old/Dashboard-objects/serviceDateFrom'), 2)

WebUI.setText(findTestObject('FDR-Dashboard-old/Dashboard-objects/serviceDateFrom'), intDate1)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard-old/Dashboard-objects/serviceDateTo'), 2)

WebUI.click(findTestObject('FDR-Dashboard-old/Dashboard-objects/serviceDateTo'))

WebUI.setText(findTestObject('FDR-Dashboard-old/Dashboard-objects/serviceDateTo'), intDate2)

WebUI.click(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/input__WaiverTypeKey'))

WebUI.sendKeys(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/input__WaiverTypeKey'), waiverType)

WebUI.sendKeys(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/input__WaiverTypeKey'), Keys.chord(
        Keys.ENTER))

WebUI.click(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/input__WaiverNameKey'))

WebUI.sendKeys(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/input__WaiverNameKey'), waiverName)

WebUI.waitForElementPresent(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/input__WaiverNameKey'), 
    2)

WebUI.sendKeys(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/input__WaiverNameKey'), Keys.chord(
        Keys.ENTER))

WebUI.click(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/input__FundingSourceKey'))

WebUI.sendKeys(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/input__FundingSourceKey'), fundingSource)

WebUI.waitForElementPresent(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/input__FundingSourceKey'), 
    2)

WebUI.sendKeys(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/input__FundingSourceKey'), Keys.chord(
        Keys.ENTER))

WebUI.click(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/input__FundRatioKey'))

WebUI.sendKeys(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/input__FundRatioKey'), fundRatio)

WebUI.waitForElementPresent(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/input__FundRatioKey'), 
    2)

WebUI.sendKeys(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/input__FundRatioKey'), Keys.chord(
        Keys.ENTER))

WebUI.click(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/input__NonFederalFundKey'))

WebUI.sendKeys(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/input__NonFederalFundKey'), nonFederalFund)

WebUI.sendKeys(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/input__NonFederalFundKey'), Keys.chord(
        Keys.ENTER))

WebUI.click(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/input_AccountKey'))

WebUI.sendKeys(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/input_AccountKey'), account)

WebUI.sendKeys(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/input_AccountKey'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/input__AltAccountKey'))

WebUI.sendKeys(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/input__AltAccountKey'), altAccount)

WebUI.sendKeys(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/input__AltAccountKey'), Keys.chord(
        Keys.ENTER))

WebUI.click(findTestObject('FDR-Dashboard-old/DashBoard Validation/input_serviceCategoryKey'))

WebUI.sendKeys(findTestObject('FDR-Dashboard-old/DashBoard Validation/input_serviceCategoryKey'), serviceCategory)

WebUI.sendKeys(findTestObject('FDR-Dashboard-old/DashBoard Validation/input_serviceCategoryKey'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('FDR-Dashboard-old/DashBoard Validation/input_IncreaseDecreaseLine'))

WebUI.sendKeys(findTestObject('FDR-Dashboard-old/DashBoard Validation/input_IncreaseDecreaseLine'), incDecLine)

WebUI.sendKeys(findTestObject('FDR-Dashboard-old/DashBoard Validation/input_IncreaseDecreaseLine'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('FDR-Dashboard-old/DashBoard Validation/input_Index'))

WebUI.sendKeys(findTestObject('FDR-Dashboard-old/DashBoard Validation/input_Index'), index)

WebUI.sendKeys(findTestObject('FDR-Dashboard-old/DashBoard Validation/input_Index'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/Input_Amount'))

WebUI.sendKeys(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/Input_Amount'), findTestData('DistributionLine').getValue(
        11, 1))

WebUI.sendKeys(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/Input_Amount'), Keys.chord(Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/button_AddClose'), 4)

WebUI.click(findTestObject('FDR-CreateDistributionLineModel/DistributionLineObjects/button_AddClose'))

CustomKeywords.'com.functions.UIfunctions.logoutFDR'()

WebUI.closeBrowser()

