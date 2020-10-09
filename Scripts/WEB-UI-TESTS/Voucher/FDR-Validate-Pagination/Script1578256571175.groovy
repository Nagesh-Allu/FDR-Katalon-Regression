import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.functions.validators as validators
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/voucherText'), 3)

WebUI.scrollToPosition(99999, 99999, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('FDR-Dashboard/Pagination/rowsPerPage'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('FDR-Dashboard/Pagination/listBox'), '10')

def paginationIndicatorText = WebUI.getText(findTestObject('FDR-Dashboard/Pagination/paginationIndicator'))

int totalVouchers = ((paginationIndicatorText.split('of ')[1]) as Integer)

int rowsPerPage = ((WebUI.getText(findTestObject('FDR-Dashboard/Pagination/listBox'))) as Integer)

assert validators.validateDashboardPagination(totalVouchers, rowsPerPage) == true

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/voucherText'), 2)

if (totalVouchers > 10) {
    WebUI.click(findTestObject('FDR-Dashboard/Pagination/paginationRight'))

    WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/voucherText'), 2)

    assert validators.validateDashboardPagination(totalVouchers - 10, rowsPerPage) == true

    WebUI.click(findTestObject('FDR-Dashboard/Pagination/paginationLeft'))

    WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/voucherText'), 2)
}

KeywordUtil.markPassed('Pagination Validation for 10 rows per page')

WebUI.scrollToElement(findTestObject('FDR-Dashboard/Pagination/listBox'), 3)

WebUI.click(findTestObject('FDR-Dashboard/Pagination/listBox'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/Pagination/listBox'), 2)

WebUI.click(findTestObject('FDR-Dashboard/Pagination/listbox25'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/voucherText'), 2)

rowsPerPage = ((WebUI.getText(findTestObject('FDR-Dashboard/Pagination/listBox'))) as Integer)

assert validators.validateDashboardPagination(totalVouchers, rowsPerPage) == true

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/voucherText'), 2)

if (totalVouchers > 25) {
    WebUI.click(findTestObject('FDR-Dashboard/Pagination/paginationRight'))

    WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/voucherText'), 2)

    assert validators.validateDashboardPagination(totalVouchers - 25, rowsPerPage) == true

    WebUI.click(findTestObject('FDR-Dashboard/Pagination/paginationLeft'))

    WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/voucherText'), 2)
}

KeywordUtil.markPassed('Pagination Validation for 25 rows per page')

