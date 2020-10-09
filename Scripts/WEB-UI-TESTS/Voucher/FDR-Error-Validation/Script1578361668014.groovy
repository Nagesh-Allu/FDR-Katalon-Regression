import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.functions.Uifunctions as Uifunctions
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 8)

WebUI.click(findTestObject('FDR-Dashboard/createNewVoucherButton'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/voucherText'), 2)

def vmessage = org.apache.commons.lang.RandomStringUtils.randomAlphabetic(232)

WebUI.setText(findTestObject('FDR-VoucherEntry/Voucher/vendorMessage'), vmessage)

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/buttonNext'), 2)

WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/buttonNext'))

WebUI.verifyElementVisible(findTestObject('FDR-EditVoucher/VoucherErrorMessages/drawDateErr'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('FDR-EditVoucher/VoucherErrorMessages/payDateErr'))

WebUI.verifyElementVisible(findTestObject('FDR-EditVoucher/DLErrorMessages/errorMessage'))

WebUI.verifyElementVisible(findTestObject('FDR-EditVoucher/DLErrorMessages/errorMessage'))

WebUI.verifyElementVisible(findTestObject('FDR-EditVoucher/DLErrorMessages/errorMessage'))

WebUI.verifyElementVisible(findTestObject('FDR-EditVoucher/DLErrorMessages/errorMessage'))

WebUI.verifyElementVisible(findTestObject('FDR-EditVoucher/DLErrorMessages/errorMessage'))

WebUI.verifyElementVisible(findTestObject('FDR-EditVoucher/DLErrorMessages/errorMessage'))

WebUI.verifyElementVisible(findTestObject('FDR-EditVoucher/DLErrorMessages/errorMessage'))

WebUI.verifyElementVisible(findTestObject('FDR-EditVoucher/DLErrorMessages/errorMessage'))

WebUI.back()

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/voucherText'), 5)

WebUI.callTestCase(findTestCase('WEB-UI-TESTS/Voucher/FDR-Create-Simple-Voucher'),  [('drawDate') : drawDate,('payDate') : payDate,('programType') : programType, ('invoiceType') : invoiceType, ('fundCode') : fundCode, ('supplier') : supplier
	, ('contractNum') : contractNum, ('vendorMessage') : vendorMessage, ('sequence') : sequence, ('primaryContact') : primaryContact, ('secondaryContact') : secondaryContact],FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

def processorVoucherNumber = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/voucherNum'))

String existingInvoiceNumber = WebUI.getText(findTestObject('FDR-EditVoucher/firstInvoiceNumber'))

WebUI.setText(findTestObject('FDR-VoucherEntry/VoucherEntryObjects/inputInvoiceDescription'), existingInvoiceNumber)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('FDR-EditVoucher/button_Add'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.verifyElementVisible(findTestObject('FDR-EditVoucher/InvoiceErrorMessages/duplicateInvoiceErr'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.verifyElementVisible(findTestObject('FDR-EditVoucher/DLErrorMessages/dateErrorMessage'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceAddlineButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 6)

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/addSaveButton'))

WebUI.verifyElementVisible(findTestObject('FDR-EditVoucher/DLErrorMessages/dateErrorMessage'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('FDR-EditVoucher/DLErrorMessages/dateErrorMessage'))

WebUI.verifyElementVisible(findTestObject('FDR-EditVoucher/DLErrorMessages/errorMessage'))

WebUI.verifyElementVisible(findTestObject('FDR-EditVoucher/DLErrorMessages/errorMessage'))

WebUI.verifyElementVisible(findTestObject('FDR-EditVoucher/DLErrorMessages/errorMessage'))

WebUI.verifyElementVisible(findTestObject('FDR-EditVoucher/DLErrorMessages/errorMessage'))

WebUI.verifyElementVisible(findTestObject('FDR-EditVoucher/DLErrorMessages/errorMessage'))

WebUI.verifyElementVisible(findTestObject('FDR-EditVoucher/DLErrorMessages/errorMessage'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/waiverType'))

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/waiverType'), '2020')

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/waiverType'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'))

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'), 'A-FamilyU TPM/GMC')

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'))

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'), 'Dental')

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'))

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'), '50/50')

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'), 2)

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.verifyElementVisible(findTestObject('FDR-EditVoucher/DLErrorMessages/errorMessage'))

WebUI.verifyElementVisible(findTestObject('FDR-EditVoucher/DLErrorMessages/errorMessage'))

WebUI.verifyElementVisible(findTestObject('FDR-EditVoucher/DLErrorMessages/errorMessage'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/cancelButton'))

