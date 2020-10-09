import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import com.functions.Uifunctions as Uifunctions
import com.functions.editors as editors
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

def newDepositId = org.apache.commons.lang.RandomStringUtils.randomNumeric(7)

editors.createReceipt(Drawdate, Paydate, newDepositId, Receiptnotes, Remittance, Controller)


editors.createReceiptline(ReceiptID, SupplierID, DepositDate)

def d = new Date().plus(1)

def dd = new Date().plus(2)

servicedatefrom = d.format('MM/dd/yyyy')

servicedateto = dd.format('MM/dd/yyyy')

originalwarrantdate = dd.format('MM/dd/yyyy')

WebUI.verifyElementClickable(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/arrow_Down_Receipts'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/arrow_Down_Receipts'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/deposit_Control_Amount'), 10)

def Receipttotalbefaddwith$ = WebUI.getText(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/deposit_Control_Amount'))

def Receipttotalbefaddwithout$ = Receipttotalbefaddwith$.substring(1)

def ReceipttotalbefaddwithoutComma = Receipttotalbefaddwithout$.replaceAll(',', '')

Receipttotalbefreceiptlineadd = Float.parseFloat(ReceipttotalbefaddwithoutComma)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_Add-Invoiceline'), 
    10)

WebUI.scrollToElement(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_Add-Invoiceline'), 
    3)

WebUI.verifyElementClickable(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_Add-Invoiceline'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_Add-Invoiceline'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/invoice_Searchfield'), 
    10)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/invoice_Searchfield'), 
    searchfield)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_Add_invoicemanually'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service date (from)'), 
    10)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service date (from)'), 
    servicedatefrom)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service date (to)'), 
    10)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service date (to)'), 
    servicedateto)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_OrginalWarrantDate'), 
    10)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_OrginalWarrantDate'), 
    originalwarrantdate)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Amount'), 
    10)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Amount'), Amount)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/waiver_Type'), 
    10)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/waiver_Type'), 
    8)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/waiver_Type'), Waivertype)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/waiver_Type'), Keys.chord(
        Keys.DOWN, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/waiver_Name'), 
    6)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/waiver_Name'), Waivername)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/waiver_Name'), Keys.chord(
        Keys.DOWN, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/funding_Source'), 
    6)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/funding_Source'), Fundingsource)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/funding_Source'), Keys.chord(
        Keys.DOWN, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/fund_Code'), 
    30)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/fund_Code'), Fundcode)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/fund_Code'), Keys.chord(
        Keys.DOWN, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/fund_Ratio'), 
    10)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/fund_Ratio'), Fundratio)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/fund_Ratio'), Keys.chord(
        Keys.DOWN, Keys.ENTER))


WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/non_Federalfund'), 
    10)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/non_Federalfund'))

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/non_Federalfund'), 
    Nonfederalfund)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/non_Federalfund'), 
    Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/serviceLocation'), 
    10)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/serviceLocation'), 
    Servicelocation)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/serviceLocation'), 
    Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/Index'), 
    10)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/Index'), Index)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/Index'), Keys.chord(
        Keys.DOWN, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/program_Type'), 
    10)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/program_Type'), Programtype)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/program_Type'), Keys.chord(
        Keys.DOWN, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/service_Category'), 
    10)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/service_Category'), 
    Servicecategory)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/service_Category'), 
    Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/increaseDecreaseLine'), 
    10)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/increaseDecreaseLine'), 
    IncreaseDecreaseLine)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/increaseDecreaseLine'), 
    Keys.chord(Keys.ARROW_DOWN, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_accountId'), 
    2, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_accountId'), 
    accountId + Keys.chord(Keys.ARROW_DOWN, Keys.ENTER))

WebUI.delay(4)

WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_altAccountId'), 
    altAccountId + Keys.chord(Keys.ARROW_DOWN, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_SaveClose'), 
    10)

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_SaveClose'))

//WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)
//WebUI.click(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'))
//WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)
//WebUI.verifyElementPresent(findTestObject('FDR-Draw/DrawDateValidation/changeDrawTextMsg'), 3)
//WebUI.verifyElementPresent(findTestObject('FDR-Draw/DrawDateValidation/changeDrawDate'), 2)
//WebUI.click(findTestObject('FDR-Draw/DrawDateValidation/changeDrawDate'))
//WebUI.verifyElementPresent(findTestObject('FDR-Draw/DrawDateValidation/editReceipt'), 2)

