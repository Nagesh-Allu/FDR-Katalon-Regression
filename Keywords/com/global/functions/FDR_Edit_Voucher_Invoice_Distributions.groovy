/* Functions to EditVoucher,Invoice and Distribution line functions.
 * Author : Nagesh Allu
 * Creation Date: 10/25/2020
 * Revision History:
 */

package com.global.functions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testdata.ExcelData as ExcelData

public class Edit_Voucher_Invoice_DistributionLines {

	public static void EditVoucher() {
		ExcelData voucherData = findTestData('End_2_End/End_2_End_Voucher')
		voucherData.changeSheet("EditVoucher")
		//	//List of data Elements-supplierID,seqNum,contractNum,vendorMessage
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/supplierID'), 5)
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/supplierID'))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/supplierID'), 5)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/supplierID'),voucherData.getValue('supplierID',1) + '\n')
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/supplierID'), Keys.chord(Keys.DOWN, Keys.ENTER))

		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/seqNum'), 4)
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/seqNum'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/seqNum'), voucherData.getValue('seqNum',1) + '\n')
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/seqNum'), Keys.chord(Keys.DOWN, Keys.ENTER))

		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/contractNum'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/contractNum'), voucherData.getValue('contractNum',1) + '\n')
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/contractNum'), Keys.chord(Keys.DOWN, Keys.ENTER))

		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/vendorMessage'), 3)
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/vendorMessage'))
		WebUI.clearText(findTestObject('FDR-VoucherEntry/Voucher/vendorMessage'))
		WebUI.setText(findTestObject('FDR-VoucherEntry/Voucher/vendorMessage'), '---Update voucher')

		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/buttonNext'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)

	}

	public static void EditInvoice() {
		//	//List of data Elements-inputInvoiceDescription,invoiceDate,originalWarrantDate

		ExcelData voucherData = findTestData('End_2_End/End_2_End_Voucher')
		voucherData.changeSheet("Editinvoice")

		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherEntryObjects/inputInvoiceDescription'), 3)
		WebUI.click(findTestObject('FDR-VoucherEntry/VoucherEntryObjects/inputInvoiceDescription'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/VoucherEntryObjects/inputInvoiceDescription'), Keys.chord(Keys.CONTROL,'a'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/VoucherEntryObjects/inputInvoiceDescription'), Keys.chord(Keys.BACK_SPACE))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
		int Vrandom=new Random().nextInt(900000)+100000
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/VoucherEntryObjects/inputInvoiceDescription'),'INC-'+Vrandom)
		WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceDate'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceDate'), Keys.chord(Keys.CONTROL,'a'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceDate'), Keys.chord(Keys.BACK_SPACE))
		WebUI.setText(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceDate'),voucherData.getValue('invoiceDate',1))
		WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/originalWarrantDate'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/InvoiceLine/originalWarrantDate'), Keys.chord(Keys.CONTROL,'a'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/InvoiceLine/originalWarrantDate'), Keys.chord(Keys.BACK_SPACE))
		WebUI.setText(findTestObject('FDR-VoucherEntry/InvoiceLine/originalWarrantDate'),voucherData.getValue('originalWarrantDate',1))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'),2)
		WebUI.click(findTestObject('Object Repository/FDR-EditVoucher/dlSaveButton'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
	}
	public static void EditDistribution()
	//List of data Elements- amount,waiverName,fundingSource,serviceCategory
	{
		ExcelData voucherData = findTestData('End_2_End/End_2_End_Voucher')
		voucherData.changeSheet("EditDistribution")

		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/DistributionLine/amount'), 2)
		WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/amount'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/amount'), Keys.chord(Keys.CONTROL,'a'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/amount'), Keys.chord(Keys.BACK_SPACE))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/amount'),voucherData.getValue('amount',1))

		WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'), voucherData.getValue('waiverName',1))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'), 6)
		WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'), voucherData.getValue('fundingSource',1))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'), Keys.chord(Keys.DOWN, Keys.ENTER))

		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'), 5)
		WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'), voucherData.getValue('serviceCategory',1))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/FDR-EditVoucher/dlSaveButton'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
	}

}

