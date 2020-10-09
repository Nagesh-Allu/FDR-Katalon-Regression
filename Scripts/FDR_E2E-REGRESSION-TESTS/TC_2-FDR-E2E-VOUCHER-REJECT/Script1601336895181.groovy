 /* Project : FDR
 * End_End_TC_2: FDR-E2E-FDR-8119-VOUCHER-REJECT workflow process
 * Purpose : To Reject Voucher,Invoice Line and Distribution Line Items. 
 * Author : Nagesh Allu
 * Creation Date: 09/24/2020
 * Revision History:
 09/24/2020: Updated Object Repository and XPaths.
 10/05/2020- Added Draw Date Function
 * **************************************************************************************************/ 
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
import com.global.functions.ChangeDrawDate as ChangeDrawDate


// Data sheet
def Datasheet = findTestData('FDR_E2E-REGRESSION-TESTS-DATA/FDR-E2E-FDR-VOUCHER-APPROVAL-DATA')

//Login function
CF.login(GlobalVariable.superUserAccnt, GlobalVariable.superUserPwd)

// Switching the role to accountsPayableProcessor
CF.selectRole('accountsPayableProcessor')

WebUI.click(findTestObject('FDR-Dashboard/createNewVoucherButton'))

ChangeDrawDate.DrawDate()

//WebUI.setText(findTestObject('FDR-VoucherEntry/Voucher/drawDate'), Datasheet.getValue('drawDate', 1))
//WebUI.setText(findTestObject('FDR-VoucherEntry/Voucher/payDate'), Datasheet.getValue('payDate', 1))
WebUI.waitForElementVisible(findTestObject('FDR-VoucherEntry/Voucher/programType'), 10)
WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/programType'))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/programType'), Datasheet.getValue('programType', 1))
WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/programType'), 5)
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/programType'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.waitForElementVisible(findTestObject('FDR-VoucherEntry/Voucher/invoiceType'), 2)
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/invoiceType'), Datasheet.getValue('invoiceType', 1))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/invoiceType'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.waitForElementVisible(findTestObject('FDR-VoucherEntry/Voucher/fundcode'), 1)
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/fundcode'), Datasheet.getValue('fundcode', 1))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/fundcode'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.waitForElementVisible(findTestObject('FDR-VoucherEntry/Voucher/supplierID'), 1)
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/supplierID'), Datasheet.getValue('supplierID', 1))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/supplierID'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/seqNum'))
WebUI.waitForElementVisible(findTestObject('FDR-VoucherEntry/Voucher/seqNum'), 3)
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/seqNum'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.waitForElementVisible(findTestObject('FDR-VoucherEntry/Voucher/seqNum'), 2)
WebUI.setText(findTestObject('FDR-VoucherEntry/Voucher/seqNum'), Datasheet.getValue('seqNum', 1))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/seqNum'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/contractNum'), 1)
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/contractNum'), Datasheet.getValue('contractNum', 1))

WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/contractNum'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/vendorMessage'))
WebUI.setText(findTestObject('Object Repository/FDR-VoucherEntry/Voucher/vendorMessage'), Datasheet.getValue('vendorMessage',1))


WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/primaryContact'), 1)
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/primaryContact'), Datasheet.getValue('primaryContact', 1))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/primaryContact'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/secondaryContact'), 1)
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/secondaryContact'), Datasheet.getValue('secondaryContact', 1))
WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/secondaryContact'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/buttonNext'),5)

WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/buttonNext'))

//Get Number of Line data

	int irandom = new Random().nextInt(90000) + 10000
	
	WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/InvoiceLine/invoice'), 10)
	WebUI.setText(findTestObject('FDR-VoucherEntry/InvoiceLine/invoice'), 'INC-' + irandom)
	WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceDate'),5)
	WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceDate'))
	WebUI.setText(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceDate'), Datasheet.getValue('invoiceDate', 1))

	WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/InvoiceLine/originalWarrantDate'), 5)
	WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/originalWarrantDate'))
	WebUI.setText(findTestObject('FDR-VoucherEntry/InvoiceLine/originalWarrantDate'), Datasheet.getValue('originalWarrantDate',	1))
	
	WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/addInvoiceLineButton'))
	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 10)
	WebUI.click(findTestObject('Object Repository/FDR-EditVoucher/expandicon1'))
	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)
	WebUI.click(findTestObject('Object Repository/FDR-VoucherEntry/InvoiceLine/invoiceAddlineButton'))
	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)
	WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/serviceDateFrom'))
	WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/serviceDateFrom'), Datasheet.getValue('serviceDateFrom',1))

	WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/serviceDateTo'), Datasheet.getValue('serviceDateTo',1))
	WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/amount'))
	WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/amount'), Datasheet.getValue('amount', 1))
	WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/waiverType'))
	WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/waiverType'), Datasheet.getValue('waiverType', 1))
	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/waiverType'), Keys.chord(Keys.DOWN, Keys.ENTER))
	WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'))

	WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'), Datasheet.getValue('waiverName', 1))
	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'), Keys.chord(Keys.DOWN, Keys.ENTER))
	WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'))

	WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'), Datasheet.getValue('fundingSource',1))
	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'), Keys.chord(Keys.DOWN, Keys.ENTER))
	WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'))
	WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'), Datasheet.getValue('fundRatio', 1))
	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'), Keys.chord(Keys.DOWN, Keys.ENTER))
	WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'), 5)
	WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'))

	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'), Datasheet.getValue('nonFederalFund',	1))

	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'), Keys.chord(Keys.DOWN, Keys.ENTER))
	WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/account'))
	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/account'), Datasheet.getValue('account', 1))
	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/account'), Keys.chord(Keys.DOWN, Keys.ENTER))
	WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/altAccount'))
	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/altAccount'), Datasheet.getValue('altAccount', 1))
	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/altAccount'), Keys.chord(Keys.DOWN, Keys.ENTER))
	WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'))
	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'), Datasheet.getValue('serviceCategory',1))
	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'), Keys.chord(Keys.DOWN, Keys.ENTER))

	WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/DistributionLine/incDecLine'), 5)
	WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/incDecLine'))
	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/incDecLine'), Datasheet.getValue('incDecLine', 1))
	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/incDecLine'), Keys.chord(Keys.DOWN, Keys.ENTER))
	WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/index'))
	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/index'), Datasheet.getValue('index', 1))
	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/index'), Keys.chord(Keys.DOWN, Keys.ENTER))
	WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/ServiceLocation'))
	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/ServiceLocation'), Datasheet.getValue('ServiceLocation',1))
	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/ServiceLocation'), Keys.chord(Keys.DOWN, Keys.ENTER))
	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)
	WebUI.click(findTestObject('Object Repository/FDR-VoucherEntry/DistributionLine/addSaveButton'))
	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)
	def processorVoucherNumber = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/voucherNum'))
	WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 10)
	WebUI.click(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'))
	WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Vouchers-States/Resume/submitForApproval'), 5)
	WebUI.click(findTestObject('Object Repository/FDR-Vouchers-States/Resume/submitForApproval'))

	CF.selectRole('accountsPayableApprover')

	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/Filters/validateFilterButton'), 5)
	WebUI.click(findTestObject('FDR-Dashboard/Filters/validateFilterButton'))
	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/Filters/validateFilterButton'), 5)
	WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), processorVoucherNumber)
	WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Dashboard/VouhcersTable/validateButton'), 10)
	
	WebUI.click(findTestObject('Object Repository/FDR-Dashboard/VouhcersTable/validateButton'))

	//Reject Distribution Line Items
	
	WebUI.waitForElementVisible(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'), 16)
	WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'))
	WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/DLHover'), 10)
	WebUI.mouseOver(findTestObject('FDR-EditVoucher/DLHover'))
	WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/DLEditIcon'), 10)
	WebUI.click(findTestObject('FDR-EditVoucher/DLEditIcon'))
	WebUI.waitForElementPresent(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/DLRejectClick'), 7)
	WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/DLRejectClick'))
	WebUI.waitForElementPresent(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/rejectDistributionLine'), 7)
	WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/rejectDistributionLine'))
	
	WebUI.waitForElementPresent(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/spanIncorrectFundRatio'), 7)
	WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/spanIncorrectFundRatio'))

	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

	WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/spanIncorrectDistributionLine'))

	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

	WebUI.setText(findTestObject('Object Repository/FDR-Dashboard/DashBoard Validation/Notes'), 'Distribution Line Reject Notes Here')

	WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/rejectDistributionLine'))

	/* Distribution Line Reject END -------------------------------------------------*/
	// Invoice Line Starts here */ BLUE LINE
	WebUI.waitForElementVisible(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'), 17)

	WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'))

	WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/invoiceHover'), 5)

	WebUI.mouseOver(findTestObject('FDR-EditVoucher/invoiceHover'))

	WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/voucherLineEditIcon'), 5)

	WebUI.click(findTestObject('FDR-EditVoucher/voucherLineEditIcon'))

	WebUI.waitForElementPresent(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/DLRejectClick'), 7)

	WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectDistributionLine/DLRejectClick'))

	WebUI.waitForElementPresent(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucherLine/spanIncorrectInvoiceNum'), 5)

	WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucherLine/spanIncorrectInvoiceNum'))

	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)

	WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucherLine/spanIncorrectInvoiceAmount'))

	WebUI.setText(findTestObject('Object Repository/FDR-Dashboard/DashBoard Validation/Notes'), 'Invoice Reject Notes Here')

	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

	WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucherLine/rejectInvoiceLine'))

	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

	// Invoice Line Starts END ----------------------------------- */
	// Reject Voucher Starts here
	WebUI.click(findTestObject('FDR-Vouchers-States/Validate/Reject/rejectButton'))

	WebUI.check(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucher/spanDrawDate'))

	WebUI.check(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucher/spanPayDate'))

	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

	WebUI.setText(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucher/Notes'), 'Voucher Reject Notes')

	WebUI.check(findTestObject('FDR-Vouchers-States/Validate/Reject/RejectVoucher/rejectVoucherButton'))

	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

	WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), processorVoucherNumber)

	WebUI.click(findTestObject('FDR-Dashboard/Filters/clearFilterButton'))

	// Reject Voucher END here---------------------------------------*/
	// Login As an account Payable processor STEP # 21
	CF.selectRole('accountsPayableProcessor')

	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

	WebUI.click(findTestObject('FDR-Dashboard/Filters/fixFilterButton'))

	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

	WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), processorVoucherNumber)

	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

	WebUI.click(findTestObject('FDR-Dashboard/VouhcersTable/fixButton'))

	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

	//INSTRUCTIONS FOR FIXING THIS VOUCHER verify or wait until text appear
	// Invoice Line Starts here */
	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)

	WebUI.mouseOver(findTestObject('FDR-EditVoucher/invoiceHover'))

	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

	WebUI.click(findTestObject('FDR-EditVoucher/voucherLineEditIcon'))

	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

	WebUI.click(findTestObject('Object Repository/FDR-EditVoucher/DLEditClick'))

	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

	WebUI.click(findTestObject('FDR-VoucherEntry/VoucherEntryObjects/inputInvoiceDescription'))

	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/VoucherEntryObjects/inputInvoiceDescription'), Keys.chord(Keys.CONTROL,'a'))

	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/VoucherEntryObjects/inputInvoiceDescription'), Keys.chord(Keys.BACK_SPACE))

	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

	int Vrandom = new Random().nextInt(900000) + 100000

	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/VoucherEntryObjects/inputInvoiceDescription'), 'INC-' + Vrandom)

	WebUI.click(findTestObject('Object Repository/FDR-EditVoucher/dlSaveButton'))

	WebUI.waitForElementVisible(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'), 15)

	WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'))

	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

	WebUI.mouseOver(findTestObject('Object Repository/FDR-EditVoucher/DLHover'))

	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

	WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/3dots/editIconDistributionLine'))

	WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-EditVoucher/DLEditClick'), 3)

	WebUI.click(findTestObject('Object Repository/FDR-EditVoucher/DLEditClick'))

	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

	WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'))

	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'), Keys.chord(Keys.BACK_SPACE))

	WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'), '90/10')

	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'), Keys.chord(Keys.DOWN, Keys.ENTER))

	 WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'))
	 WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'), Keys.chord(Keys.BACK_SPACE))
	 WebUI.clearText(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'))
	 WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'), 5)
	 WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'),"3158")
	 //WebUI.executeJavaScript('document.getelementbyxpath(FDR-VoucherEntry/DistributionLine/nonFederalFund).value = 3158', null)
	 WebUI.delay(2)
	 WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'), Keys.chord(Keys.DOWN, Keys.ENTER))
	WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'))
	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'), '18B1')
	WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'), Keys.chord(Keys.DOWN, Keys.ENTER))
	WebUI.click(findTestObject('Object Repository/FDR-EditVoucher/editvocuherSave'))
	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
	WebUI.click(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'))
	
	//Print cmiaForm,faceSheet and remittanceAdvice
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
	
	WebUI.waitForElementPresent(findTestObject('FDR-Vouchers-States/Resume/submitForApproval'), 7)
	WebUI.click(findTestObject('FDR-Vouchers-States/Resume/submitForApproval'))
	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)
	WebUI.click(findTestObject('FDR-Dashboard/Filters/clearFilterButton'))
	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)

	// Step # 35 -- 1.Login As an account Payable Aprpover
	WebUI.refresh()
	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)
	CF.selectRole('accountsPayableApprover') // ************Validate Voucher **********

	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
	WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), processorVoucherNumber)
	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/Filters/validateFilterButton'), 10)
	WebUI.click(findTestObject('FDR-Dashboard/Filters/validateFilterButton'))
	WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Dashboard/VouhcersTable/validateButton'), 10)
	WebUI.click(findTestObject('Object Repository/FDR-Dashboard/VouhcersTable/validateButton'))
	WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Vouchers-States/Validate/approveButton'), 10)
	WebUI.click(findTestObject('Object Repository/FDR-Vouchers-States/Validate/approveButton'))
	WebUI.click(findTestObject('FDR-Dashboard/Filters/clearFilterButton'))
	WebUI.waitForElementVisible(findTestObject('FDR-Dashboard/Search/searchInputField'), 5)
	WebUI.click(findTestObject('FDR-Dashboard/Search/searchInputField'))
	WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), processorVoucherNumber)
	WebUI.click(findTestObject('Object Repository/FDR-Dashboard/Filters/printFilterButton'))
	WebUI.delay(5)
	WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Dashboard/VouhcersTable/printButton'), 5)
	WebUI.click(findTestObject('Object Repository/FDR-Dashboard/VouhcersTable/printButton'))
	////*[text()='Print']/parent::a[@data-id='button-link']

	// Print Forms printCMIAForm,printFaceSheet,printRA,allFormsPrintButton
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
	WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Dashboard/appLogo'), 2)
	WebUI.click(findTestObject('Object Repository/FDR-Dashboard/appLogo'))
	//Logout function
	CF.logout()
