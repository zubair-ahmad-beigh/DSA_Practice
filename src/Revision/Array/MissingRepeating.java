package Revision.Array;

public class MissingRepeating {
    static int[] findMissingAndRepeating(int[]arr){
        int n=arr.length;
        int repeating=-1;
        int missing=-1;
        for(int num=1; num<=n;num++){
            int count=0;
            for(int i=0;i<n;i++){
                if(arr[i]==num){
                    count++;
                }
            }
            if(count==2){
                repeating=num;
            }
            if(count==0){
                missing=num;
            }
        }
        return new int[]{repeating,missing};
    }
    static int[] findMissingAndRepeatingg(int[]arr){

        int n = arr.length;

        // Step 1: XOR all numbers from 1 to N
        // and all elements of array
        int xor = 0;

        for (int i = 1; i <= n; i++) {
            xor = xor ^ i;
        }

        for (int num : arr) {
            xor = xor ^ num;
        }

        // Now:
        // xor = missing ^ repeating

        // Step 2: Find rightmost set bit
        int bit = xor & -xor;

        int x = 0;
        int y = 0;

        // Step 3: Divide numbers from 1 to N into two groups
        for (int i = 1; i <= n; i++) {

            if ((i & bit) != 0) {
                x = x ^ i;
            } else {
                y = y ^ i;
            }
        }

        // Divide array elements into two groups
        for (int num : arr) {

            if ((num & bit) != 0) {
                x = x ^ num;
            } else {
                y = y ^ num;
            }
        }

        // x and y are:
        // one = missing
        // one = repeating

        int repeating = -1;
        int missing = -1;

        // Step 4: Find which one is repeating
        for (int num : arr) {

            if (num == x) {
                repeating = x;
                break;
            }

            if (num == y) {
                repeating = y;
                break;
            }
        }

        // The other one is missing
        if (repeating == x) {
            missing = y;
        } else {
            missing = x;
        }

        return new int[]{repeating, missing};
    }
    static int[] findMissAndRepeat(int[]arr){
        int n=arr.length;
        long expectedSum=(long)n*(n+1)/2;
        long expectedSquareSum=(long)n*(n+1)*(2L*n+1)/6;
        long actualSum=0;
        long actualSquareSum=0;
        for(int num:arr){
            actualSum+=num;
            actualSquareSum+=(long)num*num;
        }
        long diff=expectedSum-actualSum;
        long squareDiff=expectedSquareSum-actualSquareSum;
        long sum=squareDiff/diff;
        long missing=(diff+sum)/2;
        long repeating=missing-diff;
        return new int[]{
                (int)repeating,(int)missing
        };
    }


    static void main(String[] args) {
        int []arr={4, 3, 6, 2, 1, 1};
        //int []answer=findMissingAndRepeating(arr);
        //int []answer=findMissingAndRepeatingg(arr);
        int []answer=findMissAndRepeat(arr);
        System.out.println("Repeating: "+answer[0]);
        System.out.println("Missing: "+answer[1]);
    }
}
