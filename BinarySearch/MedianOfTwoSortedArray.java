package BinarySearch;

import java.util.Arrays;

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] num1 = {1,2};
        int[] num2 = {3,4};

        func(num1, num2);

    }

    public static double func(int[] nums1, int[] nums2) {
        int i1 = 0;
        int i2 = 0;
        Integer[] merged = new Integer[nums1.length + nums2.length];

        for(int i = 0 ; i < merged.length ; i++){
            if(i1 >= nums1.length){
                merged[i] = nums2[i2];
                i2++;
            }else if(i2 >= nums2.length){
                merged[i] = nums1[i1];
                i1++;
            }else if(nums1[i1] <= nums2[i2]){
                merged[i] = nums1[i1];
                i1++;
            }else{
                merged[i] = nums2[i2];
                i2++;
            }
        }
        
        if(merged.length <= 1){
            return merged[0];
        }

        System.out.println(Arrays.toString(merged));
        System.out.println(merged[merged.length/2]);
        System.out.println(merged[(merged.length/2) -1]);

        double median;
        if(merged.length%2 == 0){
            median = (Double.valueOf((merged[(merged.length/2) -1]) + merged[merged.length/2])) / 2;
        }else{
            median = merged[merged.length/2];
        }

        System.out.println(median);

        return median;
    }
}
