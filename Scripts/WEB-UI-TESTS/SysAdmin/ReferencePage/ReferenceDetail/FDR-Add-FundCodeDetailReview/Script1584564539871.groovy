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

import org.junit.After
import org.openqa.selenium.Keys as Keys

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/SysAdmin-Dashboard/maintainReferenceDataBtn'))

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/reference-data'))

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), 'fund Code')

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/fundCodeReference/fundCodeDetail/fundCode'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/addFundCodeBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/addFundCodeBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/newFundCodeHeader'), 3)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/fundCodeText'), 3)

def fundCode = org.apache.commons.lang.RandomStringUtils.randomNumeric(5)

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/fundCodeText'), fundCode)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/fundCodeNameText'), 3)

def fundCodeName = org.apache.commons.lang.RandomStringUtils.randomAlphabetic(5).toUpperCase()

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/fundCodeNameText'), 'Health '+fundCodeName+' Fund')

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/accountDropdown'), 3)

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/accountDropdown'), 'Grants and Subdivisions - Governmental')

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/accountOption'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/accountOption'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/reportingStructureText'), 3)

def reportingStructure1 = org.apache.commons.lang.RandomStringUtils.randomAlphabetic(2).toUpperCase()

def reportingStructure2 = org.apache.commons.lang.RandomStringUtils.randomNumeric(1)

def reportingStructure3 = org.apache.commons.lang.RandomStringUtils.randomAlphabetic(1).toUpperCase()

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/reportingStructureText'), '4260'+reportingStructure1+reportingStructure2+reportingStructure3)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/chapterAdvancesText'), 3)

def chapterAdvances = org.apache.commons.lang.RandomStringUtils.randomNumeric(4).toString()

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/chapterAdvancesText'), chapterAdvances)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/enactmentYearText'), 3)

def enactmentYear = org.apache.commons.lang.RandomStringUtils.randomNumeric(2)

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/enactmentYearText'), '19'+enactmentYear)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/confirmAddFundCodeBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/confirmAddFundCodeBtn'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-ReferencePage/fundCodeReference/fundCodeDetail/fundCodeHeader'), 3)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-FundCode/fundCodeElipsisBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-FundCode/fundCodeElipsisBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-FundCode/fundCodeEditBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-FundCode/fundCodeEditBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/fundCodeNameText'), 3)

WebUI.doubleClick(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/fundCodeNameText'))

WebUI.sendKeys(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/fundCodeNameText'), Keys.chord(Keys.BACK_SPACE))

def editFundCodeName = org.apache.commons.lang.RandomStringUtils.randomAlphabetic(5).toUpperCase()

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/fundCodeNameText'), 'Health '+editFundCodeName+' Fund')

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-FundCode/fundCodeSaveBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-FundCode/fundCodeSaveBtn'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-ReferencePage/fundCodeReference/fundCodeDetail/fundCodeHeader'), 3)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/backToFundCode'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundCode/backToFundCode'))

if(WebUI.verifyElementPresent(findTestObject('FDR-System-Admin/FDR-ReferencePage/firstRowOfRefData'), 2)) {
	WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/firstRowOfRefData'))
	WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-ReferencePage/fundCodeReference/fundCodeDetail/fundCodeHeader'), 3)
	String label = WebUI.getText(findTestObject('FDR-System-Admin/FDR-ReferencePage/fundCodeReference/fundCodeDetail/fundCodeName'))
	assert label == 'CODE'
	
}

