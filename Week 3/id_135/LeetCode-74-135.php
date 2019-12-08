<?php

class Solution
{

    /**
     * @param Integer[][] $matrix
     * @param Integer $target
     * @return Boolean
     */
    function searchMatrix($matrix, $target)
    {
        $depth = count($matrix);
        if ($depth == 0) return false;
        $len = count($matrix[0]);
        $left = 0;
        $right = $depth * $len - 1;
        while ($left <= $right) {
            $mid = $right - floor(($right - $left) / 2);
            $row = floor($mid / $len);
            $col = fmod($mid, $len);
            if ($matrix[$row][$col] == $target) {
                return true;
            } else if ($matrix[$row][$col] > $target) {
                $right = $mid - 1;
            } else {
                $left = $mid + 1;
            }
        }
        return false;
    }
}