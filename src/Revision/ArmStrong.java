package Revision;

import java.util.Scanner;

public class ArmStrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int dup = n;
        int sum = 0;

        while (n > 0) {
            int lastDigit = n % 10;
            sum = sum + (lastDigit * lastDigit * lastDigit);
            n = n / 10;
        }

        if (sum == dup) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        sc.close();
    }
}