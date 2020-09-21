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
import internal.GlobalVariable as GlobalVariable

WebUI.maximizeWindow()

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-Report-Dashboard/reportBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-Report-Dashboard/reportBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/mbesBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/mbesBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/mbesHeaderLabel'), 0)

String mbesHeaderLabel = WebUI.getText(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/mbesHeaderLabel'))

assert mbesHeaderLabel == 'MBES Reports'

//String monthlyTransactionReports = WebUI.getText(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/monthlyTransactionReportsTxt'))
//
//assert monthlyTransactionReports == 'Monthly Transaction Reports'

//WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/monthlyTransactionReportBtn'), 3)
//
//WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/monthlyTransactionReportBtn'))
//
//WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/monthlyTransactionReportHeader'), 3)
//
//WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/backToMBESReports'), 3)
//
//WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/backToMBESReports'))

//String quarterlyTransactionReports = WebUI.getText(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/quarterlyTransactionReportsTxt'))
//
//assert quarterlyTransactionReports == 'Quarterly Transaction Reports'

//WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/quarterlyTransactionReportsBtn'), 3)
//
//WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/quarterlyTransactionReportsBtn'))
//
//WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/quarterlyTransactionReportHeader'), 3)
//
//WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/backToMBESReports'), 3)
//
//WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/backToMBESReports'))

String NonWaiver_6421U = WebUI.getText(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/64.21U-non-Waiver'))

assert NonWaiver_6421U == '64.21U Non-Waiver'

//WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.21U-NonWaiverBtn'), 3)
//
//WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.21U-NonWaiverBtn'))
//
//WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.21U-NonWaiverHeader'), 3)
//
//WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/backToMBESReports'))

String NonWaiver_21 = WebUI.getText(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/21-Non-Waiver'))

assert NonWaiver_21 == '21 Non-Waiver'

String NonWaiver_21P = WebUI.getText(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/21P-Non-Waiver'))

assert NonWaiver_21P == '21P Non-Waiver'

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-21P-Non-Waiver/21P-Non-Waiver-Btn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-21P-Non-Waiver/21P-Non-Waiver-Btn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-21P-Non-Waiver/21P-Non-Waiver-Header'), 3)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-21P-Non-Waiver/quartersDropdown'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-21P-Non-Waiver/quartersDropdown'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-21P-Non-Waiver/quartersOption'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-21P-Non-Waiver/quartersOption'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-21P-Non-Waiver/lineNumberDropdown'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-21P-Non-Waiver/lineNumberDropdown'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-21P-Non-Waiver/lineNumberOption'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-21P-Non-Waiver/lineNumberOption'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-21P-Non-Waiver/21P-Non-Waiver-Header'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/backToMBESReports'))

String nonWaiver_6421UP = WebUI.getText(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/64.21UP-Non-Waiver'))

assert nonWaiver_6421UP == '64.21UP Non-Waiver'

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.21UP-NonWaiverBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.21UP-NonWaiverBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-64.21UP Non-Waiver/header'), 3)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-64.21UP Non-Waiver/header'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-64.21UP Non-Waiver/quartersDropdown'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-64.21UP Non-Waiver/quartersOption'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-64.21UP Non-Waiver/quartersOption'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-64.21UP Non-Waiver/lineNumberDropdown'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-64.21UP Non-Waiver/lineNumberDropdown'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-64.21UP Non-Waiver/lineNumberOption'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-64.21UP Non-Waiver/lineNumberOption'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.21UP-NonWaiverHeader'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/backToMBESReports'))

String waiver_6421U = WebUI.getText(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/64.21U-Waiver'))

assert waiver_6421U == '64.21U Waiver'

//WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.21U-WaiverBtn'), 3)
//
//WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.21U-WaiverBtn'))
//
//WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.21U-WaiverHeader'), 3)
//
//WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/backToMBESReports'))

String waiver_6421UP = WebUI.getText(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/64.21UP-Waiver'))

assert waiver_6421UP == '64.21UP Waiver'

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.21UP-WaiverBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.21UP-WaiverBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.21UP-WaiverHeader'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/backToMBESReports'))

String nonWaiver_649 = WebUI.getText(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/64.9Non-Waiver'))

assert nonWaiver_649 == '64.9 Non-Waiver'

//WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.9-NonWaiverBtn'), 3)
//
//WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.9-NonWaiverBtn'))
//
//WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.9-NonWaiverHeader'), 3)
//
//WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/backToMBESReports'))

String nonWaiver_649P = WebUI.getText(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/64.9PNon-Waiver'))

assert nonWaiver_649P == '64.9P Non-Waiver'

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.9P-NonWaiverBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.9P-NonWaiverBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.9P-NonWaiverHeader'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/backToMBESReports'))

String waiver_649 = WebUI.getText(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/64.9Waiver'))

assert waiver_649 == '64.9 Waiver'

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.9-WaiverBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.9-WaiverBtn'))

WebUI.delay(2)



WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.9-WaiverHeader'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/backToMBESReports'))

String waiver_649P = WebUI.getText(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/64.9P-Waiver'))

assert waiver_649P == '64.9P Waiver'

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.9P-WaiverBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.9P-WaiverBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.9P-WaiverHeader'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/backToMBESReports'))

String nonWaiver_649VIII = WebUI.getText(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/64.9VIII-Non-Waiver'))

assert nonWaiver_649VIII == '64.9VIII Non-Waiver'

//WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.9VIII-NonWaiverBtn'), 3)
//
//WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.9VIII-NonWaiverBtn'))
//
//WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.9VIII-NonWaiverHeader'), 3)
//
//WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/backToMBESReports'))

String nonWaiver_649VIIIP = WebUI.getText(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/64.9VIIIP-Non-Waiver'))

assert nonWaiver_649VIIIP == '64.9VIIIP Non-Waiver'

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.9VIIIP-NonWaiverBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.9VIIIP-NonWaiverBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.9VIIIP-NonWaiverHeader'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/backToMBESReports'))

String waiver_649VIII = WebUI.getText(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/64.9VIII-Waiver'))

assert waiver_649VIII == '64.9VIII Waiver'

//WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.9VIII-WaiverBtn'), 3)
//
//WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.9VIII-WaiverBtn'))
//
//WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.9VIII-WaiverHeader'), 3)
//
//WebUI.back()

WebUI.refresh()

String waiver_649VIIIP = WebUI.getText(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/64.9VIIIP-Waiver'))

assert waiver_649VIIIP == '64.9VIIIP Waiver'

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.9VIIIP-WaiverBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.9VIIIP-WaiverBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Reports/FDR-MBES-Reports/FDR-ReportBtns/64.9VIIIP-WaiverHeader'), 3)




