<?php
/**
 * 题目名称：remove-duplicates-from-sorted-array 删除排序数组中的重复项
 * 题目链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */

/**
 * 第一种解法，双重循环
 * @param Integer[] $nums
 * @return Integer
 */
function removeDuplicates(&$nums) {
    for ($i = 1; $i < count($nums); $i++) {
        if ($nums[$i] == $nums[$i - 1]) {
            for ($j = $i; $j < count($nums) - 1; $j++) {
                $nums[$j] = $nums[$j + 1];
            }
            unset($nums[$j]);
            $i--;
        }
    }
}


/**
 * 双指针法，快慢指针
 * @param Integer[] $nums
 * @return Integer
 */
function removeDuplicates2(&$nums) {
    $i = 0;
    for ($j = 1; $j < count($nums); $j++) {
        if ($nums[$i] != $nums[$j]) {
            $i++;
            $nums[$i] = $nums[$j];
        }
    }
    return $i + 1;
}

