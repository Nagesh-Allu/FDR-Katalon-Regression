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

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), 'fund')

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/fundReference/fundDetail/fund'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Funds/addFundBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Funds/addFundBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Funds/newFundHeaderLabel'), 3)

def code = org.apache.commons.lang.RandomStringUtils.randomNumeric(7)

def fundName = org.apache.commons.lang.RandomStringUtils.randomAlphabetic(10)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Funds/fundCode'), 3)

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Funds/fundCode'), code)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Funds/fundName'), 3)

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Funds/fundName'), fundName)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Funds/addFundConfirmBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Funds/addFundConfirmBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Funds/fundHeader'), 3)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-Fund/fundElipsisBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-Fund/fundElipsisBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-Fund/fundEditBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-Fund/fundEditBtn'))

def editFundName = org.apache.commons.lang.RandomStringUtils.randomAlphabetic(10)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Funds/fundName'), 3)

WebUI.doubleClick(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Funds/fundName'))

WebUI.sendKeys(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Funds/fundName'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Funds/fundName'), editFundName)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-Fund/fundSaveBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-Fund/fundSaveBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Funds/fundHeader'), 3)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Funds/backToFunds'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Funds/backToFunds'))




