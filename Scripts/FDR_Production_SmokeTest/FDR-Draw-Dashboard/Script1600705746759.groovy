import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.testng.Assert
import com.functions.Uifunctions
import com.etoe.commonFunctions as CF
import com.etoe.voucherFunctions as VF
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

CF.login(GlobalVariable.superUserAccnt, GlobalVariable.superUserPwd)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
CF.selectRole('cashManagementApprover')
WebUI.click(findTestObject('FDR-Draw/reconcileButton'))
WebUI.back()
WebUI.click(findTestObject('Object Repository/FDR-Draw/CompletedTabs/completedTab'))

CF.logout()
Uifunctions.logoutFDR()

