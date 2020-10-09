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

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/reference-data'))

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), 'program type')


WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/programTypeReference/programTypeDetail/programType'))


if (WebUI.verifyElementPresent(findTestObject('FDR-System-Admin/FDR-ReferencePage/firstRowOfRefData'), 2)) {
	WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/firstRowOfRefData'))
	WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-ReferencePage/programTypeReference/programTypeDetail/programTypeHeader'), 3)
	String header = WebUI.getText(findTestObject('FDR-System-Admin/FDR-ReferencePage/programTypeReference/programTypeDetail/programTypeHeader'))
	String breadCrumbLabel = WebUI.getText(findTestObject('FDR-System-Admin/FDR-ReferencePage/programTypeReference/programTypeDetail/programTypeBreadCrumb'))

	assert breadCrumbLabel.indexOf(header) >= 0
}

