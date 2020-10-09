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


def d = new Date().plus(1)

def dd = new Date().plus(2)

servicedatefrom = d.format('MM/dd/yyyy')

servicedateto = dd.format('MM/dd/yyyy')

def newDepositId = org.apache.commons.lang.RandomStringUtils.randomNumeric(7)

editors.createReceipt(Drawdate, Paydate, newDepositId, Receiptnotes, RA, CR)

editors.createReceiptline(ReceiptID, SupplierID, DepositDate)

editors.createReceiptDistributionLine(servicedatefrom, servicedateto, amount, waiverType, waiverName, fundingSource, fundCode, fundRatio,
	nonFederalFund, serviceLocation, index, programType, serviceCategory, increaseDecreaseLine, accountId, altAccountId)

String buttonColor = WebUI.getCSSValue(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Fix/reviewButton'), 'color')

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Fix/reviewButton'), 5)

WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Fix/reviewButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/PrintForms/buttonTransactionRequestPreview'), 2)

WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/PrintForms/buttonTransactionRequestPreview'))

WebUI.verifyElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/PrintForms/titleTransactionRequestPreview'), 2)

