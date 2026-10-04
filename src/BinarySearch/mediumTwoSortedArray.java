package BinarySearch;

public class mediumTwoSortedArray {
    public static double findMedianBrute(int[] nums1,int[] nums2 ){
        int n=nums1.length;
        int m=nums2.length;
        int []merged=new int[n+m];
        int i=0;
        int j=0;
        int k=0;
        while(i<n && j<m){
            if(nums1[i]<=nums2[j]){
                merged[k++]=nums1[i++];
            }else{
                merged[k++]=nums2[j++];
            }
        }
        while(i<n){
            merged[k++]=nums1[i++];
        }
        while(j<m){
            merged[k++]=nums2[j++];
        }
        int total=n+m;
        if(total%2==1){
            return merged[total/2];
        }
        return (merged[total/2-1]+merged[total/2])/2.0;
    }
    public static double findMedianBetter(int []nums1,int []nums2){
        int n=nums1.length;
        int m=nums2.length;
         int i=0;
         int j=0;
         int prev=0;
         int curr=0;
         int total=n+m;
         for(int count=0;count<=total/2;count++){
             prev=curr;
             if(i<n && (j>=m || nums1[i]<=nums2[j])){
                 curr=nums1[i++];
             }else{
                 curr=nums2[j++];
             }
         }
         if(total% 2==1){
             return curr;
         }
         return (prev+curr)/2.0;
    }
    public static double findMediumOptimal(int []nums1,int []nums2){
        if(nums1.length>nums2.length){
            return findMediumOptimal(nums2,nums1);
        }
        int n=nums1.length;
        int m=nums2.length;
        int low=0;
        int high=n;
        int total=n+m;
        while(low<=high){
            int cut1=low+(high-low)/2;
            int cut2=(total+1)/2-cut1;
            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int right1 = (cut1 == n) ? Integer.MAX_VALUE : nums1[cut1];

            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int right2 = (cut2 == m) ? Integer.MAX_VALUE : nums2[cut2];

            // Correct partition
            if (left1 <= right2 && left2 <= right1) {

                // Odd total elements
                if (total % 2 == 1) {
                    return Math.max(left1, left2);
                }

                // Even total elements
                return (Math.max(left1, left2)
                        + Math.min(right1, right2)) / 2.0;
            }

            // nums1's left side is too big
            else if (left1 > right2) {
                high = cut1 - 1;
            }

            // nums1's left side is too small
            else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }

    static void main(String[] args) {

    }
}