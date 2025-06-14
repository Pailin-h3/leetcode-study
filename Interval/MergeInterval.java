package Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        int[][] nums = {{2,3},{4,5},{6,7},{1,10}};

        func(nums);
    }

    public static int[][] func(int[][] intervals) {
        if(intervals.length == 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingDouble(o -> o[0]));
        for(int[] k : intervals){
            System.out.println(Arrays.toString(k));
        }
        System.out.println();
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int j = 1;
        int comparer = intervals[0][1];

        while(j < intervals.length){
            System.out.println("compare " + comparer + " and " + intervals[j][0]);
            if(comparer >= intervals[j][0]){
                comparer = comparer > intervals[j][1] ? comparer : intervals[j][1];
            }else{
                intervals[j-1][1] = comparer > intervals[j-1][1] ? comparer : intervals[j-1][1];
                System.out.println("merge " + Arrays.toString(intervals[i]) + " and " + Arrays.toString(intervals[j-1]));
                result.add(merge(intervals[i], intervals[j-1]));
                i=j;
                comparer = comparer > intervals[i][1] ? comparer : intervals[i][1];
            }
            
            if(j == intervals.length-1){
                System.out.println("merge " + Arrays.toString(intervals[i]) + " and " + Arrays.toString(intervals[j]));
                intervals[j][1] = comparer > intervals[j][1] ? comparer : intervals[j][1];
                result.add(merge(intervals[i], intervals[j]));
            }
            System.out.println();
            j++;
        }

        for(int[] k : result){
            System.out.println(Arrays.toString(k));
        }

        return result.toArray(new int[result.size()][2]);
    }

    private static int[] merge(int[] i1, int[] i2){
        int[] merged = {
            i1[0] <=  i2[0] ? i1[0] : i2[0], 
            i1[1] >=  i2[1] ? i1[1] : i2[1]
        };
        return merged;
    }
}
