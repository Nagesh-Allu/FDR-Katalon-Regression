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

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), '')

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/serviceCategory'))


WebUI.click(findTestObject('FDR-System-Admin/AddReference/ServiceCategoryAdd/addServiceCategoryBtn'))

String lineNumber = '1234'

WebUI.setText(findTestObject('FDR-System-Admin/AddReference/ServiceCategoryAdd/lineNumberInput'), 
    lineNumber)

String description = 'test service category automation'

WebUI.setText(findTestObject('FDR-System-Admin/AddReference/ServiceCategoryAdd/serviceCategoryDescription'), description)

WebUI.click(findTestObject('FDR-System-Admin/AddReference/ServiceCategoryAdd/requiresFeederForm'))

WebUI.click(findTestObject('FDR-System-Admin/AddReference/ServiceCategoryAdd/submitServiceCategoryBtn'))

WebUI.delay(6)

String breadCumbLabel = WebUI.getText(findTestObject('FDR-System-Admin/AddReference/ServiceCategoryAdd/breadCrumb'))
assert breadCumbLabel.equals(lineNumber)


String header =  WebUI.getText(findTestObject('FDR-System-Admin/AddReference/ServiceCategoryAdd/serviceCategoryHeader'))
assert header.equals(lineNumber)

String viewDescription = WebUI.getText(findTestObject('FDR-System-Admin/AddReference/ServiceCategoryAdd/viewDescription'))
assert viewDescription.equals(description)

String feederFormValue = WebUI.getText(findTestObject('FDR-System-Admin/AddReference/ServiceCategoryAdd/feederFormValue'))
assert "Yes".equals(feederFormValue)
