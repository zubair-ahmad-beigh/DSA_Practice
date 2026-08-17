package Revision.Array;

public class nextPermutation {
    public static void nextPermutationn(int []arr){
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
    static void swap(int []arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        }
        static void reverse(int []arr,int left,int right){
        while(left<right){
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    static void main(String[] args) {
        int []arr={1, 2, 5, 4, 3, 0, 0};
        nextPermutationn(arr);
        for(int num:arr){
            System.out.print(num+" ");
        }
    }

}
