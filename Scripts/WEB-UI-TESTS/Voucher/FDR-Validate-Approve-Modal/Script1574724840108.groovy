import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebDriver as WebDriver
import com.functions.Uifunctions as Uifunctions
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('WEB-UI-TESTS/Voucher/FDR-Create-Simple-Voucher'),  [('drawDate') : drawDate,('payDate') : payDate,('programType') : programType, ('invoiceType') : invoiceType, ('fundCode') : fundCode, ('supplier') : supplier
	, ('contractNum') : contractNum, ('vendorMessage') : vendorMessage, ('sequence') : sequence, ('primaryContact') : primaryContact, ('secondaryContact') : secondaryContact],FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 5)

def voucherDrawDate = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/drawDate'))

Uifunctions.createInvoiceLine(1)

def processorVoucherNumber = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/voucherNum'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.click(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.click(findTestObject('FDR-Vouchers-States/Resume/submitForApproval'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

println(((GlobalVariable.URL + '/vouchers/') + Integer.parseInt(processorVoucherNumber.split('CAP')[1])) + '/entry')

WebUI.navigateToUrl(((GlobalVariable.URL + '/vouchers/') + Integer.parseInt(processorVoucherNumber.split('CAP')[1])) + '/entry')

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

//def expectedDrawDate = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/drawDate'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)

WebUI.click(findTestObject('FDR-Vouchers-States/Validate/approveButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.navigateToUrl(((GlobalVariable.URL + '/vouchers/') + Integer.parseInt(processorVoucherNumber.split('CAP')[1])) + '/entry')

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

WebUI.click(findTestObject('FDR-Vouchers-States/Print/printCMIAForm'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

WebDriver driver = DriverFactory.getWebDriver()

driver.switchTo().window(driver.getWindowHandle())

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

WebUI.click(findTestObject('FDR-Vouchers-States/Print/printFaceSheet'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

driver.switchTo().window(driver.getWindowHandle())

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

WebUI.click(findTestObject('FDR-Vouchers-States/Print/printRA'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)

WebUI.click(findTestObject('FDR-Vouchers-States/Print/bankInfoTextArea'))

def bankInfoText = 'Bank Information this will provide bank detail \n Bank Information this will provide bank detail \n Bank Information this will provide bank detail \n Bank Information this will provide bank detail \n Bank Information this will provide bank detail'

WebUI.setText(findTestObject('FDR-Vouchers-States/Print/bankInfoTextArea'), bankInfoText)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('FDR-Vouchers-States/Print/bankInfoSubmit'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.verifyElementPresent(findTestObject('FDR-Vouchers-States/Print/bankInfoErrorMessage'), 1, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('FDR-Vouchers-States/Print/bankInfoCancel'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)

WebUI.click(findTestObject('FDR-Vouchers-States/Print/printRA'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

WebUI.click(findTestObject('FDR-Vouchers-States/Print/bankInfoTextArea'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)

WebUI.setText(findTestObject('FDR-Vouchers-States/Print/bankInfoTextArea'), 'Bank Information this will provide bank')

WebUI.click(findTestObject('FDR-Vouchers-States/Print/bankInfoSubmit'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)

driver.switchTo().window(driver.getWindowHandle())

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('FDR-Vouchers-States/Print/allFormsPrintButton'))

def values = [voucherDrawDate, processorVoucherNumber]

return voucherDrawDate