package com.functions

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalAdjusters
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject

public class util {

	public static String  getNearMonORWed() {
		LocalDate day = LocalDate.now().plusDays(10)
		LocalDate wed = day.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
		LocalDate mon = day.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		long daysBetween = ChronoUnit.DAYS.between(wed, mon)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");
		if (daysBetween > 0)
			return formatter.format(wed)
		else
			return formatter.format(mon)
	}

	public static Float convertToNum(TestObject object) {
		def amountWith$ = WebUI.getText(object)
		if (amountWith$.contains("(")) {
			return ("-" + amountWith$.replaceAll("[^\\d.]", "")) as Float
		} else {
			return amountWith$.replaceAll("[^\\d.]", "") as Float
		}
	}
}
