import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class CountFrequency {
    public static List<List<Integer>> countFrequency(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> pair = new ArrayList<>();
            pair.add(entry.getKey());
            pair.add(entry.getValue());
            result.add(pair);
        }
        return result;
    }
    public static int mostfrequent(int[]nums){
        Map<Integer,Integer>map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int maxFreq=0;
        int mostFrequentNumber=nums[0];
        for(Map.Entry<Integer,Integer>entry: map.entrySet()){
            if(entry.getValue()>maxFreq){
                    maxFreq= entry.getValue();
                    mostFrequentNumber= entry.getKey();
            }
        }
        return mostFrequentNumber;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 3, 2, 4, 1};

        List<List<Integer>> result = countFrequency(nums);

        for (List<Integer> pair : result) {
            System.out.println(pair.get(0) + " -> " + pair.get(1));

        }
        System.out.println("Most frequent number:"+mostfrequent(nums));
    }
}
