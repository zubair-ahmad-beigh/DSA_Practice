package Revision.Array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class LongestCons {
    public static int longestCons(int []arr){
        int longest=0;
        for(int i=0;i< arr.length;i++){
            int current=arr[i];
            int count=1;
            while(linearSearch(arr,current+1)){
                current++;
                count++;
            }
            longest=Math.max(longest,count);
        }
        return longest;
    }
    static boolean linearSearch(int []arr,int target){
        for(int num:arr){
            if(num==target){
                return true;
            }
        }
        return false;
    }
    public static int longestConsecutivee(int []arr){
        if(arr.length==0){
            return 0;
        }
        Arrays.sort(arr);
        int longest=1;
        int currentCount=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1]+1){
                currentCount++;
            }else if(arr[i]==arr[i-1]){

            }else{
                currentCount=1;
            }
            longest=Math.max(longest,currentCount);
        }
        return longest;
    }
    public static int longestConnsective(int []arr){
        if(arr.length==0){
            return 0;
        }
        HashSet<Integer>set=new HashSet<>();
        for(int num:arr){
            set.add(num);
        }
        int longest=0;
        for(int num:set){
            if(!set.contains((num-1))){
                int current=num;
                int count=1;
                while(set.contains(current+1)){
                    current++;
                    count++;
                }
                longest=Math.max(longest,count);
            }
        }
        return longest;
    }



    static void main(String[] args) {
        int []arr={100,200,5,3,2,1,4};
        int answer=longestCons(arr);
        System.out.println("Longest Consecutive sequence " +answer);
        System.out.println("longest Consecutive sequence "+longestConsecutivee(arr));
        System.out.println("longest Consective Sequence "+longestConnsective(arr));
    }
}
