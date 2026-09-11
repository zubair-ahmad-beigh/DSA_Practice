package Revision.Array;

public class ReversePairs {
    static int reversePairs(int []arr){
        int count=0;
        int n= arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((long)arr[i]>2L*arr[j]){
                    count++;
                }
            }
        }
        return count;
    }
    static int reverse(int[]arr){
        return mergesort(arr,0,arr.length-1);
    }
    private static int mergesort(int[] arr,int low,int high){
        if(low>=high){
            return 0;
        }
        int mid=low+(high-low)/2;
        int count=0;
        count+=mergesort(arr, low, mid);
        count+=mergesort(arr,mid+1,high);
        count+=countPairs(arr,low,mid,high);
        merge(arr,low,mid,high);
        return count;
    }
    private static int countPairs(int[] arr,int low,int mid,int high){
        int count=0;
        int j=mid+1;
        for(int i=low;i<=mid;i++){
            while(j<=high && (long)arr[i]>2L*arr[j]){
                j++;
            }
            count+=j-(mid+1);
        }
        return count;
    }
    private static void merge(int[] arr,int low,int mid,int high){
        int[]temp=new int[high-low+1];
        int i=low;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=high){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }
        while(i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            arr[low + x] = temp[x];
        }
    }
    static void main(String[] args) {
        int []arr={1, 3, 2, 3, 1};
        System.out.println(reversePairs(arr));
        System.out.println(reverse(arr));
    }
}
