/* Project Name : FDR
 * Test Scenario : Creating a Voucher with header, invoice and Distribution Line items.
 * 	List of Voucher Functions are used :
 * 	  --> createVoucherHeader
 * 	 --> createInvoiceLinesAndDistributionLines
 * Author :
 * Revision Date:
 */
// List of Import packages and libraries
import com.etoe.voucherFunctions as VF
import com.etoe.commonFunctions as CF
import com.kms.katalon.core.testdata.ExcelData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import internal.GlobalVariable

// Execute Login function,Set role to SuperUser (Path-->Keywords\com\etoe--commonFunctions)
CF.login(GlobalVariable.superUserAccnt, GlobalVariable.superUserPwd)

// Login Funtion as a "Account Specific Role (Path -->Keywords\com\etoe--commonFunctions)
CF.selectRole('accountsPayableProcessor')

//Data Source- Extract data from Voucher Excelsheet (Data Files/Regression-Voucher/E2E Regression-Data.xlsx)
ExcelData vocuhersExcelData = TestDataFactory.findTestData('Regression-Voucher/E2E-Regression-Data')

//Declaring data variables for voucher Header Voucher Invoice Lines,Distribution Lines
def invoicesData = []
def distributionLinesData = []
def voucherNums = []
def supplierIds= []
def numOfSheets = vocuhersExcelData.getSheetNames().size()

for (int i = 1; i <= numOfSheets-1; i++) {
	vocuhersExcelData.changeSheet("Voucher" + i)
	def numOfRows = vocuhersExcelData.getRowNumbers()
	// calling createVoucherHeader function from VouchersFunctions.groovy
	VF.createVoucherHeader(vocuhersExcelData)
	voucherNums.add(WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/voucherNum')))
	supplierIds.add(vocuhersExcelData.getValue('Supplier ID #', 1))
	def invoiceData = []
	for (int j = 1; j <= numOfRows; j++) {
		invoiceData.add(vocuhersExcelData.getValue('Invoice Number', j))
		invoiceData.add(vocuhersExcelData.getValue('Invoice Date', j))
		invoiceData.add(vocuhersExcelData.getValue('Original Warrant Date', j))
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
		distributionLineData.add(vocuhersExcelData.getValue('Invoice Number', l))
		distributionLineData.add(vocuhersExcelData.getValue('Service Date ( To)', l))
		distributionLineData.add(vocuhersExcelData.getValue('Service Date ( From)', l))
		distributionLineData.add(vocuhersExcelData.getValue('Amount', l))
		distributionLineData.add(vocuhersExcelData.getValue('Waiver Type', l))
		distributionLineData.add(vocuhersExcelData.getValue('Waiver Name', l))
		distributionLineData.add(vocuhersExcelData.getValue('Funding Source', l))
		distributionLineData.add(vocuhersExcelData.getValue('Fund Ratio', l))
		distributionLineData.add(vocuhersExcelData.getValue('Non-Federal Fund', l))
		distributionLineData.add(vocuhersExcelData.getValue('Account', l))
		distributionLineData.add(vocuhersExcelData.getValue('Alt Account', l))
		distributionLineData.add(vocuhersExcelData.getValue('Service Category', l))
		distributionLineData.add(vocuhersExcelData.getValue('Increase/Decrease Line', l))
		distributionLineData.add(vocuhersExcelData.getValue('Index ', l))
		distributionLinesData.add(distributionLineData)
		distributionLineData = []
	}
	
	// calling a createInvoiceLinesAndDistributionLines line function from VouchersFunctions.groovy
	VF.createInvoiceLinesAndDistributionLines(invoicesData, distributionLinesData)
	invoicesData = []
	distributionLinesData = []
	WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)
	WebUI.click(findTestObject('FDR-Dashboard/appLogo'))
	WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)
}
// Execute login funcitons, set role to Accounts payable Approval to approve and validate a Voucher
CF.selectRole('accountsPayableApprover')
for (int i = 0; i < supplierIds.size(); i++) {
	VF.validateToApprove(supplierIds[i])
}

//Calling Logout function (Location path -->Keywords\com\etoe--commonFunctions)
CF.logout()

/* END*/








