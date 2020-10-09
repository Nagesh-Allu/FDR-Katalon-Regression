package com.functions
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

public class Uifunctions {
	public static  void loginFDR(String userName, String passWord) {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(GlobalVariable.URL)
		WebUI.waitForElementPresent(findTestObject('FDR-SignIn/SignInEmail'), 6)
		WebUI.click(findTestObject('FDR-SignIn/SignInEmail'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.waitForElementPresent(findTestObject('FDR-SignIn/SignInEmail'), 2)
		WebUI.setText(findTestObject('FDR-SignIn/SignInEmail'), userName)
		WebUI.waitForElementVisible(findTestObject('FDR-SignIn/SignInEmailNext'), 4)
		WebUI.click(findTestObject('FDR-SignIn/SignInEmailNext'))
		WebUI.waitForElementVisible(findTestObject('FDR-SignIn/SignInEmailPassword'), 4)
		WebUI.click(findTestObject('FDR-SignIn/SignInEmailPassword'))
		WebUI.setEncryptedText(findTestObject('FDR-SignIn/SignInEmailPassword'), passWord)
		WebUI.click(findTestObject('FDR-SignIn/SignInButton'))
	}

	public static  void logoutFDR() {
		//		WebUI.click(findTestObject('FDR-SignIn/Signout'))
		WebUI.closeBrowser()
	}

	public static String findVoucherWithVoucherNum(String voucherNumber) {
		try {
			WebUI.navigateToUrl(((GlobalVariable.URL + '/vouchers/') + (voucherNumber.split('CAP')[1])) + '/entry')
			WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 5)
			def VouchertotalbefDelwith$ = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/voucherTotal'))
			if (VouchertotalbefDelwith$.equals('$0.00')) {
				return 'undefined'
			}
			return voucherNumber
		} catch(Exception e){
			return null
		}
	}

	public static TestObject findVoucherButtonOnDashboard(String voucherNumber) {
		String xpath = ''
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> rows = driver.findElements(By.xpath(xpaths.vouchersXpath))
		int numRows = rows.size()
		for (int row = 3;  row <= numRows; row++) {
			xpath = '('+xpaths.vouchersXpath +'[' + row + ']' +xpaths.taskAttribute +')[3]'
			String voucherNumberUi = driver.findElement(By.xpath(xpath)).getText()
			if (voucherNumber.equals(voucherNumberUi)) {
				xpath = xpaths.vouchersXpath +'[' + row + ']' +xpaths.actionButton
				TestObject object = new TestObject()
				object.addProperty("xpath", ConditionType.CONTAINS, xpath)
				return object
			}
		}
		return null
	}

	public static void clearElementText(TestObject to) {
		WebElement element = WebUiCommonHelper.findWebElement(to,30)
		WebUI.executeJavaScript("arguments[0].value='';", Arrays.asList(element))
	}

	public static void deleteFirstDistributionLine() {

		WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/DLHover'), 3)
		WebUI.mouseOver(findTestObject('FDR-EditVoucher/DLHover'))
		WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/DLEditIcon'), 3)
		WebUI.click(findTestObject('FDR-EditVoucher/DLEditIcon'))
		WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/DLDeleteClick'), 6)
		WebUI.click(findTestObject('FDR-EditVoucher/DLDeleteClick'))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/voucherTotal'), 8)
	}

	public static void deleteVoucherLine() {
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
		WebUI.mouseOver(findTestObject('FDR-EditVoucher/invoiceHover'))
		WebUI.click(findTestObject('FDR-EditVoucher/voucherLineEditIcon'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
		WebUI.click(findTestObject('FDR-EditVoucher/voucherLineDeleteClick'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
	}

	public static void createVoucherHeader(data) {
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)
		WebUI.click(findTestObject('FDR-Dashboard/createNewVoucherButton'))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 3)
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/drawDate'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
		WebUI.setText(findTestObject('FDR-VoucherEntry/Voucher/drawDate'),data.drawDate)
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'),3)
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/programType'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/programType'), data.programType)
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/programType'), 3)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/programType'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/invoiceType'))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/invoiceType'), 2)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/invoiceType'), data.invoiceType)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/invoiceType'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/fundCode'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/fundCode'), data.fundCode)
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/fundCode'), 2)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/fundCode'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/supplierID'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/supplierID'), data.supplier)
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/supplierID'), 2)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/supplierID'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/seqNum'))
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/seqNum'), 5)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/seqNum'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/contractNum'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/contractNum'), data.contractNum)
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/contractNum'), 5)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/contractNum'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.setText(findTestObject('FDR-VoucherEntry/Voucher/vendorMessage'), data.vendorMessage)
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/primaryContact'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/primaryContact'), data.primaryContact)
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/primaryContact'), 2)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/primaryContact'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/secondaryContact'))
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/secondaryContact'), data.secondaryContact)
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/secondaryContact'), 2)
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/secondaryContact'), 2)
		WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/secondaryContact'), Keys.chord(Keys.DOWN, Keys.ENTER))
		WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/buttonNext'))
		WebUI.delay(3)

		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 4)
	}
	/*public static void createVoucherHeader(payDate, drawDate, program, invoiceType, fundCode, supplier, contract,  sequence, vMessage = true, primaryContact, secondaryContact) {
	 WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 8)
	 WebUI.click(findTestObject('FDR-Dashboard/createNewVoucherButton'))
	 WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
	 WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/drawDate'))
	 WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
	 WebUI.setText(findTestObject('FDR-VoucherEntry/Voucher/drawDate'),drawDate )
	 WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
	 WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/programType'))
	 WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/programType'), 2)
	 WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/programType'), program )
	 WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/programType'), 3)
	 WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/programType'), Keys.chord(Keys.DOWN, Keys.ENTER))
	 WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/invoiceType'))
	 WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/invoiceType'), 2)
	 WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/invoiceType'), invoiceType)
	 WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/invoiceType'), Keys.chord(Keys.DOWN, Keys.ENTER))
	 WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/fundCode'))
	 WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/fundCode'), fundCode)
	 WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/fundCode'), 2)
	 WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/fundCode'), Keys.chord(Keys.DOWN, Keys.ENTER))
	 WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/supplierID'))
	 WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/supplierID'), supplier)
	 WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/supplierID'), 2)
	 WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/supplierID'), Keys.chord(Keys.DOWN, Keys.ENTER))
	 WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/seqNum'))
	 WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/seqNum'), 5)
	 WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/seqNum'), Keys.chord(Keys.DOWN, Keys.ENTER))
	 WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/contractNum'))
	 WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/contractNum'), contract)
	 WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/contractNum'), 5)
	 WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/contractNum'), Keys.chord(Keys.DOWN, Keys.ENTER))
	 if (vMessage) {
	 WebUI.setText(findTestObject('FDR-VoucherEntry/Voucher/vendorMessage'), vMessage)
	 }
	 WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/primaryContact'))
	 WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/primaryContact'), primaryContact)
	 WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/primaryContact'), 2)
	 WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/primaryContact'), Keys.chord(Keys.DOWN, Keys.ENTER))
	 WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/secondaryContact'))
	 WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/secondaryContact'), secondaryContact)
	 WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/Voucher/secondaryContact'), 2)
	 WebUI.sendKeys(findTestObject('FDR-VoucherEntry/Voucher/secondaryContact'), Keys.chord(Keys.DOWN, Keys.ENTER))
	 WebUI.click(findTestObject('FDR-VoucherEntry/Voucher/buttonNext'))
	 WebUI.delay(3)
	 WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 4)
	 } */

	public static void createInvoiceLine(numOfInvoices) {
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 3)
		for (def i = 0; i < numOfInvoices; i++) {
			def invoicetype = org.apache.commons.lang.RandomStringUtils.randomNumeric(3) + i
			WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/InvoiceLine/addVoucherButton'), 2)
			WebUI.waitForElementClickable(findTestObject('FDR-VoucherEntry/InvoiceLine/invoice'), 4)
			WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoice'))
			WebUI.setText(findTestObject('FDR-VoucherEntry/InvoiceLine/invoice'), invoicetype)
			def invoiceDate = new Date().plus(i).format('MM/dd/yyyy')
			WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceDate'))
			WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceDate'), 4)
			WebUI.setText(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceDate'), invoiceDate)
			def WarrantDate = new Date().plus(i+1).format('MM/dd/yyyy')
			WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/originalWarrantDate'))
			WebUI.setText(findTestObject('FDR-VoucherEntry/InvoiceLine/originalWarrantDate'), WarrantDate)
			WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/InvoiceLine/addInvoiceLineButton'), 4)
			if (i < numOfInvoices-1) {
				WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/addInvoiceLineButton'))
			} else {
				WebUI.click(findTestObject('FDR-VoucherEntry/InvoiceLine/addInvoiceLineButtonIndex2'))
			}
			WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/VoucherHeader/reviewButton'), 6)
		}
	}
	public static void createDistributionLines(numOfDLines, dataSheet, voucherFundCode = ''){
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
		for (def i = 1; i <= numOfDLines; i++) {
			WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
			WebUI.waitForElementClickable(findTestObject('FDR-VoucherEntry/DistributionLine/serviceDateFrom'), 2)
			WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/serviceDateFrom'))
			WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/DistributionLine/serviceDateFrom'), 2)
			WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/serviceDateFrom'), findTestData(dataSheet).getValue('serviceDateFrom',i))
			WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/serviceDateTo'))
			WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/DistributionLine/serviceDateTo'), 2)
			WebUI.setText(findTestObject('FDR-VoucherEntry/DistributionLine/serviceDateTo'), findTestData(dataSheet).getValue('serviceDateTo', i))
			WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
			WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/amount'))
			Uifunctions.clearElementText(findTestObject('FDR-VoucherEntry/DistributionLine/amount'))
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/amount'), findTestData(dataSheet).getValue('amount', i))
			WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
			WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/waiverType'))
			WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/waiverType'), findTestData(dataSheet).getValue('waiverType', i))
			WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/waiverType'), Keys.chord(Keys.DOWN, Keys.ENTER))

			WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'))
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'),findTestData(dataSheet).getValue('fundSource', i))
			WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundingSource'), Keys.chord(Keys.DOWN, Keys.ENTER))

			def fundRatio = findTestData(dataSheet).getValue('fundRatio', i)
			WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'))
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'), fundRatio)
			WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/fundRatio'), Keys.chord(Keys.DOWN,Keys.ENTER))

			WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'))
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'),findTestData(dataSheet).getValue('waiverName', i))
			WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/waiverName'), Keys.chord(Keys.DOWN, Keys.ENTER))

			if (fundRatio  != '100/0'){
				WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'))
				WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'), findTestData(dataSheet).getValue('nonFederal', i))
				WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'),2)
				WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/nonFederalFund'), Keys.chord(Keys.DOWN, Keys.ENTER))
			}
			if(voucherFundCode == '') {
				WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/account'))
				WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/account'), findTestData(dataSheet).getValue('account', i))
				WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/account'), Keys.chord(Keys.DOWN, Keys.ENTER))
				WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/altAccount'))
				WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/altAccount'), findTestData(dataSheet).getValue('altAccount', i))
				WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/DistributionLine/altAccount'), 1)
				WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/altAccount'), Keys.chord(Keys.DOWN, Keys.ENTER))
			}
			WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'))
			WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'), findTestData(dataSheet).getValue('serviceCategory', i))
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/serviceCategory'), Keys.chord(Keys.DOWN, Keys.ENTER))
			WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/incDecLine'))
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/incDecLine'), findTestData(dataSheet).getValue('incDecLine', i))
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/incDecLine'), Keys.chord(Keys.DOWN, Keys.ENTER))
			WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
			WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/index'))
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/index'), findTestData(dataSheet).getValue('index', i))
			WebUI.sendKeys(findTestObject('FDR-VoucherEntry/DistributionLine/index'), Keys.chord(Keys.DOWN, Keys.ENTER))
			if (i < numOfDLines) {
				WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/addAnotherLine'))
				WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
				WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/clearButton'))
				WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
			}
			else {
				WebUI.click(findTestObject('FDR-VoucherEntry/DistributionLine/addSaveButton'))
			}
		}
	}

	public static void updateSCOBalances(data) {
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)
		WebUI.click(findTestObject('FDR-Draw/SCOBalances/buttonUpdateSCO'))
		WebUI.delay(3)
		WebUI.click(findTestObject('FDR-Draw/SCOBalances/updateFundBalanceInputText1'))
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
		WebUI.setText(findTestObject('FDR-Draw/SCOBalances/inputTextBalance1'), '120')
		WebUI.click(findTestObject('FDR-Draw/SCOBalances/balanceUnchanged1'))
		WebUI.click(findTestObject('FDR-Draw/SCOBalances/balanceUnchanged1'))
		for( int i = 1; i <= 14; i++){

			WebUI.click(findTestObject('FDR-Draw/SCOBalances/updateFundBalanceInputText' + i))
			WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
			WebUI.setText(findTestObject('FDR-Draw/SCOBalances/inputTextBalance' + i), data)
			WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
		}
		WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)
		WebUI.click(findTestObject('FDR-Draw/SCOBalances/saveFundBalanceButton'))
		WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)
		WebUI.click(findTestObject('FDR-Draw/SCOBalances/buttonUpdateSCO'))
		WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)
		WebUI.verifyElementPresent(findTestObject('/FDR-Draw/SCOBalances/lastUpdatedText'), 1)
		WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)
		WebUI.click(findTestObject('FDR-Draw/SCOBalances/scoCancelButton'))
		WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)
	}
	public static void clickOnReconcileButton(drawDate) {
		def xpath = "(//*[text()='Draw Date']//parent::*//parent::*//parent::*//button)[1]"
		TestObject expandButton = new TestObject("expandButton")
		expandButton.addProperty("xpath", ConditionType.EQUALS, xpath)
		WebUI.click(expandButton, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
		xpath = "(//*[text()='Draw Date']//parent::*//p)"

		WebDriver driver =  DriverFactory.getWebDriver()
		def rowCount = driver.findElements(By.xpath(xpath)).size()
		for (int i = 1 ; i <= rowCount; i++){
			TestObject drawDateObject = new TestObject("drawDate")
			xpath = "(//*[text()='Draw Date']//parent::*//p)[" + i +"]"
			drawDateObject.addProperty("xpath", ConditionType.EQUALS, xpath)
			def drawDateText = WebUI.getText(drawDateObject)
			if(drawDateText == drawDate) {
				xpath = "(//*[text()='Draw Date']//parent::*//parent::*//parent::*//button)[" + i +"]"
				expandButton = new TestObject("expandButton")
				expandButton.addProperty("xpath", ConditionType.EQUALS, xpath)
				WebUI.click(expandButton, FailureHandling.STOP_ON_FAILURE)
				WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)
				xpath = "(//*[@data-id='button-link' ]//*[contains(text(),'Reconcile')])[" + i +"]"
				TestObject reconcileButton = new TestObject("reconcileButton")
				reconcileButton.addProperty("xpath", ConditionType.EQUALS, xpath)
				WebUI.click(reconcileButton, FailureHandling.STOP_ON_FAILURE)
				WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
				break
			}
		}
	}
}






