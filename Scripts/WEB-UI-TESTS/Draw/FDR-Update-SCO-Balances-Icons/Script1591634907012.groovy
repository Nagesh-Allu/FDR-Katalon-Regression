import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.bouncycastle.operator.KeyWrapper as KeyWrapper
import com.kms.katalon.core.annotation.Keyword as Keyword
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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.functions.Uifunctions as Uifunctions

def grayRGBValue = 'rgba(190, 194, 199, 1)'

def greenRGBValue = 'rgba(71, 185, 112, 1)'

def redRGBValue = 'rgba(190, 71, 39, 1)'

def scoBalanceStatus = 0

def documentAmountsStatus = 0

def postDrawBalancesStatus = 0

def drawClosed = 0

def drawDate = '10/07/2020'

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

Uifunctions.clickOnReconcileButton(drawDate)

WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)

def scoBalanceIconStatus = WebUI.getCSSValue(findTestObject('Object Repository/FDR-Draw/reviewScreen/scoBalanceVerifiedIcon'), 
    'color')

if (scoBalanceIconStatus == grayRGBValue) {
    scoBalanceStatus = 0
} else if (scoBalanceIconStatus == greenRGBValue) {
    scoBalanceStatus = 1
} else {
    KeywordUtil.markFailed('scoBalance Icon color  is neither Green nor Gray')
}

Uifunctions.updateSCOBalances('0')

scoBalanceStatus = 1

scoBalanceIconStatus = WebUI.getCSSValue(findTestObject('Object Repository/FDR-Draw/reviewScreen/scoBalanceVerifiedIcon'), 
    'color')

if (scoBalanceIconStatus != greenRGBValue) {
    KeywordUtil.markFailed('EvenThough sco balances updated color not changed to green')
}

scoBalanceStatus = 1

def scoEndingBalanceTextColor = WebUI.getCSSValue(findTestObject('FDR-Draw/SCOBalances/scoEndingBalanceText'), 'color')

if (scoEndingBalanceTextColor != redRGBValue) {
    KeywordUtil.markFailed('sco ending balances not negative')
}

WebUI.click(findTestObject('FDR-Draw/SCOBalances/overDrawFundsButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

Uifunctions.updateSCOBalances('1000000')

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

def postDrawBalanceIconStatus = WebUI.getCSSValue(findTestObject('Object Repository/FDR-Draw/reviewScreen/postDrawBalanceSafeIcon'), 
    'color')

if (postDrawBalanceIconStatus == grayRGBValue) {
    postDrawBalancesStatus = 0
} else if (postDrawBalanceIconStatus == greenRGBValue) {
    postDrawBalancesStatus = 1
} else {
    KeywordUtil.markFailed('postDrawBalanceIconStatus Icon color  is neither Green nor Gray')
}

def expdThumbsUpColor = WebUI.getCSSValue(findTestObject('Object Repository/FDR-Draw/reviewScreen/expenditureThumsUpButton'), 
    'color')

if (expdThumbsUpColor == grayRGBValue) {
    WebUI.click(findTestObject('Object Repository/FDR-Draw/reviewScreen/expenditureThumsUpButton'))

    WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
}

def recpThumbsUpColor = WebUI.getCSSValue(findTestObject('Object Repository/FDR-Draw/reviewScreen/receiptsThumbsUpButton'), 
    'color')

if (recpThumbsUpColor == grayRGBValue) {
    WebUI.click(findTestObject('Object Repository/FDR-Draw/reviewScreen/receiptsThumbsUpButton'))

    WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
}

def documenAmountIconStatus = WebUI.getCSSValue(findTestObject('Object Repository/FDR-Draw/reviewScreen/documentsAmountVerified'), 
    'color')

if (documenAmountIconStatus == grayRGBValue) {
    KeywordUtil.markFailed('documentAmountStatus Icon color not changed to Green')
}

documentAmountsStatus = 1

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)

WebUI.click(findTestObject('Object Repository/FDR-Draw/reviewScreen/closedIcon'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)

def drawClosedIconStatus = WebUI.getCSSValue(findTestObject('Object Repository/FDR-Draw/reviewScreen/drawClosedIcon'), 'color')

if (drawClosedIconStatus != greenRGBValue) {
    KeywordUtil.markFailed('drawClosedIconStatus Icon color  not changed to Green')
}

drawClosed = 1

if ((((scoBalanceStatus == 1) && (documentAmountsStatus == 1)) && (postDrawBalancesStatus == 1)) && (drawClosed == 1)) {
    WebUI.verifyElementNotHasAttribute(findTestObject('Object Repository/FDR-Draw/reviewScreen/reviewButton'), 'disabled', 
        2, FailureHandling.STOP_ON_FAILURE)
} else {
    WebUI.verifyElementHasAttribute(findTestObject('Object Repository/FDR-Draw/reviewScreen/reviewButton'), 'disabled', 
        2, FailureHandling.STOP_ON_FAILURE)
}

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('Object Repository/FDR-Draw/reviewScreen/reviewButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('Object Repository/FDR-Draw/reviewScreen/submitForApproval'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
 
WebUI.verifyElementPresent(findTestObject('Object Repository/FDR-Draw/reviewScreen/validateButton'), 2)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)

WebUI.verifyElementPresent(findTestObject('Object Repository/FDR-Draw/reviewScreen/validateNowText'), 2) 

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)  

WebUI.click(findTestObject('Object Repository/FDR-Draw/reviewScreen/expandValidateButton2'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('Object Repository/FDR-Draw/reviewScreen/validateButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.click(findTestObject('Object Repository/FDR-Draw/reviewScreen/expenditureThumsUpButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('Object Repository/FDR-Draw/reviewScreen/receiptsThumbsUpButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('Object Repository/FDR-Draw/reviewScreen/reOpenDrawButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.verifyElementPresent(findTestObject('Object Repository/FDR-Draw/reviewScreen/reOpenDrawText'), 2)



