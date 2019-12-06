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
        if (empty($nums)) {
            return false;
        }
        $length = count($nums) - 1;// 代表当前位置
        for ($i = $length - 1; $i >= 0; $i--) {
            // 确保上一个点能去到下一个点就 OK
            if ($i + $nums[$i] >= $length) {
                $length = $i;// 设置下一个当前位置
            }
        }
        return $length == 0;
    }
}
