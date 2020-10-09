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

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/SysAdmin-Dashboard/maintainReferenceDataBtn'))

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/reference-data'))

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), 'Service Categories')

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/serviceCategoryReference/serviceCategoryDetail/serviceCategory'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/serviceCategoryReference/serviceCategoryDetail/addServiceCategoryBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/serviceCategoryReference/serviceCategoryDetail/addServiceCategoryBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/serviceCategoryReference/serviceCategoryDetail/newServiceCategoryHeader'), 3)

def lineNumber = org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(5)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/serviceCategoryReference/serviceCategoryDetail/lineNumberInputTxt'), 3)

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/serviceCategoryReference/serviceCategoryDetail/lineNumberInputTxt'), lineNumber)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/serviceCategoryReference/serviceCategoryDetail/confirmAddServiceCategoryBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/serviceCategoryReference/serviceCategoryDetail/confirmAddServiceCategoryBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/serviceCategoryReference/serviceCategoryDetail/backToServiceCategory'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/serviceCategoryReference/serviceCategoryDetail/backToServiceCategory'))


