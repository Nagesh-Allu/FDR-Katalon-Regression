/* Project Name : FDR
 * Test Scenario : END_END_TC_1b_Creating a Single Receipt workflow process.
 * 	List of Receipt Functions are used :
 * 	  --> createReceipt,createReceiptline,createReceiptMultipleDistributionLine
 *  Data sheet : Data Files/Regression-Voucher/E2E Regression-Single_Receipt_Data
 *
 *Revision Date:10/08/2020
 * 	1) New Pickup Draw Date Logic updated.
 *  2) Updated datasheet for few Receipts
 */
// List of Import packages and libraries

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
import com.etoe.commonFunctions as CF
import com.kms.katalon.core.testdata.ExcelData as ExcelData
import com.global.functions.ChangeDrawDate as ChangeDrawDate

CF.login(GlobalVariable.superUserAccnt, GlobalVariable.superUserPwd)

CF.selectRole('cashieringProcessorRole')

TestData exceldata = findTestData('Data Files/Regression-Voucher/E2E Regression-Single_Receipt_Data')
exceldata.changeSheet("Receipt1")
String drawdate =null
String paydate =null

//String drawdate = exceldata.getValue("Draw Date", 1)
//String paydate = exceldata.getValue("Pay Date", 1)
//String depositId = exceldata.getValue("Deposit ID", 1)
String depositId =  org.apache.commons.lang.RandomStringUtils.randomNumeric(7)

String receiptNotes = exceldata.getValue("Receipt Notes", 1)
String remittanceAdvice = exceldata.getValue("Remittance Advise #", 1)
String controllerReceipt = exceldata.getValue("Controller Receipt #", 1)
String receiptId = exceldata.getValue("Receipt ID", 1)
String supplierId = exceldata.getValue("Supplier ID", 1)
String depositDate = exceldata.getValue("Deposit Date", 1)

int numOfRows = 2
	
editors.createReceipt(drawdate, paydate, depositId, receiptNotes, remittanceAdvice, controllerReceipt)
	
/*String drawdate=findTestObject('Object Repository/FDR-VoucherEntry/VoucherHeader/drawDate')
String paydate=findTestObject('Object Repository/FDR-VoucherEntry/VoucherHeader/payDate')*/

editors.createReceiptline(receiptId, supplierId, depositDate)
	
for(int i=1;i<=numOfRows;i++)
	
	{
		
		String invoiceNum = exceldata.getValue("Invoice #", i)
		String manual = exceldata.getValue("Manual?", i)
		String serviceDateTo = exceldata.getValue("Service Date ( To)", i)
		String serviceDateFrom = exceldata.getValue("Service Date ( From)", i)
		String amount = exceldata.getValue("Amount", i)
		String waiverType = exceldata.getValue("Waiver Type", i)
		String waiverName = exceldata.getValue("Waiver Name", i)
		String fundingSource = exceldata.getValue("Funding Source", i)
		String fundCode = exceldata.getValue("Fund Code", i)
		String fundRatio = exceldata.getValue("Fund Ratio", i)
		String nonFederalFund = exceldata.getValue("Non-Federal Fund", i)
		String index = exceldata.getValue("Index ", i)
		String programType = 'Medical Assistance (MA)'
		String serviceCategory = exceldata.getValue("Service Category", i)
		String increaseDecreaseLine = exceldata.getValue("Increase/Decrease Line", i)
		String accountId = exceldata.getValue("Account", i)
		String altAccountId = exceldata.getValue("Alt Account", i)
	
		editors.createReceiptMultipleDistributionLine(serviceDateFrom, serviceDateTo, amount, waiverType, waiverName, fundingSource, fundCode, fundRatio,
			nonFederalFund, index, programType, serviceCategory, increaseDecreaseLine, accountId, altAccountId, invoiceNum, manual)
		
	}	
		
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Fix/reviewButton'), 5)
WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Fix/reviewButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/previewTROthers'), 2,FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/previewTROthers'))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/closePreview'), 2)
WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/closePreview'))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/previewTRHQAF'), 2, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/previewTRHQAF'))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/closePreview'), 2)
WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/closePreview'))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/previewTRHHP'), 2, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/previewTRHHP'))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/closePreview'), 2)

WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/closePreview'))
WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/previewTRForReceipts'), 2)
WebUI.click(findTestObject('Object Repository/FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/previewTRForReceipts'))
WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/closePreview'))
WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/previewTRForHQAF'), 2)
WebUI.click(findTestObject('Object Repository/FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/previewTRForHQAF'))
WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/closePreview'))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/button_Submitforapproval'), 2)
WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/button_Submitforapproval'))

CF.selectRole('cashieringApproverRole')

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/searchBar'), 3)
WebUI.click(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/searchBar'))
WebUI.setText(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/searchBar'), depositId)
WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)
WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-EndToEnd-Regression/validateBtn'), 4)
WebUI.click(findTestObject('Object Repository/FDR-Receipt/FDR-EndToEnd-Regression/validateBtn')) 
WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)

WebUI.click(findTestObject('Object Repository/FDR-Receipt/FDR-EndToEnd-Regression/approveBtn'))

CF.logout()
