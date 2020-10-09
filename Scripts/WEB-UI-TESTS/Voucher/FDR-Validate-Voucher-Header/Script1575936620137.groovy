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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

CustomKeywords.'com.functions.Uifunctions.loginFDR'(GlobalVariable.drawCashierAcc6Acc6, GlobalVariable.drawCashierAcc6Acc6Pwd)

WebUI.waitForElementPresent(findTestObject('ValidateVoucherheader/span_Validate'), 2)

WebUI.click(findTestObject('ValidateVoucherheader/span_Validate'))

WebUI.verifyElementClickable(findTestObject('Object Repository/ValidateVoucherheader/Arrowdown'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/ValidateVoucherheader/Arrowdown'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('ValidateVoucherheader/VoucherNo'), 2)

if (WebUI.getText(findTestObject('ValidateVoucherheader/VoucherNo')) == findTestData('FDRVoucherHeaderTestData').getValue(
    1, 1)) {
    KeywordUtil.markPassed('Valid Voucher No.')
}

if (WebUI.getText(findTestObject('ValidateVoucherheader/VoucherNo')) != findTestData('FDRVoucherHeaderTestData').getValue(
    1, 1)) {
    KeywordUtil.markFailedAndStop('Invalid Voucher No.')
}

WebUI.waitForElementPresent(findTestObject('ValidateVoucherheader/Drawdate'), 2)

if (WebUI.getText(findTestObject('ValidateVoucherheader/Drawdate')) == findTestData('FDRVoucherHeaderTestData').getValue(
    2, 1)) {
    KeywordUtil.markPassed('Valid Draw date.')
} else {
    (WebUI.getText(findTestObject('ValidateVoucherheader/Drawdate')) != findTestData('FDRVoucherHeaderTestData').getValue(
        2, 1)).call({ 
            KeywordUtil.markFailedAndStop('Invalid Draw date.')
        })
}

WebUI.waitForElementPresent(findTestObject('ValidateVoucherheader/Paydate'), 2)

if (WebUI.getText(findTestObject('ValidateVoucherheader/Paydate')) == findTestData('FDRVoucherHeaderTestData').getValue(
    3, 1)) {
    KeywordUtil.markPassed('Valid Paydate.')
} else {
    (WebUI.getText(findTestObject('ValidateVoucherheader/Paydate')) != findTestData('FDRVoucherHeaderTestData').getValue(
        3, 1)).call({ 
            KeywordUtil.markFailedAndStop('Invalid Paydate.')
        })
}

WebUI.waitForElementPresent(findTestObject('ValidateVoucherheader/Supplier'), 2)

if (WebUI.getText(findTestObject('ValidateVoucherheader/Supplier')) == findTestData('FDRVoucherHeaderTestData').getValue(
    4, 1)) {
    KeywordUtil.markPassed('Valid Supplier.')
} else {
    (WebUI.getText(findTestObject('ValidateVoucherheader/Supplier')) != findTestData('FDRVoucherHeaderTestData').getValue(
        4, 1)).call({ 
            KeywordUtil.markFailedAndStop('Invalid Supplier.')
        })
}

WebUI.waitForElementPresent(findTestObject('ValidateVoucherheader/Contract'), 2)

if (WebUI.getText(findTestObject('ValidateVoucherheader/Contract')) == findTestData('FDRVoucherHeaderTestData').getValue(
    5, 1)) {
    KeywordUtil.markPassed('Valid Supplier.')
} else {
    (WebUI.getText(findTestObject('ValidateVoucherheader/Contract')) != findTestData('FDRVoucherHeaderTestData').getValue(
        5, 1)).call({ 
            KeywordUtil.markFailedAndStop('Invalid Supplier.')
        })
}

WebUI.waitForElementPresent(findTestObject('ValidateVoucherheader/federalshare'), 2)

if (WebUI.getText(findTestObject('ValidateVoucherheader/federalshare')) == findTestData('FDRVoucherHeaderTestData').getValue(
    6, 1)) {
    KeywordUtil.markPassed('Valid Federalshare.')
} else {
    (WebUI.getText(findTestObject('ValidateVoucherheader/federalshare')) != findTestData('FDRVoucherHeaderTestData').getValue(
        6, 1)).call({ 
            KeywordUtil.markFailedAndStop('Invalid Federalshare.')
        })
}

WebUI.waitForElementPresent(findTestObject('ValidateVoucherheader/nonfederalshare'), 2)

if (WebUI.getText(findTestObject('ValidateVoucherheader/nonfederalshare')) == findTestData('FDRVoucherHeaderTestData').getValue(
    7, 1)) {
    //KeywordUtil.markPassed("Valid Non-Federalshare.")
    //KeywordUtil.markFailedAndStop("Invalid Non-Federalshare.")
} else {
    (WebUI.getText(findTestObject('ValidateVoucherheader/nonfederalshare')) != findTestData('FDRVoucherHeaderTestData').getValue(
        7, 1)).call({ 
        })
}

WebUI.waitForElementPresent(findTestObject('ValidateVoucherheader/Vouchertotal'), 2)

if (WebUI.getText(findTestObject('ValidateVoucherheader/Vouchertotal')) == findTestData('FDRVoucherHeaderTestData').getValue(
    8, 1)) {
    KeywordUtil.markPassed('Valid Vouchertotal.')
} else {
    (WebUI.getText(findTestObject('ValidateVoucherheader/Vouchertotal')) != findTestData('FDRVoucherHeaderTestData').getValue(
        8, 1)).call({ 
            KeywordUtil.markFailedAndStop('Invalid Vouchertotal.')
        })
}

WebUI.waitForElementPresent(findTestObject('ValidateVoucherheader/Fundcode'), 2)

if (WebUI.getText(findTestObject('ValidateVoucherheader/Fundcode')) == findTestData('FDRVoucherHeaderTestData').getValue(
    9, 1)) {
    KeywordUtil.markPassed('Valid Fundcode.')
} else {
    (WebUI.getText(findTestObject('ValidateVoucherheader/Fundcode')) != findTestData('FDRVoucherHeaderTestData').getValue(
        9, 1)).call({ 
            KeywordUtil.markFailedAndStop('Invalid Fundcode.')
        })
}

WebUI.waitForElementPresent(findTestObject('ValidateVoucherheader/Vendormessage'), 2)

if (WebUI.getText(findTestObject('ValidateVoucherheader/Vendormessage')) == findTestData('FDRVoucherHeaderTestData').getValue(
    10, 1)) {
    KeywordUtil.markPassed('Valid Vendormessage.')
} else {
    (WebUI.getText(findTestObject('ValidateVoucherheader/Vendormessage')) != findTestData('FDRVoucherHeaderTestData').getValue(
        10, 1)).call({ 
            KeywordUtil.markFailedAndStop('Invalid vendormessage.')
        })
}

WebUI.closeBrowser(FailureHandling.CONTINUE_ON_FAILURE)

