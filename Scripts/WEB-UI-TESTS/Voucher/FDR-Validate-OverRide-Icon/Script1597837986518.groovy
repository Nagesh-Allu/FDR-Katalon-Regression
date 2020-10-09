import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import org.openqa.selenium.Keys as Keys
import com.functions.Uifunctions as Uifunctions
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

def voucherHeaderData = [('drawDate') : drawDate, ('payDate') : payDate, ('programType') : programType, ('invoiceType') : invoiceType
    , ('fundCode') : fundCode, ('supplier') : supplier, ('contractNum') : contractNum, ('vendorMessage') : vendorMessage
    , ('sequence') : sequence, ('primaryContact') : primaryContact, ('secondaryContact') : secondaryContact]

Uifunctions.createVoucherHeader(voucherHeaderData)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

Uifunctions.createInvoiceLine(1)

WebUI.waitForElementClickable(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'), 5)

WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceAddlineButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.waitForElementClickable(findTestObject('FDR-VoucherEntry/DistributionLine/serviceDateFrom'), 2)

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/serviceDateFrom'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/DistributionLine/serviceDateFrom'), 2)

def dataSheet = 'Voucher/FDR-DL-OverRide'

WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/serviceDateFrom'), findTestData(dataSheet).getValue('serviceDateFrom', 
        1))

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/serviceDateTo'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/DistributionLine/serviceDateTo'), 2)

WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/serviceDateTo'), findTestData(dataSheet).getValue('serviceDateTo', 
        1))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/checkBox'))

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/amount'))

Uifunctions.clearElementText(findTestObject('FDR-VoucherEntry/DistributionLine/amount'))

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/amount'), findTestData(dataSheet).getValue('amount', 1))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/waiverType'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/waiverType'), findTestData(dataSheet).getValue('waiverType', 
        1))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/waiverType'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'))

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'), findTestData(dataSheet).getValue('waiverName', 
        1))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/orgFundingSource'))

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/orgFundingSource'), findTestData(dataSheet).getValue('orgFundSource', 
        1))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/orgFundingSource'), Keys.chord(Keys.DOWN, Keys.ENTER))

def fundRatio = findTestData(dataSheet).getValue('orgFundRatio', 1)

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/orgFundRatio'))

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/orgFundRatio'), fundRatio)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/orgFundRatio'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/orgNonFederalFund'))

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/orgNonFederalFund'), findTestData(dataSheet).getValue('orgNonFederal', 
        1))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/orgNonFederalFund'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/orgNonFederalFund'))

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'))

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'), findTestData(dataSheet).getValue('fundingSource', 
        1))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'), Keys.chord(Keys.DOWN, Keys.ENTER))

fundRatio = findTestData(dataSheet).getValue('fundRatio', 1)

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'))

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'), fundRatio)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'), Keys.chord(Keys.DOWN, Keys.ENTER))

if (fundRatio != '100/0') {
    WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'))

    WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'), findTestData(dataSheet).getValue(
            'nonFederal', 1))

    WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

    WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'), Keys.chord(Keys.DOWN, Keys.ENTER))
}

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/account'))

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/account'), findTestData(dataSheet).getValue('account', 
        1))

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/account'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/altAccount'))

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/altAccount'), findTestData(dataSheet).getValue('altAccount', 
        1))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/DistributionLine/altAccount'), 1)

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/altAccount'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/incDecLine'))

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/incDecLine'), findTestData(dataSheet).getValue('incDecLine', 
        1))

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/incDecLine'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/index'))

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/index'), findTestData(dataSheet).getValue('index', 1))

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/index'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/addSaveButton'))

WebUI.delay(4)