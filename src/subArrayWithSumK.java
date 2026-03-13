import java.util.HashMap;

public class subArrayWithSumK {

    public static void main(String[] args) {
        int []arr={1,-1,5,-2,3};
        int k=3;
        int maxLen=0;
        int sum=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i< arr.length;i++){
            sum+=arr[i];
            if(sum==k){
                maxLen=i+1;
            }
            if(map.containsKey(sum-k)){
                int length=i-map.get(sum-k);
                maxLen=Math.max(maxLen,length);
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        System.out.println("Longest subArray Length:"+maxLen);
    }
}