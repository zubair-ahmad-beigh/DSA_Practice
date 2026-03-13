import java.util.HashSet;

public class LongestConsecutive {

    static int longestConsecutive(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        int maxLength = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;

                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {

        int[] arr = {100,4,200,1,3,2};

        System.out.println("Longest Consecutive Length: " + longestConsecutive(arr));
    }
}
