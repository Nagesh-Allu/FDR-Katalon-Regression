import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.functions.Uifunctions as Uifunctions
import com.functions.editors as editors
import com.functions.validators as validators

WebUI.callTestCase(findTestCase('WEB-UI-TESTS/Voucher/FDR-Create-Simple-Voucher'),  [('drawDate') : drawDate,('payDate') : payDate,('programType') : programType, ('invoiceType') : invoiceType, ('fundCode') : fundCode, ('supplier') : supplier
    , ('contractNum') : contractNum, ('vendorMessage') : vendorMessage, ('sequence') : sequence, ('primaryContact') : primaryContact, ('secondaryContact') : secondaryContact],FailureHandling.STOP_ON_FAILURE)

def processorVoucherNumber = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/voucherNum'))


editors.editVoucherInfo(supplier, sequence, contractNum)

String takenSupplier = WebUI.getAttribute(findTestObject('FDR-VoucherEntry/Voucher/supplierID'), 'value')

String takenContract = WebUI.getAttribute(findTestObject('FDR-VoucherEntry/Voucher/contractNum'), 'value')

WebUI.waitForElementClickable(findTestObject('FDR-VoucherEntry/Voucher/buttonNext'), 4)

WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/buttonNext'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

WebUI.click(findTestObject('FDR-VoucherEntry/VoucherHeader/expandButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

validators.validateVoucherInfo(takenSupplier, takenContract)

editors.editVoucherLineInfo()

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 5)

WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/editvocuherSave'), 5)

WebUI.click(findTestObject('FDR-EditVoucher/editvocuherSave'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'), 3)

WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'))

editors.editDistributionLineInfo(waiverType, waiverName, fundingSource, serviceCategory)

String takenWaiverType = WebUI.getAttribute(findTestObject('FDR-EditVoucher/waiverTypeEditVal'), 'value')

String takenFundingSource = WebUI.getAttribute(findTestObject('FDR-EditVoucher/fundingSourceEditVal'), 'value')

String takenAmount = WebUI.getAttribute(findTestObject('FDR-EditVoucher/amountEditVal'), 'value')

WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/dlCancelButton'), 3)

WebUI.click(findTestObject('FDR-EditVoucher/dlCancelButton'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/voucherText'), 3)

editors.editDistributionLineInfo(waiverType, waiverName, fundingSource, serviceCategory)

takenWaiverType = WebUI.getAttribute(findTestObject('FDR-EditVoucher/waiverTypeEditVal'), 'value')

WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/fundingSourceEditVal'), 4)

takenFundingSource = WebUI.getAttribute(findTestObject('FDR-EditVoucher/fundingSourceEditVal'), 'value')

WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/amountVal'), 4)

takenAmount = WebUI.getAttribute(findTestObject('FDR-EditVoucher/amountEditVal'), 'value')

WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/dlSaveButton'), 4)

WebUI.click(findTestObject('FDR-EditVoucher/dlSaveButton'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 4)

