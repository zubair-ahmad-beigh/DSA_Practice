package BinarySearch;

import java.util.Arrays;

public class aggresiveCows {
    static int aggresiveCowsBrute(int []stalls,int k){
        Arrays.sort(stalls);
        int maxDistance=stalls[stalls.length-1]-stalls[0];
        int answer=0;
        for(int distance =1;distance<=maxDistance;distance++){
            if(canPlace(stalls,k,distance)){
                answer=distance;
            }
        }
        return answer;
    }
    static boolean canPlace(int []stalls,int k,int distance){
        int cows=1;
        int lastPosition=stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-lastPosition>=distance){
                cows++;
                lastPosition=stalls[i];
            }
            if(cows>=k){
                return true;
            }
        }
        return false;
    }
    public static int aggressiveCows(int[] stalls,int k){
        Arrays.sort(stalls);
        int low=1;
        int high=stalls[stalls.length-1]-stalls[0];
        int answer=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canPlace(stalls,k,mid)){
                answer=mid;
                low=mid+1;

            }else{
                high=mid-1;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        int[] stalls = {1, 2, 4, 8, 9};

        int k = 3;

        System.out.println(aggressiveCows(stalls, k));
    }
}

