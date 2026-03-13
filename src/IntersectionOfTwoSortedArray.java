import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoSortedArray {
    static List<Integer> intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        // store nums1 elements
        for (int num : nums1) {
            set.add(num);
        }

        // check nums2
        for (int num : nums2) {
            if (set.contains(num)) {
                resultSet.add(num);
            }
        }

        return new ArrayList<>(resultSet);
    }

    static void main(String[] args) {
        int[]nums1={4,9,5};
        int []nums2={9,4,9,8,4};
        List<Integer>ans=intersection(nums1,nums2);
        System.out.println("Intersection:");
        for(int num:ans){
            System.out.print(num+" ");

        }
    }
}
