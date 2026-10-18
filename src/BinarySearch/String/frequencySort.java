package BinarySearch.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class frequencySort {
    public static String frequencySortBrute(String s) {
        int[] freq = new int[256];
        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }
        StringBuilder ans = new StringBuilder();
        for (int count = 0; count < s.length(); count++) {
            int maxFreq = 0;
            int maxChar = -1;
            for (int ch = 0; ch < 256; ch++) {
                if (freq[ch] > maxFreq) {
                    maxFreq = freq[ch];
                    maxChar = ch;
                }
            }
            if (maxChar == -1) {
                break;
            }
            for (int j = 0; j < maxFreq; j++) {
                ans.append((char) maxChar);
            }
            freq[maxChar] = 0;
        }
        return ans.toString();
    }
    public static String frequencySortBetter(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        List<Character> chars = new ArrayList<>(freq.keySet());
        chars.sort((a, b) -> freq.get(b) - freq.get(a));
        StringBuilder ans = new StringBuilder();
        for (char ch : chars) {
            for (int i = 0; i < freq.get(ch); i++) {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
    public static String frequencySortOptimal(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        // Step 1: Count frequency
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        List<Character>[] buckets = new ArrayList[s.length() + 1];

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            int count = entry.getValue();
            char ch = entry.getKey();
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(ch);
        }
        StringBuilder ans = new StringBuilder();
        for (int count = s.length(); count >= 1; count--) {
            if (buckets[count] != null) {
                for (char ch : buckets[count]) {
                    for (int j = 0; j < count; j++) {
                        ans.append(ch);
                    }
                }
            }
        }
        return ans.toString();
    }

    static void main(String[] args) {
        String s="tree";
        System.out.println(frequencySortBrute(s));
        System.out.println(frequencySortBetter(s));
        System.out.println(frequencySortOptimal(s));
    }
}
