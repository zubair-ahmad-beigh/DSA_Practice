package BinarySearch;

public class FirstAndLastOccurance {
    public static int[] firstAndLast(int[] arr, int target) {
        int first = -1;
        int last = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }
        return new int[]{first, last};
    }

    static int[] optimal(int[] arr, int target) {
        int first = -1;
        int last = -1;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        low = 0;
        high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                last = mid;
                low = mid + 1;         // RIGHT jao
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return new int[]{first, last};
    }

    static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 4, 5, 6};

        int target = 2;

        int[] ans = optimal(arr, target);

        System.out.println("First: " + ans[0]);
        System.out.println("Last: " + ans[1]);
    }
}

