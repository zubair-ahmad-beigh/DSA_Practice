package Revision.Array;

public class MaximumProfit {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

    public static int maxProfitt(int[] prices) {
        int n = prices.length;
        int[] suffixMatrix = new int[n];
        suffixMatrix[n - 1] = prices[n - 1];
        for (int i = n - 2; i >= 0; i++) {
            suffixMatrix[i] = Math.max(prices[i], suffixMatrix[i + 1]);
        }
        int maxprofit = 0;
        for (int i = 0; i < n - 1; i++) {
            int profit = suffixMatrix[i + 1] - prices[i];
            maxprofit = Math.max(maxprofit, profit);
        }
        return maxprofit;
    }

    public static int maxProffit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            // Minimum buying price
            minPrice = Math.min(minPrice, prices[i]);

            // Profit if we sell today
            int profit = prices[i] - minPrice;

            // Maximum profit
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }



    static void main(String[] args) {
        int []prices={1,2,3,2,3,5,6,7};
        System.out.println(maxProffit(prices));

    }
}
