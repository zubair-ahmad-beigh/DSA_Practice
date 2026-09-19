package BinarySearch;

public class kokoEatingBananas {
    public static int minEating(int []piles,int h){
        int maxPile=0;
        for (int pile:piles){
            maxPile=Math.max(maxPile,pile);
        }
        for(int k=1;k<=maxPile;k++){
            int hours=0;
            for(int pile:piles){
                hours+=(pile+k-1)/k;
            }
            if(hours<=h){
                return k;
            }
        }
        return -1;
    }
    public static int minEatingSpeed(int[] piles, int h) {

        int maxPile = 0;

        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        int low = 1;
        int high = maxPile;

        int ans = maxPile;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long hours = 0;

            for (int pile : piles) {

                hours += (pile + mid - 1) / mid;
            }

            if (hours <= h) {

                // mid works
                ans = mid;

                // Try smaller speed
                high = mid - 1;

            } else {

                // mid is too slow
                low = mid + 1;
            }
        }

        return ans;
    }

    static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        int answer = minEatingSpeed(piles, h);

        System.out.println(answer);

    }

}

