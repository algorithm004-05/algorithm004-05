<?php
class Solution {
    // 1. 暴力穷举 n^2
    // 2. 新建一个新的数组，对下标加k取模后, 按照顺序存入新的数组中
    // 3. 添加一个变量

    /**
     * @param Integer[] $nums
     * @param Integer $k
     * @return NULL
     */
    function rotate(&$nums, $k) {
        $len = count($nums);
        $k = $k % $len;
        $this->reverse($nums, 0, $len - 1);
        $this->reverse($nums, 0, $k - 1);
        $this->reverse($nums, $k, $len - 1);
    }
    
    function reverse(&$nums, $start, $end) {
        while ($start < $end) {
            $tmp = $nums[$start];
            $nums[$start] = $nums[$end];
            $nums[$end] = $tmp;
            $start++;
            $end--;
        }
    }
}