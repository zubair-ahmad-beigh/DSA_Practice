package Revision.Array;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Intersection {
    public static ArrayList<Integer> intersection(int[] arr1, int[] arr2) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else if(arr1[i]==arr2[j]) {
                if (ans.size() == 0 || ans.get(ans.size() - 1) != arr1[i]) {
                    ans.add(arr1[i]);
                }
                i++;
                j++;
            }
        }
        return ans;
    }
    static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4, 5};
        int[] arr2 = {2, 3, 4, 4, 5, 6};

        System.out.println(intersection(arr1, arr2));
    }

}
