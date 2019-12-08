<?php
class Solution {

    /**
     * @param Integer[] $nums
     * @return NULL
     */
    function moveZeroes(&$nums) {
        $lastIdx = count($nums) - 1;

        for ($i = 0; $i < $lastIdx; $i++) {
            for ($j = $i + 1; $j <= $lastIdx; $j++) {
                if (($nums[$i] === 0) && ($nums[$j] !== 0)) {
                    $zero = $nums[$i];
                    $nonZero = $nums[$j];
                    $nums[$i] = $nonZero;
                    $nums[$j] = $zero;
                }
            }
        }
    }
}
