<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $k
     * @return NULL
     */
    function rotate(&$nums, $k) {
        for ($i = count($nums) - 1; $k > 0; $k--) {
            $insert = $nums[$i];
            array_unshift($nums, $insert);
            unset($nums[count($nums) - 1]);
        }
        return $nums;
    }
}