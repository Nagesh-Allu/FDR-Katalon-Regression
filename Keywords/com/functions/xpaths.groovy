package com.functions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class xpaths {
	public static String vouchersXpath = '(//div[contains(@class,\'MuiGrid-justify-xs-space-between\')])'
	public static String buttonLabel = '//span[contains(@class,\'MuiButton-label\')]'
	public static String lineGrid = '//*[@data-id=\'line-grid\']'
	public static String amount = '//*[@data-id=\'amount\']'
	public static String dlAttribute = '//*[@data-id=\'distribution-line-attribute\']'
	public static String lineTotal = '//*[@data-id=\'line-total\']'
	public static String taskAttribute  = '//*[@data-id=\'task-attribute\']'
	public static String muiChipLabel = '//*[contains(@class,\'MuiChip-label\')]'
	public static String buttonLink = '//*[@data-id=\'button-link\']'
	public static String actionButton = '//*[@data-id=\'action-button\']'
}
