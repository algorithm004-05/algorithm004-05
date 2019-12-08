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
function trap($height) {
    $sum = 0;
    $maxLeft = [];
    $maxRight = [];
    $len = count($height);
    for ($i = 1; $i < $len - 1; $i++) {
        $maxLeft[$i] = max($maxLeft[$i - 1], $height[$i - 1]);
    }
    for ($i = $len - 2; $i >= 0; $i--) {
        $maxRight[$i] = max($maxRight[$i + 1], $height[$i + 1]);
    }
    
    for ($i = 1; $i < $len - 1; $i++) {
        $minEdge = min($maxLeft[$i], $maxRight[$i]);
        if ($minEdge > $height[$i]) {
            $sum += $minEdge - $height[$i];
        }
    }
    return $sum;
}