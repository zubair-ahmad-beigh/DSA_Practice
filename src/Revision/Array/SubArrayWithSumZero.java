package Revision.Array;

import java.util.HashMap;

public class SubArrayWithSumZero {
    static int maxLen(int []arr){
        int n=arr.length;
        int maxLength=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
                if(sum==0){
                    int length=j-i+1;
                    maxLength=Math.max(maxLength,length);
                }
            }
        }
        return maxLength;
    }
    static int maxxLen(int []arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                maxLength = i + 1;
            }
            if (map.containsKey(sum)) {
                int length = i - map.get(sum);
                maxLength = Math.max(maxLength, length);
            } else {
                map.put(sum, i);
            }
        }
        return maxLength;
    }

    static void main(String[] args) {
        int []arr={9, -3, 3, -1, 6, -5};
        int answer=maxLen(arr);
        System.out.println("Longest zero sum subArray length:"+answer);
        System.out.println("Longest zero sum subArray length:"+maxLen(arr));
    }
}
