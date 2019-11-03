<?php
/**
 * 题目名称：best-time-to-buy-and-sell-stock-ii 买卖股票的最佳时机 II
 * 题目链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */

class Solution {

    /**
     * 第一种解法：峰谷法
     * @param Integer[] $prices
     * @return Integer
     */
    function maxProfit($prices) {
        $i = 0;
        $profit = 0;
        $valley = $prices[0];
        $peak = $prices[0];
        while ($i < count($prices) - 1) {
            while ($i < count($prices) - 1 && $prices[$i] >= $prices[$i+1]) {
                $i++;
            }
            $valley = $prices[$i];
            while ($i < count($prices) - 1 && $prices[$i] <= $prices[$i+1]) {
                $i++;
            }
            $peak = $prices[$i];
            $profit += $peak - $valley;
        }
        
        return $profit;
    }

    /**
     * 第二种解法：一次遍历法
     * @param Integer[] $prices
     * @return Integer
     */
    function maxProfit2($prices) {
        $profit = 0;
        for ($i = 1; $i < count($prices); $i++) {
            if ($prices[$i] > $prices[$i - 1]) {
                $profit += $prices[$i] - $prices[$i - 1];
            }
        }       
        return $profit;
    }
}

$solution = new Solution();
$prices = [7,1,5,3,6,4]; // 7
$index = $solution->maxProfit2($prices);
var_dump($index);