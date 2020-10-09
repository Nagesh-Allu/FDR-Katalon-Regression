import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
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
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.functions.Uifunctions as Uifunctions
import com.functions.validators as validators

def voucherHeaderData = [('drawDate') : drawDate,('payDate') : payDate,('programType') : programType, ('invoiceType') : invoiceType, ('fundCode') : fundCode, ('supplier') : supplier
    , ('contractNum') : contractNum, ('vendorMessage') : vendorMessage, ('sequence') : sequence, ('primaryContact') : primaryContact, ('secondaryContact') : secondaryContact]

Uifunctions.createVoucherHeader(voucherHeaderData)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

Uifunctions.createInvoiceLine(1)

WebUI.waitForElementClickable(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'), 5)

WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceAddlineButton'))

Uifunctions.createDistributionLines(6, 'Voucher/FDR-DL') 

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

String federalShareHeaderValue = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/federalShare'))

String federalShareRowAmtValue = WebUI.getText(findTestObject('FDR-VoucherEntry/InvoiceLine/federalShareRowAmt'))

WebUI.verifyMatch(federalShareRowAmtValue, federalShareHeaderValue, false)

String nonFederalShareHeaderValue = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/nonFederalShare'))

String nonFederalShareRowAmtValue = WebUI.getText(findTestObject('FDR-VoucherEntry/InvoiceLine/nonFederalShareRowAmt'))

WebUI.verifyMatch(nonFederalShareHeaderValue, nonFederalShareRowAmtValue, false)

String vouhcerTotalHeaderValue = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/voucherTotal'))

String vouhcerTotalRowAmtValue = WebUI.getText(findTestObject('FDR-VoucherEntry/InvoiceLine/voucherTotalRowAmt'))

WebUI.verifyMatch(vouhcerTotalHeaderValue, vouhcerTotalRowAmtValue, false)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

validators.validateDistributionLineData(federalShareRowAmtValue, nonFederalShareRowAmtValue, vouhcerTotalRowAmtValue) 

