package BinarySearch;

public class MinInRotatedArray {
    public static int findMinBrute(int[]arr){
        int min=arr[0];
        for(int i=1;i< arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }
    public static int finMinBetter(int[]arr){
        for(int i=0;i< arr.length;i++){
            if(arr[i]>arr[i+1]){
                return arr[i+1];
            }
        }
        return arr[0];
    }
    public static int findMinOptimal(int[]arr){
        int low=0;
        int high= arr.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(arr[mid]>arr[high]){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return arr[low];
    }
    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 7, 0, 1, 2};

        System.out.println("Brute: " + findMinBrute(arr));

        System.out.println("Better: " + finMinBetter(arr));

        System.out.println("Optimal: " + findMinOptimal(arr));
    }
}
