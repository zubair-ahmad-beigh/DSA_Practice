package CrashDSA.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class lengthOfLongestSubstring {
    static int longestSubstringBrute(String s){
        int maxLength=0;
        for(int i=0;i<s.length();i++){
            HashSet<Character>set=new HashSet<>();
            for(int j=i;j<s.length();j++){
                char ch=s.charAt(j);
                if(set.contains(ch)){
                    break;
                }
                set.add(ch);
                maxLength=Math.max(maxLength,j-i+1);
            }
        }
        return maxLength;
    }
    public static int lengthOfLongestSubstringOptimal(String s){
        HashMap<Character,Integer>map=new HashMap<>();
        int left=0;
        int maxLength=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            if(map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch,right);
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }

    static void main(String[] args) {
        String s="abcabbc";
        System.out.println(longestSubstringBrute(s));
        System.out.println(lengthOfLongestSubstringOptimal(s));
    }
}
