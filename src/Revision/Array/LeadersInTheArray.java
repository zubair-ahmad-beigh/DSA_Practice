package Revision.Array;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInTheArray {
    public static void leaders(int []arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            boolean isLeader=true;
            for(int j=i+1;j<n;j++){
                if(arr[i]<=arr[j]){
                    isLeader=false;
                    break;
                }
            }
            if(isLeader){
                System.out.println(arr[i]+" ");
            }
        }
    }
    public static void leader(int []arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        int maxRight = arr[n - 1];
        result.add(maxRight);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxRight) {
                result.add(arr[i]);
                maxRight = arr[i];
            }
        }
        Collections.reverse(result);
        System.out.println(result);
    }
    static void main(String[] args) {
        int[]arr={16,17,4,3,2};
        leaders(arr);
    }
}
