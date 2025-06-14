package SlidingWindows;

public class MinSizeSubarraySum {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};

        func(target, nums);
        minSubArrayLen(target, nums);
    }

    private static int func(int target, int[] nums){
        int size = nums.length;
        System.out.printf("size = %d\n", size);

        boolean is_found = false;
        while(size > 0){
            int maxsum = 0;
            for(int i = 0 ; i <= nums.length - size ; i++){
                int sum = 0;
                for(int j = 0 ; j < size ; j++){
                    sum += nums[i+j];
                    System.out.printf("%d ", nums[i+j]);
                }
                System.out.printf("\n");

                if(maxsum < sum) maxsum = sum;
            }

            System.out.printf("maxsum = %d\n", maxsum);
            System.out.printf("size = %d\n", size);
            System.out.printf("--------\n");

            if(maxsum > target){
                is_found = true;
                if(size == 1) break;
                size--;
            }else if(maxsum == target){
                is_found = true;
                break;
            }else if(maxsum < target){
                size++;
                break;
            }
        }

        System.out.printf("size = %d\n", size);
        return is_found? size : 0;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(j<nums.length) {
            System.out.printf("%d ", nums[j]);
            sum += nums[j];
            if(sum < target){
            j++;
            }
            else {
                while(sum >= target) {
                    System.out.printf("  =>  %d\n", sum);
                    min = Math.min(min,(j-i+1));
                    sum -= nums[i];
                    i++;
                }
                j++;
            }
        }
        if(i==0) {
            return 0;
        }
        return min;
    }
}
