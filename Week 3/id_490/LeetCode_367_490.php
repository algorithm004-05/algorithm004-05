<?php
/**
 * 题目名称：valid-perfect-square 有效的完全平方数
 * 题目链接：https://leetcode-cn.com/problems/valid-perfect-square/
 */


/**
 * 第一种解法：二分查找
 * @param Integer $num
 * @return Boolean
 */
function isPerfectSquare($num) {
    $low = 0;
    $high = $num;
    while ($low <= $high) {
        $mid = intval($low + ($high - $low) / 2);
        if ($mid * $mid == $num) {
            return true;
        } elseif ($mid * $mid > $num) {
            $high = $mid - 1;
        } else {
            $low = $mid + 1;
        }
    }
    return false;
}
