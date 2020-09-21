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

String taskName = 'Reference Data'

WebUI.verifyElementText(findTestObject('Object Repository/FDR-System-Admin/SysAdmin-Dashboard/maintainReferenceDataTxt'), taskName)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/SysAdmin-Dashboard/maintainReferenceDataBtn'))

WebUI.callTestCase(findTestCase('WEB-UI-TESTS/SysAdmin/SystemAdmin-Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), '')

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/fundRatio'))

String label = WebUI.getText(findTestObject('FDR-System-Admin/FDR-ReferencePage/fundRatioReference/fundRatioTable/FundingRatio'))
assert label == 'Funding Ratio'

label = WebUI.getText(findTestObject('FDR-System-Admin/FDR-ReferencePage/fundRatioReference/fundRatioTable/Federal'))
assert label == 'Federal %'

label = WebUI.getText(findTestObject('FDR-System-Admin/FDR-ReferencePage/fundRatioReference/fundRatioTable/NonFederal'))
assert label == 'Non-Federal %'

label = WebUI.getText(findTestObject('FDR-System-Admin/FDR-ReferencePage/fundRatioReference/fundRatioTable/ServiceCategory'))
assert label == 'Service Category'

WebUI.callTestCase(findTestCase('WEB-UI-TESTS/SysAdmin/ReferencePage/ReferenceTable/Pagination'), [:], FailureHandling.STOP_ON_FAILURE)