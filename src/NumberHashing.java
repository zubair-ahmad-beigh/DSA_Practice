import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumberHashing {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        // Array creation
        int[] arr = new int[n];

        // Array input
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // HashMap for frequency
        Map<Integer, Integer> map = new HashMap<>();

        // Frequency count
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // Queries
        System.out.println("Enter number of queries:");
        int q = sc.nextInt();

        while (q-- > 0) {
            System.out.println("Enter number to find frequency:");
            int number = sc.nextInt();
            System.out.println("Frequency: " + map.getOrDefault(number, 0));
        }

        sc.close();
    }
}
