<?php
class Solution
{
    /**
     * 暴力
     * 执行用时 :3820 ms, 在所有 php 提交中击败了11.86%的用户
     * 算法复杂度O(n²)
     * @param Integer[] $height
     * @return Integer
     */
    public function trap($height)
    {
        $area = 0;
        $len = count($height);
        // 从左向右扫描数组
        for ($i = 1; $i < $len-1 ; $i++) {
            $left = 0;
            $right = 0;
            for ($j = $i; $j >= 0; $j--) {
                $left = max($left, $height[$j]);
            }
            for ($j = $i; $j < $len; $j++) {
                $right = max($right, $height[$j]);
            }
            $area += min($left, $right) - $height[$i];
        }
        return $area;
    }

    /**
     * 动态规划
     * 执行用时 :16 ms, 在所有 php 提交中击败了86.44%的用户
     * 算法复杂度 O(n)
     * @param Integer[] $height
     * @return Integer
     */
    public function trapTwo($height)
    {
        if (empty($height)) {
            return 0;
        }
        $area = 0;
        $len = count($height);
        $left = [];
        $right = [];
        $left[0] = $height[0];
        for ($i = 1; $i < $len-1; $i++) {
            $left[$i] = max($height[$i-1], $left[$i-1]);
        }
        $right[$len - 1] = $height[$len-1];
        for ($i = $len-2; $i >= 0; $i--) {
            $right[$i] = max($height[$i+1], $right[$i+1]);
        }
        for ($i = 1; $i < $len-1; $i++) {
            $min = min($left[$i], $right[$i]);
            if ($min > $height[$i]) {
                $area += $min - $height[$i];
            }
        }
        return $area;
    }

    /**
     * 双指针
     * 执行用时 :12 ms, 在所有 php 提交中击败了96.61%的用户
     * 算法复杂度 O(n)
     * @param Integer[] $height
     * @return Integer
     */
    public function trapPointer($height)
    {
        $left = 0;
        $right = count($height) - 1;
        $area = 0;
        $left_max = 0;
        $right_max = 0;
        while ($left < $right) {
            if ($height[$left] < $height[$right]) {
                $height[$left] >= $left_max ? ($left_max = $height[$left]) : $area += ($left_max - $height[$left]);
                ++$left;
            } else {
                $height[$right] >= $right_max ? ($right_max = $height[$right]) : $area += ($right_max - $height[$right]);
                --$right;
            }
        }
        return $area;
    }
}
