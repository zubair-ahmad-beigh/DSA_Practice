package Revision.Array;

import java.util.HashMap;

public class LongestSubArray {
    public static int longSub(int []arr,int k) {
        int n = arr.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];

                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
    public static void longSubb(int[] arr, int k) {

        int maxLen = 0;
        int start = -1;
        int end = -1;

        for (int i = 0; i < arr.length; i++) {

            int sum = 0;

            for (int j = i; j < arr.length; j++) {

                sum += arr[j];

                if (sum == k && (j - i + 1) > maxLen) {

                    maxLen = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }

        System.out.print("Longest Subarray: ");

        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        System.out.println("Sum = " + maxLen);
    }
    public static int LongestSubArray(int[]arr,int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLen = i + 1;
            }
            if (map.containsKey(sum - k)) {
                int len = i - map.get(sum - k);
                maxLen = Math.max(maxLen, len);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
    public static int LongSubArray(int[]arr,int k){
        int left=0;
        int right=0;
        int sum=0;
        int maxLen=0;
        while(right<arr.length){
            sum+=arr[right];
            while(sum>k){
                sum-=arr[left];
                left++;
            }
            if(sum==k){
                maxLen=Math.max(maxLen,right-left+1);
            }
            right++;
        }
        return maxLen;
    }

    static void main(String[] args) {
        int []arr={1,2,3,1,1,1,2};
        int k=3;
        longSubb(arr,k);
        System.out.println("Longest SubArray:"+LongestSubArray(arr,k));
        System.out.println("Longest SubArray:"+LongSubArray(arr,k));

    }
}
