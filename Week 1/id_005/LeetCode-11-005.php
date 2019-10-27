<?php

class Solution
{
    /**
     * 执行用时 :44 ms, 在所有 php 提交中击败了73.20%的用户
     * 采用双指针
     * 时间复杂度 O(n)
     * @param Integer[] $height
     * @return Integer
     */
    public function maxArea($height)
    {
        $i = 0;
        $j = count($height) - 1;
        $maxArea = 0;
        while ($i < $j) {
            $width = $j - $i;
            $length = min($height[$i], $height[$j]);
            $maxArea = max($width * $length, $maxArea);
            if ($height[$i] > $height[$j]) {
                $j--;
            } else {
                $i++;
            }
        }
        return $maxArea;
    }
}
