import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.functions.Uifunctions as Uifunctions
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('WEB-UI-TESTS/Voucher/FDR-Create-Voucher-Header'), [('drawDate') : drawDate, ('payDate') : payDate
        , ('programType') : programType, ('invoiceType') : invoiceType, ('fundCode') : fundCode, ('supplier') : supplier
        , ('contractNum') : contractNum, ('vendorMessage') : vendorMessage, ('sequence') : sequence, ('primaryContact') : primaryContact
        , ('secondaryContact') : secondaryContact])

def processorVoucherNumber = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/voucherNum'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/expandButton'), 3)

WebUI.click(findTestObject('FDR-VoucherEntry/VoucherHeader/expandButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

String ContractExpected = 'CONTRACT'

String ContractActual = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/contractLabel'))

assert ContractActual == ContractExpected

String SupplierExpected = 'SUPPLIER'

String SupplierActual = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/supplierLabel'))

assert SupplierActual == SupplierExpected

String DrawDateExpected = 'DRAW DATE'

String DrawDateActual = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/drawDateLabel'))

assert DrawDateActual == DrawDateExpected

String PayDateExpected = 'PAY DATE'

String PayDateActual = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/payDateLabel'))

assert PayDateActual == PayDateExpected

String FundCodeExpected = 'FUND CODE'

String FundCodeActual = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/fundCodeLabel'))

assert FundCodeActual == FundCodeExpected

String VendorMessageExpected = 'VENDOR MESSAGE'

String VendorMessageActual = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/vendorMessageLabel'))

assert VendorMessageActual == VendorMessageExpected

String FederalshareActual = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/federalShareLabel'))

String FederalshareExpected = 'FEDERAL SHARE (0890)'

assert FederalshareActual == FederalshareExpected

String NonfederalshareActual = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/nonFederalShareLabel'))

String NonfederalshareExpected = 'NON-FEDERAL SHARE'

assert NonfederalshareActual == NonfederalshareExpected

String VouchertotalActual = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/voucherTotalLabel'))

String VouchertotalExpected = 'VOUCHER TOTAL'

assert VouchertotalExpected == VouchertotalExpected

String voucherNo = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/voucherNum'))

String Drawdate = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/drawDate'))

String Paydate = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/payDate'))

String Supplier = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/supplier'))

String Contract = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/contract'))

String Federalshare = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/federalShare'))

String Nonfederalshare = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/nonFederalShare'))

String Vouchertotal = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/voucherTotal'))

String Fundcode = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/fundCode'))

String vendormessage = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/vendorMessage'))

KeywordUtil.markPassed((((((((((((((((((('VoucherNo  ' + voucherNo) + '  Draw Date  ') + Drawdate) + '  Paydate  ') + Paydate) + 
    '  Supplier  ') + Supplier) + '  Contract  ') + Contract) + '  Federalshare  ') + Federalshare) + '  Nonfederalshare  ') + 
    Nonfederalshare) + '  Vouchertotal ') + Vouchertotal) + '  Fundcode ') + Fundcode) + '  vendormessage  ') + vendormessage)