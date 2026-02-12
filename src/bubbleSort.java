import java.util.Scanner;

public class bubbleSort {
    static void BubbleSort(int[] arr){
        int n= arr.length;
        for(int i=0;i<n-1;i++){
            for (int j = 0; j <n-i-1 ; j++) {
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of the elements:");
        int n=sc.nextInt();
        int[]arr=new int[n];
        System.out.println("Enter"+n+"elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        BubbleSort(arr);
        System.out.println("Sorted Array:");
        for(int num:arr){
            System.out.println(num+" ");
        }
        sc.close();
    }

}
