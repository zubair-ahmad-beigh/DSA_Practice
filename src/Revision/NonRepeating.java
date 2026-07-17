package Revision;

import java.util.HashMap;
import java.util.Map;

public class NonRepeating {
    static void main(String[] args) {
        String strs="aabcba";
        Map<Character,Integer> map=new HashMap<>();
        for(Character ch:strs.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        for(char ch: strs.toCharArray()){
            if(map.get(ch)==1){
                System.out.println("First Non-Repeating Character:"+ch);
                return;
            }
        }
        System.out.println("No Non-Repeating Character Found");
    }
}
