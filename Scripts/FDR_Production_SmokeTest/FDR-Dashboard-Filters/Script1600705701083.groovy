
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
import com.etoe.commonFunctions as CF
import com.etoe.voucherFunctions as VF
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.testng.asserts.SoftAssert as SoftAssert
import com.functions.Uifunctions as Uifunctions
import com.functions.validators as validators

CF.login(GlobalVariable.superUserAccnt, GlobalVariable.superUserPwd)

CF.selectRole('accountsPayableApprover')

def waitTime = 3

SoftAssert softAssertion = new SoftAssert()

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), waitTime)

WebUI.click(findTestObject('FDR-Dashboard/Filters/clearFilterButton'))

WebUI.click(findTestObject('FDR-Dashboard/Filters/resumeFilterButton'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), waitTime)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/VouhcersTable/resumeButton'), waitTime)

boolean validate = validators.validateDashboardFilterValidation('Resume')

softAssertion.assertTrue(validate, 'Voucher button validation failed')

WebUI.click(findTestObject('FDR-Dashboard/Filters/clearFilterButton'))

WebUI.click(findTestObject('FDR-Dashboard/Filters/printFilterButton'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), waitTime)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/VouhcersTable/printButton'), waitTime)

validate = validators.validateDashboardFilterValidation('Print')

softAssertion.assertTrue(validate, 'Print Voucher button validation failed')

WebUI.click(findTestObject('FDR-Dashboard/Filters/clearFilterButton'))

WebUI.click(findTestObject('FDR-Dashboard/Filters/fixFilterButton'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), waitTime)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/VouhcersTable/fixButton'), waitTime)

validate = validators.validateDashboardFilterValidation('Fix')

softAssertion.assertTrue(validate, 'Fix Voucher button validation failed')

WebUI.click(findTestObject('FDR-Dashboard/Filters/clearFilterButton'))

WebUI.click(findTestObject('FDR-Dashboard/Filters/validateFilterButton'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), waitTime)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/VouhcersTable/validateButton'), waitTime)

validate = validators.validateDashboardFilterValidation('Validate')

softAssertion.assertTrue(validate, 'Validate Voucher button validation failed')

WebUI.click(findTestObject('FDR-Dashboard/Filters/clearFilterButton'))

WebUI.click(findTestObject('FDR-Dashboard/Filters/resumeFilterButton'))

WebUI.click(findTestObject('FDR-Dashboard/Filters/printFilterButton'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), waitTime)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/VouhcersTable/printButton'), waitTime)

validate = validators.validateDashboardFilterValidation('Resume', 'Print')

softAssertion.assertTrue(validate, 'Voucher and Print voucher buttons combination validation failed')

WebUI.click(findTestObject('FDR-Dashboard/Filters/clearFilterButton'))

WebUI.click(findTestObject('FDR-Dashboard/Filters/fixFilterButton'))

WebUI.click(findTestObject('FDR-Dashboard/Filters/validateFilterButton'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), waitTime)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/VouhcersTable/validateButton'), waitTime)

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), waitTime)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/VouhcersTable/fixButton'), waitTime)

validate = validators.validateDashboardFilterValidation('Fix', 'Validate')

softAssertion.assertTrue(validate, 'Fix voucher  and validate voucher buttons combination validation failed')

WebUI.click(findTestObject('FDR-Dashboard/Filters/clearFilterButton'))

WebUI.click(findTestObject('FDR-Dashboard/Filters/resumeFilterButton'))

WebUI.click(findTestObject('FDR-Dashboard/Filters/printFilterButton'))

WebUI.click(findTestObject('FDR-Dashboard/Filters/fixFilterButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/VouhcersTable/fixButton'), waitTime)

validate = validators.validateDashboardFilterValidation('Resume', 'Print', 'Fix')

softAssertion.assertTrue(validate, 'Voucher, Print voucher and Fix voucher buttons combination validation failed')

WebUI.click(findTestObject('FDR-Dashboard/Filters/clearFilterButton'))

WebUI.click(findTestObject('FDR-Dashboard/Filters/validateFilterButton'))

WebUI.click(findTestObject('FDR-Dashboard/Filters/printFilterButton'))

WebUI.click(findTestObject('FDR-Dashboard/Filters/fixFilterButton'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), waitTime)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/VouhcersTable/fixButton'), waitTime)

validate = validators.validateDashboardFilterValidation('Validate', 'Print', 'Fix')

softAssertion.assertTrue(validate, ' Validate voucher, Print voucher and Fix voucher buttons combination validation failed')
WebUI.click(findTestObject('FDR-Dashboard/Filters/clearFilterButton'))
CF.logout()
