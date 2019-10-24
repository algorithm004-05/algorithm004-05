<?php

/**
 * 题目名称：Trapping Rain Water 接雨水
 * 题目链接：https://leetcode-cn.com/problems/trapping-rain-water/
 */

/**
 * 第一种解法，双重循环，时间复杂度O(n^2)
 * @param Integer[] $height
 * @return Integer
 */
function trap($height) {
    $sum = 0;
    $len = count($height);

    for ($i = 1; $i < $len - 1; $i++) {
        $maxLeft = 0;
        for ($j = $i - 1; $j >= 0; $j--) {
            if ($height[$j] > $maxLeft) {
                $maxLeft = $height[$j];
            }
        }
        $maxRight = 0;
        for ($j = $i + 1; $j < $len; $j++) {
            if ($height[$j] > $maxRight) {
                $maxRight = $height[$j];
            }
        }
        $minEnd = min($maxLeft, $maxRight);
        if ($minEnd > $height[$i]) {
            $sum += ($minEnd - $height[$i]);
        }
    }
    return $sum;
}

/**
 * 第二种解法，动态规划，时间复杂度O(n)
 * @param Integer[] $height
 * @return Integer
 */
function trap2($height) {
    $sum = 0;
    $len = count($height);

    for ($i = 1; $i < $len - 2; $i++) {

    }

    for ($i = 1; $i < $len - 1; $i++) {
        $maxLeft = 0;
        for ($j = $i - 1; $j >= 0; $j--) {
            if ($height[$j] > $maxLeft) {
                $maxLeft = $height[$j];
            }
        }
        $maxRight = 0;
        for ($j = $i + 1; $j < $len; $j++) {
            if ($height[$j] > $maxRight) {
                $maxRight = $height[$j];
            }
        }
        $minEnd = min($maxLeft, $maxRight);
        if ($minEnd > $height[$i]) {
            $sum += ($minEnd - $height[$i]);
        }
    }
    return $sum;
}