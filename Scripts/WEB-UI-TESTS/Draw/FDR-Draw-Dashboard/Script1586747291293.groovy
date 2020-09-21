import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.testng.Assert
import com.functions.Uifunctions
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

def data = [('waiverType') : waiverType, ('waiverName') : waiverName
	, ('fundingSource') : fundingSource, ('fundRatio') : fundRatio, ('nonFederalFund') : nonFederalFund, ('account') : account, ('altAccount') : altAccount, ('serviceCategory') : serviceCategory
	, ('incDecLine') : incDecLine, ('index') : index, ('amount') : amount, ('program') : program, ('invoiceType') : invoiceType, ('fundCode') : fundCode
	, ('supplierID') : supplier, ('sequence') : sequence, ('primaryContact') : primaryContact, ('secondaryContact') : secondaryContact, ('contractNum') : contract,('giveFutureDate') : true, ('plusMonths') : 5]

def values = WebUI.callTestCase(findTestCase('WEB-UI-TESTS/Voucher/FDR-Validate-Approve-Modal'), [('data') : data, ('giveFutureDate') : true, ('plusMonths') : 9],
FailureHandling.STOP_ON_FAILURE)


WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

Uifunctions.logoutFDR()

Uifunctions.loginFDR(GlobalVariable.drawCashierAcc6, GlobalVariable.drawCashierAcc6Pwd)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.click(findTestObject('FDR-Draw/reconcileButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)


