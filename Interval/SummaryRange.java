package Interval;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {
    public static void main(String[] args) {
        int[] nums = {-2147483648,-2147483647,2147483646};

        func(nums);
    }

    public static List<String> func(int[] nums) {
        List<String> ans = new ArrayList<>();

        if(nums.length ==1){
            ans.add(String.valueOf(nums[0]));
            return ans;
        }

        int i = 0;
        for(int j = 1 ; j < nums.length ; j++){
            if(nums[j] - nums[j-1] != 1){
                System.out.println(nums[j-1] + " " + nums[j]);
                System.out.println(nums[i] + " " + nums[j-1]);
                System.out.println();

                if(j-1>i) ans.add(nums[i] + "->" + nums[j-1]);
                else ans.add(String.valueOf(nums[j-1]));

                i=j;
            }
            if(j == nums.length-1){
                System.out.println("LAST ROUND");
                System.out.println(nums[j-1] + " " + nums[j]);
                System.out.println(nums[i] + " " + nums[j-1]);
                System.out.println();

                if(j>i) ans.add(nums[i] + "->" + nums[j]);
                else ans.add(String.valueOf(nums[j]));
            }
        }

        System.out.println(ans);

        return ans;
    }
}
