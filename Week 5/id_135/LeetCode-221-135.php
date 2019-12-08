<?php

class Solution
{

    /**
     * @param String[][] $matrix
     * @return Integer
     */
    function maximalSquare($matrix)
    {
        $max = 0;
        $dp = [];
        for ($i = 0; $i < count($matrix); $i++) {
            for ($j = 0; $j < count($matrix[0]); $j++) {
                if ($i == 0 || $j == 0 || $matrix[$i][$j] == 0) {
                    $dp[$i][$j] = $matrix[$i][$j];
                } else {
                    $dp[$i][$j] = min($dp[$i - 1][$j], $dp[$i - 1][$j - 1], $dp[$i][$j - 1]) + 1;

                }
                if ($dp[$i][$j] > $max)
                    $max = $dp[$i][$j];
            }
        }
        return $max * $max;
    }
}