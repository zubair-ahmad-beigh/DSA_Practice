package Revision;

import org.w3c.dom.ls.LSOutput;

public class HashingCharacter {
    static void main(String[] args) {
        String str = "abcabc";
        int[] hash = new int[26];
        for (int i = 0; i < str.length(); i++) {
            hash[str.charAt(i) - 'a']++;
        }
        System.out.println(hash['a' - 'a']);
        System.out.println(hash['b' - 'a']);
        System.out.println(hash['c' - 'a']);
    }

}
