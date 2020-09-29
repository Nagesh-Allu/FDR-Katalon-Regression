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
import com.functions.validators as validators

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/Filters/clearFilterButton'), 4)

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)

WebUI.click(findTestObject('FDR-Dashboard/Filters/clearFilterButton'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)

WebUI.click(findTestObject('FDR-Dashboard/Filters/resumeFilterButton'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2) 

assert validators.validateVoucherLabelAndTag('Resume') == true
//Not Required-- WebUI.click(findTestObject('FDR-Dashboard/Filters/clearFilterButton'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)

WebUI.click(findTestObject('FDR-Dashboard/Filters/fixFilterButton'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)

assert validators.validateVoucherLabelAndTag('Fix') == true

WebUI.click(findTestObject('FDR-Dashboard/Filters/clearFilterButton'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)

WebUI.click(findTestObject('FDR-Dashboard/Filters/printFilterButton'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)

assert validators.validateVoucherLabelAndTag('Print') == true

WebUI.click(findTestObject('FDR-Dashboard/Filters/clearFilterButton'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)

WebUI.click(findTestObject('FDR-Dashboard/Filters/validateFilterButton'))

WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)

assert validators.validateVoucherLabelAndTag('Validate') == true

















