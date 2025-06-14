package BinarySearch;

import java.util.Arrays;

public class FindFirstnLastSorted {
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;

        int[] ans = searchRange(nums, target);

        System.out.println(Arrays.toString(ans));
    }

    public static int[] searchRange(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                for (int j = i; j < nums.length; j++) {
                    if(nums[j] > target){
                        return new int[]{i, j-1};
                    }else if(nums[j] == target && j == nums.length-1){
                        return new int[]{i, j};
                    }
                }
            }

            if(nums[i] > target) break;
        }

        return new int[]{-1,-1};
    }
}
