package DP;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};

        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int[] total = new int[nums.length];
        total[0] = nums[0];
        total[1] = max(nums[0], nums[1]);

        for(int i = 2 ; i<total.length ; i++){
            total[i] = max(total[i-2] + nums[i], total[i-1]);
        }

        return total[total.length-1];
    }

    private static int max(int n, int m){
        return n<m? m : n;
    }
}
