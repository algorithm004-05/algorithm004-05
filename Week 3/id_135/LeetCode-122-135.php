<?php

class Solution
{

    /**
     * @param Integer[] $prices
     * @return Integer
     */
    function maxProfit($prices)
    {
        $maxProfit = 0;
        for ($i = 1; $i < count($prices); $i++)
            if ($prices[$i] > $prices[$i - 1])
                $maxProfit += $prices[$i] - $prices[$i - 1];
        return $maxProfit;

    }
}