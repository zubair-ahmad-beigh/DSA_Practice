public class MaximumSubArraySum {

    static int maxSubArray(int[] arr) {

        int maxSum = arr[0];
        int currentSum = 0;

        for (int num : arr) {

            currentSum += num;

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};

        int result = maxSubArray(arr);

        System.out.println("Maximum Subarray Sum: " + result);
    }
}
