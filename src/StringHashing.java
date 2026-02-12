import java.util.Scanner;

public class StringHashing {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the input String:");
        String s = sc.next();
        int[] hash = new int[26];
        for (int i = 0; i < s.length() - 1; i++) {
            hash[s.charAt(i) - 'a']++;
        }
        System.out.println("enter the number of the queries:");
        int q = sc.nextInt();
        while (q-- > 0) {
            String c = sc.next();
            char ch = c.charAt(0);
            System.out.println(hash[ch - 'a']);
        }
        sc.close();
    }
}