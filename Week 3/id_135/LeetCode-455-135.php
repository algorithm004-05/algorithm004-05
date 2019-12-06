<?php

class Solution
{

    /**
     * @param Integer[] $g
     * @param Integer[] $s
     * @return Integer
     */
    function findContentChildren($g, $s)
    {
        $i = $j = 0;
        $count = 0;
        sort($g);
        sort($s);
        while ($i < count($g) && $j < count($s)) {
            if ($g[$i] > $s[$j]) {
                $j++;
            } else {
                $i++;
                $j++;
                $count++;
            }
        }
        return $count;
    }
}