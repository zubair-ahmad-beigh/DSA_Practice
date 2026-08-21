package Revision;

import java.util.HashMap;

public class subArrayWithSumK {
    static int subArraySum(int []arr,int k){
        int count=0;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                if(sum==k){
                    count++;
                }
            }
        }
        return count;
    }
    static int subArray(int []arr,int k){
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int count=0;
        for(int num:arr){
            sum+=num;
            int required=sum-k;
            if(map.containsKey(required)){
                count+=map.get(required);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

    static void main(String[] args) {
        int []arr={1,2,3};
        int k=3;
        System.out.println(subArraySum(arr,k));
        System.out.println(subArray(arr,k));
    }
}
