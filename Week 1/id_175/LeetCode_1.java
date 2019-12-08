import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: shizeying
 * @Date: 19-10-20 20:22
 * @Description:
 */
public class LeetCode_1 {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		
		
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int j = 0; j < nums.length; j++) {
			int result = target - nums[j];
			if (map.containsKey(result) && map.get(result) != j) {
				return new int[]{map.get(result), j};
			}
			
		}
		
		throw new IllegalArgumentException("错误");
		
	}
}
