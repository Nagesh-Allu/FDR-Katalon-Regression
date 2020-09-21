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

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-ServiceCategory/lineNumber'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-ServiceCategory/lineNumber'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-ServiceCategory/ellipsis'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-ServiceCategory/ellipsis'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-ServiceCategory/editBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-ServiceCategory/editBtn'))

String breadcrumbLabel = WebUI.getText(findTestObject('FDR-System-Admin/FDR-Edit-ServiceCategory/breadcrumbLabel'))

assert breadcrumbLabel == 'Edit Service Category'

def lineNumber = org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(5)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-ServiceCategory/lineNumberText'), 3)

WebUI.doubleClick(findTestObject('FDR-System-Admin/FDR-Edit-ServiceCategory/lineNumberText'))

WebUI.sendKeys(findTestObject('FDR-System-Admin/FDR-Edit-ServiceCategory/lineNumberText'), Keys.chord(Keys.BACK_SPACE))

WebUI.delay(2)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-ServiceCategory/lineNumberText'), 3)

WebUI.setText(findTestObject('FDR-System-Admin/FDR-Edit-ServiceCategory/lineNumberText'), lineNumber)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-ServiceCategory/cancelBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-ServiceCategory/cancelBtn'))


