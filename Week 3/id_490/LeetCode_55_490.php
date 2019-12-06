<?php
/**
 * 题目名称：jump-game 跳跃游戏
 * 题目链接：https://leetcode-cn.com/problems/jump-game/
 */

class Solution {

    /**
     * 贪心算法实现，从后往前处理
     * @param Integer[] $nums
     * @return Boolean
     */
    function canJump($nums) {
        $len = count($nums);
        $lastPos = $len - 1;
        for ($i = $len - 2; $i >= 0; $i--) {
            if ($i + $nums[$i] >= $lastPos) {
                $lastPos = $i;
            }
        }
        return $lastPos == 0;
    }
}

$solution = new Solution();
$nums = [2,3,1,1,4]; // true
$res = $solution->canJump($nums);
var_dump($res);