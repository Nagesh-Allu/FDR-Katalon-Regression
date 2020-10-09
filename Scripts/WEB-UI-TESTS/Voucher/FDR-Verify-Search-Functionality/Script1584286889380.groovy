import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.functions.validators as validators
import org.testng.asserts.SoftAssert as SoftAssert
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.functions.Uifunctions as Uifunctions

def waitTime = 3

SoftAssert softAssertion = new SoftAssert()

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), waitTime)

WebUI.click(findTestObject('FDR-Dashboard/Search/searchInputField'))

WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), 'Entry')

WebUI.waitForElementClickable(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)

boolean validate = validators.validateDashboardFilterValidation('Resume')

softAssertion.assertTrue(validate, 'Entry state validation failed')

Uifunctions.clearElementText(findTestObject('FDR-Dashboard/Search/searchInputField'))

WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), 'Validation')

WebUI.waitForElementClickable(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)

validate = validators.validateDashboardFilterValidation('Validate')

softAssertion.assertTrue(validate, 'Validate state validation failed')

Uifunctions.clearElementText(findTestObject('FDR-Dashboard/Search/searchInputField'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/Search/searchInputField'), 2)

WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), 'Revision')

WebUI.waitForElementClickable(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)

validate = validators.validateDashboardFilterValidation('Fix')

softAssertion.assertTrue(validate, 'Fix State validation failed')

Uifunctions.clearElementText(findTestObject('FDR-Dashboard/Search/searchInputField'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/Search/searchInputField'), 2)

WebUI.waitForElementClickable(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)

WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), 'Printing')

WebUI.waitForElementClickable(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)

validate = validators.validateDashboardFilterValidation('Print')

softAssertion.assertTrue(validate, 'Print State validation failed')

Uifunctions.clearElementText(findTestObject('FDR-Dashboard/Search/searchInputField'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/Search/searchInputField'), 2)

WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), 'Print Validation')

WebUI.waitForElementClickable(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)

validate = validators.validateDashboardFilterValidation('Print', 'Validate')

softAssertion.assertTrue(validate, 'Print , Validate State validation failed')

Uifunctions.clearElementText(findTestObject('FDR-Dashboard/Search/searchInputField'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/Search/searchInputField'), 2)

WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), 'Print Validation revision')

WebUI.waitForElementClickable(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)

validate = validators.validateDashboardFilterValidation('Print', 'Validate', 'Fix')

softAssertion.assertTrue(validate, 'Print , Validate, Fix State validation failed')

Uifunctions.clearElementText(findTestObject('FDR-Dashboard/Search/searchInputField'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/Search/searchInputField'), 2)

WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), '01/04')

WebUI.waitForElementClickable(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)

validate = validators.voucherSearchValidation('01/04')

softAssertion.assertTrue(validate, 'PayDate validation failed')

Uifunctions.clearElementText(findTestObject('FDR-Dashboard/Search/searchInputField'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/Search/searchInputField'), 2)

WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), '6543')

WebUI.waitForElementClickable(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)

validate = validators.voucherSearchValidation('6543')

softAssertion.assertTrue(validate, 'supplier Vvalidation Failed')

Uifunctions.clearElementText(findTestObject('FDR-Dashboard/Search/searchInputField'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/Search/searchInputField'), 2)

WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), 'yoda')

WebUI.waitForElementClickable(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)

validate = validators.voucherSearchValidation('4567')

softAssertion.assertTrue(validate, 'supplier Vvalidation Failed')

Uifunctions.clearElementText(findTestObject('FDR-Dashboard/Search/searchInputField'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/Search/searchInputField'), 2)

WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), 'Thor')

WebUI.waitForElementClickable(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)

validate = validators.voucherSearchValidation('6789')

softAssertion.assertTrue(validate, 'supplier validation Failed')

Uifunctions.clearElementText(findTestObject('FDR-Dashboard/Search/searchInputField'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/Search/searchInputField'), 2)

WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), '98735')

WebUI.waitForElementClickable(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)

validate = validators.voucherSearchValidation('98735')

softAssertion.assertTrue(validate, 'Contract validation Failed')

