/*
 * 
 * 
 * Revision History:
 * NA on 10/09/2020 --> 1) Modified Xpath of arrow_Down
 * 
 * 
 * 
 * 
 * 
 * 
 */

package com.functions

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.global.functions.ChangeDrawDate as ChangeDrawDate
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class editors {

	public static void editVoucherInfo(supplier, sequence, contract) {
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
		WebUI.click(findTestObject('FDR-EditVoucher/voucherEditIcon'))
		WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/voucherEdit'), 1)
		WebUI.click(findTestObject('FDR-EditVoucher/voucherEdit'))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/supplierID'), 5)
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/supplierID'))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/supplierID'), 5)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/supplierID'), supplier + '\n')
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
		//WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/supplierID'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/seqNum'), 4)
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/seqNum'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/seqNum'), sequence + '\n')
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
		//WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/seqNum'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/contractNum'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/contractNum'), contract + '\n')
		//WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/contractNum'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/vendorMessage'), 3)
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/vendorMessage'))
		Uifunctions.clearElementText(findTestObject('FDR-VoucherEntry/Voucher/vendorMessage'))
		WebUI.setText(findTestObject('FDR-VoucherEntry/Voucher/vendorMessage'), 'Hello this is my edit first voucher')
	}

	public static void editVoucherLineInfo() {
		WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/invoiceHover'), 3)
		WebUI.mouseOver(findTestObject('FDR-EditVoucher/invoiceHover'))
		WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/voucherLineEditIcon'), 1)
		WebUI.click(findTestObject('FDR-EditVoucher/voucherLineEditIcon'))
		WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/voucherLineEditClick'), 1)
		WebUI.click(findTestObject('FDR-EditVoucher/voucherLineEditClick'))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherEntryObjects/inputInvoiceDescription'), 3)
		WebUI.click(findTestObject('FDR-VoucherEntry/VoucherEntryObjects/inputInvoiceDescription'))
		Uifunctions.clearElementText(findTestObject('FDR-VoucherEntry/VoucherEntryObjects/inputInvoiceDescription'))
		def invoicetype = org.apache.commons.lang.RandomStringUtils.randomNumeric(3)
		WebUI.setText(findTestObject('FDR-VoucherEntry/VoucherEntryObjects/inputInvoiceDescription'), invoicetype)
	}

	public static void editDistributionLineInfo(waiverType, waiverName, fundingSource, serviceCategory) {
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)
		WebUI.mouseOver(findTestObject('FDR-EditVoucher/DLHover'))
		WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/DLEditIcon'), 5)
		WebUI.click(findTestObject('FDR-EditVoucher/DLEditIcon'))
		WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/DLEditClick'), 6)
		WebUI.click(findTestObject('FDR-EditVoucher/DLEditClick'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 6)
		WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'), waiverName)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'), 6)
		WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'), fundingSource)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'), 5)
		WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'), serviceCategory)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/DistributionLine/amount'), 2)
		WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/amount'))
		Uifunctions.clearElementText(findTestObject('FDR-VoucherEntry/DistributionLine/amount'))
		WebElement element = WebUiCommonHelper.findWebElement(findTestObject('FDR-VoucherEntry/DistributionLine/amount'),30)
		element.clear()
		element.sendKeys("\$325")
	}
	public static void createReceipt(Drawdate, Paydate, Depositid, Receiptnotes,remittance = '', controller = '') {
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)
		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Dashboard/createNew_ReceiptBatch_Button'), 3)
		WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Dashboard/createNew_ReceiptBatch_Button'))
		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/inputDrawDate'), 6)
		if(Drawdate==null)
		{
			ChangeDrawDate.DrawDate()			

		}
		else{
			WebUI.setText(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/inputDrawDate'), Drawdate )
			WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/inputDrawDate'), Keys.chord(Keys.TAB, Keys.ENTER, Keys.ENTER))
			WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/payDate'), 3)
			WebUI.setText(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/payDate'), Paydate)
		}		
		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/deposit ID'), 10)
		WebUI.setText(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/deposit ID'), Depositid )
		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/receiptNotes'), 10)
		WebUI.setText(findTestObject('FDR-Receipt/FDR-ReceiptBatch/receiptNotes'), Receiptnotes )
		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/remmitanceAdviceInput'), 5)
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/remmitanceAdviceInput'), remittance )
		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/controllerReceiptInput'), 5)
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/controllerReceiptInput'), controller )
		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/buttonNext'), 5)
		WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/buttonNext'))
		WebUI.delay(5)
		ChangeDrawDate.GlobalDrawDate=WebUI.getText(findTestObject('Object Repository/FDR-VoucherEntry/VoucherHeader/drawDate'))
		//println "Draw Date"+ChangeDrawDate.GlobalDrawDate
		
	}
	public static void createReceiptline(ReceiptID,SupplierID,DepositDate ) {
		def dd = new Date().plus(2)
		def depositdate = dd.format('MM/dd/yyyy')
		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/receipt_ID'), 10)
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/receipt_ID'), ReceiptID )
		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/supplier_Id'), 10)
		WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/supplier_Id'))
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/supplier_Id'), SupplierID )
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/supplier_Id'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/deposit_Date'), 10)
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/deposit_Date'), DepositDate)
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)
		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/addReceipt_Button2'), 10)
		WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/addReceipt_Button2'))
	}
	public static void addRemmitanceAdviceAndControllerReceiptOnReceiptHeader(RA, CR, Drawdate, Paydate) {
		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/3dots_icon'), 2)
		WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/3dots_icon'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/edit-Icon'), FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/remmitanceAdviceInput'), 10)
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/remmitanceAdviceInput'), RA)
		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/controllerReceiptInput'), 2)
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/controllerReceiptInput'), CR)
		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/inputDrawDate'), 2)
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/inputDrawDate'),
		Keys.chord(Keys.TAB, Keys.SHIFT, Keys.TAB, Keys.BACK_SPACE) + Drawdate + Keys.chord(Keys.TAB))
		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/payDate'), 2)
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/payDate'),
		Keys.chord(Keys.TAB, Keys.SHIFT, Keys.TAB, Keys.BACK_SPACE) + Paydate + Keys.chord(Keys.TAB))
		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/next_Button'), 10)
		WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Header/Edit/next_Button'))
	}
	public static void createReceiptDistributionLine(servicedatefrom, servicedateto, amount, waivertype,
	waivername, fundingsource, fundcode, fundratio, nonFederalFund, servicelocation, index, programtype, servicecategory,
	increaseDecreaseLine, accountId, altAccountId){

		def searchfield = 'MC'
		WebUI.delay(10)
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

		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/serviceLocation'),10)
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/serviceLocation'),servicelocation)
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/serviceLocation'),Keys.chord(Keys.DOWN, Keys.ENTER))
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
	}


	public static void createReceiptMultipleDistributionLine(servicedatefrom, servicedateto, amount, waivertype,
	waivername, fundingsource, fundcode, fundratio, nonFederalFund, index, programtype, servicecategory,
	increaseDecreaseLine, accountId, altAccountId, invoiceNum, manual){
		WebUI.delay(5)
		//WebUI.click(findTestObject('Object Repository/FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'))
		WebUI.verifyElementClickable(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/arrow_Down'),FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(5)
	    WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/arrow_Down'),FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_Add-Invoiceline'),10)
		WebUI.scrollToElement(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_Add-Invoiceline'),3)
		WebUI.verifyElementClickable(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_Add-Invoiceline'),FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/button_Add-Invoiceline'), FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/invoice_Searchfield'),10)


		if(manual == 'Y'){

			WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/invoice_Searchfield'),invoiceNum)
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
			WebUI.delay(5)
			WebUI.verifyElementClickable(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/arrow_Down'),FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(5)
			WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/arrow_Down'),FailureHandling.STOP_ON_FAILURE)
		}

		else{
			WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/invoice_Searchfield'),invoiceNum)
			WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/invoice_Searchfield'),Keys.chord(Keys.ARROW_DOWN, Keys.ENTER))
			WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-EndToEnd-Regression/invoiceNumbersDropdownChecklist'), 3)
			WebUI.click(findTestObject('Object Repository/FDR-Receipt/FDR-EndToEnd-Regression/invoiceNumbersDropdownChecklist'))
			WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-EndToEnd-Regression/amountInputTxt'),3)
			WebUI.setText(findTestObject('Object Repository/FDR-Receipt/FDR-EndToEnd-Regression/amountInputTxt'), amount)
			WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-EndToEnd-Regression/saveAndCloseBtn'), 3)
			WebUI.click(findTestObject('Object Repository/FDR-Receipt/FDR-EndToEnd-Regression/saveAndCloseBtn'))
			//WebUI.delay(5)
			//WebUI.verifyElementClickable(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/arrow_Down'),FailureHandling.STOP_ON_FAILURE)
			//WebUI.delay(5)
			//WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/arrow_Down'),FailureHandling.STOP_ON_FAILURE)
		}
	}
}
