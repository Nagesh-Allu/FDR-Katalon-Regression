/* Project Name : FDR
 * Get Seed Data Global Functions: File containing get data seed functions to retrieve reference data 
 * List of global functions used are:
 * 	  	--> getDrawDate
 * Author : Jocelyn Renaud
 * Revision Date: 09/29/20
 */

package com.global.seedDataFunctions

// List of import packages/libraries
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
import com.kms.katalon.core.testdata.ExcelData
import com.kms.katalon.core.testdata.TestDataFactory

import internal.GlobalVariable

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType

public class getSeedDataFunctions {

	// Get Draw Date from seed data file; make sure that draw date is a valid date for processing
	public static String  getDrawDate() {

		ExcelData dataSheet = TestDataFactory.findTestData('FDR-SEED-DATA/SEED-DRAW-DATE')
		return dataSheet.getValue('draw_date',1)
	}


	//JR UPDATE (9/30/20) - Added new Get Seed Data function
	// Get Program Type from seed data file; pick code value randomly
	public static String  getProgramType() {

		ExcelData dataSheet = TestDataFactory.findTestData('FDR-SEED-DATA/SEED-DATA-PROGRAM-TYPES')
		def numOfRows = dataSheet.getRowNumbers()
		int randomNumber = new Random().nextInt(numOfRows) + 1

		return dataSheet.getValue('description',randomNumber)
	}

	//JR UPDATE (9/30/20) - Added new Get Seed Data function
	// Get Invoice Type from seed data file; pick code value randomly
	public static String  getInvoiceType() {

		ExcelData dataSheet = TestDataFactory.findTestData('FDR-SEED-DATA/SEED-DATA-INVOICE-TYPES')
		def numOfRows = dataSheet.getRowNumbers()
		int randomNumber = new Random().nextInt(numOfRows) + 1

		return dataSheet.getValue('description',randomNumber)
	}


	//JR UPDATE (9/30/20) - Added new Get Seed Data function
	// Get Primary Contact from seed data file; pick code value randomly
	public static Object  getPrimaryContact() {

		ExcelData dataSheet = TestDataFactory.findTestData('FDR-SEED-DATA/SEED-DATA-CONTACTS')
		def numOfRows = dataSheet.getRowNumbers()
		int randomNumber = new Random().nextInt(numOfRows) + 1
		def primaryContactInformation = []

		primaryContactInformation.add(dataSheet.getValue('id', randomNumber))
		primaryContactInformation.add(dataSheet.getValue('first_name', randomNumber))
		primaryContactInformation.add(dataSheet.getValue('last_name', randomNumber))

		//primaryContactInformation.addProperty('id',ConditionType.EQUALS,dataSheet.getValue('id',randomNumber))
		//primaryContactInformation.addProperty('first_name',ConditionType.EQUALS,dataSheet.getValue('first_name',randomNumber))
		//primaryContactInformation.addProperty('last_name',ConditionType.EQUALS,dataSheet.getValue('last_name',randomNumber))

		//return dataSheet.getValue('first_name',randomNumber) + " " + dataSheet.getValue('last_name',randomNumber)
		return primaryContactInformation
	}

	//JR UPDATE (9/30/20) - Added new Get Seed Data function
	// Get Secondary Contact from seed data file; exclude Primary Contact from list
	public static String  getSecondaryContact(primaryContactID) {

		ExcelData dataSheet = TestDataFactory.findTestData('FDR-SEED-DATA/SEED-DATA-CONTACTS')

		def numOfRows = dataSheet.getRowNumbers()
		int randomNumber = new Random().nextInt(numOfRows) + 1

		while (primaryContactID == dataSheet.getValue('id',randomNumber)){
			randomNumber = Random().nextInt(numOfRows) + 1
		}

		return dataSheet.getValue('first_name',randomNumber) + " " + dataSheet.getValue('last_name',randomNumber)
	}

}
