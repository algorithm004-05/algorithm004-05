<?php
/**
 * 题目名称：triangle 三角形最小路径和
 * 题目链接：https://leetcode-cn.com/problems/triangle/
 */

/**
 * @param Integer[][] $triangle
 * @return Integer
 */
function minimumTotal($triangle) {
    $dp = [];
    for ($i = 0; $i < count($triangle); $i++) {
        for ($j = 0; $j < count($triangle[$i]); $j++) {
            if ($j == 0) {
                $dp[$i][$j] = $dp[$i - 1][$j] + $triangle[$i][$j];
            } elseif ($j == count($triangle[$i]) - 1) {
                $dp[$i][$j] = $dp[$i - 1][$j - 1] + $triangle[$i][$j];
            } else {
                $dp[$i][$j] =  min($dp[$i - 1][$j], $dp[$i - 1][$j - 1]) + $triangle[$i][$j];
            }
        }
    }
    return min($dp[$i - 1]);
}