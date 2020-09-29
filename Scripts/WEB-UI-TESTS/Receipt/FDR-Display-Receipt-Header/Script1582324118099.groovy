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

def newDepositId = org.apache.commons.lang.RandomStringUtils.randomNumeric(7)

editors.createReceipt(Drawdate, Paydate, newDepositId, Receiptnotes)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/depositId'), 10)

String depositId = WebUI.getText(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/depositId'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/pDrawDate'), 2)

String drawDate = WebUI.getText(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/pDrawDate'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/payDate'), 2)

String payDate = WebUI.getText(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/payDate'))

//WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/receiptsNotes'), 2)

println(' DepositId  '+depositId+ '  DrawDate  ' + drawDate+ '  Paydate  '+ payDate)

WebUI.closeBrowser(FailureHandling.CONTINUE_ON_FAILURE)
