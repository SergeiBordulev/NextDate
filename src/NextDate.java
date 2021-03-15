import java.util.Scanner;

public class NextDate {
    private static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter day (digit):");
        int enteredDay = scanner.nextInt();

        System.out.println("Enter month (digit):");
        int enteredMonth = scanner.nextInt();

        System.out.println("Enter year:");
        int enteredYear = scanner.nextInt();

        int daysPerMonthCount;

        if (enteredMonth == 1 || enteredMonth == 3 || enteredMonth == 5 || enteredMonth == 7 || enteredMonth == 8 || enteredMonth == 10 || enteredMonth == 12) {
            daysPerMonthCount = 31;
        } else if (enteredMonth == 4 || enteredMonth == 6 || enteredMonth == 9 || enteredMonth == 11) {
            daysPerMonthCount = 30;
        } else {
            if (isLeapYear(enteredYear)) {
                daysPerMonthCount = 29;
            } else {
                daysPerMonthCount = 28;
            }
        }

        if ((enteredDay > daysPerMonthCount || enteredDay <= 0) || (enteredMonth > 12 || enteredMonth <= 0)) {
            System.out.printf("%d.%d.%d the date does not exist", enteredDay, enteredMonth, enteredYear);
        } else {
            int tomorrowDay;
            int tomorrowMonth = enteredMonth;

            if (enteredDay != daysPerMonthCount) {
                tomorrowDay = enteredDay + 1;
            } else {
                tomorrowDay = 1;
                tomorrowMonth = enteredMonth + 1;
            }

            int tomorrowYear = enteredYear;

            if (enteredMonth == 12) {
                tomorrowMonth = 1;
                tomorrowYear = enteredYear + 1;
            }

            System.out.printf("Yesterday: %02d.%02d.%d", tomorrowDay, tomorrowMonth, tomorrowYear);
        }
    }
}
