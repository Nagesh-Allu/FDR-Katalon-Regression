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

def newDepositId = org.apache.commons.lang.RandomStringUtils.randomNumeric(7)

editors.createReceipt(Drawdate, Paydate, newDepositId, Receiptnotes)

editors.createReceiptline(ReceiptID, SupplierID, DepositDate)

WebUI.delay(2)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/Delete/lineAttribute'))

WebUI.mouseOver(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/Edit/Mose_over'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/Edit/3dots_Icon'), 2)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/Edit/3dots_Icon'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/Delete/li_Delete'), 2)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/Delete/li_Delete'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/Delete/li_Delete'), 5)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/Delete/undoIcon'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/Delete/li_Delete'), 2)
