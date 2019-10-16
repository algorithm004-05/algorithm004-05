<?php

/**
 * @param Integer[] $nums
 * @return NULL
 */
function moveZeroes(&$nums) {
    $zeroIndex = -1;
    for ($i = 0; $i < count($nums); $i++) {
        if ($zeroIndex < 0 && $nums[$i] == 0) {
            $zeroIndex = $i;
        }
        if ($nums[$i] != 0 && $zeroIndex >= 0) {
            $tmp = $nums[$i];
            $nums[$i] = $nums[$zeroIndex];
            $nums[$zeroIndex] = $tmp;
            $zeroIndex++;
        }
    }
}
