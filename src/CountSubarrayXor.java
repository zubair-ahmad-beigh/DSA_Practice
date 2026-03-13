import java.util.HashMap;

public class CountSubarrayXor {
    static int countSubarray(int[]arr,int k){
        HashMap<Integer,Integer>map=new HashMap<>();
        int xor=0;
        int count=0;
        for(int i=0;i<arr.length;i++){
            xor=xor^arr[i];
            if(xor==k){
                count++;
            }
            if(map.containsKey(xor^k)){
                count+=map.get(xor^k);
            }
            map.put(xor, map.getOrDefault(xor,0)+1);
        }
        return count;
    }

    static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int k = 4;
        System.out.println(countSubarray(arr,k));
    }
}
