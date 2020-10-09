/* Project : FDR
 * End_End_TC_4: FDR-E2E-FDR-RECEIPT-EDIT_REJECT workflow process
* Purpose : To Reject Voucher,Invoice Line and Distribution Line Items. 
* Author : Nagesh Allu
* Creation Date: 09/24/2020
* Revision History:
*          Objects are Added in OR: spanIncorrectsupplierID,spanIncorrectreceiptIDnumber,spanIncorrectdepositdate,RejectReceiptLine wtih some existing OR updates.
*		   Updated wait statments to sync up during the execution.
Steps:
Create automation script in Katalon. Script development will follow the same steps and 
execution patterns as TC_2-E2E-FDR-VOUCHER-REJECT script. Please refer to the currently automated script TC_2.
Automate the following flow:
Create receipt by a Cashiering Processor
Reject receipt by Cashiering Approver
Fix receipt by Cashiering Processor
Approve receipt by Cashiering Approver
*/

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
import com.functions.editors as editors
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import internal.GlobalVariable
import com.functions.validators as validators
import com.global.functions.Edit_Receipt_Invoice_DistributionLines as EditReceiptssheet
import com.global.functions.Edit_Voucher_Invoice_DistributionLines as Editvouchersheet
import com.global.seedDataFunctions.getSeedDataFunctions as SD
import com.global.functions.ChangeDrawDate as ChangeDrawDate

// Calling a Datasheet
def ReceiptDatasheet=findTestData('FDR_E2E-REGRESSION-TESTS-DATA/FDR-E2E-FDR-RECEIPT-REJECT-DATA')
def wait=10
//Login as Super User 
CF.login(GlobalVariable.superUserAccnt, GlobalVariable.superUserPwd)
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), wait)
CF.selectRole('cashieringProcessorRole')
// Create Receipt 
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), wait)
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Dashboard/createNew_ReceiptBatch_Button'), wait)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Dashboard/createNew_ReceiptBatch_Button'))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/inputDrawDate'), wait)
//WebUI.setText(findTestObject('FDR-VoucherEntry/Voucher/drawDate'), SD.getDrawDate())

//WebUI.setText(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/inputDrawDate'),SD.getDrawDate())
//WebUI.setText(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/inputDrawDate'),ReceiptDatasheet.getValue('DrawDate', 1))
//WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/payDate'), wait)
//WebUI.setText(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/payDate'), ReceiptDatasheet.getValue('PayDate', 1))

ChangeDrawDate.DrawDate()

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/deposit ID'), 1)
def depositId = org.apache.commons.lang.RandomStringUtils.randomNumeric(7)
WebUI.setText(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/deposit ID'), depositId )

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/receiptNotes'),wait)
WebUI.setText(findTestObject('FDR-Receipt/FDR-ReceiptBatch/receiptNotes'), ReceiptDatasheet.getValue('ReceiptNotes', 1))

int remittanceNo =new Random().nextInt(900000)+10000
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/remittanceNo'))
WebUI.setText(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/remittanceNo'),'RA'+remittanceNo)

int controllerNo =new Random().nextInt(900000)+10000
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/controllerNo'))
WebUI.setText(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/controllerNo'),'CA'+controllerNo)

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/buttonNext'), wait)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/buttonNext'))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/receipt_ID'), wait)
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/receipt_ID'), 3)

// Receipt Line
int ReceiptID =new Random().nextInt(90000)+1000
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/receipt_ID'), 'RA'+ReceiptID)
WebUI.waitForElementVisible(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/supplier_Id'), wait)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/supplier_Id'))
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/supplier_Id'), ReceiptDatasheet.getValue('supplier_Id', 1))
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/supplier_Id'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/deposit_Date'), 1)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/deposit_Date'), ReceiptDatasheet.getValue('Deposit_Date',1))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), wait)
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/addReceipt_Button2'), wait)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/addReceipt_Button2'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), wait)

WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'))

// Add Invoice Line
WebUI.click(findTestObject('FDR-EditVoucher/button_AddInvoice'))
int InvoiceNo =new Random().nextInt(9000)+100
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), wait)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/invoice_Searchfield'),'INC'+InvoiceNo)
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_Add_invoicemanually'), wait)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_Add_invoicemanually'))

//Distribution Lines
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service date (from)'),wait)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service date (from)'), ReceiptDatasheet.getValue('serviceDateFrom', 1))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service date (to)'),wait)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service date (to)'),ReceiptDatasheet.getValue('serviceDateTo',1))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_OrginalWarrantDate'),wait)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_OrginalWarrantDate'),,ReceiptDatasheet.getValue('originalWarrantDate',1))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Amount'),wait)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Amount'),ReceiptDatasheet.getValue('Input_Amount',1))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/waiver_Type'), wait)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/waiver_Type'),ReceiptDatasheet.getValue('waiver_Type',1))
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/waiver_Type'),Keys.chord(Keys.DOWN,Keys.ENTER))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/waiver_Name'), wait)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/waiver_Name'),ReceiptDatasheet.getValue('waiver_Name',1))
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/waiver_Name'),Keys.chord(Keys.DOWN,Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/fund_Code'), wait)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/fund_Code'),ReceiptDatasheet.getValue('fundCode',1))
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/fund_Code'), Keys.chord(Keys.DOWN,Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/funding_Source'),wait)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/funding_Source'),ReceiptDatasheet.getValue('funding_Source',1))
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/funding_Source'),Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/service_Category'),3)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/service_Category'), ReceiptDatasheet.getValue('serviceCategory',1))
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/service_Category'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/fund_Ratio'), 3)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/fund_Ratio'),ReceiptDatasheet.getValue('fundRatio',1))
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/fund_Ratio'), Keys.chord(Keys.DOWN,Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/non_Federalfund'),wait)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/non_Federalfund'),ReceiptDatasheet.getValue('non_Federalfund',1))
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/non_Federalfund'),Keys.chord(Keys.DOWN,Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_accountId'),wait)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_accountId'),ReceiptDatasheet.getValue('input_accountId',1))
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_accountId'),Keys.chord( Keys.ARROW_DOWN, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_altAccountId'),wait)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_altAccountId'),ReceiptDatasheet.getValue('input_altAccountId',1))
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_altAccountId'),Keys.chord( Keys.ARROW_DOWN, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/increaseDecreaseLine'),wait)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/increaseDecreaseLine'),ReceiptDatasheet.getValue('IncreaseDecreaseLine',1))
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/increaseDecreaseLine'), Keys.chord(Keys.ARROW_DOWN, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/program_Type'),3)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/program_Type'),ReceiptDatasheet.getValue('ProgramType',1))
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/program_Type'), Keys.chord(Keys.DOWN,Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/Index'), wait)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/Index'),ReceiptDatasheet.getValue('Index',1))
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/Index'), Keys.chord(Keys.DOWN,Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/serviceLocation'),2)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/serviceLocation'),ReceiptDatasheet.getValue('Servicelocation',1))
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/serviceLocation'),Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_SaveClose'),3)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_SaveClose'))
////////////////////////////////////////////// End of Distribution Line///////////////////////////////
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), wait)
WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/button_Review'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), wait)
WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/button_Submitforapproval'))

// change the user Role
CF.selectRole('cashieringApproverRole')
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Search-Receipt/searchBar'), wait)
WebUI.click(findTestObject('FDR-Receipt/FDR-Search-Receipt/searchBar'))
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Search-Receipt/searchBar'),depositId)
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Dashboard/filterValidatebatch'), wait)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Dashboard/filterValidatebatch'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/VouhcersTable/validateButton'), wait)
WebUI.click(findTestObject('FDR-Dashboard/VouhcersTable/validateButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'),wait)

//Receipt Distribution line rejection
WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'),5)
WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'),15)
WebUI.mouseOver(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/3dots/distributionLineHover'))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/3dots/distributionLineHover'), wait)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/3dots/editIconDistributionLine'))
WebUI.waitForElementPresent(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/DLRejectClick'), wait)
WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/DLRejectClick'))
WebUI.waitForElementPresent(findTestObject('FDR-Draw/RejectVocuherReceipts/IncorrectInvoiceNumber'), wait)
WebUI.click(findTestObject('FDR-Draw/RejectVocuherReceipts/IncorrectInvoiceNumber'))
WebUI.waitForElementPresent(findTestObject('FDR-Draw/RejectVocuherReceipts/IncorrectFundCode'),wait)
WebUI.click(findTestObject('FDR-Draw/RejectVocuherReceipts/IncorrectFundCode'))
WebUI.waitForElementPresent(findTestObject('FDR-Draw/RejectVocuherReceipts/IncorrectFundRatio'),wait)
WebUI.click(findTestObject('FDR-Draw/RejectVocuherReceipts/IncorrectFundRatio'))

WebUI.setText(findTestObject('FDR-Receipt/ReceiptNotes'),'Reject Distribution Line Notes Here')
WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/rejectDistributionLine'))

// Invoice Line Starts here */ BLUE LINE
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), wait)
//WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'))
WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/invoiceHover'), 10)
WebUI.mouseOver(findTestObject('FDR-EditVoucher/invoiceHover'))
WebUI.waitForElementPresent(findTestObject('FDR-Validate-Delete-Voucher-Header/3dots_icon2'), wait)
WebUI.click(findTestObject('FDR-Validate-Delete-Voucher-Header/3dots_icon2'))
WebUI.waitForElementPresent(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/DLRejectClick'), wait)
WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/DLRejectClick'))
WebUI.waitForElementPresent(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucher/spanIncorrectreceiptIDnumber'), wait)

//Receipt Invoice line Rejection
WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucher/spanIncorrectreceiptIDnumber'))
WebUI.waitForElementPresent(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucher/spanIncorrectsupplierID'),wait)
WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucher/spanIncorrectsupplierID'))
WebUI.click(findTestObject('FDR-Receipt/ReceiptNotes'))
WebUI.setText(findTestObject('FDR-Receipt/ReceiptNotes'),'Reject Receipt Notes Here')
WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectReceiptLine'))
WebUI.waitForElementPresent(findTestObject('FDR-Vouchers-States/Validate/Reject/rejectButton'), wait)
WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/rejectButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Draw/RejectVocuherReceipts/IncorrectDrawDate'),wait)
WebUI.click(findTestObject('FDR-Draw/RejectVocuherReceipts/IncorrectDrawDate'))
WebUI.waitForElementPresent(findTestObject('FDR-Draw/RejectVocuherReceipts/IncorrectPayDate'),wait)
WebUI.click(findTestObject('FDR-Draw/RejectVocuherReceipts/IncorrectPayDate'))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/button_RejectReceiptBatch'),wait)
WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/button_RejectReceiptBatch'))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Fix/clearButton'),wait)
WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Fix/clearButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), wait)

//////////////////////////////////////////
//Change the Role to Fix the Receipt
CF.selectRole('cashieringProcessorRole')
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), wait)
WebUI.click(findTestObject('FDR-Receipt/FDR-Search-Receipt/searchBar'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), wait)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Search-Receipt/searchBar'),depositId)
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 10)
WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Fix/fixButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 10)
WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/voucherEditIcon'),wait)
WebUI.click(findTestObject('FDR-EditVoucher/voucherEditIcon'))
WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/voucherEdit'), wait)
WebUI.click(findTestObject('FDR-EditVoucher/voucherEdit'))

EditReceiptssheet.EditRecieptLine()
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/buttonNext'),wait)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/buttonNext'))
WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'), wait)

// Receipt invoice line Edit
///////////////////////////////////

WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), wait)
WebUI.mouseOver(findTestObject('FDR-Receipt/editReceiptLine'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), wait)
WebUI.click(findTestObject('FDR-Receipt/editReceiptLine'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), wait)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/Edit/li_Edit'))

////////////////////////////////////////////////////////

EditReceiptssheet.EditReceiptInvoice()

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/Edit/button_Save'),wait)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/Edit/button_Save'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), wait)

// Expand Distribution Line

WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/3dots/distributionLineHover'), wait)
WebUI.mouseOver(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/3dots/distributionLineHover'))
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/3dots/distributionLineHover'))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/3dots/distributionLineHover'), wait)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/3dots/editIconDistributionLine'))
WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/DLEditClick'),wait)
WebUI.click(findTestObject('FDR-EditVoucher/DLEditClick'))

EditReceiptssheet.EditReceiptDistribution()

WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_SaveClose'))
//WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/button_Review'), wait)
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 10)
WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/button_Review'))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/button_Submitforapproval'), wait)
WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Review-Receipt/button_Submitforapproval'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), wait)
CF.selectRole('cashieringApproverRole')
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Fix/clearButton'),wait)
WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Fix/clearButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Search-Receipt/searchBar'), wait)
WebUI.click(findTestObject('FDR-Receipt/FDR-Search-Receipt/searchBar'))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Search-Receipt/searchBar'), wait)
WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Search-Receipt/searchBar'),depositId)
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/VouhcersTable/validateButton'), wait)
WebUI.click(findTestObject('FDR-Dashboard/VouhcersTable/validateButton')) //old-//div[contains(@class,'MuiGrid-container')]/parent::div/parent::div[1]/div[1]//span[text()='Validate']
//New xpath - //div[contains(@class,'MuiBox-root')]/parent::div/parent::div[1]/div[1]//span[text()='Validate']
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-EndToEnd-Regression/approveBtn'), wait)
WebUI.click(findTestObject('FDR-Receipt/FDR-EndToEnd-Regression/approveBtn'))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Fix/clearButton'),wait)
WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/Fix/clearButton'))
CF.logout()
/////////////////////////////////////////////////////////////////////////////////////////////////