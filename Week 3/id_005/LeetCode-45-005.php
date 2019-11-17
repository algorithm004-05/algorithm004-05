<?php
class Solution
{

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function jump($nums)
    {
        $count = 0;
        $end = 0;// 可选最大距离的范围
        $max_step = 0; // 当前距离最大的值
        for ($i = 0; $i < count($nums)-1; $i++) {
            $max_step = max($max_step, $i + $nums[$i]);
            if ($i == $end) {
                $count++;
                $end = $max_step;
            }
        }
        return $count;
    }
}
