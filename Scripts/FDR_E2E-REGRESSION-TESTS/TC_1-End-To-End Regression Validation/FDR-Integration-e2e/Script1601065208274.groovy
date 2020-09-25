import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('FDR_E2E-REGRESSION-TESTS/TC_1-End-To-End Regression Validation/FDR-Validation-Voucher'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('FDR_E2E-REGRESSION-TESTS/TC_1-End-To-End Regression Validation/FDR-Validation-Receipt'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('FDR_E2E-REGRESSION-TESTS/TC_1-End-To-End Regression Validation/FDR-Validation-Draw'), [:], FailureHandling.STOP_ON_FAILURE)