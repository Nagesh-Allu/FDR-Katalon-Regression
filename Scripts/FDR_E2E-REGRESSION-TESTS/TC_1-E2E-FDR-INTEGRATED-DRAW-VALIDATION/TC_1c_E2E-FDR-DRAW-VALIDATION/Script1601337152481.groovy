/* Project Name : FDR
 * Test Scenario : END_END_TC_1c_Reconcillation process
 * 	List of Receipt Functions are used :
 *
 *Revision Date:10/08/2020

 */
// List of Import packages and libraries

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import com.etoe.commonFunctions as CF
import com.etoe.drawFunctions as DF
import com.global.functions.ChangeDrawDate as DD
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable


def DrawDate=DD.DrawDate()

CF.login(GlobalVariable.superUserAccnt, GlobalVariable.superUserPwd)

CF.selectRole('cashManagementApprover')

WebUI.waitForElementClickable(findTestObject('FDR-Draw/reconcileButton'), 2)
WebUI.delay(30)

//WebUI.click(findTestObject('FDR-Draw/SCOBalances/expandButtonReconcile'))
if(DrawDate!=null)
{
	if(WebUI.waitForElementClickable(DF.ClickReconcillationExpandButton(DrawDate),10))
	WebUI.click(DF.ClickReconcillationExpandButton(DrawDate))
}
else
{
	if(WebUI.waitForElementClickable(DF.ClickReconcillationExpandButton("10/28/2020"),10))
	WebUI.click(DF.ClickReconcillationExpandButton("10/28/2020"))
}

WebUI.waitForElementClickable(findTestObject('FDR-Draw/reconcileButton'), 2)

WebUI.click(findTestObject('FDR-Draw/SCOBalances/reconcileButton'))

WebUI.delay(60)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

DF.updateSCOBalances('550000000')

WebUI.click(findTestObject('Object Repository/FDR-Draw/reviewScreen/expenditureThumsUpButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.scrollToElement(findTestObject('Object Repository/FDR-Draw/reviewScreen/receiptsThumbsUpButton'), 2)

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('Object Repository/FDR-Draw/reviewScreen/receiptsThumbsUpButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('Object Repository/FDR-Draw/reviewScreen/closedIcon'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 1)

WebUI.click(findTestObject('Object Repository/FDR-Draw/reviewScreen/reviewButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('FDR-Draw/reviewScreen/editDraw'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('Object Repository/FDR-Draw/reviewScreen/reviewButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('Object Repository/FDR-Draw/reviewScreen/submitForApproval'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2) 

WebUI.click(findTestObject('FDR-Draw/SCOBalances/expandButtonReconcile'))

WebUI.click(findTestObject('FDR-Draw/reviewScreen/validateButton'))

WebUI.click(findTestObject('Object Repository/FDR-Draw/reviewScreen/expenditureThumsUpButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('Object Repository/FDR-Draw/reviewScreen/receiptsThumbsUpButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('FDR-Draw/reviewScreen/approveButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('FDR-Draw/SCOBalances/expandButtonReconcile'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('FDR-Draw/reviewScreen/printButton'))

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2) 

WebDriver driver = DriverFactory.getWebDriver()

def printXpath = '(//*[@type=\'button\' ]//*[contains(text(),\'Print\')])'

def printCount = driver.findElements(By.xpath(printXpath)).size()

for (int i = 1; i <= printCount; i++) {
    def xpath = ((printXpath + '[') + i) + ']'

    TestObject printButton = new TestObject('printButton')

    printButton.addProperty('xpath', ConditionType.EQUALS, xpath)

    WebUI.click(printButton)
}  

WebUI.click(findTestObject('FDR-Draw/SCOBalances/expandButtonReconcile'))

WebUI.waitForElementClickable(findTestObject('FDR-Draw/reconcileButton'), 2)

WebUI.click(findTestObject('FDR-Draw/reviewScreen/addInfoButton'))

WebUI.waitForElementClickable(findTestObject('FDR-Draw/reconcileButton'), 2)

def jeXpath = '(//*[contains(@name,\'transactionRequestValues\')])'

def jeCount = driver.findElements(By.xpath(jeXpath)).size()

for (int i = 1; i <= jeCount; i++) {
    def xpath = ((jeXpath + '[') + i) + ']'

    TestObject jeInput = new TestObject('jeInput')

    jeInput.addProperty('xpath', ConditionType.EQUALS, xpath)

    WebUI.click(jeInput)

    def jeInputText = 'JE' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(8)

    WebUI.setText(jeInput, jeInputText)
}

def crXpath = "(//*[contains(@name,'remittanceAdviceValues')])"

def crCount = driver.findElements(By.xpath(crXpath)).size()

for (int i = 1; i <= crCount; i++) {
    def xpath = ((crXpath + '[') + i) + ']'

    TestObject crInput = new TestObject('crInput')

    crInput.addProperty('xpath', ConditionType.EQUALS, xpath)

    WebUI.click(crInput)
	
	WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

    def crInputText = 'CR' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(8)

    WebUI.setText(crInput, crInputText)
	
	
}

WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 4)

WebUI.click(findTestObject('FDR-Draw/reviewScreen/saveCloseButton'))


WebUI.waitForElementPresent(findTestObject('FDR-Dashboard/createNewVoucherButton'), 2)

WebUI.click(findTestObject('FDR-Draw/reviewScreen/closeButton'))

CF.logout()