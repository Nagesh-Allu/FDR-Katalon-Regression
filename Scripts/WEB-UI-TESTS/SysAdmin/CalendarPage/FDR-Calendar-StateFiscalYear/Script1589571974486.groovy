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

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/calendarBtn'), 3)

String taskName = "Calendar"

WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/calendarBtnText'), taskName)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/calendarBtn'))

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/calendarDataTypeDropdown'), '')

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/calendarDropdown'))

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/stateFiscalYearOption'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-StateFiscalYear/gridViewFiscalYearLabel'), 3)

String stateFiscalYearLabel = 'Fiscal Year'

WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-StateFiscalYear/gridViewFiscalYearLabel'), stateFiscalYearLabel)

WebUI.navigateToUrl('https://fdr-katalon.cammis-mod-dev.dhcs.ca.gov/admin/calendar/state/2020')

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-StateFiscalYear/stateFiscalYearHeader'), 3)

WebUI.navigateToUrl('https://fdr-katalon.cammis-mod-dev.dhcs.ca.gov/admin/calendar/state/2020')

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-StateFiscalYear/quarter1-Header'), 3)

String quarter1 = 'Quarter 1'
				   
WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-StateFiscalYear/quarter1-Header'), quarter1)

String quarter2 = 'Quarter 2'

WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-StateFiscalYear/quarter2-header'), quarter2)

String quarter3 = 'Quarter 3'

WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-StateFiscalYear/quarter3-Header'), quarter3)

String quarter4 = 'Quarter 4'

WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-StateFiscalYear/quarter4-Header'), quarter4)