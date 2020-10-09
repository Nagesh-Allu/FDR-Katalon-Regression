import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.junit.After
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.etoe.commonFunctions as CF
import com.etoe.voucherFunctions as VF
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CF.login(GlobalVariable.superUserAccnt, GlobalVariable.superUserPwd)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/calendarBtn'), 3)

String taskName = "Calendar"

WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/calendarBtnText'), taskName)
WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/calendarBtn'))
WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/calendarDataTypeDropdown'))
WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/drawDateOption'))
WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/calendarDropdown'))
WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/federalFiscalYearOption'))
WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/calendarDropdown'))
WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/stateFiscalYearOption'))

CF.logout()