import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.functions.Uifunctions as Uifunctions
import com.functions.validators as validators
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

WebUI.callTestCase(findTestCase('WEB-UI-TESTS/Voucher/FDR-Create-Simple-Voucher'),  [('drawDate') : drawDate,('payDate') : payDate,('programType') : programType, ('invoiceType') : invoiceType, ('fundCode') : fundCode, ('supplier') : supplier
    , ('contractNum') : contractNum, ('vendorMessage') : vendorMessage, ('sequence') : sequence, ('primaryContact') : primaryContact, ('secondaryContact') : secondaryContact],FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

// Get Voucher Total before Delete
def VouchertotalbefDelwith$ = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/voucherTotal'))

def VouchertotalbefDLDelwithout$ = VouchertotalbefDelwith$.substring(1)

def VouchertotalbefDLDelwithoutComma = VouchertotalbefDLDelwithout$.replaceAll(',', '')

VouchertotalbefDLDel = Float.parseFloat(VouchertotalbefDLDelwithoutComma)

// Get Invoice Line Total before Delete
WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/InvoiceLine/voucherTotalRowAmt'), 1)

def InvTotalbefDelwith$ = WebUI.getText(findTestObject('FDR-VoucherEntry/InvoiceLine/voucherTotalRowAmt'))

def InvTotalbefDelwithout$ = InvTotalbefDelwith$.substring(1)

def InvTotalbefDelwithoutComma = InvTotalbefDelwithout$.replaceAll(',', '')

InvTotalbefDel = Float.parseFloat(InvTotalbefDelwithoutComma)

// Expected Voucher Total after Invoive Line delete
Newexpectedvouchertotal = (VouchertotalbefDLDel - InvTotalbefDel)

Uifunctions.deleteVoucherLine()

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.click(findTestObject('FDR-EditVoucher/undoButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 6)

validators.validateVoucherHeaderTotals(VouchertotalbefDLDel, false)

Uifunctions.deleteVoucherLine()

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

validators.validateVoucherHeaderTotals(Newexpectedvouchertotal, true)

