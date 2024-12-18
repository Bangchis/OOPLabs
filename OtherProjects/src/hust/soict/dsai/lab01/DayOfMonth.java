package hust.soict.dsai.lab01;

import java.util.Scanner;

public class DayOfMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = 0;
        int month = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter year: ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year >= 0) {
                    validInput = true;
                } else {
                    System.out.println("Invalid year.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid year.");
                scanner.next(); // clear non legit inputs
            }
        }

        validInput = false;
        while (!validInput) {
            System.out.print("Enter month: ");
            if (scanner.hasNextInt()) {
                month = scanner.nextInt();
                if (month >= 1 && month <= 12) {
                    validInput = true;
                } else {
                    System.out.println("Invalid month. Please enter a number between 1 and 12.");
                }
            } else {
                String monthStr = scanner.next();
                month = getMonthFromString(monthStr);
                if (month != -1) {
                    validInput = true;
                } else {
                    System.out.println("Invalid month. Please enter a valid month name or abbreviation.");
                }
            }
        }

        int days = getDaysInMonth(month, year);
        System.out.println("Number of days: " + days);
    }

    private static int getMonthFromString(String monthStr) {
        switch (monthStr.toLowerCase()) {
            case "january":
            case "jan.":
            case "jan":
                return 1;
            case "february":
            case "feb.":
            case "feb":
                return 2;
            case "march":
            case "mar.":
            case "mar":
                return 3;
            case "april":
            case "apr.":
            case "apr":
                return 4;
            case "may":
                return 5;
            case "june":
            case "jun":
                return 6;
            case "july":
            case "jul":
                return 7;
            case "august":
            case "aug.":
            case "aug":
                return 8;
            case "september":
            case "sep.":
            case "sep":
                return 9;
            case "october":
            case "oct.":
            case "oct":
                return 10;
            case "november":
            case "nov.":
            case "nov":
                return 11;
            case "december":
            case "dec.":
            case "dec":
                return 12;
            default:
                return -1;
        }
    }

    private static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: 
            case 3: 
            case 5:
            case 7: 
            case 8: 
            case 10: 
            case 12: 
                return 31;
            case 4: 
            case 6: 
            case 9: 
            case 11: 
                return 30;
            case 2: // February
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return -1;
        }
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
