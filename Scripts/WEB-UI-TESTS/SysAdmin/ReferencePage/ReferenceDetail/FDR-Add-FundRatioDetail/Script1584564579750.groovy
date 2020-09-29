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

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/reference-data'))

WebUI.setText(findTestObject('FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), 'fund ratio')

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/fundRatioReference/fundRatioDetail/fundRatio'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-FundRatio/addFundRatioBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-FundRatio/addFundRatioBtn'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-FundRatio/federalPercent'), 3)

WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-FundRatio/federalPercent'), '100')

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-FundRatio/nonFederalPercent'), 3)

WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-FundRatio/nonFederalPercent'), '0')

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-FundRatio/fundRatioCancelBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-FundRatio/fundRatioCancelBtn'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-FundRatios/firstRowofFundRatio'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-FundRatios/firstRowofFundRatio'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-FundRatios/fundRatioHeader'), 3)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-FundRatios/fundRatioEditElipsisBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-FundRatios/fundRatioEditElipsisBtn'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-FundRatios/fundRatioEditBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-FundRatios/fundRatioEditBtn'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-FundRatios/editFundRatioLabel'), 3)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-FundRatios/saveFundRatioBtn'), 3)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-FundRatios/backToFundRatios'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-FundRatios/backToFundRatios'))

if (WebUI.verifyElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-FundRatios/firstRowofFundRatio'), 2)) {
	WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-FundRatios/firstRowofFundRatio'))
	WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-FundRatios/fundRatioHeader'), 3)
	String label = WebUI.getText(findTestObject('FDR-System-Admin/FDR-ReferencePage/fundRatioReference/fundRatioDetail/federalPercentage'))
	assert label == 'FEDERAL %'
	
	label = WebUI.getText(findTestObject('FDR-System-Admin/FDR-ReferencePage/fundRatioReference/fundRatioDetail/nonFederalPercentage'))
	assert label == 'NON-FEDERAL %'
	
}

