<?php

class Solution
{

    /**
     * @param String[] $tasks
     * @param Integer $n
     * @return Integer
     */
    function leastInterval($tasks, $n)
    {
        $total = count($tasks);
        $count = [];
        foreach ($tasks as $k => $v) {
            if (isset($count[$v]))
                $count[$v]++;
            else
                $count[$v] = 1;
        }

        arsort($count);
        $max = array_shift($count);
        $sum = 1;
        foreach ($count as $a)
            if ($a == $max)
                $sum++;

        $res = ($max - 1) * ($n + 1) + $sum;

        return $res > $total ? $res : $total;
    }
}