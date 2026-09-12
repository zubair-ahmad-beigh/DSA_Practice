package BinarySearch;

public class searchInRotatedArray {
    public static int searchBrute(int[]arr,int target){
        for(int i=0;i< arr.length;i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
    public static int searchBetter(int[]arr,int target){
        int n= arr.length;
        int pivot=0;
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                pivot=i+1;
                break;
            }
        }
        int result=binarySearch(arr,target,0,pivot-1);
        if(result!=-1){
            return result;
        }
        return binarySearch(arr,target,pivot,n-1);
    }
    private static int binarySearch(int[]arr,int target,int low,int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid]<target){
                low=mid+1;

            }else{
                high=mid-1;
            }
        }
        return -1;
    }
    public static int searchOptimal(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            else {
                if (arr[mid] < target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println("Brute: " + searchBrute(arr, target));
        // Better
        System.out.println("Better: " + searchBetter(arr, target));

        // Optimal
        System.out.println("Optimal: " + searchOptimal(arr, target));
    }
}
