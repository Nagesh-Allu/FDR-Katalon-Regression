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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/searchBar'), 3)

WebUI.click(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/searchBar'))

WebUI.setText(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/searchBar'), depositId)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/noMatchingTasks'), 2, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/searchBar'), "")

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/searchBar'), 3)

WebUI.click(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/searchBar'))

WebUI.setText(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/searchBar'), drawDate)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/noMatchingTasks'), 2, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/searchBar'), "")

WebUI.refresh()

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/searchBar'), 3)

WebUI.click(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/searchBar'))

WebUI.setText(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/searchBar'), payDate)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/noMatchingTasks'), 2, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/searchBar'), "")

WebUI.refresh()

WebUI.click(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/searchBar'))

WebUI.setText(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/searchBar'), 'resume')

WebUI.delay(4)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/noMatchingTasks'), 2, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/searchBar'), "")

WebUI.refresh()

WebUI.click(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/searchBar'))

WebUI.setText(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/searchBar'), 'fix')

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/noMatchingTasks'), 2, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/searchBar'), "")

WebUI.refresh()

WebUI.click(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/buttonResume'))

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/resumeBatch'), 2, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/FDR-Receipt/FDR-Search-Receipt/resumeBatch'))

WebUI.delay(10)

WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-Receipt/FDR-ReceiptBatch/Fix/reviewButton'), 2, FailureHandling.STOP_ON_FAILURE)



