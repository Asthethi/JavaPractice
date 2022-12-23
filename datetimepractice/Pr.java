package coreJavaPractice.stack;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

public class Pr {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		System.out.println(findDays(15, 12, 1993, 15, 12, 1994));

	}

	static int findDays(int day_date1, int month_date1, int year_date1, int day_date2, int month_date2, int year_date2)
			throws ParseException {
		/// logic to calculate number of days between given two dates

		HashMap<Integer, Integer> monthsMap = new HashMap<>();
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

		int days = 0;
		if (Year.of(year_date1).isLeap())
			days = days + 1;

		for (int i = month_date1; i <= 12; i++) {
			int numOfDaysInMonth = monthsMap.get(month_date1);
			if (i == month_date1)
				days = days + (numOfDaysInMonth - day_date1);
			else
				days = days + numOfDaysInMonth;

		}

		for (int yr = year_date1 + 1; yr <= year_date2; yr++) {

			if (Year.of(yr).isLeap())
				days = days + 366;
			else
				days = days + 365;
		}
		
		int newDays = 0;
		for(int j=1; j<=month_date2;j++) {
			if (j == month_date2)
				newDays = newDays + (monthsMap.get(j) - day_date2);
			else
				newDays = newDays + monthsMap.get(j);
		}
		

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
		String inputString1 = "15 12 1993";
		String inputString2 = "15 12 1994";
		LocalDate date1 = LocalDate.parse(inputString1, dtf);
		LocalDate date2 = LocalDate.parse(inputString2, dtf);
		long daysBetween = ChronoUnit.DAYS.between(date1, date2);
		System.out.println(daysBetween);
//		
//		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
//
//		Date date11 = myFormat.parse(inputString1);
//	    Date date22 = myFormat.parse(inputString2);
//	    long diff = date22.getTime() - date11.getTime();
//	    System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));

		return days;

	}

}
