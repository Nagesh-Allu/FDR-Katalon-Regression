import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/SysAdmin-Dashboard/maintainReferenceDataBtn'))

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/reference-data'))

WebUI.setText(findTestObject('FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), 'invoice type')

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/invoiceTypeReference/invoiceTypeDetail/invoiceType'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-InvoiceType/addInvoiceTypeBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-InvoiceType/addInvoiceTypeBtn'))

def invoiceCode = org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10)

def invoiceName = org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(10)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-InvoiceType/invoiceCode'), 3)

WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-InvoiceType/invoiceCode'), invoiceCode)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-InvoiceType/invoiceName'), 3)

WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-InvoiceType/invoiceName'), invoiceName)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-InvoiceType/confirmInvoiceTypeBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-InvoiceType/confirmInvoiceTypeBtn'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-InvoiceType/invoiceTypeHeader'), 3)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-InvoiceType/backToInvoiceTypes'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-InvoiceType/backToInvoiceTypes'))

if (WebUI.verifyElementPresent(findTestObject('FDR-System-Admin/FDR-ReferencePage/firstRowOfRefData'), 2)) {
	WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/firstRowOfRefData'))
	WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-InvoiceType/invoiceTypeHeader'), 3)
	String label = WebUI.getText(findTestObject('FDR-System-Admin/FDR-ReferencePage/invoiceTypeReference/invoiceTypeDetail/invoiceName'))
	assert label == 'INVOICE NAME'
	
}

