/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (46.74%)
 * Likes:    6549
 * Dislikes: 0
 * Total Accepted:    603.6K
 * Total Submissions: 1.3M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 
 * 
 */

// @lc code=start

// 方法一: 暴力求解  
// 遍历每个元素x, 查找是否存在一个值 使得 与 target - x 值相同的目标元素.
// 复杂度分析: 
// 因为需要嵌套循环遍历两次 nums 数组, 时间复杂度 O(n^2). 
// 因为遍历操作并未申请新的内存, 空间复杂度 O(1).
class Solution {

     public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[j] == target - nums[i]) {
                    
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}


// 方法二: Hash 
// 因为仅用for循环遍历一次, 时间复杂度: O(n)

// 空间复杂度：O(n)
// 所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 n 个元素。
class Solution {
    public int[] twoSum(int[] nums, int target) {

        // 初始化一个 map
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

// @lc code=end
