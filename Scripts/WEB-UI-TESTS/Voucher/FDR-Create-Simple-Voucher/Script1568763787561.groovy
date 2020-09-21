import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

Uifunctions.createDistributionLines(1, 'Voucher/FDR-DL')

