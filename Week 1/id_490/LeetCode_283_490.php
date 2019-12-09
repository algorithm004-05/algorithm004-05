<?php
/**
 * 题目名称：move-zeroes 移动零
 * 题目链接：https://leetcode-cn.com/problems/move-zeroes/
 */

/**
 * 第一种解法，时间复杂度O(n)
 * @param Integer[] $nums
 * @return NULL
 */
function moveZeroes(&$nums) {
    $zeroIndex = -1;
    for ($i = 0; $i < count($nums); $i++) {
        if ($zeroIndex < 0 && $nums[$i] == 0) {
            $zeroIndex = $i;
        }
        if ($nums[$i] != 0 && $zeroIndex >= 0) {
            $tmp = $nums[$i];
            $nums[$i] = $nums[$zeroIndex];
            $nums[$zeroIndex] = $tmp;
            $zeroIndex++;
        }
    }
}

/**
 * 第二种解法，使用两个下标指针，时间复杂度O(n),元素移动次数更少
 * @param Integer[] $nums
 * @return NULL
 */
function moveZeroes2(&$nums) {
    $i = 0;
    for ($j = 0; $j < count($nums); $j++) {
        if ($nums[$j] != 0) {
            $nums[$i] = $nums[$j];
            $i++;
        }
    }
    for ($k = $i; $k < count($nums); $k++) {
        $nums[$k] = 0;           
    }
}