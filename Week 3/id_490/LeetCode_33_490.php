<?php
/**
 * 题目名称：search-in-rotated-sorted-array 搜索旋转排序数组
 * 题目链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */

class Solution {

    /**
     * 解法一：二分查找，判断左边是升序还是右边是升序，判断是否在升序的范围内
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function search($nums, $target) {
        $low = 0;
        $high = count($nums) - 1;
        while ($low <= $high) {
            $mid = intval(($low + $high) / 2);
            if ($nums[$mid] == $target) {
                return $mid;
            } elseif ($nums[$low] <= $nums[$mid]) {
                if ($nums[$low] <= $target && $target < $nums[$mid]) {
                    $high = $mid - 1;
                } else {
                    $low = $mid + 1;
                }
            } else {
                if ($nums[$mid] < $target && $target <= $nums[$high]) {
                    $low = $mid + 1;
                } else {
                    $high = $mid - 1;
                }
            }
        }
        return -1;
    }
}

$solution = new Solution();
$index = $solution->search([4,5,6,7,0,1,2], 0);
var_dump($index);