<?php

class Solution
{

    /**
     * 在排序好的数组的前提下才能生效
     * 执行用时 :20 ms, 在所有 php 提交中击败了98.66%的用户
     * @param Integer[] $nums
     * @return Integer
     */
    public function removeDuplicates(&$nums)
    {
        $index = 0;
        for ($i = 1; $i < count($nums); $i++) {
            if ($nums[$i] != $nums[$index]) {
                $nums[$index+1] = $nums[$i];
                $index++;
            }
        }
        return $index+1;
    }
}
