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
import com.functions.Uifunctions as Uifunctions

WebUI.callTestCase(findTestCase('WEB-UI-TESTS/Voucher/FDR-Create-Simple-Voucher'), [('waiverType') : '', ('waiverName') : ''
        , ('fundingSource') : '', ('fundRatio') : '', ('nonFederalFund') : '', ('account') : '', ('altAccount') : '', ('serviceCategory') : ''
        , ('incDecLine') : '', ('index') : '', ('amount') : '', ('program') : '', ('invoiceType') : '', ('fundCode') : ''
        , ('supplier') : '', ('sequence') : '', ('primaryContact') : '', ('secondaryContact') : '', ('contract') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)

def processorVoucherNumber = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/voucherNum'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.click(findTestObject('FDR-Vouchers-States/Resume/reviewButton'))

WebUI.waitForElementClickable(findTestObject('FDR-Vouchers-States/Resume/submitForApproval'), 2)

WebUI.click(findTestObject('FDR-Vouchers-States/Resume/submitForApproval'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.navigateToUrl(((GlobalVariable.URL + '/vouchers/') + (processorVoucherNumber.split('CAP')[1])) + '/entry')

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/rejectButton'))

String rejectionReasonOne = WebUI.getText(findTestObject('FDR-Vouchers-States/Validate/Reject/spanIncorrectGrossInvoiceAmount'))

WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/spanIncorrectGrossInvoiceAmount'))

String rejectionReasonTwo = WebUI.getText(findTestObject('FDR-Vouchers-States/Validate/Reject/spanIncorrectInvoiceAmount'))

WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/spanIncorrectInvoiceAmount'))

WebUI.waitForElementPresent(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucher/Notes'), 2)

def nmessage = org.apache.commons.lang.RandomStringUtils.randomAlphabetic(8)

WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucher/Notes'))

WebUI.waitForElementPresent(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucher/Notes'), 2)

WebUI.setText(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucher/Notes'), nmessage)

WebUI.waitForElementPresent(findTestObject('FDR-Vouchers-States/Validate/Reject/submitRejectButton'), 3)

WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/submitRejectButton'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)

WebUI.navigateToUrl(((GlobalVariable.URL + '/vouchers/') + (processorVoucherNumber.split('CAP')[1])) + '/entry')

WebUI.waitForElementPresent(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectHeaderText'), 3)

WebUI.verifyElementPresent(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectHeaderText'), 2)

WebUI.verifyElementPresent(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectAdditionalNote'), 1)

WebUI.verifyElementPresent(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectHeaderSubText'), 1)

WebUI.waitForElementPresent(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectAddtionalNoteText'), 2)

WebUI.verifyElementText(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectAddtionalNoteText'), nmessage)

String rejectionReasons = (rejectionReasonTwo + ', ') + rejectionReasonOne

WebUI.waitForElementPresent(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectReasons'), 2)

WebUI.verifyElementText(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectReasons'), rejectionReasons)

