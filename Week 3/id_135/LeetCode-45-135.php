<?php

class Solution
{

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function jump($nums)
    {
        $step = 0;
        $end = 0;
        $maxBound = 0;
        for ($i = 0; $i < count($nums) - 1; $i++) {
            $maxBound = max($maxBound, $nums[$i] + $i);

            if ($i == $end) {
                ++$step;
                $end = $maxBound;
            }
        }
        return $step;
    }
}
