package BinarySearch.String;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static String longestCommonPrefixBrute(String[] strs){
        String first=strs[0];
        for(int len=first.length();len>0;len--){
            String prefix=first.substring(0,len);
            boolean found=true;
            for(int i=1;i<strs.length;i++){
                if(!strs[i].startsWith(prefix)){
                    found=false;
                    break;
                }
            }
            if(found){
                return prefix;
            }
        }
        return " ";
    }
    public static String commonPrefixBetter(String []strs){
        if(strs==null||strs.length==0){
            return "";
        }
        for(int i=0;i< strs[0].length();i++){
            char ch=strs[0].charAt(i);
            for(int j=1;j< strs.length;j++){
                if(i>=strs[j].length()||strs[j].charAt(i)!=ch){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
    public static String longestCommonPrefixOptimal(String[] strs){
        if(strs==null || strs.length==0){
            return " ";
        }
        Arrays.sort(strs);
        String first=strs[0];
        String last=strs[strs.length-1];
        int i=0;
        while(i<first.length() && i<last.length() && first.charAt(i)==last.charAt(i)){
            i++;
        }
        return first.substring(0,i);
    }
    public static void main(String[] args) {

        String[] strs = {"flower", "flow", "flight"};

        System.out.println("Brute: " +
                longestCommonPrefixBrute(strs));

        System.out.println("Better: " +
                commonPrefixBetter(strs));

        System.out.println("Optimal: " +
                longestCommonPrefixOptimal(strs));
    }

}
