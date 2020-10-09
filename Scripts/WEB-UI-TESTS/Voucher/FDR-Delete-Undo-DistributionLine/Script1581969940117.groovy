import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.functions.Uifunctions as Uifunctions
import com.functions.validators as validators
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

WebUI.callTestCase(findTestCase('WEB-UI-TESTS/Voucher/FDR-Create-Simple-Voucher'),  [('drawDate') : drawDate,('payDate') : payDate,('programType') : programType, ('invoiceType') : invoiceType, ('fundCode') : fundCode, ('supplier') : supplier
    , ('contractNum') : contractNum, ('vendorMessage') : vendorMessage, ('sequence') : sequence, ('primaryContact') : primaryContact, ('secondaryContact') : secondaryContact],FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)

def processorVoucherNumber = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/voucherNum'))

def VouchertotalbefDelwith$ = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/voucherTotal'))

def VouchertotalbefDLDelwithout$ = VouchertotalbefDelwith$.substring(1)

def VouchertotalbefDLDelwithoutComma = VouchertotalbefDLDelwithout$.replaceAll(',', '')

def VouchertotalbefDLDel = Float.parseFloat(VouchertotalbefDLDelwithoutComma)

def InvTotalbefDLDelwith$ = WebUI.getText(findTestObject('FDR-VoucherEntry/InvoiceLine/voucherTotalRowAmt'))

def InvTotalbefDLDelwithout$ = InvTotalbefDLDelwith$.substring(1)

def InvTotalbefDLDelwithoutComma = InvTotalbefDLDelwithout$.replaceAll(',', '')

def InvTotalbefDLDel = Float.parseFloat(InvTotalbefDLDelwithoutComma)

if (WebUI.verifyElementPresent(findTestObject('FDR-VoucherEntry/DistributionLine/firstDLTotalAmt'), 3) == true) {
    WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 3)

    def dLsubtotalbeforeDelwith$ = WebUI.getText(findTestObject('FDR-VoucherEntry/DistributionLine/firstDLTotalAmt'))

    def dLsubtotalbeforeDelwithout$ = dLsubtotalbeforeDelwith$.substring(1)

    def dLsubtotalbeforeDelwithoutComma = dLsubtotalbeforeDelwithout$.replaceAll(',', '')

    def dLsubtotalbeforeDel = Float.parseFloat(dLsubtotalbeforeDelwithoutComma)

    def Newexpectedvouchertotal = VouchertotalbefDLDel - dLsubtotalbeforeDel

    def Newexpectedinvoicetotal = InvTotalbefDLDel - dLsubtotalbeforeDel

    Uifunctions.deleteFirstDistributionLine()

    WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 66)

   Uifunctions.deleteVoucherLine()

    WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)

    WebUI.click(findTestObject('FDR-EditVoucher/undoButton'))

    WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

    validators.validateVoucherInvoicLineTotals(Newexpectedvouchertotal, Newexpectedinvoicetotal)
}