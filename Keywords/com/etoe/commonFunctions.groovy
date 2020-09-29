package com.etoe

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import internal.GlobalVariable


public class commonFunctions {
	public static void login(userName, password) {
		WebUI.openBrowser(GlobalVariable.URL)
		WebUI.maximizeWindow()
		WebUI.waitForElementPresent(findTestObject('FDR-SignIn/SignInEmail'), 6)
		WebUI.click(findTestObject('FDR-SignIn/SignInEmail'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.waitForElementPresent(findTestObject('FDR-SignIn/SignInEmail'), 2)
		WebUI.setText(findTestObject('FDR-SignIn/SignInEmail'),userName)
		WebUI.waitForElementVisible(findTestObject('FDR-SignIn/SignInEmailNext'), 4)
		WebUI.click(findTestObject('FDR-SignIn/SignInEmailNext'))
		WebUI.waitForElementVisible(findTestObject('FDR-SignIn/SignInEmailPassword'), 4)
		WebUI.click(findTestObject('FDR-SignIn/SignInEmailPassword'))
		WebUI.setEncryptedText(findTestObject('FDR-SignIn/SignInEmailPassword'), password)
		WebUI.click(findTestObject('FDR-SignIn/SignInButton'))
	}

	public static void selectRole(role) {
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)
		WebUI.click(findTestObject('FDR-SuperUser-Dashboard/userExpandButton'))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)
		switch(role) {
			case 'accountsPayableProcessor':
				WebUI.click(findTestObject('FDR-SuperUser-Dashboard/accountsPayableProcessor'))
				break
			case 'accountsPayableApprover':
				WebUI.click(findTestObject('FDR-SuperUser-Dashboard/accountsPayableApprover'))
				break
			case 'cashManagementApprover':
				WebUI.click(findTestObject('FDR-SuperUser-Dashboard/cashManagementApprover'))
				break
			case 'cashieringApproverRole':
				WebUI.click(findTestObject('FDR-SuperUser-Dashboard/cashieringApproverRole'))
				break
			case 'cashieringProcessorRole':
				WebUI.click(findTestObject('FDR-SuperUser-Dashboard/cashieringProcessorRole'))
				break
		}
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 2)
	}
	public static void logout() {
		WebUI.closeBrowser()
	}
}
