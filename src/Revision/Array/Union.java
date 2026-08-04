package Revision.Array;

import java.util.ArrayList;

public class Union {
    public static ArrayList<Integer>union(int[]arr1,int []arr2) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                if (ans.size() == 0 || ans.get(ans.size() - 1) != arr1[i]) {
                    ans.add(arr1[i]);
                }
                i++;
            } else {
                if (ans.size() == 0 || ans.get(ans.size() - 1) != arr2[j]) {
                    ans.add(arr2[j]);
                }
                j++;
            }
        }
        while (i < arr1.length) {
            if (ans.size() == 0 || ans.get(ans.size() - 1) != arr1[i]) {
                ans.add(arr1[i]);
            }
            i++;


        }
        while (j < arr2.length) {
            if (ans.size() == 0 || ans.get(ans.size() - 1) != arr2[j]) {
                ans.add(arr2[j]);
            }
            j++;
        }
        return ans;
    }

    static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4, 5};
        int[] arr2 = {2, 3, 4, 4, 5, 6};

        System.out.println(union(arr1, arr2));
    }

}
