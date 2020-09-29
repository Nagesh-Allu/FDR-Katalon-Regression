import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.functions.Uifunctions
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

class FDRListener {

	def static skipBeforeAndAfterTestCase = false
	List<String> account7TestCases = [
		"Test Cases/WEB-UI-TESTS/Receipts/FDR-Create-Receipt-Header",
		"Test Cases/WEB-UI-TESTS/Receipts/FDR-Display-Receipt-Header",
		"Test Cases/WEB-UI-TESTS/Receipts/FDR-Edit-Receipt-Header",
		"Test Cases/WEB-UI-TESTS/Receipts/FDR-Create-Receipt-CheckLine",
		"Test Cases/WEB-UI-TESTS/Receipts/FDR-Edit-Receipt_Line",
		"Test Cases/WEB-UI-TESTS/Receipts/FDR-Add-Distribution-Line",
		"Test Cases/WEB-UI-TESTS/Receipts/FDR-Review Receipt",
		"Test Cases/WEB-UI-TESTS/Receipt/FDR-Receipts-FixStateReasons",
		"Test Cases/WEB-UI-TESTS/Receipt/FDR-Validate-Receipt-RA-CR-checkMarked",
		"Test Cases/WEB-UI-TESTS/Receipt/FDR-Validate-Updated-Receipt-DistributionLine",
		"Test Cases/WEB-UI-TESTS/Receipt/FDR-Review-fillableTR-Prior-Approval",
		"Test Cases/WEB-UI-TESTS/Receipt/FDR-Validate-ReceiptHeader-RA-CR",
		"Test Cases/WEB-UI-TESTS/Receipt/FDR-Delete-Receipt_Distribution_Line",
		"Test Cases/WEB-UI-TESTS/Receipt/FDR-Delete-Undo-Receipt-Header",
		"Test Cases/WEB-UI-TESTS/Receipt/FDR-Delete-Undo-Receipt_Line",
		"Test Cases/WEB-UI-TESTS/Receipt/FDR-Review-Print-Forms"
		]
	List<String> account10TestCases = [
		"Test Cases/WEB-UI-TESTS/SysAdmin/SystemAdmin-Login"]
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def sampleBeforeTestCase(TestCaseContext testCaseContext) {
		String profileName = RunConfiguration.getExecutionProfile();
		switch(profileName) {
			case 'Voucher':
			case 'SysAdmin':
			case 'Draw':
			case 'superUser':
				return
		}
		def testCaseId = testCaseContext.getTestCaseId()
		if(!skipBeforeAndAfterTestCase){
			if(account7TestCases.contains(testCaseId)){
				Uifunctions.loginFDR(GlobalVariable.accountsAdmin, GlobalVariable.accountsAdminPwd)
			} else if(account10TestCases.contains(testCaseId)){
				Uifunctions.loginFDR(GlobalVariable.accountsProcessor, GlobalVariable.accountsProcessorPwd)
			} else {
				Uifunctions.loginFDR(GlobalVariable.accountsApprover, GlobalVariable.accountsApproverPwd)
			}
			WebUI.navigateToUrl(GlobalVariable.URL)
			
		}
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
			case 'SysAdmin':
			case 'Draw':
			case 'superUser':
				return	
		}
		if(!skipBeforeAndAfterTestCase) {
			Uifunctions.logoutFDR()
		}
	}
	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@BeforeTestSuite
	def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {
	}
	/**
	 * Executes after every test suite ends.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@AfterTestSuite
	def sampleAfterTestSuite(TestSuiteContext testSuiteContext) {
		skipBeforeAndAfterTestCase = true
	}
}