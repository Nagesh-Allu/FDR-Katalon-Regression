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

WebUI.setText(findTestObject('FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), 'alt account')

WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/altAccountReference/altAccountReview/altAccount'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/addAltAccountBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/addAltAccountBtn'))

def altAccountCode = org.apache.commons.lang.RandomStringUtils.randomNumeric(10)

def altAccountName = org.apache.commons.lang.RandomStringUtils.randomAlphabetic(10)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/altAccountCode'), 3)

WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/altAccountCode'), altAccountCode)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/altAccountName'), 3)

WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/altAccountName'), altAccountName)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/accountName'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/accountName'))

WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/accountName'), 'Grants and Subdivisions - Governmental')

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-AltAccount/accountNameOption'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-AltAccount/accountNameOption'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-AltAccount/altAccountCancelBtn'), 5)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/confirmAltAccountBtn'), 5)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/confirmAltAccountBtn'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-AltAccount/editAltAccountElispsis'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-AltAccount/editAltAccountElispsis'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-AltAccount/editAltAccountBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-AltAccount/editAltAccountBtn'))

def editAltAccountCode = org.apache.commons.lang.RandomStringUtils.randomNumeric(10)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/altAccountCode'), 3)

WebUI.doubleClick(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/altAccountCode'))

WebUI.sendKeys(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/altAccountCode'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/altAccountCode'), editAltAccountCode)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Edit-AltAccount/saveAltAccountBtn'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Edit-AltAccount/saveAltAccountBtn'))

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/altAccountHeader'), 3)

WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/backToAltAccounts'), 3)

WebUI.click(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/backToAltAccounts'))

if (WebUI.verifyElementPresent(findTestObject('FDR-System-Admin/FDR-ReferencePage/firstRowOfRefData'), 2)) {
    WebUI.click(findTestObject('FDR-System-Admin/FDR-ReferencePage/firstRowOfRefData'))
	WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/FDR-Add-AltAccount/altAccountHeader'), 3)
    String label = WebUI.getText(findTestObject('FDR-System-Admin/FDR-ReferencePage/altAccountReference/altAccountReview/altAccountCode'))
    assert label == 'ALT ACCOUNT CODE'
    
}


