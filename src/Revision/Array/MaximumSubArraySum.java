package Revision.Array;

public class MaximumSubArraySum {
    public static int MaxSubb(int []arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
    public static int MaxArray(int []arr){
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i< arr.length;i++){
            int sum=0;
            for(int j=i;j< arr.length;j++){
                sum+=arr[j];
                maxSum=Math.max(maxSum,sum);
            }
        }
        return maxSum;
    }
    public static int Kadane(int []arr){
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i< arr.length;i++){
            sum=Math.max(arr[i],sum+arr[i]);
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }

    static void main(String[] args) {
        int []arr={-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(Kadane(arr));



    }
}