<?php
/**
 * 题目名称：rotate-array 旋转数组
 * 题目链接：https://leetcode-cn.com/problems/rotate-array/
 */

/**
 * 第一种解法：暴力求解，双重循环，时间复杂度O(n^2),空间复杂度O(1)
 * @param Integer[] $nums
 * @param Integer $k
 * @return NULL
 */
function rotate(&$nums, $k) {
    for ($i = 1; $i <= $k; $i++) {
        $length = count($nums);
        $tmp = $nums[$length - 1];
        for ($j = $length - 1; $j > 0 ; $j--) {
            $nums[$j] = $nums[$j - 1];
        }
        $nums[0] = $tmp;
    }
}

/**
 * 解法2，使用三次反转，时间复杂度O(n),空间复杂度O(1)
 * @param Integer[] $nums
 * @param Integer $k
 * @return NULL
 */
function rotate2(&$nums, $k) {
    $len = count($nums);
    $k = $k % $len;
    reverse($nums, 0, $len - 1);
    reverse($nums, 0, $k - 1);
    reverse($nums, $k, $len - 1);
}

function reverse(&$nums, $start, $end) {
    while ($start < $end) {
        $temp = $nums[$start];
        $nums[$start] = $nums[$end];
        $nums[$end] = $temp;
        $start++;
        $end--;
    }
}

$arr = [1, 2, 3, 4, 5, 6, 7];
rotate2($arr, 3);
var_dump($arr);
