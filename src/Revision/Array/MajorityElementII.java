package Revision.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {
    static List<Integer>majorityElement(int []arr){
        List<Integer>result=new ArrayList<>();
        int n= arr.length;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count>n/3 && !result.contains(arr[i])){
                result.add(arr[i]);
            }
        }
        return result;
    }
    static List<Integer>majorityElementt(int[]arr) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 3) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
    static List<Integer>majorityElementtt(int[]arr){
        List<Integer>result=new ArrayList<>();
        int candidate1=0;
        int candidate2=0;
        int count1=0;
        int count2=0;
        for(int num:arr){
            if(num==candidate1){
                count1++;
            } else if (num==candidate2) {
                count2++;
            } else if (count1==0) {
                candidate1=num;
                count1=1;
                
            } else if (count2==0) {
                candidate2=num;
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int num:arr){
            if(num==candidate1){
                count1++;
            }
            if(num==candidate2){
                count2++;
            }
        }
        int n= arr.length;
        if(count1>n/3){
            result.add(candidate1);
        }
        if(candidate2!=candidate1 &&count2>n/3){
            result.add(candidate2);
        }
        return result;
    }

    static void main(String[] args) {
        int []arr={1,2,1,1,3,2,2};
        System.out.println(majorityElement(arr));
        System.out.println(majorityElementt(arr));
        System.out.println(majorityElementtt(arr));
    }
}
