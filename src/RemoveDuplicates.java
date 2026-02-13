public class RemoveDuplicates {

    static int removeDuplicates(int[] arr) {

        if (arr.length == 0)
            return 0;

        int i = 0;  // slow pointer

        for (int j = 1; j < arr.length; j++) {

            if (arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }

        return i + 1;  // new length
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 2, 3, 4, 4};

        int newLength = removeDuplicates(arr);

        System.out.println("Array after removing duplicates:");

        for (int k = 0; k < newLength; k++) {
            System.out.print(arr[k] + " ");
        }
    }
}
