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

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), 'Contracts')

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/contractReference/contractDetail/contract'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Contract/addContractBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-Contract/addContractBtn'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Contract/contractNum'), 3)

def contractNum = org.apache.commons.lang.RandomStringUtils.randomNumeric(5)

WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-Contract/contractNum'), "02-"+contractNum)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Contract/supplierDropdown'), 3)

WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-Contract/supplierDropdown'), 'scan health plan\n')

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Contract/supplierOption'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Contract/supplierOption'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Contract/addContractConfirmBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-Contract/addContractConfirmBtn'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-ReferencePage/contractReference/contractDetail/contractHeader'), 3)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-Contract/editContactElipsis'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-Contract/editContactElipsis'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-Contract/editContractBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-Contract/editContractBtn'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-Contract/editContractLable'), 3)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-Contract/saveContractBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-Contract/saveContractBtn'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-ReferencePage/contractReference/contractDetail/contractHeader'), 3)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Contract/backToContractPage'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-Contract/backToContractPage'))

if(WebUI.verifyElementPresent(findTestObject('FDR-System-Admin/FDR-ReferencePage/firstRowOfRefData'), 2)) {
	WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/firstRowOfRefData'))
	WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-ReferencePage/contractReference/contractDetail/contractHeader'), 3)
	String label = WebUI.getText(findTestObject('FDR-System-Admin/FDR-ReferencePage/contractReference/contractDetail/supplier'))
	assert label == 'SUPPLIER'
}

