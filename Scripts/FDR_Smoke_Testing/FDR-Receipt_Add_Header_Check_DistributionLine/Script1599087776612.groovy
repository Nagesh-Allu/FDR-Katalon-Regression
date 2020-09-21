import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
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
import com.etoe.voucherFunctions as VF
import com.etoe.commonFunctions as CF
import com.kms.katalon.core.testdata.ExcelData as ExcelData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import internal.GlobalVariable

def Datasheet=findTestData('FDR_E2E-REGRESSION-TESTS-DATA/End_End_Receipt')
CF.login(GlobalVariable.superUserAccnt, GlobalVariable.superUserPwd)

CF.selectRole('cashieringProcessorRole')

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Dashboard/createNew_ReceiptBatch_Button'), 3)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Dashboard/createNew_ReceiptBatch_Button'))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/inputDrawDate'), 6)
WebUI.setText(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/inputDrawDate'), Datasheet.getValue('drawDate', 1))
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/inputDrawDate'), Keys.chord(Keys.TAB, Keys.ENTER, Keys.ENTER))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/payDate'), 3)
WebUI.setText(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/payDate'), Datasheet.getValue('payDate', 1))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/deposit ID'), 10)
WebUI.setText(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/deposit ID'),Datasheet.getValue('DepositID', 1))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/receiptNotes'), 10)
WebUI.setText(findTestObject('FDR-Receipt/FDR-ReceiptBatch/receiptNotes'),Datasheet.getValue('receiptNotes', 1))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/remmitanceAdviceInput'), 5)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/remmitanceAdviceInput'),Datasheet.getValue('remmitanceAdviceInput', 1))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/controllerReceiptInput'), 5)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/controllerReceiptInput'),Datasheet.getValue('controllerReceiptInput', 1))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/buttonNext'), 5)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/buttonNext'))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/receipt_ID'), 10)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/receipt_ID'), ReceiptID )
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/supplier_Id'), 10)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/supplier_Id'), SupplierID )
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/supplier_Id'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/deposit_Date'), 10)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/deposit_Date'), DepositDate)
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/addReceipt_Button2'), 10)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/addReceipt_Button2'))


WebUI.verifyElementClickable(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/arrow_Down'),FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/arrow_Down'),FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_Add-Invoiceline'),10)
WebUI.scrollToElement(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_Add-Invoiceline'),3)
WebUI.verifyElementClickable(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_Add-Invoiceline'),FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_Add-Invoiceline'), FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/invoice_Searchfield'),10)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/invoice_Searchfield'),searchfield)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_Add_invoicemanually'))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service date (from)'),10)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service date (from)'),servicedatefrom)
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service date (to)'),10)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service date (to)'),servicedateto)
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Amount'),10)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Amount'),amount)
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/waiver_Type'), 10)
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/waiver_Type'), 8)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/waiver_Type'), waivertype)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/waiver_Type'), Keys.chord(Keys.DOWN,Keys.ENTER))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/waiver_Name'), 6)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/waiver_Name'), waivername)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/waiver_Name'), Keys.chord(Keys.DOWN,Keys.ENTER))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/funding_Source'),6)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/funding_Source'), fundingsource)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/funding_Source'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/fund_Code'), 30)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/fund_Code'), fundcode)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/fund_Code'), Keys.chord(Keys.DOWN,Keys.ENTER))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/fund_Ratio'), 10)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/fund_Ratio'), fundratio)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/fund_Ratio'), Keys.chord(Keys.DOWN,Keys.ENTER))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/non_Federalfund'),10)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/non_Federalfund'), nonFederalFund)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/non_Federalfund'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/inputAccountId'),10)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/inputAccountId'), accountId)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/inputAccountId'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/inputAltAccountId'),10)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/inputAltAccountId'), altAccountId)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/inputAltAccountId'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service location_serviceLocation'),10)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service location_serviceLocation'),servicelocation)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service location_serviceLocation'),Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/Index'), 10)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/Index'), index)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/Index'), Keys.chord(Keys.DOWN,Keys.ENTER))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/program_Type'),10)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/program_Type'), programtype)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/program_Type'), Keys.chord(Keys.DOWN,Keys.ENTER))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/service_Category'),10)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/service_Category'), servicecategory)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/service_Category'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/increaseDecreaseLine'),10)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/increaseDecreaseLine'), increaseDecreaseLine)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/increaseDecreaseLine'), Keys.chord(Keys.ARROW_DOWN, Keys.ENTER))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_SaveClose'),10)
WebUI.waitForElementClickable(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_SaveClose'),10)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_SaveClose'))