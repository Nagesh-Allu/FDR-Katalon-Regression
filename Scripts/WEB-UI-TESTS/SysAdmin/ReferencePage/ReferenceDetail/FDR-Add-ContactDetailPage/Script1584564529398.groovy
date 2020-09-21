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

WebUI.setText(findTestObject('FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), 'Contacts')

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/contactReference/contactDetails/contactClick'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Contact/addContactBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-Contact/addContactBtn'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Contact/firstName'), 3)

String firstName = org.apache.commons.lang.RandomStringUtils.randomAlphabetic(5)

String lastName = org.apache.commons.lang.RandomStringUtils.randomAlphabetic(5)

WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-Contact/firstName'), firstName)

WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-Contact/lastName'), lastName)

def phoneNum = org.apache.commons.lang.RandomStringUtils.randomNumeric(10)

WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-Contact/phoneNum'), phoneNum)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Contact/addContactConfirmBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-Contact/addContactConfirmBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/contactReference/contactDetails/contactPhoneNumber'), 5)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-Contact/editContactElipsis'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-Contact/editContactElipsis'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-Contact/editContactBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-Contact/editContactBtn'))

String editLastName = org.apache.commons.lang.RandomStringUtils.randomAlphabetic(10)

WebUI.doubleClick(findTestObject('FDR-System-Admin/FDR-Add-Contact/lastName'))
	
WebUI.sendKeys(findTestObject('FDR-System-Admin/FDR-Add-Contact/lastName'),Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-Contact/lastName'), editLastName)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-Contact/saveContactBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-Contact/saveContactBtn'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-Contact/editContactHeader'), 3)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-Contact/backtoContactPage'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-Contact/backtoContactPage'))



