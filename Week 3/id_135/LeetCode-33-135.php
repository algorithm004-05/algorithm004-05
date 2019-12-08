<?php

class Solution
{

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function search($nums, $target)
    {
        if (count($nums) == 0) return -1;
        if (count($nums) == 1) return $nums[0] == $target ? 0 : -1;
        $start = 0;
        $end = count($nums) - 1;
        while ($start <= $end) {
            $mid = floor($start + ($end - $start) / 2);
            if ($nums[$mid] == $target) return $mid;
            if ($nums[$start] <= $nums[$mid]) {//前半段都是有序的
                if ($target >= $nums[$start] && $target < $nums[$mid]) {
                    $end = $mid - 1;
                } else {
                    $start = $mid + 1;
                }
            } else {
                if ($target > $nums[$mid] && $target <= $nums[$end]) {
                    $start = $mid + 1;
                } else {
                    $end = $mid - 1;
                }
            }
        }
        return -1;
    }
}
