import java.util.Arrays;

public class NextPermutation {
    static void nextPermutation(int[] arr){
        int n= arr.length;
        int i=n-2;
        while(i>=0 && arr[i]>=arr[i+1]){
            i--;
        }
        if(i>=0){
            int j=n-1;
            while(arr[j]<=arr[i]){
                j--;
            }
            swap(arr,i,j);
        }
        reverse(arr,i+1,n-1);
    }
    static void swap(int[] arr,int a,int b){
            int temp=arr[a];
            arr[a]=arr[b];
            arr[b]=temp;
    }
    static void reverse(int[] arr,int start,int end){
        while (start<end){
            swap(arr,start,end);
            start++;
            end--;

        }
    }

    static void main(String[] args) {
        int []arr={1,2,3};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
