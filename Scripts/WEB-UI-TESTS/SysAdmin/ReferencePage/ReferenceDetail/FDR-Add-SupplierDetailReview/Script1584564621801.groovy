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

WebUI.setText(findTestObject('FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), 'supplier')

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/supplierReference/supplierDetail/supplier'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Suppliers/addSupplierBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-Suppliers/addSupplierBtn'))

def supplierCode = org.apache.commons.lang.RandomStringUtils.randomNumeric(10)

String supplierName = org.apache.commons.lang.RandomStringUtils.randomAlphabetic(10)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Suppliers/supplierCode'), 3)

WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-Suppliers/supplierCode'), supplierCode)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Suppliers/supplierName'), 3)

WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-Suppliers/supplierName'), supplierName)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Suppliers/addSupplierConfirmBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-Suppliers/addSupplierConfirmBtn'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-ReferencePage/supplierReference/supplierDetail/supplierHeader'), 3)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-Supplier/editSupplierElipsis'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-Supplier/editSupplierElipsis'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-Supplier/editSupplierBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-Supplier/editSupplierBtn'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-Supplier/editSupplierHeaderLabel'), 3)

def editSupplierCode = org.apache.commons.lang.RandomStringUtils.randomNumeric(10)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Suppliers/supplierCode'), 3)

WebUI.doubleClick(findTestObject('FDR-System-Admin/FDR-Add-Suppliers/supplierCode'))

WebUI.sendKeys(findTestObject('FDR-System-Admin/FDR-Add-Suppliers/supplierCode'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-Suppliers/supplierCode'), editSupplierCode)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-Supplier/saveSupplierBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-Supplier/saveSupplierBtn'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-ReferencePage/supplierReference/supplierDetail/supplierHeader'), 3)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-AddAddress/addAddressBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-AddAddress/addAddressBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-AddAddress/sequenceNum'), 3)

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-AddAddress/sequenceNum'), SequenceNum)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-AddAddress/addressLine'), 3)

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-AddAddress/addressLine'), AddressLine)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-AddAddress/cityName'), 3)

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-AddAddress/cityName'), City)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-AddAddress/stateName'), 3)

WebUI.sendKeys(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-AddAddress/stateName'), State+ Keys.chord(Keys.ARROW_DOWN)+ Keys.chord(Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-AddAddress/zipCode'), 3)

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-AddAddress/zipCode'), ZipCode)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-AddAddress/addAddressConfirmBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-AddAddress/addAddressConfirmBtn'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-ReferencePage/supplierReference/supplierDetail/supplierHeader'), 3)

WebUI.refresh()

WebUI.delay(3)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-Address-DetailsPage/addressDetailsBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-Address-DetailsPage/addressDetailsBtn'))

String cityLabel = WebUI.getText(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-Address-DetailsPage/cityLabel'))

String stateLabel = WebUI.getText(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-Address-DetailsPage/stateLabel'))

String zipCodeLabel = WebUI.getText(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-Address-DetailsPage/zipcodeLabel'))

assert cityLabel == 'CITY'

assert stateLabel == 'STATE'

assert zipCodeLabel == 'ZIP CODE'

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-Supplier/editSupplierElipsis'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-Supplier/editSupplierElipsis'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-Supplier/editSupplierBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-Supplier/editSupplierBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-EditAddress/editAddressHeader'), 3)

WebUI.doubleClick(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-EditAddress/addressInputField'))

WebUI.sendKeys(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-EditAddress/addressInputField'), Keys.chord(Keys.BACK_SPACE))

def aptNo = org.apache.commons.lang.RandomStringUtils.randomNumeric(3)

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-EditAddress/addressInputField'), aptNo)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-EditAddress/saveAddressBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-EditAddress/saveAddressBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-Suppliers/FDR-EditAddress/addressDetailsHeader'), 3)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Suppliers/backToSuppliersPage'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-Suppliers/backToSuppliersPage'))

if (WebUI.verifyElementPresent(findTestObject('FDR-System-Admin/FDR-ReferencePage/firstRowOfRefData'), 2)) {
	WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/firstRowOfRefData'))
	WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-ReferencePage/supplierReference/supplierDetail/supplierHeader'), 3)
	String label = WebUI.getText(findTestObject('FDR-System-Admin/FDR-ReferencePage/supplierReference/supplierDetail/supplierCodeLabel'))
	assert label == 'SUPPLIER CODE'
}

