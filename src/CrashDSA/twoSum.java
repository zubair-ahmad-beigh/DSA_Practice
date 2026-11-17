package CrashDSA;

import java.util.Arrays;
import java.util.HashMap;

public class twoSum {
    public static int[] twoSum(int []arr,int target){
        for(int i=0;i< arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    public static int[] twoSumOptimal(int[] arr,int target){
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i< arr.length;i++){
            int required=target-arr[i];
            if(map.containsKey(required)){
                return new int[]{map.get(required),i};
            }
            map.put(arr[i],i);
        }
        return new int[]{-1,-1};
    }

    static void main(String[] args) {
        int []arr={2,7,11,15};
        int target=9;
        System.out.println(Arrays.toString(twoSum(arr,target)));
        System.out.println(Arrays.toString(twoSumOptimal(arr,target)));
    }
}
