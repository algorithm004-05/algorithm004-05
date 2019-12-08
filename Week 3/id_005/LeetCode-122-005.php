<?php
class Solution
{
    /**
     * 执行用时 :20 ms, 在所有 php 提交中击败了65.48%的用户
     * @param Integer[] $prices
     * @return Integer
     */
    public function maxProfitOne($prices)
    {
        $profit = 0;
        for ($i = 1; $i < count($prices); $i++) {
            if ($prices[$i] - $prices[$i-1] > 0) {
                $profit += $prices[$i] - $prices[$i-1];
            }
        }

        return $profit;
    }
}
