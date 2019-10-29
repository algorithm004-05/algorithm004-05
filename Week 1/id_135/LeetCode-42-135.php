<?php

class Solution {

    /**
     * @param Integer[] $height
     * @return Integer
     */
    function trap($height) {
        $sum = 0;
        $maxLeft = 0;
        $maxRight = [];
        for ($i = count($height) - 2; $i >= 0; $i--) {
            $maxRight[$i] = max($maxRight[$i + 1], $height[$i + 1]);
        }
        for ($i = 1; $i < count($height) - 1; $i++) {
            $maxLeft = max($maxLeft, $height[$i - 1]);
            $min = min($maxLeft, $maxRight[$i]);
            if ($min > $height[$i]) {
                $sum = $sum + ($min - $height[$i]);
            }
        }
        return $sum;
    }
}