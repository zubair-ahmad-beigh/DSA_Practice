package CrashDSA;

import java.util.Arrays;
import java.util.HashSet;

public class longestConsecutive {
    public static boolean Search(int []arr,int target){
        for(int num:arr){
            if(num==target){
                return true;
            }
        }
        return false;
    }
    public static int longestConsecutive(int []arr){
        int longest=0;
        for(int num:arr){
            int current=num;
            int count=1;
            while(Search(arr,current+1)){
                current++;
                count++;
            }
            longest=Math.max(longest,count);
        }
        return longest;
    }
    static int longestConsecutiveBetter(int []arr){
        if(arr.length==0){
            return 0;
        }
        Arrays.sort(arr);
        int longest=1;
        int count=1;
        for(int i=1;i< arr.length;i++){
            if(arr[i]==arr[i-1]){
                continue;
            } else if (arr[i]==arr[i-1]+1) {
                count++;
            }else{
                count=1;
            }
            longest=Math.max(longest,count);
        }
        return longest;
    }
    public static int longestConsecutiveOptimal(int []arr){
        HashSet<Integer>set=new HashSet<>();
        for(int num:arr){
            set.add(num);
        }
        int longest=0;
        for(int num:set){
            if(!set.contains(num-1)){
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
        int []arr={100,4,200,1,3,2};
        System.out.println(longestConsecutive(arr));
        System.out.println(longestConsecutiveBetter(arr));
    }

}
