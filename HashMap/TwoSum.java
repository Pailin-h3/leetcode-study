package HashMap;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        func2(nums, target);

    }

    public static int[] func1(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    System.out.println(i + " " + j);
                    return new int[]{i,j};
                }
            }
        }

        return new int[2];
    }

    public static int[] func2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == null){
                map.put(target-nums[i], i);
            }else{
                System.out.println(map.get(nums[i]) + " " + i);
                return new int[]{map.get(nums[i]), i};
            }
        }

        return new int[2];
    }
}
