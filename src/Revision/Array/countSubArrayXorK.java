package Revision.Array;

import java.util.HashMap;

public class countSubArrayXorK {
    static int countSubArray(int[] arr,int k){
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {

            int xor = 0;

            for (int j = i; j < n; j++) {

                xor = xor ^ arr[j];

                if (xor == k) {
                    count++;
                }
            }
        }

        return count;
    }
    static int countSubarrays(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int xor = 0;
        int count = 0;

        // Empty prefix
        map.put(0, 1);

        for (int num : arr) {

            xor = xor ^ num;

            int required = xor ^ k;

            if (map.containsKey(required)) {
                count += map.get(required);
            }

            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return count;
    }
    static void main(String[] args) {
        int []arr={4,2,2,6,4};
        int k=6;
        int answer=countSubArray(arr,k);
        System.out.println("count "+answer);
        System.out.println("count "+countSubarrays(arr,k));
    }
}
