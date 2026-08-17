package Revision.Array;

import java.util.HashMap;

public class majorityElement {
    public static int majorityElement(int []arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count>n/2){
                return arr[i];
            }
        }
        return -1;
    }
    public static int MajorElement(int []arr){
        HashMap<Integer,Integer>map=new HashMap<>();
        int n= arr.length;
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
            if(map.get(num)>n/2){
                return num;
            }
        }
        return -1;
    }
    public static int mooreVoting(int []arr){
        int candidate=0;
        int count=0;
        for(int num:arr){
            if(count==0){
                candidate=num;
            }
            if(num==candidate){
                count++;
            }else{
                count--;
            }
        }
        count=0;
        for(int num:arr){
            if(num==candidate){
                count++;
            }
        }
        if(count> arr.length/2){
            return candidate;
        }
        return -1;
    }

    static void main(String[] args) {
        int []arr={1,2,2,2,2,2,1,1,1,2};
        //System.out.println(majorityElement(arr));
        System.out.println(MajorElement(arr));
        System.out.println(mooreVoting(arr));
    }
}
