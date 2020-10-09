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

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/reference-data'))

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/account'))

WebUI.setText(findTestObject('FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), '')

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataDropdown'))

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/altAccount'))

WebUI.setText(findTestObject('FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), '')

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataDropdown'))

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/contact'))

WebUI.setText(findTestObject('FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), '')

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataDropdown'))

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/contract'))

WebUI.setText(findTestObject('FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), '')

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataDropdown'))

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/fdrAppropriationReference'))

WebUI.setText(findTestObject('FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), '')

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataDropdown'))

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/fundCode'))

WebUI.setText(findTestObject('FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), '')

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataDropdown'))

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/fund'))

WebUI.setText(findTestObject('FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), '')

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataDropdown'))

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/fundRatio'))

WebUI.setText(findTestObject('FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), '')

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataDropdown'))

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/fundingSource'))

WebUI.setText(findTestObject('FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), '')

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataDropdown'))

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/increaseDecreaseLineNumber'))

WebUI.setText(findTestObject('FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), '')

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataDropdown'))

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/invoiceType'))

WebUI.setText(findTestObject('FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), '')

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataDropdown'))

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/programType'))

WebUI.setText(findTestObject('FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), '')

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataDropdown'))

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/serviceCategory'))

WebUI.setText(findTestObject('FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), '')

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataDropdown'))

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/supplier'))

WebUI.setText(findTestObject('FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), '')

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataDropdown'))

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/waiverName'))

WebUI.setText(findTestObject('FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), '')

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataDropdown'))

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/waiverTypes'))


