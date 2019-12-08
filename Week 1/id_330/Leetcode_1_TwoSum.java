import java.util.Arrays;
import java.util.HashMap;

/**
 *
 */
public class Leetcode_1_TwoSum {

    public static void main(String[] args) {
        int[] a = {1,2,3,5,6,7};
        int[] ints = twoSum(a, 8);
        System.out.println(Arrays.toString(ints));

    }

    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i +1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum1(int[] nums, int target) {

        HashMap<Integer, Integer> con = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
           int n = target - nums[i];
           if (con.containsKey(n)) {
               return new int[]{con.get(n), i};
           }
           con.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
