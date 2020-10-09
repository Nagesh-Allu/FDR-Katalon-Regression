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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.testng.Assert as Assert
import com.functions.Uifunctions as Uifunctions

WebUI.callTestCase(findTestCase('WEB-UI-TESTS/Voucher/FDR-Create-Simple-Voucher'),  [('drawDate') : drawDate,('payDate') : payDate,('programType') : programType, ('invoiceType') : invoiceType, ('fundCode') : fundCode, ('supplier') : supplier
    , ('contractNum') : contractNum, ('vendorMessage') : vendorMessage, ('sequence') : sequence, ('primaryContact') : primaryContact, ('secondaryContact') : secondaryContact],FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

def processorVoucherNumber = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/voucherNum'))

WebUI.click(findTestObject('FDR-EditVoucher/voucherEditIcon'))

WebUI.click(findTestObject('FDR-EditVoucher/voucherDelete'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 4)

WebUI.click(findTestObject('FDR-EditVoucher/undoButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)

def returnVoucherNumber = Uifunctions.findVoucherWithVoucherNum(processorVoucherNumber)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

Assert.assertNotNull(returnVoucherNumber, 'Voucher deleted')

WebUI.click(findTestObject('FDR-EditVoucher/voucherEditIcon'))

WebUI.click(findTestObject('FDR-EditVoucher/voucherDelete'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 5)

WebUI.navigateToUrl(((GlobalVariable.URL + '/vouchers/') + (Integer.parseInt(processorVoucherNumber.split('CAP')[1]))) + '/entry')

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 8)

returnVoucherNumber = Uifunctions.findVoucherWithVoucherNum(processorVoucherNumber)

Assert.assertTrue(returnVoucherNumber.contains('undefined'), 'Voucher not deleted')