package Revision.Array;

public class CountInversion {

    // Brute Force
    public static int countInversionss(int[] arr) {

        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }

        return count;
    }


    // Optimal
    public static int countInversion(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }


    private static int mergeSort(int[] arr, int low, int high) {

        if (low >= high) {
            return 0;
        }

        int mid = low + (high - low) / 2;

        int count = 0;

        // LEFT HALF
        count += mergeSort(arr, low, mid);

        // RIGHT HALF
        count += mergeSort(arr, mid + 1, high);

        // MERGE + COUNT INVERSIONS
        count += merge(arr, low, mid, high);

        return count;
    }


    private static int merge(int[] arr, int low, int mid, int high) {

        int i = low;
        int j = mid + 1;

        int count = 0;

        int[] temp = new int[high - low + 1];

        int k = 0;

        while (i <= mid && j <= high) {

            if (arr[i] <= arr[j]) {

                temp[k++] = arr[i++];

            } else {

                count += (mid - i + 1);

                temp[k++] = arr[j++];
            }
        }

        // Remaining left elements
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Remaining right elements
        while (j <= high) {
            temp[k++] = arr[j++];
        }

        // Copy back
        for (int x = low; x <= high; x++) {
            arr[x] = temp[x - low];
        }

        return count;
    }


    public static void main(String[] args) {

        int[] arr = {5, 3, 2, 4, 1};

        System.out.println(countInversion(arr));
    }
}