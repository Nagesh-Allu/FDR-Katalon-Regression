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
import com.etoe.commonFunctions as CF
import com.etoe.voucherFunctions as VF
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable


CF.login(GlobalVariable.superUserAccnt, GlobalVariable.superUserPwd)

String taskName = 'Reports'

WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-Report-Dashboard/reportBtnText'), taskName)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-Report-Dashboard/reportBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-Report-Dashboard/reportBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-Report-Dashboard/mbesReportBtn'), 3)

String mbesReportTaskName = 'MBES Reports'

String customReportTaskName = 'Custom Reports'

//String MBESDataExtractTaskName='MBES Data Extract'

WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-Report-Dashboard/mbesReportText'), mbesReportTaskName)

WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-Report-Dashboard/customReportsText'), customReportTaskName)

//WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-Report-Dashboard/MBESDataExtracttext'), MBESDataExtractTaskName)


CF.logout()

