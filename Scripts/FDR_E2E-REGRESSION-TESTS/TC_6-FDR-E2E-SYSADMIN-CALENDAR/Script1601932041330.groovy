 /* Project Name : FDR
 * Test Case #6: As a SysAdmin, validate the Calendar reference data functionality 
 * List of global functions used are:
 * 	  	--> None 
 * Author : Jocelyn Renaud
 * Revision Date: 10/01/2020
 *		NA- Updated OR - gridViewDrawDateLabel ,gridViewPayDateLabel
 *
 *
 */ 

 // List of import packages/libraries
import com.global.functions.voucherFunctions as VF
import com.etoe.commonFunctions as CF
import com.kms.katalon.core.testdata.ExcelData as ExcelData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import internal.GlobalVariable as GlobalVariable

// Execute Login function; set role as SuperUser (Path-->Keywords\com\etoe--commonFunctions)
// Default role is Admin; no need to set account role 
CF.login(GlobalVariable.superUserAccnt, GlobalVariable.superUserPwd)

// As a SysAdmin, application defaults to the Reference Data dashboard - Click on the Calendar icon 
WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/calendarBtn'), 
    3)
String taskName = 'Calendar'
WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/calendarBtnText'), 
    taskName)
WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/calendarBtn'))

// VALIDATE FEDERAL FISCAL YEAR OPTION 
// Navigate to the Calendar dashboard and select the Fiscal Year Option from the drop down menu  
WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/calendarDataTypeDropdown'))
WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/calendarDataTypeDropdown'), 
    '')
WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/federalFiscalYearOption'))
WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-FederalFiscalYear/gridViewFiscalYearLabel'), 
    3)
String fiscalYear = 'Fiscal Year'
WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-FederalFiscalYear/gridViewFiscalYearLabel'), 
    fiscalYear)

// Navigate to the 2020 Federal Fiscal Year page 
WebUI.navigateToUrl('https://fdr-katalon.cammis-mod-dev.dhcs.ca.gov/admin/calendar/federal/2020')

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-FederalFiscalYear/federalFiscalYearHeader'), 
    3)
String quarter1 = 'Quarter 1'
WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-FederalFiscalYear/quarter1-Header'), 
    quarter1)
String quarter2 = 'Quarter 2'
WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-FederalFiscalYear/quarter2-Header'), 
    quarter2)
String quarter3 = 'Quarter 3'
WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-FederalFiscalYear/quarter3-Header'), 
    quarter3)
String quarter4 = 'Quarter 4'
WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-FederalFiscalYear/quarter4-Header'), 
    quarter4)

// Return to Dashboard
WebUI.navigateToUrl('https://fdr-katalon.cammis-mod-dev.dhcs.ca.gov/admin/calendar/')

// VALIDATE STATE FISCAL YEAR OPTION
// Navigate to the Calendar dashboard and select the State Year Option from the drop down menu
WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/calendarDataTypeDropdown'), 
    '')
WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/calendarDropdown'))
WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/stateFiscalYearOption'))
WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-StateFiscalYear/gridViewFiscalYearLabel'), 
    3)
String stateFiscalYearLabel = 'Fiscal Year'
WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-StateFiscalYear/gridViewFiscalYearLabel'), 
    stateFiscalYearLabel)

// Navigate to the 2020 State Fiscal Year page
WebUI.navigateToUrl('https://fdr-katalon.cammis-mod-dev.dhcs.ca.gov/admin/calendar/state/2020')

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-StateFiscalYear/stateFiscalYearHeader'), 
    3)
WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-StateFiscalYear/quarter1-Header'), 
    3)
WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-StateFiscalYear/quarter1-Header'), 
    quarter1)
WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-StateFiscalYear/quarter2-header'), 
    quarter2)
WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-StateFiscalYear/quarter3-Header'), 
    quarter3)
WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-StateFiscalYear/quarter4-Header'), 
    quarter4)

// Return to Dashboard
WebUI.navigateToUrl('https://fdr-katalon.cammis-mod-dev.dhcs.ca.gov/admin/calendar/')

// VALIDATE DRAW DATE OPTION
// Navigate to the Calendar dashboard and select the Draw Date Option from the drop down menu
WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/calendarDataTypeDropdown'))
WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/calendarDataTypeDropdown'), 
    '')
WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-Dashboard/drawDateOption'))
WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-DrawDate/gridViewDrawDateLabel'), 
    3)
String drawDateLabel = 'Draw Date'
WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-DrawDate/gridViewDrawDateLabel'), 
    drawDateLabel)
WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-DrawDate/gridViewPayDateLabel'), 
    3)
String payDateLabel = 'Pay Date'
WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/FDR-Calendar/FDR-Calendar-DrawDate/gridViewPayDateLabel'), 
    payDateLabel)

// Call Logout function (Location path -->Keywords\com\etoe--commonFunctions)
CF.logout()