package Revision.Array;
public class Sort0_1_2 {
    public static void sortArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void sorttArray(int[] arr) {

        int zero = 0;
        int one = 0;
        int two = 0;

        for (int num : arr) {

            if (num == 0)
                zero++;

            else if (num == 1)
                one++;

            else
                two++;
        }

        int index = 0;

        while (zero-- > 0)
            arr[index++] = 0;

        while (one-- > 0)
            arr[index++] = 1;

        while (two-- > 0)
            arr[index++] = 2;
    }
    public static void sortAArray(int []arr){
        int low=0;
        int mid=0;
        int high=arr.length-1;
        while(mid<=high){
            if(arr[mid]==0){
                int temp=arr[low];
                arr[low]=arr[mid];
                arr[mid]=temp;
                low++;
                mid++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else{
                int temp=arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        //sorttArray(arr);
        //sortArray(arr);
        sortAArray(arr);
        for (int num : arr) {
            System.out.print(num + " ");


        }
    }
}