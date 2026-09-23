package BinarySearch;

public class smallestDivisorThreshold {
    public int smallestDivisor(int[]nums,int threshold){
        int max=0;
        for(int num:nums){
            max=Math.max(max,num);
        }
        for(int div=1;div<=max;div++){
            int sum=0;
            for(int num:nums){
                sum+=(num+div-1)/div;
            }
            if(sum<=threshold){
                return div;
            }
        }
        return -1;
    }
    public static int smallestDivisorOptimal(int[] nums,int threshold){
        int low=1;
        int high=0;
        for(int num:nums){
            high=Math.max(high,num);
        }
        int answer=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            int sum=0;
            for(int num:nums){
                sum+=(num+mid-1)/mid;
            }
            if(sum<=threshold){
                answer=mid;
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        return answer;
    }

    static void main(String[] args) {
        int []nums={1,2,5,9};
        int threshold=6;
        int result=smallestDivisorOptimal(nums,threshold);
        System.out.println("smallest Divisor="+result);
    }
}
