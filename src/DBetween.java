public class DBetween {
    public static void main(String[] args) {
        // Define the two given dates
        int startYear = 2022;
        int startMonth = 1;
        int startDay = 1;
        
        int endYear = 2022;
        int endMonth = 12;
        int endDay = 31;
        
        // Calculate the number of days between the two dates
        int daysBetween = calculateDays(startYear, startMonth, startDay, endYear, endMonth, endDay);
        
        // Print the result
        System.out.println("Number of days between the two dates: " + daysBetween);
    }
    
    // Calculate the number of days between two dates
    public static int calculateDays(int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay) {
        // Days in each month
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        // Calculate total days from start date
        int totalDays = startDay;
        for (int year = startYear; year < endYear; year++) {
            // Add days for each year
            totalDays += isLeapYear(year) ? 366 : 365;
        }
        for (int month = 1; month < startMonth; month++) {
            // Subtract days for each month before start month
            totalDays -= daysInMonth[month - 1];
        }
        
        // Calculate total days to end date
        for (int month = startMonth; month < endMonth; month++) {
            // Add days for each month after start month and before end month
            totalDays += daysInMonth[month - 1];
        }
        totalDays += endDay; // Add days of end month
        
        return totalDays;
    }
    
    // Check if a year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
