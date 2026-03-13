import java.util.Arrays;

public class mergeTwoSortedArrays {
    static void merge(int arr1[],int arr2[],int n,int m){
        int left=n-1;
        int right=0;
        while(left>=0 &&right<m){
            if(arr1[left]>arr2[right]){
                swap(arr1,arr2,left,right);
                left--;
                right++;
            }else{
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
    static void swap(int arr1[],int arr2[],int i,int j){
        int temp=arr1[i];
        arr1[i]=arr2[j];
        arr2[j]=temp;
    }
    public static void main(String[] args){
        int arr1[]={1,4,7,8,10};
        int arr2[]={2,3,9};
        merge(arr1,arr2, arr1.length,arr2.length);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}