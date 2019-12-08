<?php

class Solution
{
    /**
     * 循环一遍清除零并在末尾追加零
     * 算法复杂度 O(n)
     * 执行用时 :12 ms, 在所有 php 提交中击败了 95.11% 的用户
     * 拿到题目第一时间想到的做法优化版
     * @param Integer[] $nums
     * @return NULL
     */
    public function moveZeroes(&$nums)
    {
        foreach ($nums as $key => $num) {
            if ($num == 0) {
                unset($nums[$key]);
                $nums[] = 0;
            }
        }
    }

    /**
     * 遇到零时记录下零的个数，遇到非零时马上替换
     * 算法复杂度 O(n)
     * 执行用时 :16 ms, 在所有 php 提交中击败了77.17%的用户
     * @param Integer[] $nums
     * @return NULL
     */
    public function moveZeroesTwo(&$nums)
    {
        $k = 0;
        for ($i = 0; $i < count($nums); $i++) {
            if ($nums[$i] == 0) {
                $k++;
            } elseif ($k > 0) {
                list($nums[$i], $nums[$i-$k]) = [$nums[$i-$k], $nums[$i]];
            }
        }
    }

    /**
     * 把非零的数直接拿到前面
     * 算法复杂度 O(n)
     * 20 ms, 在所有 php 提交中击败了 54.89% 的用户
     * @param Integer[] $nums
     * @return NULL
     */
    public function moveZeroesThree(&$nums)
    {
        $j = 0;
        for ($i = 0; $i < count($nums); $i++) {
            if ($nums[$i] != 0) {
                list($nums[$i], $nums[$j]) = [$nums[$j], $nums[$i]];
                $j++;
            }
        }
    }

    /**
     * 拿到题目第一时间想到的做法
     * @param Integer[] $nums
     * @return NULL
     */
    public function moveZeroesFirst(&$nums)
    {
        $zoro_count = 0;
        foreach ($nums as $key => $num) {
            if ($num == 0) {
                unset($nums[$key]);
                $zoro_count += 1;
            }
        }
        $nums = array_values($nums);
        for ($i=0; $i < $zoro_count; $i++) {
            $nums[] = 0;
        }
        return $nums;
    }
}
