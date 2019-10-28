import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 封玉书 FYS
 * @Date: 2019.10.20 20:16
 * @Description:
 */
public class A1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum1(nums, 9)));
        System.out.println(Arrays.toString(twoSum2(nums, 9)));
    }


    /**
     * 暴力解法
     * 时间复杂度O(n^2)
     *
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum1(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 哈希解法。
     * map记录下，key值与具体位置。
     * 每次获取新值，则查询map中是否含有其差值
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)) {
                return new int[]{map.get(result), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }


}
