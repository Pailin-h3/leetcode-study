import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {-1,4};
        int k = 3;

        func(nums, k);
    }

    private static void func(int[] nums, int k){
        if(k >= nums.length){
            k = k%nums.length;
        }

        System.out.println(k);

        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, nums.length - k)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, nums.length - k, nums.length)));

        int[] front = Arrays.copyOfRange(nums, 0, nums.length - k);
        int[] back = Arrays.copyOfRange(nums, nums.length - k, nums.length);

        int i = 0;
        for(int b : back){
            nums[i] = b;
            i++;
        }
        for(int f : front){
            nums[i] = f;
            i++;
        }

        System.out.println(Arrays.toString(nums));
    }
}
