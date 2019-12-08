<?php
/**
 * 题目名称：container-with-most-water 盛最多水的容器
 * 题目链接：https://leetcode-cn.com/problems/container-with-most-water/
 */

/**
 * 暴力求解法，时间复杂度O(n^2)
 * @param Integer[] $height
 * @return Integer
 */
function maxArea($height) {
    $maxValue = 0;
    $length = count($height);
    for ($i = 0; $i < $length; $i++) {
        for ($j = $i + 1; $j < $length; $j++) {
            $maxValue = max($maxValue, min($height[$i], $height[$j]) * ($j - $i));
        }
    }
    return $maxValue;
}


/**
 * 双指针法
 * @param Integer[] $height
 * @return Integer
 */
function maxAreaDoubePointer($height) {
    $maxValue = 0;
    $left = 0; 
    $right = count($height) - 1;
    while ($left < $right) {
        $maxValue = max($maxValue, min($height[$left], $height[$right]) * ($right - $left));
        if ($height[$left] < $height[$right]) {
            $left++;
        } else {
            $right--;
        }
    }
    
    return $maxValue;
}
