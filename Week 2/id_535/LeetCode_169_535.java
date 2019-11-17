import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * created by lchen on 2019/10/27
 */
public class LeetCode_169_535 {

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        int[] nums = new int[]{2, 3, 2, 2, 2, 2};
        System.out.println(solution5.majorityElement(nums));
    }
}

class Solution5 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        double count = nums.length >> 1;
        for (int num : nums) {
            Integer i = countMap.get(num);
            if (i != null) {
                countMap.put(num, ++i);
                if (i > count) return num;
            } else {
                countMap.put(num, 1);
            }
        }
        return nums[0];
    }
}

//排序解法
class Solution6 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}