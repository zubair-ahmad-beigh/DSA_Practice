package BinarySearch;

public class shipWithinDay {
    public static int shipWithinDays(int []weights,int days){
        int max=0;
        int sum=0;
        for(int w:weights){
            max=Math.max(max,w);
            sum+=w;
        }
        for(int capacity=max;capacity<=sum;capacity++){
            int daysUsed=1;
            int currentWeight=0;
            for(int w:weights){
                if(currentWeight+w>capacity){
                    daysUsed++;
                    currentWeight=0;
                }
                currentWeight+=w;

            }
            if(daysUsed<=days){
                return capacity;
            }
        }
        return -1;
    }
    public static int shipWithinDaysOptimal(int[] weights,int days){
        int low=0;
        int high=0;
        for(int w:weights){
            low=Math.max(low,w);
            high+=w;
        }
        while(low<high){
            int mid=low+(high-low)/2;
            int daysUsed=1;
            int curWeight=0;
            for (int w:weights){
                if(curWeight+w>mid){
                    daysUsed++;
                    curWeight=0;
                }
                curWeight+=w;
            }
            if(daysUsed<=days){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    public static void main(String[] args) {

        int[] weights = {1, 2, 3, 4, 5, 6, 7};
        int days = 3;

        System.out.println(shipWithinDays(weights, days));
    }
}
