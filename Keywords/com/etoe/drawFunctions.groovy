package com.etoe

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


public class drawFunctions {
	public static TestObject balCheckbox(index) {
		def scoBalXpath = "(//*[@data-id='checkbox'])["+ index + "]"
		TestObject scoBalancesCheckbox = new TestObject("scoBalancesCheckbox")
		scoBalancesCheckbox.addProperty("xpath", ConditionType.EQUALS, scoBalXpath)
		return scoBalancesCheckbox
	}

	public static TestObject updateFundBalanceInput(index) {
		def balXpath = "(//*[@data-id='text-field'])["+ index + "]//input"
		TestObject updateFundBalanceInput = new TestObject("updateFundBalanceInput")
		updateFundBalanceInput.addProperty("xpath", ConditionType.EQUALS, balXpath)
		return updateFundBalanceInput
	}

	public static TestObject inputTextField(index) {
		def inputTextXpath = "(//*[@type='text'])[" + index +"]"
		TestObject updateFundBalanceInput = new TestObject("updateFundBalanceInput")
		updateFundBalanceInput.addProperty("xpath", ConditionType.EQUALS, inputTextXpath)
		return updateFundBalanceInput
	}

	public static void updateSCOBalances(balance) {
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
		WebUI.click(findTestObject('FDR-Draw/SCOBalances/buttonUpdateSCO'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
		for( int i = 1; i <= 14; i++){
			WebUI.click(updateFundBalanceInput(i))
			WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
			WebUI.setText(inputTextField(i), balance)
			WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
		}
		WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'),1)
		WebUI.click(findTestObject('FDR-Draw/SCOBalances/saveFundBalanceButton'))
	}
	public static TestObject ClickReconcillationExpandButton(DrawDate) {
		def inputTextXpath = "//*[contains(@class,'MuiExpansionPanelSummary-root') and @aria-expanded='false']//p[text()='"+DrawDate+"']//parent::*//parent::*/following-sibling::*//button"
		TestObject updateFundBalanceInput = new TestObject("ReconcillationExpandButton")
		updateFundBalanceInput.addProperty("xpath", ConditionType.EQUALS, inputTextXpath)
		return updateFundBalanceInput
	}
	
/*Reconcillation Button-->	//*[text()='10/28/2020']//ancestor::*[@role="button"]/following-sibling::div//*[@role='button']
	
	public static TestObject ClickReconcillationButton(index) {
		def inputTextXpath = "//*[text()'"+DrawDate+"']//ancestor::*[@role="button"]/following-sibling::div//*[@role='button']"
		TestObject ReconcillationClickButton = new TestObject("ReconcillationClickButton")
		ReconcillationClickButton.addProperty("xpath", ConditionType.EQUALS, inputTextXpath)
		return index
		*/

}
