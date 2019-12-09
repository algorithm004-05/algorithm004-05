<?php
class Solution
{
    /**
     * hash
     * 执行用时 :16 ms, 在所有 php 提交中击败了88.54%的用户
     * 算法复杂度 O(n)
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    public function twoSum($nums, $target)
    {
        $map = [];

        foreach ($nums as $key => $value) {
            $need = $target - $value;
            if (isset($map[$need])) {
                return [$map[$need], $key];
            }
            $map[$value] = $key;
        }
        return [];
    }

    /**
     * 暴力
     * 执行用时 :1776 ms, 在所有 php 提交中击败了29.58%的用户
     * 算法复杂度 O(n²)
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    public function twoSumTwo($nums, $target)
    {
        for ($i = 0; $i < count($nums); $i++) {
            for ($j = $i+1; $j < count($nums); $j++) {
                if ($nums[$i] + $nums[$j] == $target) {
                    return [$i, $j];
                }
            }
        }
    }
}
