import java.util.Map;
import java.util.HashMap;
import java.lang.IllegalArgumentException;

/**
* 两数之和
*/
public class LeetCode_1_495 {

  public static void main(String[] args){
        int[] nums = {2,3,4,5,32,10};
        int target = 36;
        for (int i: twoSum(nums, target)) {
          System.out.println(i);
        }
  }

  public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
