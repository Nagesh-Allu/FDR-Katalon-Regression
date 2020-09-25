import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.etoe.commonFunctions as CF
import com.etoe.voucherFunctions as VF
import com.functions.Uifunctions
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CF.login(GlobalVariable.superUserAccnt, GlobalVariable.superUserPwd)
CF.selectRole('cashManagementApprover')
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
WebUI.click(findTestObject('FDR-Draw/CompletedTabs/completedTab'))
WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/CompletedTabs/drawDate'), 2)
WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/CompletedTabs/drawDateLabel'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/CompletedTabs/depositDate'), 2)
WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/CompletedTabs/depositDateLabel'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/CompletedTabs/transactionRequest1'), 2)
WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/CompletedTabs/transactionRequest1Label1'), 2)
CF.logout()
Uifunctions.logoutFDR()