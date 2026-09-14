package BinarySearch;

import com.sun.source.tree.BreakTree;

public class peakElement {
    public static int findPeakBrute(int[] arr) {

        int n = arr.length;

        // First element
        if (n == 1) {
            return 0;
        }

        if (arr[0] > arr[1]) {
            return 0;
        }

        // Middle elements
        for (int i = 1; i < n - 1; i++) {

            if (arr[i] > arr[i - 1] &&
                    arr[i] > arr[i + 1]) {

                return i;
            }
        }

        // Last element
        if (arr[n - 1] > arr[n - 2]) {
            return n - 1;
        }

        return -1;
    }
    public static int findPeakOptimal(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[mid + 1]) {

                // We are on the increasing side
                // Peak is on the right
                low = mid + 1;

            } else {

                // We are on the decreasing side
                // Peak is at mid or on the left
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 3, 1};

        System.out.println(
                "Brute: " + findPeakBrute(arr)
        );

        System.out.println(
                "Optimal: " + findPeakOptimal(arr)
        );
    }


}