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

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/Resume'), 2)

WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/Resume'))

WebUI.verifyElementClickable(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/Arrowdown'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/Arrowdown'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/receiptLine_Total'), 5)

WebUI.delay(4)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/deposit_Control_Amount'),5)

WebUI.delay(4)

def Receipttotalaftaddwith$ = WebUI.getText(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/deposit_Control_Amount'))

def Receipttotalaftaddwithout$ = Receipttotalaftaddwith$.substring(1)

def ReceipttotalaftaddwithoutComma = Receipttotalaftaddwithout$.replaceAll(",","")

def Recdeptotalaftreceiptlinseadded = Float.parseFloat(ReceipttotalaftaddwithoutComma)

println(Recdeptotalaftreceiptlinseadded)

WebUI.delay(6)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/expand_Button'))

WebUI.delay(4)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/receiptLine_Totala'),5)

WebUI.delay(4)

def Receiptlinetotalaftaddwitha$ = WebUI.getText(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/receiptLine_Totala'))

def Receiptlinetotalaftaddwithouta$ = Receiptlinetotalaftaddwitha$.substring(1)

def ReceiptlinetotalaftaddwithoutCommaa = Receiptlinetotalaftaddwithouta$.replaceAll(",","")

Receiptlinetotala = Float.parseFloat(ReceiptlinetotalaftaddwithoutCommaa)

println(Receiptlinetotala)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/receiptLine_Totala'),5)

WebUI.delay(4)

def Receiptlinetotalaftaddwithb$ = WebUI.getText(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/receiptLine_Totalb'))

def Receiptlinetotalaftaddwithoutb$ = Receiptlinetotalaftaddwithb$.substring(1)

def ReceiptlinetotalaftaddwithoutCommab = Receiptlinetotalaftaddwithoutb$.replaceAll(",","")

Receiptlinetotalb = Float.parseFloat(ReceiptlinetotalaftaddwithoutCommab)

println(Receiptlinetotalb)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/receiptLine_Total'), 5)

WebUI.delay(4)

def Receiptlinetotalaftaddwith$ = WebUI.getText(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/receiptLine_Total'))

def Receiptlinetotalaftaddwithout$ = Receiptlinetotalaftaddwith$.substring(1)

def ReceiptlinetotalaftaddwithoutComma = Receiptlinetotalaftaddwithout$.replaceAll(",","")

def Receiptlinetotal = Float.parseFloat(ReceiptlinetotalaftaddwithoutComma)

println(Receiptlinetotal)

def newreceiptototal  = Receiptlinetotala+Receiptlinetotalb
println(newreceiptototal)


if ((newreceiptototal) == (Receiptlinetotal))
{
	KeywordUtil.markPassed("Valid Receipt Linet total Amount")
	
}

else
{
	KeywordUtil.markFailedAndStop("Invalid Receipt Linet total Amount")
}

if ((Receiptlinetotal) == (Recdeptotalaftreceiptlinseadded))
{
	KeywordUtil.markPassed("Valid Total Deposit Control Amount")
}

else
{
	KeywordUtil.markFailedAndStop("Invalid Total Deposit Control Amount")
}

