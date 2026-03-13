import java.util.ArrayList;
import java.util.List;

public class UnionOfTwoSortedArray {

    static List<Integer> union(int[] nums1, int[] nums2) {

        List<Integer> result = new ArrayList<>();

        int i = 0, j = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;

        while (i < n1 && j < n2) {

            if (i > 0 && nums1[i] == nums1[i - 1]) {
                i++;
                continue;
            }

            if (j > 0 && nums2[j] == nums2[j - 1]) {
                j++;
                continue;
            }

            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]) {
                result.add(nums1[i]);
                i++;
            }
            else {
                result.add(nums2[j]);
                j++;
            }
        }
        // remaining elements of nums1
        while (i < n1) {
            if (i == 0 || nums1[i] != nums1[i - 1])
                result.add(nums1[i]);
            i++;
        }
        // remaining elements of nums2
        while (j < n2) {
            if (j == 0 || nums2[j] != nums2[j - 1])
                result.add(nums2[j]);
            j++;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 1, 2, 3, 4};
        int[] nums2 = {2, 3, 5};

        List<Integer> ans = union(nums1, nums2);

        System.out.println("Union of arrays:");
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
