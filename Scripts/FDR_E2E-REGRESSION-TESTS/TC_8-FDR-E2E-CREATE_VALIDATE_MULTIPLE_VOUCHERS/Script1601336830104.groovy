/* Project Name : FDR
 * Test Case #8: As an Accounts Payable Processor, create multiple vouchers with header, 
 * invoice and distribution line items
 * List of global voucher functions used are:
 * 	  	--> createVoucherHeader
 * 	 	--> createInvoiceLinesAndDistributionLines
 * User Story - FDRPM-3145
 * Author : Jocelyn Renaud
 * Revision Date: 09/29/2020
 */

 // List of import packages/libraries
import com.global.functions.voucherFunctions as VF
import com.etoe.commonFunctions as CF
import com.kms.katalon.core.testdata.ExcelData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import internal.GlobalVariable

// Execute Login function; set role as SuperUser (Path-->Keywords\com\etoe--commonFunctions)
CF.login(GlobalVariable.superUserAccnt, GlobalVariable.superUserPwd)

// Change role to "Accounts Payable Processor (Path -->Keywords\com\etoe--commonFunctions)
CF.selectRole('accountsPayableProcessor')

//Data Source- Extract data from E2E-T8 Excelsheet (Data Files/Regression-Voucher/E2E Regression-Data-TC8.xlsx)
//ExcelData vouchersExcelData = TestDataFactory.findTestData('Regression-Voucher/TC_8-FDR-E2E-CREATE_MULTIPLE_VOUCHERS-DATA')
ExcelData vouchersExcelData = TestDataFactory.findTestData('Data Files/FDR_E2E-REGRESSION-TESTS-DATA/E2E Regression-Data-TC8')

//Declare data variables for Voucher Header, Voucher Invoice Lines, and Invoice Distribution Lines
def invoicesData = []
def distributionLinesData = []
def voucherNums = []
def supplierIds= []
// Test for multiple vouchers found in the datasheet file 
def numOfSheets = vouchersExcelData.getSheetNames().size()

// Loop through multiple datasheets to generate multiple vouchers
for (int i = 1; i <= numOfSheets-1; i++) {
	vouchersExcelData.changeSheet("Voucher" + i)
	def numOfRows = vouchersExcelData.getRowNumbers()
	
	// Call createVoucherHeader function from VouchersFunctions.groovy
	VF.createVoucherHeader(vouchersExcelData)
	voucherNums.add(WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/voucherNum')))
	supplierIds.add(vouchersExcelData.getValue('Supplier ID #', 1))
	def invoiceData = []
	for (int j = 1; j <= numOfRows; j++) {
		invoiceData.add(vouchersExcelData.getValue('Invoice Number', j))
		invoiceData.add(vouchersExcelData.getValue('Invoice Date', j))
		invoiceData.add(vouchersExcelData.getValue('Original Warrant Date', j))
		def voucherInvoicePresent = false
		for (int k = 0; k < invoicesData.size(); k++) {
			def invData = invoicesData[k]
					
			if(invData[0] == invoiceData[0]){
				voucherInvoicePresent = true
				break
			}
		}
		if(!voucherInvoicePresent) {
			invoicesData.add(invoiceData)
			//break
		}
		invoiceData = []
	}
	for ( int l = 1; l <= numOfRows; l++) {
		def distributionLineData = []
		distributionLineData.add(vouchersExcelData.getValue('Invoice Number', l))
		distributionLineData.add(vouchersExcelData.getValue('Service Date ( To)', l))
		distributionLineData.add(vouchersExcelData.getValue('Service Date ( From)', l))
		distributionLineData.add(vouchersExcelData.getValue('Amount', l))
		distributionLineData.add(vouchersExcelData.getValue('Waiver Type', l))
		distributionLineData.add(vouchersExcelData.getValue('Waiver Name', l))
		distributionLineData.add(vouchersExcelData.getValue('Funding Source', l))
		distributionLineData.add(vouchersExcelData.getValue('Fund Ratio', l))
		distributionLineData.add(vouchersExcelData.getValue('Non-Federal Fund', l))
		distributionLineData.add(vouchersExcelData.getValue('Account', l))
		distributionLineData.add(vouchersExcelData.getValue('Alt Account', l))
		distributionLineData.add(vouchersExcelData.getValue('Service Category', l))
		distributionLineData.add(vouchersExcelData.getValue('Increase/Decrease Line', l))
		distributionLineData.add(vouchersExcelData.getValue('Index ', l))
		distributionLinesData.add(distributionLineData)
		distributionLineData = []
	}
	
	// Call createInvoiceLinesAndDistributionLines line function from vouchersFunctions.groovy
	VF.createInvoiceLinesAndDistributionLines(invoicesData, distributionLinesData)
	invoicesData = []
	distributionLinesData = []
	WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)
	WebUI.click(findTestObject('FDR-Dashboard/appLogo'))
	WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)
}

// Call Logout function (Location path -->Keywords\com\etoe--commonFunctions)
CF.logout()

/* END SCRIPT */