package com.functions
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.eclipse.persistence.internal.jpa.parsing.jpql.antlr.JPQLParser.func_scope
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class validators {
	static KeywordLogger log = new KeywordLogger()
	public static void validateVoucherInfo(supplier, contract) {
		String supplierVal = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/supplier'))
		if (!(supplierVal.startsWith(supplier))) {
			KeywordUtil.markFailedAndStop('Supplier value not matching')
		}
		WebUI.verifyElementText(findTestObject('FDR-VoucherEntry/VoucherHeader/contract'), contract)
	}

	public static void validateDLInfo(waiverType, fundingSource, amount) {
		WebUI.waitForElementPresent(findTestObject('FDR-EditVoucher/amountVal'),5)
		WebUI.verifyElementText(findTestObject('FDR-EditVoucher/waiverTypeVal'), waiverType)
		WebUI.verifyElementText(findTestObject('FDR-EditVoucher/fundingSourceVal'), fundingSource)
		WebUI.verifyElementText(findTestObject('FDR-EditVoucher/amountVal'), amount)
	}

	public static boolean validateDashboardFilterValidation(Object... buttonTexts) {
		//to pass more than 1 argument
		String xpath = ''
		WebDriver driver = DriverFactory.getWebDriver()
		String vouchersXpath = xpaths.vouchersXpath
		List<WebElement> rows = driver.findElements(By.xpath(vouchersXpath))
		int numRows = rows.size()
		for (int row = 3; row < numRows; row++) {
			WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 3)
			xpath = vouchersXpath+'[' + row + ']' + xpaths.buttonLabel
			String buttonLabel = driver.findElement(By.xpath(xpath)).getText()
			if (buttonTexts.length == 1) {
				if (!buttonLabel.equalsIgnoreCase(buttonTexts[0])) {
					return	false
				}
			} else if (buttonTexts.length == 2) {
				if (!(buttonLabel.equalsIgnoreCase(buttonTexts[0]) || buttonLabel.equalsIgnoreCase(buttonTexts[1]))) {
					return	false
				}
			} else if (buttonTexts.length == 3) {
				if (!(buttonLabel.equalsIgnoreCase(buttonTexts[0]) || buttonLabel.equalsIgnoreCase(buttonTexts[1]) || buttonLabel.equalsIgnoreCase(buttonTexts[2])))  {
					return	false
				}
			}
		}
		return true
	}

	public static boolean voucherSearchValidation(string) {
		String xpath = ''
		WebDriver driver = DriverFactory.getWebDriver()
		String vouchersXpath = xpaths.vouchersXpath
		List<WebElement> rows = driver.findElements(By.xpath(vouchersXpath))
		int numRows = rows.size()
		boolean inVoucherNum = false
		boolean inDrawDate = false
		boolean inPayDate = false
		boolean inSupplier = false
		boolean inContract = false
		for (int row = 3; row < numRows; row++) {
			xpath = '(' + vouchersXpath+'[' + row + ']' + xpaths.taskAttribute + ')[3]'
			String searchValidation = driver.findElement(By.xpath(xpath)).getText()
			if(searchValidation.contains(string))
				inVoucherNum = true
			xpath = '(' + vouchersXpath+'[' + row + ']' + xpaths.taskAttribute + ')[5]'
			searchValidation = driver.findElement(By.xpath(xpath)).getText()
			if(searchValidation.contains(string))
				inDrawDate = true
			xpath = '(' + vouchersXpath+'[' + row + ']' + xpaths.taskAttribute + ')[7]'
			searchValidation = driver.findElement(By.xpath(xpath)).getText()
			if(searchValidation.contains(string))
				inPayDate = true
			xpath = '(' + vouchersXpath+'[' + row + ']' + xpaths.taskAttribute + ')[9]'
			searchValidation = driver.findElement(By.xpath(xpath)).getText()
			if(searchValidation.contains(string))
				inSupplier = true
			xpath = '(' + vouchersXpath+'[' + row + ']' + xpaths.taskAttribute + ')[11]'
			searchValidation = driver.findElement(By.xpath(xpath)).getText()
			if(searchValidation.contains(string))
				inContract = true
			if(!(inVoucherNum || inDrawDate || inPayDate || inSupplier || inContract)){
				return false
			}
			inVoucherNum = false
			inDrawDate = false
			inPayDate = false
			inSupplier = false
			inContract = false
		}

		return true
	}

	public static void validateDistributionLineData(federalShareRowAmtValue, nonFederalShareRowAmtValue , voucherTotalRowAmtValue ) {
		WebUI.waitForElementClickable(findTestObject('FDR-VoucherEntry/InvoiceLine/invoiceLineExpandButton'), 8)
		String xpath = ''
		String value = ''
		WebDriver driver = DriverFactory.getWebDriver()
		def federalShares = []
		def nonFederalShares = []
		def subTotals = []
		def lineTotals = []
		def fundRatios = []

		//Reading data from UI
		List<WebElement> dsitributionLines = driver.findElements(By.xpath(xpaths.lineGrid))
		int numDLs = dsitributionLines.size()
		for (int dl = 1; dl <= numDLs; dl++) {
			TestObject object = new TestObject()
			xpath = "((" + xpaths.lineGrid + ")["+dl+"]" + xpaths.amount + ")[1]"
			object.addProperty("xpath", ConditionType.CONTAINS, xpath)
			WebUI.waitForElementPresent(object, 5)
			federalShares.add(getNumericValue(WebUI.getText(object)))
			xpath = "((" + xpaths.lineGrid + ")["+dl+"]" + xpaths.amount + ")[2]"
			object = new TestObject()
			object.addProperty("xpath", ConditionType.CONTAINS, xpath)
			WebUI.waitForElementPresent(object, 5)
			nonFederalShares.add(getNumericValue((WebUI.getText(object)).split(" ")[0]))
			xpath = "((" + xpaths.lineGrid + ")["+dl+"]" + xpaths.amount + ")[3]"
			object = new TestObject()
			object.addProperty("xpath", ConditionType.CONTAINS, xpath)
			WebUI.waitForElementPresent(object, 5)
			subTotals.add(getNumericValue(WebUI.getText(object)))
			xpath = "((" + xpaths.lineGrid + ")["+dl+"]" + xpaths.dlAttribute + ")[4]"
			object = new TestObject()
			object.addProperty("xpath", ConditionType.CONTAINS, xpath)
			WebUI.waitForElementPresent(object, 5)
			fundRatios.add(WebUI.getText(object))
		}
		List<WebElement> lineTotalElements = driver.findElements(By.xpath(xpaths.lineTotal + xpaths.amount))
		for (int lineTotal = 0; lineTotal < lineTotalElements.size(); lineTotal++) {
			lineTotals.add(getNumericValue(lineTotalElements.get(lineTotal).getText()))
		}
		//Reading test data and comparing UI values
		TestData data = findTestData("Voucher/FDR-FundRatioValidations")
		FileInputStream fis = new FileInputStream(data.getSourceUrl());
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("DLData");
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

		for (int i = 1; i <= rowCount; i++) {
			WebUI.verifyEqual(sheet.getRow(i).getCell(0).getNumericCellValue(), federalShares.get(i-1))
			KeywordUtil.markPassed(((('Federal Share amount - ' + 'Expected Value : ') + sheet.getRow(i).getCell(0).getNumericCellValue()) + ' is matching with Actual Value : ') +
					federalShares.get(i-1))
			WebUI.verifyEqual(sheet.getRow(i).getCell(1).getNumericCellValue(), nonFederalShares.get(i-1))
			KeywordUtil.markPassed(((('Non Federal Share amount - ' + 'Expected Value : ') + sheet.getRow(i).getCell(1).getNumericCellValue()) + ' is matching with Actual Value : ') +
					nonFederalShares.get(i-1))
			WebUI.verifyEqual(sheet.getRow(i).getCell(2).getNumericCellValue(), subTotals.get(i-1))
			KeywordUtil.markPassed((((' subTotals amount - ' + 'Expected Value : ') + sheet.getRow(i).getCell(2).getNumericCellValue()) + ' is matching with Actual Value : ') +
					subTotals.get(i-1))
			println(fundRatios.get(i-1))
			println(sheet.getRow(i).getCell(3).getStringCellValue())
			WebUI.delay(3)
			WebUI.verifyEqual(sheet.getRow(i).getCell(3).getStringCellValue(), fundRatios.get(i-1))
			KeywordUtil.markPassed((((' fundRatio  - ' + 'Expected Value : ') + sheet.getRow(i).getCell(3).getStringCellValue()) + ' is matching with Actual Value : ') +
					fundRatios.get(i-1))
		}
		sheet = workbook.getSheet("lineTotals")
		rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		for (int i = 1; i <= rowCount; i++) {
			WebUI.verifyEqual(sheet.getRow(i).getCell(0).getNumericCellValue(), lineTotals.get(i-1))
			KeywordUtil.markPassed((((' Line Total Amount  ' + 'Expected Value : ') + sheet.getRow(i).getCell(0).getNumericCellValue()) + ' is matching with Actual Value : ') +
					lineTotals.get(i-1))
		}

		WebUI.click(findTestObject('FDR-VoucherEntry/VoucherHeader/expandButton'))
		def voucherDrawDate = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/drawDate'))
		def voucherPayDate = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/payDate'))
		def supplier = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/supplier'))
		def supplierName = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/supplierName'))
		def contract = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/contract'))
		def fundCode = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/fundCode'))
		def voucherVendorMsg = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/vendorMessage'))

		sheet = workbook.getSheet("VoucherHeader")
		WebUI.verifyEqual(sheet.getRow(1).getCell(2).getStringCellValue(), supplier)
		KeywordUtil.markPassed(((('Voucher supplier - ' + 'Expected Value : ') + sheet.getRow(1).getCell(2).getStringCellValue()) + ' is matching with Actual Value : ') +
				supplier)
		WebUI.verifyEqual(sheet.getRow(1).getCell(9).getStringCellValue(), supplierName)
		KeywordUtil.markPassed(((('Voucher supplierName - ' + 'Expected Value : ') + sheet.getRow(1).getCell(9).getStringCellValue()) + ' is matching with Actual Value : ') +
				supplierName)
		WebUI.verifyEqual(sheet.getRow(1).getCell(3).getStringCellValue(), contract)
		KeywordUtil.markPassed(((('Voucher contract - ' + 'Expected Value : ') + sheet.getRow(1).getCell(3).getStringCellValue()) + ' is matching with Actual Value : ') +
				contract)
		WebUI.verifyEqual(sheet.getRow(1).getCell(4).getStringCellValue(), fundCode)
		KeywordUtil.markPassed(((('Voucher fundCode - ' + 'Expected Value : ') + sheet.getRow(1).getCell(4).getStringCellValue()) + ' is matching with Actual Value : ') +
				fundCode)
		WebUI.verifyEqual(sheet.getRow(1).getCell(5).getStringCellValue(), voucherVendorMsg)
		KeywordUtil.markPassed(((('Voucher vendorMessage - ' + 'Expected Value : ') + sheet.getRow(1).getCell(5).getStringCellValue()) + ' is matching with Actual Value : ') +
				voucherVendorMsg)
		WebUI.verifyEqual(sheet.getRow(1).getCell(6).getNumericCellValue(), getNumericValue(federalShareRowAmtValue))
		KeywordUtil.markPassed(((('Federal Share Total  amount - ' + 'Expected Value : ') + sheet.getRow(1).getCell(6).getNumericCellValue()) + ' is matching with Actual Value : ') +
				getNumericValue(federalShareRowAmtValue))
		WebUI.verifyEqual(sheet.getRow(1).getCell(7).getNumericCellValue(), getNumericValue(nonFederalShareRowAmtValue))
		KeywordUtil.markPassed(((('Non Federal Share Total amount - ' + 'Expected Value : ') + sheet.getRow(1).getCell(7).getNumericCellValue()) + ' is matching with Actual Value : ') +
				getNumericValue(nonFederalShareRowAmtValue))
		WebUI.verifyEqual(sheet.getRow(1).getCell(8).getNumericCellValue(), getNumericValue(voucherTotalRowAmtValue))
		KeywordUtil.markPassed((((' Total amount ' + 'Expected Value : ') + sheet.getRow(1).getCell(8).getNumericCellValue()) + ' is matching with Actual Value : ') +
				getNumericValue(voucherTotalRowAmtValue))

	}

	public static Float getNumericValue(String value) {
		if (value.contains("(")) {
			return ("-" + value.replaceAll("[^\\d.]", "")) as Float
		} else {
			return value.replaceAll("[^\\d.]", "") as Float
		}
	}

	public static boolean validateDashboardPagination(int totalVouchers, int rowsPerPage){
		WebDriver driver = DriverFactory.getWebDriver()
		String vouchersXpath = xpaths.vouchersXpath
		List<WebElement> rows = driver.findElements(By.xpath(vouchersXpath))
		int numRows = rows.size() - 2
		if (totalVouchers > rowsPerPage) {
			if (numRows == rowsPerPage){
				return true
			} else {
				log.logFailed("Pagination not working as expected")
				return false
			}
		} else {
			if(numRows == totalVouchers){
				return true
			} else {
				log.logFailed("Pagination not working as expected")
				return false
			}
		}
	}
	public static boolean validateVoucherLabelAndTag(String voucherState) {
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 10)
		def currentDate = new Date()
		def voucherDrawDate = null
		def presenceOfHighPriorityTag = false
		String xpath = ''
		String vouchersXpath = xpaths.vouchersXpath
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> rows = driver.findElements(By.xpath(vouchersXpath))
		int numRows = rows.size()
		for (int row = 3; row <= numRows; row++) {
			xpath = '('+ vouchersXpath+'[' + row + ']' + xpaths.taskAttribute + ')[3]'
			String voucherNumber = driver.findElement(By.xpath(xpath)).getText()
			xpath = '('+ vouchersXpath+'[' + row + ']' + xpaths.taskAttribute + ')[5]'
			String voucherDrawDateString = driver.findElement(By.xpath(xpath)).getText()
			voucherDrawDate = new Date(voucherDrawDateString)
			xpath = '('+ vouchersXpath+'[' + row + ']' + xpaths.taskAttribute + ')[2]'
			String voucherLabel = driver.findElement(By.xpath(xpath)).getText()
			xpath = '('+ vouchersXpath+'[' + row + '])' + xpaths.muiChipLabel
			try {
				if(driver.findElement(By.xpath(xpath)) != null) {
					presenceOfHighPriorityTag = true
				}
			} catch(Exception e){
				presenceOfHighPriorityTag = false
			}

			if(voucherState.equalsIgnoreCase('Resume') || voucherState.equalsIgnoreCase('Fix') ){
				use(groovy.time.TimeCategory) {
					def duration = voucherDrawDate - currentDate
					if (duration.days > 13) {
						if(!voucherLabel.equalsIgnoreCase("Submit for draw") || presenceOfHighPriorityTag){
							return false
						}
						KeywordUtil.markPassed("For " + voucherState + " State voucher " + voucherNumber + " Label:" +voucherLabel + " and Presence of High Priority Tag " + presenceOfHighPriorityTag +" is Verified when duration is >10days+72hours" )
					} else if(duration.days <= 13 && duration.days > 2) {
						if(!voucherLabel.equalsIgnoreCase("Submit by tomorrow, 12:00 pm")){
							return false
						}
						if (duration.hours >= 12) {
							if(!presenceOfHighPriorityTag) {
								return false
							}
						} else {
							if(presenceOfHighPriorityTag) {
								return false
							}
						}
						KeywordUtil.markPassed("For " + voucherState + " State voucher " + voucherNumber + " Label:" +voucherLabel + " and Presence of High Priority Tag " + presenceOfHighPriorityTag +" is Verified when duration is >48hours,<=10days+48hours" )
					} else if(duration.days <= 2) {
						if(!voucherLabel.equalsIgnoreCase("Submit immediately") || !presenceOfHighPriorityTag){
							return false
						}
						KeywordUtil.markPassed("For " + voucherState + " State voucher " + voucherNumber + " Label:" +voucherLabel + " and Presence of High Priority Tag " + presenceOfHighPriorityTag +" is Verified when duration is <=48hours" )
					}
				}
			} else if (voucherState.equalsIgnoreCase('Validate')) {
				use(groovy.time.TimeCategory) {
					def duration = voucherDrawDate - currentDate
					if (duration.days > 12) {
						if(!voucherLabel.equalsIgnoreCase("Approve for draw") || presenceOfHighPriorityTag){
							return false
						}
						KeywordUtil.markPassed("For " + voucherState + " State voucher " + voucherNumber + " Label:" +voucherLabel + " and Presence of High Priority Tag " + presenceOfHighPriorityTag +" is Verified when duration is >10days+48hours" )
					} else if(duration.days <= 12 && duration.days > 1) {
						if(!voucherLabel.equalsIgnoreCase("Approve by tomorrow, 12:00 pm")){
							return false
						}
						if (duration.hours >= 12) {
							if(!presenceOfHighPriorityTag) {
								return false
							}
						} else {
							if(presenceOfHighPriorityTag) {
								return false
							}
						}
						KeywordUtil.markPassed("For " + voucherState + " State voucher " + voucherNumber + " Label:" +voucherLabel + " and Presence of High Priority Tag " + presenceOfHighPriorityTag +" is Verified when duration is >48hours,<=10days+48hours" )
					} else if(duration.days <= 1) {
						if(!voucherLabel.equalsIgnoreCase("Approve immediately") || !presenceOfHighPriorityTag){
							return false
						}
						KeywordUtil.markPassed("For " + voucherState + " State voucher " + voucherNumber + " Label:" +voucherLabel + " and Presence of High Priority Tag " + presenceOfHighPriorityTag +" is Verified when duration is <=48hours" )
					}
				}
			} else if (voucherState.equalsIgnoreCase('Print')) {
				use(groovy.time.TimeCategory) {
					def duration = voucherDrawDate - currentDate
					if (duration.days > 11) {
						if(!voucherLabel.equalsIgnoreCase("Print for draw") || presenceOfHighPriorityTag){
							return false
						}
						KeywordUtil.markPassed("For " + voucherState + " State voucher " + voucherNumber + " Label:" +voucherLabel + " and Presence of High Priority Tag " + presenceOfHighPriorityTag +" is Verified when duration is >10days+24hours" )
					} else if(duration.days <= 11 && duration.days > 1) {
						if(!voucherLabel.equalsIgnoreCase("Print by tomorrow, 12:00 pm") || !presenceOfHighPriorityTag ){
							return false
						}
						KeywordUtil.markPassed("For " + voucherState + " State voucher " + voucherNumber + " Label:" +voucherLabel + " and Presence of High Priority Tag " + presenceOfHighPriorityTag +" is Verified when duration is >24hours,<=10days+24hours" )
					} else if(duration.days <= 1) {
						if(!voucherLabel.equalsIgnoreCase("Print immediately") || !presenceOfHighPriorityTag){
							return false
						}
						KeywordUtil.markPassed("For " + voucherState + " State voucher " + voucherNumber + " Label:" +voucherLabel + " and Presence of High Priority Tag " + presenceOfHighPriorityTag +" is Verified when duration is <=24hours" )
					}
				}
			}
			KeywordUtil.markPassed("For Voucher Number " + voucherNumber + " Label is " +voucherLabel + " and HighPriorityTag Presence is " + presenceOfHighPriorityTag)
		}
		return true
	}
	def static void validateVoucherInvoicLineTotals(expectedVoucherTotal, expectedInvoiceTotal ) {
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 6)
		def actualVoucherTotalWith$ = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/voucherTotal'))
		def actualVoucherTotalWithout$ = actualVoucherTotalWith$.substring(1)
		def actualVoucherTotalWithoutComma = actualVoucherTotalWithout$.replaceAll(',', '')
		def actualVoucherTotal = Float.parseFloat(actualVoucherTotalWithoutComma)
		WebUI.waitForElementPresent(findTestObject('FDR-VoucherEntry/InvoiceLine/voucherTotalRowAmt'),6)
		def actualInvoiceTotalWith$ = WebUI.getText(findTestObject('FDR-VoucherEntry/InvoiceLine/voucherTotalRowAmt'))
		def actualInvoiceTotalWithout$ = actualInvoiceTotalWith$.substring(1)
		def actualInvoiceTotalWithoutComma = actualInvoiceTotalWithout$.replaceAll(',', '')
		def actualInvoiceTotal = Float.parseFloat(actualInvoiceTotalWithoutComma)
		if ( expectedVoucherTotal == actualVoucherTotal) {
			KeywordUtil.markPassed('Valid Vouchertotal')
		} else {
			KeywordUtil.markFailedAndStop('Invalid Vouchertotal')
		}
		if (expectedInvoiceTotal == actualInvoiceTotal) {
			KeywordUtil.markPassed('Valid Invoice total.')
		} else {
			KeywordUtil.markFailedAndStop('Invalid Invoice total ')
		}
	}
	def static void validateVoucherHeaderTotals(expectedVoucherTotal, isDeleted) {
		// Get Voucher Total after undo
		WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 6)
		def NewVoucherTotalAftDelactualwith$ = WebUI.getText(findTestObject('FDR-VoucherEntry/VoucherHeader/voucherTotal'))
		if (NewVoucherTotalAftDelactualwith$ == '' && isDeleted) {
			KeywordUtil.markPassed('Valid Vouchertotal')
		} else {
			def NewVoucherTotalAftDelactualwithout$ = NewVoucherTotalAftDelactualwith$.substring(1)
			def NewVoucherTotalAftDelactualwithoutComma = NewVoucherTotalAftDelactualwithout$.replaceAll(',', '')
			def NewVoucherTotalAftDelactual = Float.parseFloat(NewVoucherTotalAftDelactualwithoutComma)
			if (NewVoucherTotalAftDelactual == expectedVoucherTotal) {
				KeywordUtil.markPassed('Valid Vouchertotal')
			} else {
				KeywordUtil.markFailedAndStop('Invalid Vouchertotal')
			}
		}

	}
}
