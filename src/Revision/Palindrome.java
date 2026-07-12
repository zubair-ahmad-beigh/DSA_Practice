package Revision;

import java.util.Scanner;

public class Palindrome {
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        for(int i=1;i<5;i++) {
            int n = sc.nextInt();

            int dup = n;
            int rev = 0;
            while (n > 0) {
                int lastDigit = n % 10;
                rev = rev * 10 + lastDigit;
                n = n / 10;
            }
            if (rev == dup) {
                System.out.println("this is palindrome");
            } else {
                System.out.println("not the palindrome");
            }
        }
            sc.close();

        }
    }
