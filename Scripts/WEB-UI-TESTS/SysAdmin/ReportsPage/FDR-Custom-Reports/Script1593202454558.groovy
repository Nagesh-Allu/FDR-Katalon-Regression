import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Reports/FDR-Report-Dashboard/mbesReportBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Reports/FDR-Report-Dashboard/reportBtn'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Reports/FDR-Report-Dashboard/mbesReportBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Reports/FDR-Custom-Reports/customReports'))

WebUI.verifyElementPresent(findTestObject('FDR-System-Admin/FDR-Reports/FDR-Custom-Reports/auditReportsSubText'), 2)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Reports/FDR-Custom-Reports/auditReports'))

//WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Reports/FDR-Report-Dashboard/mbesReportBtn'), 3)

WebUI.verifyElementPresent(findTestObject('FDR-System-Admin/FDR-Reports/FDR-Custom-Reports/voucherHistoryReportSubText'), 2)

//WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Reports/FDR-Report-Dashboard/mbesReportBtn'), 3)

//WebUI.click(findTestObject('FDR-System-Admin/FDR-Reports/FDR-Custom-Reports/auditReports'))
//
//WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Reports/FDR-Report-Dashboard/mbesReportBtn'), 3)

WebUI.verifyElementPresent(findTestObject('FDR-System-Admin/FDR-Reports/FDR-Custom-Reports/receiptHistoryReportSubText'), 2)

//WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Reports/FDR-Report-Dashboard/mbesReportBtn'), 3)
//
//WebUI.click(findTestObject('FDR-System-Admin/FDR-Reports/FDR-Custom-Reports/receiptHistoryReport'))
//
//WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Reports/FDR-Report-Dashboard/mbesReportBtn'), 3)

