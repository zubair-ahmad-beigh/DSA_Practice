import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindMissingNumber {
    static List<Integer>findMissing(int[]arr){
        int n= arr.length;
        Set<Integer> set=new HashSet<>();
        for(int num:arr){
            set.add(num);
        }
        List<Integer>result=new ArrayList<>();
        for (int i = 0; i <n; i++) {
            if(!set.contains(i)){
                result.add(i);
            }
        }
        return result;
    }
    static int Missing(int[]arr,int n){
        int total=n*(n+1)/2;
        int sum=0;
        for(int num:arr){
            sum+=num;
        }
        return total-sum;
    }

    static void main(String[] args) {
        int[]arr={1,2,5,6,7};
        List<Integer>missing=findMissing(arr);
        System.out.println("Missing Number:");
        for(int num:missing){
            System.out.println(num+" ");
        }
    }

}
