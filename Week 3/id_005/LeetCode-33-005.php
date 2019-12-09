<?php

class Solution
{
    /**
     * 执行用时 :12 ms, 在所有 php 提交中击败了78.79%的用户
     * 暴力法 先找到旋转点再搜索
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    public function search($nums, $target)
    {
        $left = 0;
        $count = count($nums);
        $right = $count-1;

        while ($left < $right) {
            $middle = (int)(($left + $right)/2);
            if ($nums[$middle] > $nums[$right]) {
                $left = $middle + 1;
            } else {
                $right = $middle;
            }
        }

        $rot = $left;
        $left = 0;
        $right = $count-1;
        while ($left <= $right) {
            $middle = (int)(($left + $right)/2);
            $realMiddle = (int)(($middle + $rot)%$count);

            if ($nums[$realMiddle] == $target) {
                return $realMiddle;
            } elseif ($nums[$realMiddle] < $target) {
                $left = $middle+1;
            } else {
                $right = $middle-1;
            }
        }
        return -1;
    }
}
