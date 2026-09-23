package BinarySearch;

public class flowerBouquets {
    static boolean canMakeBouquets(int []bloomDay,int day,int m,int k){
        int bouquets=0;
        int consecutive=0;
        for(int bloom:bloomDay){
            if(bloom<=day){
                consecutive++;
                if(consecutive==k){
                    bouquets++;
                    consecutive=0;
                }
            }else{
                consecutive=0;
            }
        }
        return bouquets>=m;
    }
    static int minDaysBrute(int []bloomDay,int m,int k){
        int maxDay=0;
        for(int day:bloomDay){
            maxDay=Math.max(maxDay,day);
        }
        for (int day=1;day<=maxDay;day++){
            if(canMakeBouquets(bloomDay,day,m,k)){
                return day;
            }
        }
        return -1;
    }
    static boolean canMakeeBouquets(int []bloomDay,int day,int m,int k){
        int bouquets=0;
        int consecutive=0;
        for(int bloom:bloomDay){
            if(bloom<=day){
                consecutive++;
                if(consecutive==k){
                    bouquets++;
                    consecutive=0;
                }
            }else{
                consecutive=0;
            }
        }
        return bouquets>=m;
    }
    static int minDays(int[] bloomDay,int m,int k){
        if((long)m*k>bloomDay.length){
            return -1;
        }
        int low=1;
        int high=0;
        for(int day:bloomDay){
            high=Math.max(high,day);
        }
        while(low<high){
            int mid=low+(high-low)/2;
            if(canMakeeBouquets(bloomDay,mid,m,k)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }

    static void main(String[] args) {
        int []bloomDay={1,10,3,10,2};
        int m=3;
        int k=1;
//        int answer=minDaysBrute(bloomDay,m,k);
//        System.out.println("Minimum days="+answer);
        int answer=minDays(bloomDay,m,k);
        System.out.println("Minimum days= "+answer);
    }

}
