import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principal = 0;
        float annualInterest = 0;
        float monthlyInterest = 0;
        int noOfPayments = 0;
        byte year = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Mortgage Calculator");

        while (true) {
            System.out.print("Principal ($1k - $1M): ");
            principal = scanner.nextInt();
            if (principal >= 1_000 && principal <= 1_000_000)
                break;
            else {
                System.out.println("Enter a number between 1,000 and 1,000,000.");
            }
        }

        while (true) {
            System.out.print("Annual Interest Rate (): ");
            annualInterest = scanner.nextFloat();
            if (annualInterest > 0.00 && annualInterest <= 30) {
                monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;
                break;
            } else {
                System.out.println("Enter a value greater than 0 or equal or less than 30.");
            }
        }

        while (true) {
            System.out.print("Period (In Years): ");
            year = scanner.nextByte();
            if (year > 1 && year <= 30) {
                noOfPayments = year * MONTHS_IN_YEAR;
                break;
            } else
                System.out.println("Enter a value between 1 and 30.");
        }

        double mortgage = principal * ((monthlyInterest * Math.pow(1 + monthlyInterest, noOfPayments)) / (Math.pow(1 + monthlyInterest, noOfPayments) - 1));
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}