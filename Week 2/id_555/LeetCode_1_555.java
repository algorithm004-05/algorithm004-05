package lsn05.map;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_555 {

	public static void main(String[] args) {
		LeetCode_1_555 leetcode = new LeetCode_1_555();

		int[] nums = { 2, 7, 11, 15 };
		int target = 9;

		int[] res = leetcode.twoSum(nums, target);

		int[] res2 = leetcode.twoSum2(nums, target);

		int[] res3 = leetcode.twoSum3(nums, target);

		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
		System.out.println("-------------------------------------------");
		for (int i = 0; i < res2.length; i++) {
			System.out.println(res2[i]);
		}
		System.out.println("-------------------------------------------");
		for (int i = 0; i < res3.length; i++) {
			System.out.println(res3[i]);
		}

	}

	/**
	 * 方法三：一遍哈希表
	 */
	public int[] twoSum3(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int key = target - nums[i];
			if (map.containsKey(key)) {
				return new int[] { map.get(key), i };
			}
			map.put(nums[i], i);

		}
		throw new IllegalArgumentException("No two sum solution");
	}

	/**
	 * 方法二：两遍哈希表
	 */
	public int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);// 数组中的元素作为键，数组中的索引作为值
		}
		for (int i = 0; i < nums.length; i++) {
			int key = target - nums[i];// 差值作为键，去map中查找
			if (map.containsKey(key) && map.get(key) != i) {
				return new int[] { i, map.get(key) };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	/**
	 * 方法一：暴力法
	 */
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

}
