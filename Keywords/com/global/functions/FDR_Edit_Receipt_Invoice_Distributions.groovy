/* Functions to Edit Receipt,Invoice and Distribution line functions.
 * Author : Nagesh Allu
 * Creation Date: 10/25/2020
 * Revision History:
 */

package com.global.functions
import com.global.seedDataFunctions.getSeedDataFunctions as SD

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
import com.global.functions.ChangeDrawDate as ChangeDrawDate

public class Edit_Receipt_Invoice_DistributionLines {

	public static void EditRecieptLine() {
		ExcelData ReceiptData = findTestData('End_2_End/End_2_End_Receipt')
		ReceiptData.changeSheet("EditReciept")

		//WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/inputDrawDate'))
		//WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/inputDrawDate'),Keys.chord(Keys.CONTROL,'a'))
		//WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/inputDrawDate'),Keys.chord(Keys.DELETE))
		//WebUI.setText(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/inputDrawDate'),SD.getDrawDate())

		ChangeDrawDate.EditSelectAvailableDate()

		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-ReceiptBatch/receiptNotes'),5)
		WebUI.click(findTestObject('FDR-Receipt/FDR-ReceiptBatch/receiptNotes'))
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-ReceiptBatch/receiptNotes'), Keys.chord(Keys.CONTROL,'a'))
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-ReceiptBatch/receiptNotes'), Keys.chord(Keys.DELETE))
		WebUI.setText(findTestObject('FDR-Receipt/FDR-ReceiptBatch/receiptNotes'),'ReceiptNotes Updated')

		int remittanceNo =new Random().nextInt(900000)+10000
		WebUI.clearText(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/remittanceNo'))
		WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/remittanceNo'))
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/remittanceNo'), Keys.chord(Keys.CONTROL,'a'))
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/remittanceNo'), Keys.chord(Keys.DELETE))
		WebUI.setText(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/remittanceNo'),'RA'+remittanceNo)

		int controllerNo =new Random().nextInt(900000)+10000
		WebUI.clearText(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/controllerNo'))
		WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/controllerNo'))
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/controllerNo'), Keys.chord(Keys.CONTROL,'a'))
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/controllerNo'), Keys.chord(Keys.DELETE))
		WebUI.setText(findTestObject('FDR-Receipt/FDR-Receipt-Header/View/controllerNo'),'CA'+controllerNo)
	}

	public static void EditReceiptInvoice() {
		//	//List of data Elements-inputInvoiceDescription,invoiceDate,originalWarrantDate
		ExcelData ReceiptData = findTestData('End_2_End/End_2_End_Receipt')
		ReceiptData.changeSheet("EditReceiptInvoice")

		int ReceiptID =new Random().nextInt(90000)+1000
		WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/receipt_ID'))
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/receipt_ID'), Keys.chord(Keys.CONTROL,'a'))
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/receipt_ID'), Keys.chord(Keys.DELETE))
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/receipt_ID'), 'RA'+ReceiptID)

		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/supplier_Id'), 5)
		WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/supplier_Id'))
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/supplier_Id'), ReceiptData.getValue('supplier_Id', 1))
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/supplier_Id'), Keys.chord(Keys.DOWN, Keys.ENTER))

		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/deposit_Date'), 5)

		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-Checkline/View/deposit_Date'), ReceiptData.getValue('Deposit_Date',1))

	}

	public static void EditReceiptDistribution()
	//List of data Elements- amount,waiverName,fundingSource,serviceCategory
	{
		ExcelData ReceiptData = findTestData('End_2_End/End_2_End_Voucher')
		ReceiptData.changeSheet("EditDistribution")

		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service date (from)'),5)
		WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service date (from)'))
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service date (from)'), Keys.chord(Keys.CONTROL,'a'))
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service date (from)'), Keys.chord(Keys.DELETE))
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service date (from)'), ReceiptData.getValue('serviceDateFrom', 1))

		WebUI.waitForElementPresent(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service date (to)'),5)
		WebUI.click(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service date (to)'))
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service date (to)'), Keys.chord(Keys.CONTROL,'a'))
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service date (to)'), Keys.chord(Keys.DELETE))
		WebUI.sendKeys(findTestObject('FDR-Receipt/FDR-Receipt-DistributionLine/FDR-AddEdit-DistributionLine/input_Service date (to)'),ReceiptData.getValue('serviceDateTo',1))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 15)
	}

}

