package BinarySearch;

public class FloorAndCeil {
    public static int[]floorCeil(int []arr,int x){
        int floor=-1;
        int ceil=-1;
        for(int num:arr){
            if(num<=x){
                floor=num;
            }
            if(num>=x){
                ceil=num;
                break;
            }
        }
        return new int[]{floor,ceil};
    }
    static int[]optimal(int []arr,int x) {
        int low = 0;
        int high = arr.length - 1;

        int floor = -1;
        int ceil = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {

                // Same element is both floor and ceil
                floor = arr[mid];
                ceil = arr[mid];
                break;

            } else if (arr[mid] < x) {

                // Possible floor
                floor = arr[mid];

                // Search right for a bigger valid floor
                low = mid + 1;

            } else {

                // Possible ceil
                ceil = arr[mid];

                // Search left for a smaller valid ceil
                high = mid - 1;
            }
        }
        return new int[]{floor, ceil};
    }
    static void main(String[] args) {
        int[] arr={1, 2, 4, 6, 8, 10};
        int x=5;
        //int[] result=floorCeil(arr,x);
        int []result=optimal(arr,x);
        System.out.println("floor: "+result[0]);
        System.out.println("ceil: "+result[1]);
    }
}
