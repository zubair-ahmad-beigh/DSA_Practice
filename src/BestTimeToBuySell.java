public class BestTimeToBuySell {
    static int maxProfit(int[] prices){
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int price:prices){
            if(price<minPrice){
                minPrice=price;
            }else{
                int profit=price-minPrice;
                if(profit>maxProfit){
                    maxProfit=profit;
                }
            }
        }
        return maxProfit;
    }

    static void main(String[] args) {
        int []prices={7,5,4,3,2,5,8};
        int result=maxProfit(prices);
        System.out.println("Maximum Profit:"+result);
    }
}
