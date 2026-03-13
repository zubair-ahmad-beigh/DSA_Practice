import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestSubString {
    static int longestSub(String s){
        Set<Character>set=new HashSet<>();
        int left=0;
        int maXLength=0;
        for(int right=0;right<s.length();right++){
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maXLength=Math.max(maXLength,right-left+1);

        }
        return maXLength;

    }

    static void main(String[] args) {
        String s="abcabbbc";
        System.out.println(longestSub(s));
    }
}
