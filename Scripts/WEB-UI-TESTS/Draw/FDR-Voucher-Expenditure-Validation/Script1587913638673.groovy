import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.functions.Uifunctions as Uifunctions

def drawDate = '09/30/2020'

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

Uifunctions.clickOnReconcileButton(drawDate)

WebUI.delay(5)
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/VoucherExpenditure/voucherNum'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/VoucherExpenditure/amount1'), 100)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/federalFund(0890)'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/fy2019MA113'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/title21CHIP'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/113-20-10-030'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/federalFund(0890)Col2'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/fy2019MA101'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/Title19-MAP'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/101-20-10-030'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/genFund(0001)'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/fy2019MA101'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/101-20-10-030 -3rdcol'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/stateOnlyRefugee(0001)'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/fy2019Refugee'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/non-FedFundHQAF(3158)'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/fy2019MA(611)HQAF'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/611-SB 239(2013)HQAF'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/fy2019Refugee'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/fedFundHQAF(0890)'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/fy2019MA(611)HQAF-6thcol'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/611-SB 239(2013)HQAF-6thCol'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/fedFundHQAF(0890)-7thCol'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/fy2019MA(611)-7thcol'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/title21CHIP-7thCol'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/611-SB 239(2013)HQAF-7thCol'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/fy2019MA(611)-7thcol'), 2)
WebUI.verifyElementPresent(findTestObject('FDR-Draw/ColumnHeaderValidation/0942-314'), 2)