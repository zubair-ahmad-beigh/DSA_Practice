package Revision;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[]arr,int target){
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i< arr.length;i++) {
            int diff = target -arr[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff),i};
            }
            map.put(arr[i],i);
        }
        return new int[]{};
    }

    static void main(String[] args) {
        int []arr={7,2,3,5};
        int[] ans=twoSum(arr,8);
        System.out.println(ans[0]+" "+ans[1]);
    }
}
