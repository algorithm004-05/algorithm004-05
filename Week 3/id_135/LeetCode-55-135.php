<?php

class Solution
{
    /**
     * @param Integer[] $nums
     * @return Boolean
     */
    function canJump($nums)
    {
        if (empty($nums)) {
            return false;
        }
        $k = 0;// 代表可以去到的最远的地方
        for ($i = 0; $i < count($nums); $i++) {
            if ($i > $k) {
                return false;
            }
            $k = max($k, $i + $nums[$i]);
        }
        return true;
    }

    /**
     * @param Integer[] $nums
     * @return Boolean
     */
    function canJumpOne($nums)
    {
        $lastPos = count($nums) - 1;
        for ($i = count($nums) - 1; $i >= 0; $i--) {
            if ($i + $nums[$i] >= $lastPos) {
                $lastPos = $i;
            }
        }
        return $lastPos == 0;
    }
}