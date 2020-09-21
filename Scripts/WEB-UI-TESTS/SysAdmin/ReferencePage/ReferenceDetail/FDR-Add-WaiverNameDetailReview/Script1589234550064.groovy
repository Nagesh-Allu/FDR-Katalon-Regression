import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.junit.After

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

WebUI.setText(findTestObject('FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), '')

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataDropdown'))

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/waiverName'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverName/addWaiverNameBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverName/addWaiverNameBtn'))

def waiverName = org.apache.commons.lang.RandomStringUtils.randomAlphabetic(5).toUpperCase()

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverName/newWaiverNameHeader'), 3)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverName/waiverNameInputText'), 3)

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverName/waiverNameInputText'), 'A-Family ' + waiverName)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverName/waiverNameConfirmBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverName/waiverNameConfirmBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverName/waiverNameHeader'), 3)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-WaiverName/waiverNameElipsisBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-WaiverName/waiverNameElipsisBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-WaiverName/waiverNameEditBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-WaiverName/waiverNameEditBtn'))

def editWaiverName = org.apache.commons.lang.RandomStringUtils.randomAlphabetic(5).toUpperCase()

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverName/waiverNameInputText'), 3)

WebUI.doubleClick(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverName/waiverNameInputText'))

WebUI.sendKeys(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverName/waiverNameInputText'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverName/waiverNameInputText'), waiverName)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverName/waiverNameSaveBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-WaiverName/waiverNameSaveBtn'))



















