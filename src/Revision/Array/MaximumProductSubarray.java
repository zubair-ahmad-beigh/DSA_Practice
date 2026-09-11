package Revision.Array;

public class MaximumProductSubarray {
    static int brute (int []arr){
        int n= arr.length;
        int maxProduct=Integer.MIN_VALUE;
        for (int i = 0; i <n ; i++) {
            for (int j = i; j < n; j++) {
                int product=1;
                for (int k = i; k <= j; k++) {
                    product*=arr[k];
                }
                maxProduct=Math.max(maxProduct,product);
            }
        }
        return maxProduct;
    }
    static int better(int[]arr){
        int n= arr.length;
        int maxProduct=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int product=1;
            for(int j=i;j<n;j++){
                product*=arr[j];
                maxProduct=Math.max(maxProduct,product);
            }
        }
        return maxProduct;
    }
    static int optimal(int[] arr) {

        int maxEnding = arr[0];
        int minEnding = arr[0];

        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int current = arr[i];

            int tempMax = Math.max(
                    current,
                    Math.max(maxEnding * current,
                            minEnding * current)
            );

            int tempMin = Math.min(
                    current,
                    Math.min(maxEnding * current,
                            minEnding * current)
            );

            maxEnding = tempMax;
            minEnding = tempMin;

            answer = Math.max(answer, maxEnding);
        }

        return answer;
    }

    static void main(String[] args) {
        int[]arr={2, 3, -2, 4};
        System.out.println(brute(arr));
        System.out.println(better(arr));
        System.out.println(optimal(arr));
    }
}
