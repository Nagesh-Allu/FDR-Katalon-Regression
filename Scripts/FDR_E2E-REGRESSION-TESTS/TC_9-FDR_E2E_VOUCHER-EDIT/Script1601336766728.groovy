/* Project Name : FDR
 * END_2_END_TC_9:Automate and run End to End FDR User workflow- Integrate Voucher Create/Edit/Approval process while 
 * switching the roles from Processor to Approver
 * Requirement - https://ca-mmisds.atlassian.net/browse/FDRPM-2938
 * Test Scenario : Validate Account Number in Voucher-Distribution line after added a New Account as a System Admin role.
 * Author : Nagesh Allu
 * Creation Date: 09/25/2020
 * Revision History:
 * 09/20/2020 : Linked with Account Number with Account Name .So that Account Number & Alt Account will be update at Voucher Level
 * *******************************************************************************************************/
//Import statements
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
import com.global.functions.Edit_Voucher_Invoice_DistributionLines as Editvouchersheet
import com.global.functions.ChangeDrawDate as ChangeDrawDate

// Calling a Datasheet
def Datasheet=findTestData('FDR_E2E-REGRESSION-TESTS-DATA/FDR-E2E-FDR-VOUCHER-APPROVAL-DATA')
//Login as Super User 
CF.login(GlobalVariable.superUserAccnt, GlobalVariable.superUserPwd)

// Switch the Role to accountsPayableProcessor
CF.selectRole('accountsPayableProcessor')
// Voucher Creation steps starts here 
WebUI.click(findTestObject('Object Repository/FDR-Dashboard/createNewVoucherButton'))
//WebUI.setText(findTestObject('FDR-VoucherEntry/Voucher/drawDate'), Datasheet.getValue('drawDate', 1))
//WebUI.setText(findTestObject('FDR-VoucherEntry/Voucher/payDate'), Datasheet.getValue('payDate', 1))

ChangeDrawDate.DrawDate()

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
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
// Calling a DrawDate function
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
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
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/addInvoiceLineButton'))

WebUI.delay(5)

if(j==1){
	
	WebUI.click(findTestObject('Object Repository/FDR-EditVoucher/expandicon1'))

}else if(j==2)
{
	WebUI.click(findTestObject('Object Repository/FDR-EditVoucher/expandicon2'))
}
// Invoice Line creation
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

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
WebUI.click(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
WebUI.click(findTestObject('Object Repository/FDR-Draw/drawDateValidation/editVoucher'))

// calling method to EDIT voucher Method here 

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
WebUI.click(findTestObject('FDR-EditVoucher/voucherEditIcon'))
WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/voucherEdit'), 1)
WebUI.click(findTestObject('FDR-EditVoucher/voucherEdit'))

Editvouchersheet.EditVoucher()

// calling method to EDIT invoice Method here
WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/invoiceHover'), 3)
WebUI.mouseOver(findTestObject('FDR-EditVoucher/invoiceHover'))
WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/voucherLineEditIcon'), 1)
WebUI.click(findTestObject('FDR-EditVoucher/voucherLineEditIcon'))
WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/voucherLineEditClick'), 1)
WebUI.click(findTestObject('FDR-EditVoucher/voucherLineEditClick'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

Editvouchersheet.EditInvoice()

//Calling method to EDIT Distribution Line here

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
WebUI.mouseOver(findTestObject('Object Repository/FDR-EditVoucher/DLHover'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/3dots/editIconDistributionLine'))
WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-EditVoucher/DLEditClick'),3)
WebUI.click(findTestObject('Object Repository/FDR-EditVoucher/DLEditClick'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

Editvouchersheet.EditDistribution()

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
WebUI.click(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'))

//Print Forms
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)
WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/cmiaForm'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)
WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/closeButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)
WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/faceSheet'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)
WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/closeButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)
WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/remittanceAdvice'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)
WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/closeButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Vouchers-States/Resume/submitForApproval'),3)
WebUI.click(findTestObject('Object Repository/FDR-Vouchers-States/Resume/submitForApproval'))

// swtiching the role to accountsPayableApprover
CF.selectRole('accountsPayableApprover')
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/Search/searchInputField'),2)
WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), processorVoucherNumber)
WebUI.click(findTestObject('FDR-Dashboard/Filters/validateFilterButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
WebUI.click(findTestObject('Object Repository/FDR-Dashboard/VouhcersTable/validateButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
WebUI.click(findTestObject('Object Repository/FDR-Draw/reviewScreen/approveButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
WebUI.click(findTestObject('FDR-Dashboard/Filters/clearFilterButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
WebUI.click(findTestObject('FDR-Dashboard/Search/searchInputField'))
WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), processorVoucherNumber)
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Dashboard/Filters/printFilterButton'),4)
WebUI.click(findTestObject('Object Repository/FDR-Dashboard/Filters/printFilterButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/VouhcersTable/printButton'), 4)
WebUI.click(findTestObject('FDR-Dashboard/VouhcersTable/printButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

// Print Forms
		WebUI.click(findTestObject('Object Repository/FDR-Vouchers-States/Print/printCMIAForm'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
		WebUI.closeWindowIndex(1, FailureHandling.STOP_ON_FAILURE)
		WebUI.switchToWindowIndex(0, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
		WebUI.click(findTestObject('FDR-Vouchers-States/Print/printFaceSheet'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
		WebUI.closeWindowIndex(1, FailureHandling.STOP_ON_FAILURE)
		WebUI.switchToWindowIndex(0, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
		WebUI.click(findTestObject('FDR-Vouchers-States/Print/printRA'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
		WebUI.closeWindowIndex(1, FailureHandling.STOP_ON_FAILURE)
		WebUI.switchToWindowIndex(0, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('FDR-Vouchers-States/Print/allFormsPrintButton'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
		WebUI.click(findTestObject('FDR-Dashboard/Filters/clearFilterButton'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Dashboard/appLogo'),2)
		WebUI.click(findTestObject('Object Repository/FDR-Dashboard/appLogo'))
		//Logout function
		CF.logout()