/* Project : FDR
 * Purpose : Creating a Voucher header,Invoice and Distribution line items for Voucher.
 * Business Module : Voucher
 * List of All Voucher Functions are here
 *  	1) createVoucherHeader
 * 		2) createInvoiceLinesAndDistributionLines
 * 		3) createDistributionLines
 * List of Parameters : Draw Date,Program Type,Invoice Type,FundCode,Supplier ID #,seqNum,Contract #,Vendor Message,Primary Contact,Secondary Contact
 * Excel sheet Data set: Data Files/Voucher/voucherHeader
 ***************************************************************************************************/
//List of all Import packages and libraries
package com.global.functions
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.CellType
import org.openqa.selenium.Keys
import com.functions.Uifunctions
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

public class voucherFunctions {
	public static void createVoucherHeader(dataSheet) {
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 1)
		WebUI.scrollToPosition(0, 0, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 1)
		WebUI.click(findTestObject('FDR-Dashboard/createNewVoucherButton'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/drawDate'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
		WebUI.setText(findTestObject('FDR-VoucherEntry/Voucher/drawDate'), dataSheet.getValue('Draw Date',1))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/programType'))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/programType'), 2)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/programType'), dataSheet.getValue('Program Type',1))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/programType'), 2)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/programType'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/invoiceType'))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/invoiceType'), 1)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/invoiceType'), dataSheet.getValue('Invoice Type',1))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/invoiceType'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/fundCode'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/fundCode'), dataSheet.getValue('FundCode',1))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/fundCode'), 1)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/fundCode'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/supplierID'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/supplierID'), dataSheet.getValue('Supplier ID #',1))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/supplierID'), 1)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/supplierID'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/seqNum'))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/seqNum'), 3)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/seqNum'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)
		if(dataSheet.getValue('C/O Dept. of Social Services',1) == 'TRUE'){
			WebUI.click(findTestObject('FDR-VoucherEntry/VoucherHeader/deptOfSocialServices'))
		}
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/contractNum'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/contractNum'), dataSheet.getValue('Contract #',1))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/contractNum'), 5)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/contractNum'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.setText(findTestObject('FDR-VoucherEntry/Voucher/vendorMessage'), dataSheet.getValue('Vendor Message',1))
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/primaryContact'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/primaryContact'), dataSheet.getValue('Primary Contact',1))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/primaryContact'), 2)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/primaryContact'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/secondaryContact'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/secondaryContact'), dataSheet.getValue('Secondary Contact',1))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/secondaryContact'), 2)
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/secondaryContact'), 2)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/secondaryContact'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/buttonNext'))
		WebUI.delay(3)
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)
	}
	//***************************************************************************************************************************//
	/*	Purpose : To create a Invoice Line Items for the Voucher
	 * 	FunctionName : createInvoiceLinesAndDistributionLines
	 *  	List of Parameters : invoice,invoiceDate and originalWarrantDate
	 *   Excel sheet Data set : 
	 */
	public static void createInvoiceLinesAndDistributionLines(invoiceLinesData, distributionLinesData) {
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 1)
		for (def i = 0; i < invoiceLinesData.size(); i++) {
			def invoiceLineData = invoiceLinesData[i]
			WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 1)
			WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoice'))
			WebUI.setText(findTestObject('FDR-VoucherEntry/InvoiceLine/invoice'), invoiceLineData[0])
			WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceDate'))
			WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceDate'), 1)
			WebUI.setText(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceDate'), invoiceLineData[1])
			WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/originalWarrantDate'))
			WebUI.setText(findTestObject('FDR-VoucherEntry/InvoiceLine/originalWarrantDate'), invoiceLineData[2])
			WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/InvoiceLine/addInvoiceLineButton'), 1)
			if(i == 0) {
				WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/addInvoiceLineButton'))
			} else if(i < invoiceLinesData.size()-1) {
				WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/addInvoiceLineButtonIndex2'))
				WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
				WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/addVoucherButton'))
			}  else {
				WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/addInvoiceLineButtonIndex2'))
			}
			WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)

			def currentInvoiceDistributionLines = []
			for (int j = 0; j < distributionLinesData.size(); j++){
				if(invoiceLineData[0] == distributionLinesData[j][0]){
					currentInvoiceDistributionLines.add(distributionLinesData[j])
				}
			}
			createDistributionLines(currentInvoiceDistributionLines, i)
			currentInvoiceDistributionLines = []
		}
	}

	//***************************************************************************************************************************//
	/* Purpose : To create a Distribution Line items for the Voucher
	 * Function Name : createDistributionLines
	 *  List of parameters : serviceDateFrom,serviceDateTo,amount,waiverType,waiverName,fundingSource,fundRatio,nonFederalFund,account,altAccount,
	 *  serviceCategory,incDecLine,index
	 * Excel Sheet data set : Data Files/Voucher/DistributionLine.xlsx
	 */
	public static void createDistributionLines(dataArray, index){
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
		WebUI.click(getExpandButton(index +1 ))
		WebUI.waitForElementClickable(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceAddlineButton'), 3)
		WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceAddlineButton'))
		println(dataArray)
		for ( def i = 0; i < dataArray.size(); i++) {
			def data = dataArray[i]
			WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
			WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/serviceDateFrom'))
			WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/serviceDateFrom'), data[1])
			WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/serviceDateTo'))
			WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/serviceDateTo'), data[2])
			WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
			WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/amount'))
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/amount'), data[3])
			WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/waiverType'))
			WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/waiverType'),data[4] + '\n')
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/waiverType'), Keys.chord(Keys.DOWN, Keys.ENTER))
			WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'))
			Uifunctions.clearElementText(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'))
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'),data[5] + '\n' )
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'), Keys.chord(Keys.DOWN, Keys.ENTER))
			WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'))
			Uifunctions.clearElementText(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'))
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'),data[6] + '\n')
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'), Keys.chord(Keys.DOWN, Keys.ENTER))
			WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'))
			Uifunctions.clearElementText(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'))
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'), data[7] + '\n')
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'), Keys.chord(Keys.DOWN, Keys.ENTER))
			WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'))
			Uifunctions.clearElementText(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'))
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'), data[8] + '\n')
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'), Keys.chord(Keys.DOWN, Keys.ENTER))
			WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/account'))
			Uifunctions.clearElementText(findTestObject('FDR-VoucherEntry/DistributionLine/account'))
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/account'), data[9] + '\n')
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/account'), Keys.chord(Keys.DOWN, Keys.ENTER))
			WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/altAccount'))
			Uifunctions.clearElementText(findTestObject('FDR-VoucherEntry/DistributionLine/altAccount'))
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/altAccount'), data[10] + '\n')
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/altAccount'), Keys.chord(Keys.DOWN, Keys.ENTER))
			WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'))
			Uifunctions.clearElementText(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'))
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'), data[11] + '\n')
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'), Keys.chord(Keys.DOWN, Keys.ENTER))
			WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/incDecLine'))
			Uifunctions.clearElementText(findTestObject('FDR-VoucherEntry/DistributionLine/incDecLine'))
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/incDecLine'), data[12] + '\n')
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/incDecLine'), Keys.chord(Keys.DOWN, Keys.ENTER))
			WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/index'))
			Uifunctions.clearElementText(findTestObject('FDR-VoucherEntry/DistributionLine/index'))
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/index'), data[13] + '\n')
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/index'), Keys.chord(Keys.DOWN, Keys.ENTER))
			if (i < dataArray.size() - 1) {
				WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/addAnotherLine'))
			}
			else {
				WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/addSaveButton'))
			}
		}
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
		WebUI.scrollToPosition(50, 50)
		println("scrolling")
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
		WebUI.click(getExpandButton(index +1 ))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
	}

	public static void validateToApprove(uniqueIdentifier) {
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)
		Uifunctions.clearElementText(findTestObject('FDR-Dashboard/Search/searchInputField'))
		WebUI.click(findTestObject('FDR-Dashboard/Search/searchInputField'))
		WebUI.setText(findTestObject('FDR-Dashboard/Search/searchInputField'), uniqueIdentifier)
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)
		WebUI.click(findTestObject('FDR-Dashboard/uniqueVoucherActionButton'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
		WebUI.click(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
		WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/cmiaForm'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
		WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/closeButton'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
		WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/faceSheet'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
		WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/closeButton'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
		WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/remittanceAdvice'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
		WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/closeButton'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
		WebUI.click(findTestObject('FDR-Vouchers-States/Resume/submitForApproval'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
		WebUI.click(findTestObject('FDR-Dashboard/uniqueVoucherActionButton'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
		WebUI.click(findTestObject('FDR-Vouchers-States/Validate/approveButton'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
		WebUI.click(findTestObject('FDR-Dashboard/uniqueVoucherActionButton'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
		WebUI.click(findTestObject('FDR-Vouchers-States/Print/printCMIAForm'))
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
	}

	public static TestObject getExpandButton(index) {
		def xpath = "(//*[contains(@class,'MuiExpansionPanel-root')])[" + index + "]//*[contains(@class,'expandIcon')]"
		TestObject expandButton = new TestObject("expandButton")
		expandButton.addProperty("xpath", ConditionType.EQUALS, xpath)
		return expandButton
	}
}
