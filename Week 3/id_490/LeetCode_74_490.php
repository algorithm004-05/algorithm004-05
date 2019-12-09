<?php
/**
 * 题目名称：search-a-2d-matrix 搜索二维矩阵
 * 题目链接：https://leetcode-cn.com/problems/search-a-2d-matrix/
 */

class Solution {

    /**
     * 标准二分查找，将二维数组转换成一维
     * @param Integer[][] $matrix
     * @param Integer $target
     * @return Boolean
     */
    function searchMatrix($matrix, $target) {
        $m = count($matrix);
        $n = count($matrix[0]);
        $low = 0;
        $high = $m * $n - 1;
        
        while ($low <= $high) {
            $mid = intval(($low + $high) / 2);
            $midEle = $matrix[intval($mid / $n)][intval($mid % $n)];
            if ($midEle == $target) {
                return true;
            } elseif ($midEle > $target) {
                $high = $mid - 1;
            } else {
                $low = $mid + 1;
            }
        }
        
        return false;
    }
}

$solution = new Solution();
$matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
];
$target = 3;
$res = $solution->searchMatrix($matrix, $target);
var_dump($res);