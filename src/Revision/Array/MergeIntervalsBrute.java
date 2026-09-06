package Revision.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervalsBrute {
    static int[][] merge(int[][] intervals) {

        int n = intervals.length;
        boolean[] merged = new boolean[n];

        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (merged[i]) {
                continue;
            }

            int start = intervals[i][0];
            int end = intervals[i][1];

            for (int j = i + 1; j < n; j++) {

                if (merged[j]) {
                    continue;
                }

                // Overlap condition
                if (intervals[j][0] <= end &&
                        intervals[j][1] >= start) {

                    start = Math.min(start, intervals[j][0]);
                    end = Math.max(end, intervals[j][1]);

                    merged[j] = true;
                }
            }

            result.add(new int[]{start, end});
        }

        return result.toArray(new int[result.size()][]);
    }
    static int [][]mergee(int [][]intervals){
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]>result=new ArrayList<>();
        result.add(intervals[0]);
        for(int i=1;i< intervals.length;i++){
            int[] current = intervals[i];

            int[] last = result.get(result.size() - 1);

            // Overlapping
            if (current[0] <= last[1]) {

                last[1] = Math.max(last[1], current[1]);

            }
            // Not overlapping
            else {

                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

//        int[][] intervals = {
//                {1, 3},
//                {2, 6},
//                {8, 10},
//                {9, 11}
//        };
//
//        int[][] answer = merge(intervals);
//
//        for (int[] interval : answer) {
//            System.out.println(
//                    "[" + interval[0] + ", " + interval[1] + "]"
//            );
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {9, 11}
        };

        int[][] answer = mergee(intervals);

        for (int[] interval : answer) {
            System.out.println(
                    "[" + interval[0] + ", " + interval[1] + "]"
            );
        }
    }
}