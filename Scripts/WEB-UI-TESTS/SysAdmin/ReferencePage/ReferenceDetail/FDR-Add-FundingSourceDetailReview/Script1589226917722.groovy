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

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/reference-data'))

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/referenceDataNameInput'), '')

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-ReferencePage/fundingSource'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/fundingSourcesAddBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/fundingSourcesAddBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/newFundingSourceHeader'), 3)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/fundingSourceInputTxt'), 3)

def fundingSource = org.apache.commons.lang.RandomStringUtils.randomAlphabetic(5).toUpperCase()

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/fundingSourceInputTxt'), 'Fund '+fundingSource)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/addFundingSourceConfirmBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/addFundingSourceConfirmBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/fundingSourceHeader'), 3)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-FundingSource/fundingSourceElipsisBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-FundingSource/fundingSourceElipsisBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-FundingSource/fundingSourceEditBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-FundingSource/fundingSourceEditBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/fundingSourceInputTxt'), 3)

def editFundingSource = org.apache.commons.lang.RandomStringUtils.randomAlphabetic(5).toUpperCase()

WebUI.doubleClick(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/fundingSourceInputTxt'))

WebUI.sendKeys(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/fundingSourceInputTxt'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/fundingSourceInputTxt'), 'Fund '+editFundingSource)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-FundingSource/fundingSourceSaveBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Edit-FundingSource/fundingSourceSaveBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/fundingSourceHeader'), 3)

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/FDR-Adding Associations/linkServiceCategoryBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/FDR-Adding Associations/linkServiceCategoryBtn'), FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/FDR-Adding Associations/linkServiceCategoryHeader'), 3, FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/FDR-Adding Associations/linkServiceCategoryDropdown'), 3, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/FDR-Adding Associations/linkServiceCategoryDropdown'), FailureHandling.OPTIONAL)

WebUI.delay(4)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/FDR-Adding Associations/serviceCategoryOption'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/FDR-Adding Associations/serviceCategoryOption'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/FDR-Adding Associations/linkServiceCategoryAddBtn'), 3, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/FDR-Adding Associations/linkServiceCategoryAddBtn'), FailureHandling.OPTIONAL)

WebUI.refresh()

WebUI.delay(3)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/FDR-Adding Associations/deleteLinkServiceCategory'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/FDR-Adding Associations/deleteLinkServiceCategory'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/fundingSourceHeader'), 3)

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/FDR-Adding Associations/linkWaiverTypeBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/FDR-Adding Associations/linkWaiverTypeBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/FDR-Adding Associations/linkWaiverTypeHeader'), 3)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/FDR-Adding Associations/linkWaiverTypeDropdown'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/FDR-Adding Associations/linkWaiverTypeDropdown'))

WebUI.delay(4)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/FDR-Adding Associations/linkWaiverTypeOption'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/FDR-Adding Associations/linkWaiverTypeOption'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/FDR-Adding Associations/linkWaiverTypeAddBtn'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/FDR-Adding Associations/linkWaiverTypeAddBtn'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/fundingSourceHeader'), 3)

WebUI.refresh()

WebUI.delay(3)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/FDR-Adding Associations/deleteLinkWaiverType'), 3)

WebUI.click(findTestObject('Object Repository/FDR-System-Admin/FDR-Add-FundingSource/FDR-Adding Associations/deleteLinkWaiverType'))

