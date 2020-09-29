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
import org.openqa.selenium.Keys as Keys
import com.functions.Uifunctions as Uifunctions
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

def voucherHeaderData = [('drawDate') : drawDate,('payDate') : payDate,('programType') : programType, ('invoiceType') : invoiceType, ('fundCode') : fundCode, ('supplier') : supplier
    , ('contractNum') : contractNum, ('vendorMessage') : vendorMessage, ('sequence') : sequence, ('primaryContact') : primaryContact, ('secondaryContact') : secondaryContact]

Uifunctions.createVoucherHeader(voucherHeaderData)

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 5)

Uifunctions.createInvoiceLine(2)

WebUI.waitForElementClickable(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'), 5)

WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'))

WebUI.waitForElementClickable(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceAddlineButton'), 5)

WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceAddlineButton'))

Uifunctions.createDistributionLines(2, 'Voucher/FDR-DL')

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 5)

