import java.util.HashMap;

public class TwoSum {
    static void main(String[] args) {
        int arr[]={4,3,2,5,6};
        int k=6;
        HashMap<Integer,Integer>map=new HashMap<>();
        for (int i = 0; i < arr.length ; i++) {
            int required=k-arr[i];
            if(map.containsKey(required)){
                System.out.println("Indices: "+map.containsKey(required)+" "+i);
                return;

        }
            map.put(arr[i],i);
        }
    }
}
    
    