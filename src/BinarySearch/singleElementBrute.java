package BinarySearch;

public class singleElementBrute {
    public static int singleElementBrute(int[] arr) {

        int n = arr.length;

        if (n == 1) {
            return arr[0];
        }

        if (arr[0] != arr[1]) {
            return arr[0];
        }

        if (arr[n - 1] != arr[n - 2]) {
            return arr[n - 1];
        }

        for (int i = 1; i < n - 1; i++) {

            if (arr[i] != arr[i - 1] &&
                    arr[i] != arr[i + 1]) {

                return arr[i];
            }
        }

        return -1;
    }
    static int singleElementBetter(int[]arr){
        int xor=0;
        for(int num:arr){
            xor=xor^num;
        }
        return xor;
    }
    public static int singleElementOptimal(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            // Make mid even
            if (mid % 2 == 1) {
                mid--;
            }

            if (arr[mid] == arr[mid + 1]) {

                // Pair is correct
                // Single element is on right
                low = mid + 2;

            } else {

                // Pair is broken
                // Single element is on left or at mid
                high = mid;
            }
        }

        return arr[low];
    }
    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 2, 3, 4, 4, 5, 5};

        System.out.println("Brute: " + singleElementBrute(arr));

        System.out.println("Better: " + singleElementBetter(arr));

        System.out.println("Optimal: " + singleElementOptimal(arr));
    }
}
