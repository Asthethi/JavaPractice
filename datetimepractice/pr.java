
package datetime;

import java.text.ParseException;
import java.time.Year;
import java.util.HashMap;

public class daysBetween {
	private static HashMap<Integer, Integer> monthsMap = new HashMap<>();

	public static void main(String[] args) throws ParseException {

		monthsMap.put(1, 31);
		monthsMap.put(2, 28);
		monthsMap.put(3, 31);
		monthsMap.put(4, 30);
		monthsMap.put(5, 31);
		monthsMap.put(6, 30);
		monthsMap.put(7, 31);
		monthsMap.put(8, 31);
		monthsMap.put(9, 30);
		monthsMap.put(10, 31);
		monthsMap.put(11, 30);
		monthsMap.put(12, 31);
		System.out.println(findDays(01, 01, 2001, 31, 12, 2005));
	}

	private static int findDays(int day_date1, int month_date1, int year_date1, int day_date2, int month_date2,
			int year_date2) throws ParseException {
		/// logic to calculate number of days between given two dates

		int startDateRemainingDays = 0;

		startDateRemainingDays = Year.of(year_date1).isLeap() ? startDateRemainingDays + 1 : startDateRemainingDays;

		startDateRemainingDays = calculateDaysInYear(month_date1, day_date1);

		int counter = 0;

		for (int yr = year_date1 + 1; yr < year_date2; yr++) {
			if (Year.of(yr).isLeap())
				counter++;
		}

		int daysInBetween = 365 * ((year_date2) - (year_date1 + 1)) + counter;

		int yearsDay = Year.of(year_date2).isLeap() ? 366 : 365;
		yearsDay = yearsDay - calculateDaysInYear(month_date2, day_date2);

		return startDateRemainingDays + yearsDay + daysInBetween;

	}

	// It Calculates the number of days remaining from the provided month and date
	// till the last month of the year
	private static int calculateDaysInYear(int month, int date) {
		int daysBetween = 0;
		for (int i = month; i <= 12; i++) {
			int numOfDaysInMonth = monthsMap.get(i);
			if (i == month)
				daysBetween = daysBetween + (numOfDaysInMonth - date);
			else
				daysBetween = daysBetween + numOfDaysInMonth;

		}

		return daysBetween;
	}

}
