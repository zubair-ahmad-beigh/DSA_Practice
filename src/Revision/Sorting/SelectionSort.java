package Revision.Sorting;
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    public static void bubbleSort(int[] arr){
        int n1= arr.length;
        for(int i=0;i<n1-1;i++){
            for(int j=0;j<n1-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void InsertionSort(int []arr3){
        int n= arr3.length;
        for (int i = 0; i < n; i++) {
            int key=arr3[i];
            int j=i-1;
            while(j>=0 && arr3[j]>key){
                arr3[j+1]=arr3[j];
                j--;
            }
            arr3[j+1]=key;
            
        }
    }
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        int[] arr1 = {6, 2, 1, 22, 11};
        selectionSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
        bubbleSort(arr1);
        for (int num1:arr1){
            System.out.println(num1+ " ");
        }
        int []arr3={6,4,3,7,8,9,1};
        InsertionSort(arr3);
        for (int num3:arr3){
            System.out.print(num3+" ");
        }
    }
}