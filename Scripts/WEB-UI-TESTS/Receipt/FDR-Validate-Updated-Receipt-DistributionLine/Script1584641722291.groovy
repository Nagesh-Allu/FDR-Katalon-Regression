import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.functions.editors as editors
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil


def d = new Date().plus(1)

def dd = new Date().plus(2)

servicedatefrom = d.format('MM/dd/yyyy')

servicedateto = dd.format('MM/dd/yyyy')

def newDepositId = org.apache.commons.lang.RandomStringUtils.randomNumeric(7)

editors.createReceipt(Drawdate, Paydate, newDepositId, Receiptnotes)

editors.createReceiptline(ReceiptID, SupplierID, DepositDate)

editors.createReceiptDistributionLine(servicedatefrom, servicedateto, amount, waiverType, waiverName, fundingSource, fundCode, fundRatio, 
	nonFederalFund, serviceLocation, index, programType, serviceCategory, increaseDecreaseLine, accountId, altAccountId)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-View-DitributionLine/InvoiceNumberTitle'), 3, FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-View-DitributionLine/FundCodeTitle'), 3, FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-View-DitributionLine/FundingSourceTitle'), 3, FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-View-DitributionLine/FundRatioTitle'), 3, FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-View-DitributionLine/Non-FederalFundTitle'), 3, FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-View-DitributionLine/FederalShareTitle'), 3, FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-View-DitributionLine/Non-FederalShareTitle'), 3, FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-View-DitributionLine/SubtotalTitle'), 3, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-View-DitributionLine/popoverIcon'), 3, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-View-DitributionLine/popoverIcon'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-View-DitributionLine/pAccountIdText'), 3, FailureHandling.STOP_ON_FAILURE)
def accountIdTxt = WebUI.getText(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-View-DitributionLine/pAccountIdText'), FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-View-DitributionLine/pAltAccountIdText'), 3, FailureHandling.STOP_ON_FAILURE)
def altAccountIdTxt = WebUI.getText(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-View-DitributionLine/pAltAccountIdText'), FailureHandling.STOP_ON_FAILURE)

if(accountIdTxt == accountId && altAccountIdTxt == altAccountId){
	KeywordUtil.markPassed('Valid Account and Alt Account')
} else {
	KeywordUtil.markFailedAndStop('Invalid Account and Alt Account')
}




