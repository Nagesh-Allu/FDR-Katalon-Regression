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
import org.openqa.selenium.Keys as Keys

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/SysAdmin-Dashboard/maintainReferenceDataBtn'))

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), '')

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataDropdown'))

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/waiverTypes'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverTypes/addWaiverTypeBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverTypes/addWaiverTypeBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverTypes/newWaiverTypeHeader'), 3)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverTypes/waiverTypeInputText'), 3)

def waiverType = org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(6).toUpperCase()

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverTypes/waiverTypeInputText'), waiverType)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverTypes/waiverTypeConfirmBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverTypes/waiverTypeConfirmBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverTypes/waiverTypeHeader'), 3)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-WaiverType/waiverTypeElipsisBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-WaiverType/waiverTypeElipsisBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-WaiverType/waiverTypeEditBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-WaiverType/waiverTypeEditBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverTypes/waiverTypeInputText'), 3)

def editWaiverType = org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(6).toUpperCase()

WebUI.doubleClick(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverTypes/waiverTypeInputText'))

WebUI.sendKeys(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverTypes/waiverTypeInputText'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverTypes/waiverTypeInputText'), editWaiverType)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-WaiverType/waiverTypeSaveBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-WaiverType/waiverTypeSaveBtn'))














