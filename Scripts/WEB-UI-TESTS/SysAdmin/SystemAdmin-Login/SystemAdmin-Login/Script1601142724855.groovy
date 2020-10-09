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

WebUI.openBrowser(GlobalVariable.URL)
WebUI.maximizeWindow()
WebUI.refresh()
WebUI.delay(2)
WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/SysAdmin-SignIn/adminEmail'), 5)
WebUI.setText(findTestObject('FDR-System-Admin/SysAdmin-SignIn/adminEmail'), GlobalVariable.adminEmail)
WebUI.waitForElementPresent(findTestObject('FDR-SignIn/SignInEmailNext'), 2)
WebUI.click(findTestObject('Object Repository/FDR-SignIn/SignInEmailNext'))
WebUI.waitForElementPresent(findTestObject('FDR-System-Admin/SysAdmin-SignIn/adminUserName'), 5)
WebUI.setText(findTestObject('FDR-System-Admin/SysAdmin-SignIn/adminUserName'), GlobalVariable.UserName)
WebUI.setText(findTestObject('FDR-System-Admin/SysAdmin-SignIn/adminPass'), GlobalVariable.Password)
WebUI.click(findTestObject('FDR-System-Admin/SysAdmin-SignIn/adminSignIn'))
WebUI.waitForElementPresent(findTestObject('Object Repository/FDR-System-Admin/SysAdmin-Dashboard/maintainReferenceDataBtn'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/FDR-System-Admin/SysAdmin-Dashboard/maintainReferenceDataBtn'), GlobalVariable.Timeout)

WebUI.refresh()
