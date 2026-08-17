package Revision.Array;

import java.util.HashMap;

public class TwoSum {
    public static int[] TwoSum(int[]arr,int k){
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]==k){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    public static int[] TwwoSSum(int []arr,int k){
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i< arr.length;i++){
            int complement=k-arr[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(arr[i],i);
        }
        return new int[]{-1,-1};
    }
    public static boolean TS(int []arr,int k){
        int left=0;
        int right= arr.length-1;
        while(left<right){
            int sum=arr[left]+arr[right];
            if(sum==k){
                return true;
            }
            else if(sum<k){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
    

    static void main(String[] args) {
//        int[]arr={1,3,4,5,3,4};
//        int k=6;
//        int[]ans=TwoSum(arr,k);
//        int []ams=TwwoSSum(arr,k);
//
//        System.out.println("Index 1:"+ans[0]);
//        System.out.println("Index 2:"+ans[1]);
//        System.out.println("Index 1:"+ams[0]);
//        System.out.println("Index 2:"+ams[1]);
            int[] arr = {1, 2, 3, 4, 5, 6};
            int k = 9;

            boolean ans = TS(arr, k);

            System.out.println(ans);
        }
    }

