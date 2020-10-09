import com.functions.Uifunctions
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

class VoucherDrawListener {

	List<String> account6TestCases = [
		"Test Cases/WEB-UI-TESTS/Draw/FDR-Voucher-Expenditure-Validation",
		"Test Cases/WEB-UI-TESTS/Draw/FDR-Draw-Tabs",
		"Test Cases/WEB-UI-TESTS/Draw/FDR-Draw-Reject-Vouchers-Receipts",
		"Test Cases/WEB-UI-TESTS/Draw/FDR-Draw-Voucher-Expanding-Collpasing",
		"Test Cases/WEB-UI-TESTS/Draw/FDR-Total-Validations-Receipts-Vouchers",
		"Test Cases/WEB-UI-TESTS/Draw/FDR-Draw-Icons"
	]
	List<String> account2TestCases = [
		"Test Cases/WEB-UI-TESTS/Draw/FDR-Draw-Dashboard",
		"Test Cases/WEB-UI-TESTS/Draw/Receipts Test Data",
		"Test Cases/WEB-UI-TESTS/Draw/FDR-Draw-Voucher-Date-Validation"
	]
	List<String> account4TestCases = [
		"Test Cases/WEB-UI-TESTS/Draw/FDR-Draw-Receipts-Date-Validation"
	]
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def sampleBeforeTestCase(TestCaseContext testCaseContext) {
		String profileName = RunConfiguration.getExecutionProfile();
		def testCaseId = testCaseContext.getTestCaseId()
		switch(profileName) {
			case 'Voucher':
				Uifunctions.loginFDR(GlobalVariable.accountsApproverAcc2, GlobalVariable.accountsApproverAcc2Pwd)
				break
			case 'Draw':
				if(account6TestCases.contains(testCaseId)){
					Uifunctions.loginFDR(GlobalVariable.drawCashierAcc6, GlobalVariable.drawCashierAcc6Pwd)
				} else if (account2TestCases.contains(testCaseId)) {
					Uifunctions.loginFDR(GlobalVariable.accountsApproverAcc2, GlobalVariable.accountsApproverAcc2Pwd)
				} else if(account4TestCases.contains(testCaseId)){
					Uifunctions.loginFDR(GlobalVariable.cashierApprover, GlobalVariable.cashierPwd)
				}
				else {
					Uifunctions.loginFDR(GlobalVariable.drawCashierAcc7, GlobalVariable.drawCashierAcc7Pwd)
				}
				break
			default:
				return 
		}
		WebUI.navigateToUrl(GlobalVariable.URL)
	}

	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext) {
		String profileName = RunConfiguration.getExecutionProfile();
		switch(profileName) {
			case 'Voucher':
				Uifunctions.logoutFDR()
				break
			case 'Draw':
				Uifunctions.logoutFDR()
				break
			default:
				return
		}
	}

	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@BeforeTestSuite
	def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {
		def testSuite = testSuiteContext.getTestSuiteId()
		switch(testSuite) {
			case 'Test Suites/Voucher-Regression-Suite':
			case 'Test Suites/Draw-Regression-Suite':
				WebUI.disableSmartWait()
				break
		}
	}

	/**
	 * Executes after every test suite ends.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@AfterTestSuite
	def sampleAfterTestSuite(TestSuiteContext testSuiteContext) {
		println testSuiteContext.getTestSuiteId()
	}
}