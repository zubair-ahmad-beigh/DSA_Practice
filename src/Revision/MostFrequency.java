package Revision;

import java.util.HashMap;
import java.util.Map;

public class MostFrequency {
    static void main(String[] args) {
       String []words={"apple","Oranges","apple"};
       Map<String,Integer>map=new HashMap<>();
       for(String word:words) {
           map.put(word, map.getOrDefault(word , 0) + 1);
       }
           String maxFrequncy="";
           int maxCount=0;
           for(Map.Entry<String,Integer>entry:map.entrySet()){
               if(entry.getValue()>maxCount){
                   maxCount= entry.getValue();
                   maxFrequncy=entry.getKey();
               }
           }
           System.out.println("Most Frequent:"+maxFrequncy);
           System.out.println("Max Count:"+maxCount);
    }
}
