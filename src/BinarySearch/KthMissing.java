package BinarySearch;

public class KthMissing {
    public static int kthMissing(int[]arr,int k){
        int number=1;
        while(true){
            boolean found=false;
            for(int value:arr){
                if(value==number) {
                    found = true;
                    break;
                }
            }
            if(!found){
                k--;
                if(k==0){
                    return number;
                }
            }
            number++;
        }
    }
    public static int findKthPositive(int[]arr,int k){
        int previous=0;
        for(int current:arr){
            int gap=current-previous-1;
            if(k<=gap){
                return previous+k;
            }
            k-=gap;
            previous=current;
        }
        return previous+k;
    }
    public static int findKthOptimal(int[]arr,int k){
        int left=0;
        int right= arr.length;
        while(left<right){
            int mid=left+(right-left)/2;
            int missing=arr[mid]-(mid+1);
            if(missing<k){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left+k;
    }

    static void main(String[] args) {

    int[] arr = {2, 3, 4, 7, 11};
    int k = 5;

        System.out.println("Brute force: " + kthMissing(arr, k));
        System.out.println("Better: " + findKthPositive(arr, k));
        System.out.println("Optimal: " + findKthOptimal(arr, k));

}

}
