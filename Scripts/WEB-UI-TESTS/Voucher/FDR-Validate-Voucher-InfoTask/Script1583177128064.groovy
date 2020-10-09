import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.functions.Uifunctions as Uifunctions
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('WEB-UI-TESTS/Voucher/FDR-Validate-Approve-Modal'), [('drawDate') : drawDate, ('payDate') : payDate
        , ('programType') : programType, ('invoiceType') : invoiceType, ('fundCode') : fundCode, ('supplier') : supplier
        , ('contractNum') : contractNum, ('vendorMessage') : vendorMessage, ('sequence') : sequence, ('primaryContact') : primaryContact
        , ('secondaryContact') : secondaryContact], FailureHandling.STOP_ON_FAILURE)

/*WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 3)

WebUI.click(findTestObject('FDR-Dashboard/Search/searchInputField'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), 'Ready')

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 3)

WebUI.scrollToPosition(99999, 99999, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 3)

WebUI.click(findTestObject('FDR-Dashboard/Pagination/listBox'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/Pagination/listBox'), 2)

WebUI.click(findTestObject('FDR-Dashboard/Pagination/listbox50'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 3)

TestObject readyButton = Uifunctions.findVoucherButtonOnDashboard(values[1])

if (readyButton != null) {
    WebUI.scrollToElement(readyButton, 3)

    WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 3)

    WebUI.click(readyButton)

    WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 3)

    WebUI.scrollToPosition(0, 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 3)

    WebUI.click(findTestObject('FDR-Dashboard/Search/searchInputField'))

    WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

    WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), 'Pending')

    WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 3)

    WebUI.scrollToPosition(99999, 99999, FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 3)

    WebUI.click(findTestObject('FDR-Dashboard/Pagination/listBox'))

    WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/Pagination/listBox'), 2)

    WebUI.click(findTestObject('FDR-Dashboard/Pagination/listbox50'), FailureHandling.STOP_ON_FAILURE)

    WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 3)

    TestObject addInfoButton = Uifunctions.findVoucherButtonOnDashboard(values[1])

    if (addInfoButton != null) {
        WebUI.scrollToElement(addInfoButton, 3)

        WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 3)

        WebUI.click(addInfoButton)

        WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 5)

        WebUI.click(findTestObject('FDR-Dashboard/Search/warrantNumber'))

        def wNumber = org.apache.commons.lang.RandomStringUtils.randomNumeric(9)

        WebUI.setText(findTestObject('FDR-Dashboard/Search/warrantNumber'), wNumber)

        WebUI.click(findTestObject('FDR-Dashboard/Search/warrantDate'))

        WebUI.setText(findTestObject('FDR-Dashboard/Search/warrantDate'), '03/21/2020')

        WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 3)
    }
} */