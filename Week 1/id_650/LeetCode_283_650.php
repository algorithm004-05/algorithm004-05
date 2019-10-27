<?
/*
 * @lc app=leetcode.cn id=283 lang=php
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (57.22%)
 * Likes:    412
 * Dislikes: 0
 * Total Accepted:    75.3K
 * Total Submissions: 131.6K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 说明:
 * 
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 
 * 
 */

// @lc code=start
class Solution {

    /**
     * @param Integer[] $nums
     * @return NULL
     */
    function moveZeroes(&$nums) {
        $index = 0;
        foreach ($nums as $key => $v) {
            if ($v) {
                if ($key != $index) {
                    $nums[$index] = $v; # 原本写在if外面，看下别人代码想起来index一样时不需要赋值替换
                    # 这个判断是防止前面没有0时，给覆盖掉
                    $nums[$key] = 0;
                }
                $index++;
            }
        }
    }

    /**
     * 先把非0元素往前移动，然后遍历补零
     * 
     * function moveZeroes(&$nums) {
        $index = 0;
        foreach ($nums as $key => $v) {
            if ($v != 0) {
                $nums[$index++] = $v;
            }
        }
        
        for (; $index < count($nums); $index++) {
            $nums[$index] = 0;
        }
        return $nums;
    }
     * 
     */

}
// @lc code=end

