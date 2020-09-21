import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.functions.Uifunctions
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import com.functions.Uifunctions as Uifunctions

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

def drawDate = '09/30/2020'

Uifunctions.clickOnReconcileButton(drawDate)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
WebUI.click(findTestObject('FDR-Draw/RejectVocuherReceipts/thumbsUpButtonVoucher'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)
def rejectVoucherNum = WebUI.getText(findTestObject('FDR-Draw/RejectVocuherReceipts/voucherNum1'))
WebUI.click(findTestObject('FDR-Draw/RejectVocuherReceipts/thubmsDownVoucher1'))
WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)
WebUI.click(findTestObject('FDR-Draw/RejectVocuherReceipts/spanOverdrawnFund(s)'))
WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)
WebUI.click(findTestObject('FDR-Draw/RejectVocuherReceipts/overFundInput1'))
WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)
WebUI.sendKeys(findTestObject('FDR-Draw/RejectVocuherReceipts/overFundInput1'), 'Federal')
WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)
WebUI.sendKeys(findTestObject('FDR-Draw/RejectVocuherReceipts/overFundInput1'), Keys.chord(Keys.UP, Keys.ENTER))
WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)
WebUI.click(findTestObject('FDR-Draw/RejectVocuherReceipts/addFundButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 4)
WebUI.click(findTestObject('FDR-Draw/RejectVocuherReceipts/overFundInput2'))
WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 4)
WebUI.sendKeys(findTestObject('FDR-Draw/RejectVocuherReceipts/overFundInput2'), 'Non-Federal')
WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)
WebUI.sendKeys(findTestObject('FDR-Draw/RejectVocuherReceipts/overFundInput2'), Keys.chord(Keys.DOWN, Keys.ENTER))
WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)
WebUI.click(findTestObject('FDR-Draw/RejectVocuherReceipts/spanIncorrectAmountEntry'))
WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)
def rejectionReason1 = WebUI.getAttribute(findTestObject('FDR-Draw/RejectVocuherReceipts/overFundInput1'),'value', FailureHandling.STOP_ON_FAILURE)
def rejectionReason2 = WebUI.getAttribute(findTestObject('FDR-Draw/RejectVocuherReceipts/overFundInput2'),'value', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/FDR-Draw/RejectVocuherReceipts/rejectVoucherButton'))
WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 4)

WebUI.click(findTestObject('FDR-Draw/RejectVocuherReceipts/thumbsUpButtonReceipt'))

WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)

WebUI.click(findTestObject('FDR-Draw/RejectVocuherReceipts/thubmsDownReceipts1')) //((//*[text()='Expenditures']//parent::*//parent::*//parent::*//parent::*)//button)[10]

WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)

WebUI.click(findTestObject('FDR-Draw/RejectVocuherReceipts/spanOverdrawnFund(s)'))

WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)

WebUI.click(findTestObject('FDR-Draw/RejectVocuherReceipts/overFundInput1'))

WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)

WebUI.sendKeys(findTestObject('FDR-Draw/RejectVocuherReceipts/overFundInput1'), 'Federal')

WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)

WebUI.sendKeys(findTestObject('FDR-Draw/RejectVocuherReceipts/overFundInput1'), Keys.chord(Keys.UP, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)

WebUI.click(findTestObject('FDR-Draw/RejectVocuherReceipts/addFundButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 4)

WebUI.click(findTestObject('FDR-Draw/RejectVocuherReceipts/overFundInput2'))

WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 4)

WebUI.sendKeys(findTestObject('FDR-Draw/RejectVocuherReceipts/overFundInput2'), 'Non-Federal')

WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)

WebUI.sendKeys(findTestObject('FDR-Draw/RejectVocuherReceipts/overFundInput2'), Keys.chord(Keys.DOWN, Keys.ENTER))

WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)

WebUI.click(findTestObject('FDR-Draw/RejectVocuherReceipts/spanIncorrectAmountEntry'))

WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)

WebUI.click(findTestObject('FDR-Draw/RejectVocuherReceipts/rejectReceiptButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)

//Uifunctions.logoutFDR()

//Uifunctions.loginFDR(GlobalVariable.accountsApproverAcc2, GlobalVariable.accountsApproverAcc2Pwd)
Uifunctions.loginFDR(GlobalVariable.drawCashierAcc6, GlobalVariable.drawCashierAcc6Pwd)

WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 4)

WebUI.navigateToUrl(((GlobalVariable.URL + '/vouchers/') + (Integer.parseInt(rejectVoucherNum.split('CAP')[1]))) + '/entry')

WebUI.waitForElementPresent(findTestObject('FDR-Draw/reconcileButton'), 2)

WebUI.verifyElementPresent(findTestObject('FDR-Draw/RejectVocuherReceipts/vchrjreasonsubtitle'), 2)

WebUI.verifyTextPresent(rejectionReason1, false)

WebUI.verifyTextPresent(rejectionReason2, false)

WebUI.verifyTextPresent('Incorrect Amount', false)




