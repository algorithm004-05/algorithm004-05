<?php

function rotate(&$nums, $k) {
    for ($i = 1; $i <= $k; $i++) {
        $length = count($nums);
        $tmp = $nums[$length - 1];
        for ($j = $length - 1; $j > 0 ; $j--) {
            $nums[$j] = $nums[$j - 1];
        }
        $nums[0] = $tmp;
    }
}