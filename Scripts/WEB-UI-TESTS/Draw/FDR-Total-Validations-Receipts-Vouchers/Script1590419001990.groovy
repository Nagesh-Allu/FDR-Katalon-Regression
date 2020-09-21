import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.functions.util as util
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.functions.Uifunctions as Uifunctions

def drawDate = '09/30/2020'

KeywordLogger logger = new KeywordLogger()
WebUI.delay(10)
Uifunctions.clickOnReconcileButton(drawDate)
WebUI.delay(5)
WebUI.click(findTestObject('FDR-Draw/ReconciliationPage/expandV1Button'))
WebUI.delay(3)

def voucherTotal = util.convertToNum(findTestObject('FDR-Draw/ReconciliationPage/expenditureTotal'))
logger.logInfo('voucherTotal : ' + voucherTotal)

def receiptsTotal = util.convertToNum(findTestObject('FDR-Draw/ReconciliationPage/receiptsTotal'))
logger.logInfo('receiptsTotal : ' + receiptsTotal)

def grandTotal = util.convertToNum(findTestObject('FDR-Draw/ReconciliationPage/drawGrandTotal'))
logger.logInfo('grandTotal : ' + grandTotal)

WebUI.verifyEqual(voucherTotal + receiptsTotal, grandTotal)