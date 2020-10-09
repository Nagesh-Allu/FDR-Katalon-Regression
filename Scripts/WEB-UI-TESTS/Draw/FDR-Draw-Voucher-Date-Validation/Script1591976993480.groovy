import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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
import com.functions.Uifunctions as Uifunctions

def voucherHeaderData = [('drawDate') : drawDate, ('payDate') : payDate, ('programType') : programType, ('invoiceType') : invoiceType
    , ('fundCode') : fundCode, ('supplier') : supplier, ('contractNum') : contractNum, ('vendorMessage') : vendorMessage
    , ('sequence') : sequence, ('primaryContact') : primaryContact, ('secondaryContact') : secondaryContact]

Uifunctions.createVoucherHeader(voucherHeaderData)

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 5)

def voucherDrawDate = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/drawDate'))

Uifunctions.createInvoiceLine(1)

WebUI.waitForElementClickable(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'), 5)

WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'))

WebUI.waitForElementClickable(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceAddlineButton'), 5)

WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceAddlineButton'))

Uifunctions.createDistributionLines(1, 'Voucher/FDR-DL')

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

//WebUI.click(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'))
//WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)
//WebUI.verifyElementPresent(findTestObject('FDR-Draw/DrawDateValidation/changeDrawTextMsg'), 3)
//WebUI.verifyElementPresent(findTestObject('FDR-Draw/DrawDateValidation/changeDrawDate'), 2)
//WebUI.click(findTestObject('FDR-Draw/DrawDateValidation/changeDrawDate'))
//WebUI.verifyElementPresent(findTestObject('FDR-Draw/DrawDateValidation/editVoucher'), 2)