<?
/*
 * @lc app=leetcode.cn id=1 lang=php
 *
 * [1] 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (46.84%)
 * Likes:    6596
 * Dislikes: 0
 * Total Accepted:    621.9K
 * Total Submissions: 1.3M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
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
class Solution {

    /**
     * 暴力解法 时间：O(n^2)、空间O(1)
     * 
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     *
    function twoSum($nums, $target) {
        for ($i=0; $i < count($nums) -1; $i++) { 
            for ($j=$i+1; $j < count($nums); $j++) { 
                # code...
                if ($nums[$i] + $nums[$j] == $target) {
                    return [$i, $j];
                }
            }
        }
        return [];
    }*/

    /**
     * 两遍哈希表 时间：O(n)、空间O(n)
     * 
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     *
    function twoSum($nums, $target)
    {
        # 反转数组key和value
        $nums_flip = array_flip($nums);
        for ($i=0; $i < count($nums); $i++) { 
            # code...
            $diff = $target-$nums[$i];
            if (key_exists($diff, $nums_flip) && $nums_flip[$diff] != $i) {
                return [$i, $nums_flip[$diff]];
            }
        }
        return [];
    }
    */

    /**
     * 最优
     * 一遍哈希表 时间：O(n)、空间O(n)
     * 
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($nums, $target)
    {
        $nums_flip = [];
        for ($i=0; $i < count($nums); $i++) { 
            # code...
            $diff = $target-$nums[$i];
            if (key_exists($diff, $nums_flip)) {
                return [$i, $nums_flip[$diff]];
            } else {
                $nums_flip[$nums[$i]] = $i;
            }
        }
        return [];
    }


}
// @lc code=end

