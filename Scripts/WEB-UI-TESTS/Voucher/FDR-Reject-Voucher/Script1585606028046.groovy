import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.testng.Assert as Assert
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.callTestCase(findTestCase('WEB-UI-TESTS/Voucher/FDR-Create-Complex-Voucher'),  [('drawDate') : drawDate,('payDate') : payDate,('programType') : programType, ('invoiceType') : invoiceType, ('fundCode') : fundCode, ('supplier') : supplier
	, ('contractNum') : contractNum, ('vendorMessage') : vendorMessage, ('sequence') : sequence, ('primaryContact') : primaryContact, ('secondaryContact') : secondaryContact],FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

def processorVoucherNumber = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/voucherNum'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.click(findTestObject('FDR-Vouchers-States/Resume/reviewButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.click(findTestObject('FDR-Vouchers-States/Resume/submitForApproval'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.navigateToUrl(((GlobalVariable.URL + '/vouchers/') + (Integer.parseInt(processorVoucherNumber.split('CAP')[1]))) + '/entry')

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 6)

WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'))
WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/DLHover'), 1)
WebUI.mouseOver(findTestObject('FDR-EditVoucher/DLHover'))
WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/DLEditIcon'), 1)
WebUI.click(findTestObject('FDR-EditVoucher/DLEditIcon'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/DLRejectClick'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)

WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/rejectDistributionLine'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
def elementStyle = WebUI.getAttribute(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/rejectionReasonsText'), 
    'class')

 Assert.assertTrue(elementStyle.contains('Mui-error'), 'rejectionreasons for distribution line color not changed')  

WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/spanIncorrectFundRatio'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/spanIncorrectDistributionLine'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/rejectDistributionLine'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.mouseOver(findTestObject('FDR-EditVoucher/DLHoverSecondLine'))

WebUI.click(findTestObject('FDR-EditVoucher/DLEditIcon'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/DLRejectClick'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/spanIncorrectFundRatio'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/spanIncorrectServiceCategory'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/rejectDistributionLine'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)

WebUI.mouseOver(findTestObject('FDR-EditVoucher/invoiceHover'))

WebUI.click(findTestObject('FDR-EditVoucher/voucherLineEditIcon'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/DLRejectClick'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)

WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucherLine/spanIncorrectInvoiceNum'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucherLine/spanIncorrectInvoiceAmount'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucherLine/rejectInvoiceLine'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/rejectButton')) 

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2) 

WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucher/rejectVoucherButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.navigateToUrl(((GlobalVariable.URL + '/vouchers/') + (Integer.parseInt(processorVoucherNumber.split('CAP')[1]))) + '/entry')

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'))

def rejectionReason = WebUI.getText(findTestObject('FDR-Vouchers-States/Validate/Reject/verificationReasons/invoiceRejectionReason'))

Assert.assertEquals(rejectionReason, 'Incorrect invoice number, Incorrect invoice amount', 'Invoice rejection reasons not matching')

rejectionReason = WebUI.getText(findTestObject('FDR-Vouchers-States/Validate/Reject/verificationReasons/dlGroup1RejectionReason'))

Assert.assertEquals(rejectionReason, 'Incorrect distribution line amount, Incorrect fund ratio', 'DL group1 rejection reasons not matching')

rejectionReason = WebUI.getText(findTestObject('FDR-Vouchers-States/Validate/Reject/verificationReasons/dlGroup2RejectionReason'))

Assert.assertEquals(rejectionReason, 'Incorrect fund ratio, Incorrect service category', 'DL group1 rejection reasons not matching')

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('FDR-Vouchers-States/Resume/reviewButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('FDR-Vouchers-States/Resume/submitForApproval'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.navigateToUrl(((GlobalVariable.URL + '/vouchers/') + (Integer.parseInt(processorVoucherNumber.split('CAP')[1]))) + '/entry')

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.click(findTestObject('FDR-Vouchers-States/Validate/approveButton'))




