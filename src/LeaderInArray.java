import java.util.ArrayList;
import java.util.Collections;

public class LeaderInArray {
    static ArrayList<Integer>findLeaders(int[] arr){
        int n= arr.length;
        ArrayList<Integer>result=new ArrayList<>();
        int maxRight=arr[n-1];
        result.add(maxRight);
        for(int i=n-2;i>=0;i--){
            if(arr[i]>maxRight){
                result.add(arr[i]);
                maxRight=arr[i];

            }
        }
        Collections.reverse(result);
        return result;
    }

    static void main(String[] args) {
        int []arr={10,22,12,3,0,6};
        System.out.println(findLeaders(arr));
    }
}
