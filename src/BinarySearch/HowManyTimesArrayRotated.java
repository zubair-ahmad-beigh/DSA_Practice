package BinarySearch;

public class HowManyTimesArrayRotated {
    static int rotationCountBrute(int[]arr){
        int minIndex=0;
        for(int i=1;i< arr.length;i++){
            if(arr[i]<arr[minIndex]){
                minIndex=i;
            }
        }
        return minIndex;
    }
    static int rotationCountBetter(int[]arr){
        for (int i=0;i< arr.length;i++){
            if(arr[i]>arr[i+1]){
                return i+1;
            }
        }
        return 0;
    }
    static int rotationCountOptimal(int[]arr){
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
        return low;
    }
    static void main(String[] args) {

        int[] arr = {4, 5, 6, 7, 1, 2, 3};

        System.out.println("Brute: " + rotationCountBrute(arr));

        System.out.println("Better: " + rotationCountBetter(arr));

        System.out.println("Optimal: " + rotationCountOptimal(arr));
    }
}
