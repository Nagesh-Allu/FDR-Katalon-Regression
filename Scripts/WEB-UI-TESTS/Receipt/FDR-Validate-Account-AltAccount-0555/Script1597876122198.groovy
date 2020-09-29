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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import org.openqa.selenium.WebElement as WebElement
import com.functions.Uifunctions as Uifunctions
import com.functions.editors as editors
import com.functions.validators as validators
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

def d = new Date().plus(1)

def dd = new Date().plus(2)

servicedatefrom = d.format('MM/dd/yyyy')

servicedateto = dd.format('MM/dd/yyyy')

originalwarrantdate = dd.format('MM/dd/yyyy')

def newDepositId = org.apache.commons.lang.RandomStringUtils.randomNumeric(7)

def searchfield = org.apache.commons.lang.RandomStringUtils.randomNumeric(7)

editors.createReceipt(Drawdate, Paydate, newDepositId, Receiptnotes)

editors.createReceiptline(ReceiptID, SupplierID, DepositDate)

WebUI.verifyElementClickable(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/arrow_Down'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/arrow_Down'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_Add-Invoiceline'), 
    10)

WebUI.scrollToElement(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_Add-Invoiceline'), 
    3)

WebUI.verifyElementClickable(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_Add-Invoiceline'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_Add-Invoiceline'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/invoice_Searchfield'), 
    10)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/invoice_Searchfield'), 
    searchfield)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_Add_invoicemanually'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/fund_Code'), 30)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/fund_Code'), Fundcode)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/fund_Code'), Keys.chord(Keys.DOWN, 
        Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_accountId'), 2, FailureHandling.STOP_ON_FAILURE)

if (WebUI.getText(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_accountId')) == accountId) {
	KeywordUtil.markPassed('Correct Account ID')}

else (FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_altAccountId'), 2, FailureHandling.STOP_ON_FAILURE)

if (WebUI.getText(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_altAccountId')) == altAccountId) {
	KeywordUtil.markPassed('Alt Account Empty')}

else (FailureHandling.OPTIONAL)


