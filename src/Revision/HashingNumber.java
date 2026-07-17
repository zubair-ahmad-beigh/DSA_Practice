package Revision;

import org.w3c.dom.ls.LSOutput;

public class HashingNumber {
    static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 1, 2};
        int []hash = new int[4];
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }
        System.out.println(hash[1]);
        System.out.println(hash[2]);
    }
}
