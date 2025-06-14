import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};

        int result = majorityElement(nums);
        System.out.println(result);
    }

    private static int majorityElement(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            int i = map.get(n) == null? 1 : map.get(n) + 1;;
            map.put(n, i);
        }

        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }

        return maxEntry.getKey();
    }
}