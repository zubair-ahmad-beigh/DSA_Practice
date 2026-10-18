package BinarySearch.String;

import java.util.HashMap;
import java.util.Map;

public class isomorphicString {
    public static boolean isIsomorphicBrute(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            for (int j = 0; j < i; j++) {
                if(s.charAt(i)==s.charAt(j)&&t.charAt(i)!=t.charAt(j)){
                    return false;
                }
                if(t.charAt(i)==t.charAt(j)&&
                    s.charAt(i)!=s.charAt(j)){
                    return false;
                }
            }
        }
        return false;
    }
    public static Boolean isIsomorphicBetter(String s,String t){
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (mapST.containsKey(a) && mapST.get(a) != b) {
                return false;
            }
            if (mapTS.containsKey(b) && mapTS.get(b) != a) {
                return false;
            }
            mapST.put(a, b);
            mapTS.put(b, a);
        }
        return true;
    }
    public static boolean isIsomorphicOptimal(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        int []mapST=new int[256];
        int []mapTS=new int[256];
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            char b=t.charAt(i);
            if(mapST[a]!=mapTS[b]){
                return false;
            }
            mapST[a]=i+1;
            mapTS[b]=i+1;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isIsomorphicOptimal("egg", "add"));
        System.out.println(isIsomorphicOptimal("foo", "bar"));
        System.out.println(isIsomorphicOptimal("ab", "cc"));
    }

}
