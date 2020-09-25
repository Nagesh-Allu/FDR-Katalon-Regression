/* Project : FDR
 * End_End_TC_2: FDR-E2E-FDR-8119-VOUCHER-REJECT
* Purpose : Complete Reject Voucher,Invoice Line and Distribution Line Items. 
* Author : Nagesh Allu
* Creation Date: 10/24/2020
* Revision History:
			10/24/2020: Updated Object Repository and XPaths.
* **************************************************************************************************/
//Import Statements:
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

/*WebUI.callTestCase(findTestCase('WEB-UI-TESTS/Voucher/FDR-Create-Complex-Voucher'),  [('drawDate') : drawDate,('payDate') : payDate,('programType') : programType, ('invoiceType') : invoiceType, ('fundCode') : fundCode, ('supplier') : supplier
	, ('contractNum') : contractNum, ('vendorMessage') : vendorMessage, ('sequence') : sequence, ('primaryContact') : primaryContact, ('secondaryContact') : secondaryContact],FailureHandling.STOP_ON_FAILURE)

*/

def Datasheet=findTestData('FDR_E2E-REGRESSION-TESTS-DATA/FDR-E2E-FDR-8209-VOUCHER-APPROVAL-DATA')
CF.login(GlobalVariable.superUserAccnt, GlobalVariable.superUserPwd)

CF.selectRole('accountsPayableProcessor')
WebUI.click(findTestObject('FDR-Dashboard/createNewVoucherButton'))
WebUI.setText(findTestObject('FDR-VoucherEntry/Voucher/drawDate'), Datasheet.getValue('drawDate', 1))
WebUI.setText(findTestObject('FDR-VoucherEntry/Voucher/payDate'), Datasheet.getValue('payDate', 1))
WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/programType'))
WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/programType'), 2)
WebUI.setText(findTestObject('FDR-VoucherEntry/Voucher/programType'), Datasheet.getValue('programType', 1))
WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/programType'), 3)
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/programType'), Keys.chord(Keys.DOWN,Keys.ENTER))
WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/invoiceType'))
WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/invoiceType'), 2)
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/invoiceType'),Datasheet.getValue('invoiceType', 1))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/invoiceType'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/fundcode'))
WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/fundcode'), 1)
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/fundcode'),Datasheet.getValue( 'fundcode', 1))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/fundcode'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/supplierID'))
WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/supplierID'), 1)
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/supplierID'),Datasheet.getValue('supplierID', 1))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/supplierID'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/seqNum'))
WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/seqNum'), 3)
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/supplierID'),Datasheet.getValue('seqNum', 1))
WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/seqNum'))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/seqNum'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/contractNum'))
WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/contractNum'), 1)
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/contractNum'),Datasheet.getValue('contractNum', 1))
WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/contractNum'))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/contractNum'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/vendorMessage'))
WebUI.setText(findTestObject('Object Repository/FDR-VoucherEntry/Voucher/vendorMessage'),Datasheet.getValue('vendorMessage', 1))
WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/primaryContact'))
WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/primaryContact'), 1)
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/primaryContact'),Datasheet.getValue('primaryContact', 1))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/primaryContact'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/secondaryContact'))
WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/secondaryContact'), 1)
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/secondaryContact'),Datasheet.getValue('secondaryContact', 1))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/secondaryContact'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/buttonNext'))
WebUI.delay(3)
//Get Number of Line data
def noOfLine=Datasheet.getValue('NoOfLines', 1)
int str= noOfLine as int
for(int j=1;j<=str;j++)
{
int irandom=new Random().nextInt(900000)+100000
WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoice'))
WebUI.setText(findTestObject('FDR-VoucherEntry/InvoiceLine/invoice'),'INC-'+irandom)
WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceDate'))
WebUI.setText(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceDate'),Datasheet.getValue('invoiceDate', 1))
WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/originalWarrantDate'))
WebUI.setText(findTestObject('FDR-VoucherEntry/InvoiceLine/originalWarrantDate'),Datasheet.getValue('originalWarrantDate', 1))
WebUI.delay(3)
WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/addInvoiceLineButton'))

WebUI.delay(5)

if(j==1){
	
	WebUI.click(findTestObject('Object Repository/FDR-EditVoucher/expandicon1'))

}else if(j==2)
{
	WebUI.click(findTestObject('Object Repository/FDR-EditVoucher/expandicon2'))
}
WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceAddlineButton'))
WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/serviceDateFrom'))
WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/serviceDateFrom'),Datasheet.getValue('serviceDateFrom', 1))
WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/serviceDateTo'),Datasheet.getValue('serviceDateTo', 1))
WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/amount'))
WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/amount'),Datasheet.getValue('amount', 1))
WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/waiverType'))
WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/waiverType'),Datasheet.getValue('waiverType', 1))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/waiverType'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'))
WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'),Datasheet.getValue('waiverName', 1))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'))
WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'),Datasheet.getValue('fundingSource', 1))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'))
WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'),Datasheet.getValue('fundRatio', 1))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'))
WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'),Datasheet.getValue('nonFederalFund', 1))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/account'))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/account'),Datasheet.getValue('account', 1))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/account'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/altAccount'))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/altAccount'),Datasheet.getValue(
		'altAccount', 1))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/altAccount'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'),Datasheet.getValue(
		'serviceCategory', 1))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/incDecLine'))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/incDecLine'),Datasheet.getValue('incDecLine', 1))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/incDecLine'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/index'))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/index'),Datasheet.getValue(
		'index', 1))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/index'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/ServiceLocation'))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/ServiceLocation'),Datasheet.getValue('ServiceLocation', 1))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/ServiceLocation'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.click(findTestObject('Object Repository/FDR-VoucherEntry/DistributionLine/addSaveButton'))
}
def processorVoucherNumber = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/voucherNum'))
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/FDR-Vouchers-States/Resume/reviewButton'))
WebUI.click(findTestObject('Object Repository/FDR-Vouchers-States/Resume/submitForApproval'))

CF.selectRole('accountsPayableApprover')
WebUI.delay(2)
WebUI.click(findTestObject('FDR-Dashboard/Filters/validateFilterButton'))
WebUI.delay(2)
WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), processorVoucherNumber)
WebUI.click(findTestObject('FDR-Dashboard/Filters/validateFilterButton'))
WebUI.click(findTestObject('Object Repository/FDR-Dashboard/VouhcersTable/validateButton'))
//Reject Distribution Line Items
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'))
WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/DLHover'), 3)
WebUI.mouseOver(findTestObject('FDR-EditVoucher/DLHover'))
WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/DLEditIcon'), 3)
WebUI.click(findTestObject('FDR-EditVoucher/DLEditIcon'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/DLRejectClick'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/rejectDistributionLine'))
WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/spanIncorrectFundRatio'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/spanIncorrectDistributionLine'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
WebUI.setText(findTestObject('Object Repository/FDR-Dashboard/DashBoard Validation/Notes'),'Distribution Line Reject Notes Here')
WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/rejectDistributionLine'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
//WebUI.click(findTestObject('FDR-Dashboard/DashBoard Validation/button_Reject'))
/* Distribution Line Reject END -------------------------------------------------*/

// Invoice Line Starts here */ BLUE LINE
WebUI.delay(1)
WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
WebUI.mouseOver(findTestObject('FDR-EditVoucher/invoiceHover'))
WebUI.click(findTestObject('FDR-EditVoucher/voucherLineEditIcon'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/DLRejectClick'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucherLine/spanIncorrectInvoiceNum'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucherLine/spanIncorrectInvoiceAmount'))
WebUI.setText(findTestObject('Object Repository/FDR-Dashboard/DashBoard Validation/Notes'),'Invoice Reject Notes Here')
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucherLine/rejectInvoiceLine'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
// Invoice Line Starts END ----------------------------------- */

// Reject Voucher Starts here
WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/rejectButton'))
WebUI.check(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucher/spanDrawDate'))
WebUI.check(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucher/spanPayDate'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
WebUI.setText(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucher/Notes'),'Voucher Reject Notes')
WebUI.check(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucher/rejectVoucherButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), processorVoucherNumber)

WebUI.click(findTestObject('FDR-Dashboard/Filters/clearFilterButton'))
// Reject Voucher END here---------------------------------------*/

// Login As an account Payable processor STEP # 21

CF.selectRole('accountsPayableProcessor')
WebUI.delay(3)
WebUI.click(findTestObject('FDR-Dashboard/Filters/fixFilterButton'))
WebUI.delay(3)
WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), processorVoucherNumber)

WebUI.click(findTestObject('FDR-Dashboard/VouhcersTable/fixButton'))
WebUI.delay(3)

//INSTRUCTIONS FOR FIXING THIS VOUCHER verify or wait until text appear

WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
WebUI.mouseOver(findTestObject('FDR-EditVoucher/invoiceHover'))
WebUI.click(findTestObject('Object Repository/FDR-Receipt/FDR-Receipt-DistributionLine/3dots/editIconDistributionLine'))
WebUI.click(findTestObject('Object Repository/FDR-EditVoucher/DLEditClick'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('FDR-VoucherEntry/VoucherEntryObjects/inputInvoiceDescription'))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/VoucherEntryObjects/inputInvoiceDescription'), Keys.chord(Keys.CONTROL,'a'))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/VoucherEntryObjects/inputInvoiceDescription'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(3)
int Vrandom=new Random().nextInt(900000)+100000
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/VoucherEntryObjects/inputInvoiceDescription'),'INC-'+Vrandom)
WebUI.click(findTestObject('Object Repository/FDR-EditVoucher/dlSaveButton'))
WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/FDR-EditVoucher/DLHover'))
WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/3dots/editIconDistributionLine_2'), 3)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/3dots/editIconDistributionLine_2'))
WebUI.click(findTestObject('Object Repository/FDR-EditVoucher/DLEditClick'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'), Keys.chord(Keys.BACK_SPACE))
WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'),'90/10')
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'), Keys.chord(Keys.BACK_SPACE))
WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'),'0001') // required to add/update test data sheet based on program
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'),'22')// required to add/update test data sheet based on program
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.click(findTestObject('Object Repository/FDR-EditVoucher/editvocuherSave'))
WebUI.click(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'))
WebUI.delay(2)
//def processorVoucherNumber = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/voucherNum'))
WebUI.click(findTestObject('FDR-Vouchers-States/Resume/submitForApproval'))
WebUI.click(findTestObject('FDR-Dashboard/Filters/clearFilterButton'))

// Step # 35 -- 1.Login As an account Payable Aprpover

CF.selectRole('accountsPayableApprover')// ************Validate Voucher **********
WebUI.delay(1)
WebUI.click(findTestObject('FDR-Dashboard/Filters/clearFilterButton'))
WebUI.delay(2)
WebUI.click(findTestObject('FDR-Dashboard/Filters/validateFilterButton'))
WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), processorVoucherNumber)
WebUI.click(findTestObject('Object Repository/FDR-Dashboard/VouhcersTable/validateButton'))
WebUI.click(findTestObject('Object Repository/FDR-Draw/reviewScreen/approveButton'))
WebUI.click(findTestObject('FDR-Dashboard/Filters/clearFilterButton'))
WebUI.delay(4)
WebUI.click(findTestObject('FDR-Dashboard/Search/searchInputField'))
WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), processorVoucherNumber)
WebUI.click(findTestObject('Object Repository/FDR-Dashboard/Filters/printFilterButton'))
WebUI.click(findTestObject('Object Repository/FDR-Dashboard/VouhcersTable/printButton'))
WebUI.click(findTestObject('Object Repository/FDR-Vouchers-States/Print/printCMIAForm'))
WebUI.waitForPageLoad(7)
WebUI.closeWindowIndex(1)
WebUI.delay(1)
WebUI.switchToWindowIndex(0)
WebUI.click(findTestObject('FDR-Vouchers-States/Print/printFaceSheet'))
WebUI.waitForPageLoad(7)

WebUI.closeWindowIndex(1)
WebUI.delay(5)
WebUI.switchToWindowIndex(0)

WebUI.click(findTestObject('/FDR-Vouchers-States/Print/printRA'))
WebUI.waitForPageLoad(7)
WebUI.closeWindowIndex(1)
WebUI.delay(5)
WebUI.switchToWindowIndex(0)

//All Forms
WebUI.click(findTestObject('Object Repository/FDR-Vouchers-States/Print/allFormsPrintButton'))
WebUI.delay(5)
WebUI.click(findTestObject('FDR-Dashboard/Filters/clearFilterButton'))
WebUI.click(findTestObject('Object Repository/FDR-Dashboard/appLogo'))
CF.logout()


