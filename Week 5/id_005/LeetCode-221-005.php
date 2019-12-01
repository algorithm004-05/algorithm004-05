<?php
class Solution {

    /**
     * 执行用时 :112 ms, 在所有 php 提交中击败了14.29%的用户
     * @param String[][] $matrix
     * @return Integer
     */
    function maximalSquare($matrix) {
        $rows = count($matrix);
        $cols = $rows > 0 ? count($matrix[0]) : 0;
        $dp = $matrix[$rows + 1][$cols + 1];
        $maxsqlen = 0;
        for ($i = 1;$i <= $rows; $i++) {
            for ($j = 1; $j <= $cols; $j++) {
                if ($matrix[$i-1][$j-1] == '1') {
                    $dp[$i][$j] = min(min($dp[$i][$j - 1], $dp[$i - 1][$j]), $dp[$i - 1][$j - 1]) + 1;
                    $maxsqlen = max($maxsqlen, $dp[$i][$j]);
                }
            }
        }
        return $maxsqlen * $maxsqlen;
    }

    /**
     * 执行用时 :72 ms, 在所有 php 提交中击败了100%的用户
     * @param String[][] $matrix
     * @return Integer
     */
    function maximalSquare($matrix)
    {
        $max = 0;
        for ($i = 0; $i < count($matrix); $i++) {
            for ($j = 0; $j < count($matrix[0]); $j++) {
                if ($i == 0 || $j == 0 || $matrix[$i][$j] == 0) {
                    $dp[$i][$j] = $matrix[$i][$j];
                } else {
                    $dp[$i][$j] = min($dp[$i-1][$j], $dp[$i-1][$j-1], $dp[$i][$j-1]) + 1;
                }
                if ($dp[$i][$j] > $max) {
                    $max = $dp[$i][$j];
                }
            }
        }
        return $max*$max;
    }
}
