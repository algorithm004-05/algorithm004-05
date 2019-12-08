<?php
/**
 * 题目名称：lemonade-change 柠檬水找零
 * 题目链接：https://leetcode-cn.com/problems/lemonade-change/
 */

class Solution {

    /**
     * @param Integer[] $bills
     * @return Boolean
     */
    function lemonadeChange($bills) {
        $fiveCoins = 0;
        $tenCoins = 0;
        foreach ($bills as $bill) {
            if ($bill == 5) {
                $fiveCoins++;
            } elseif ($bill == 10) {
                $tenCoins++;
                if ($fiveCoins >= 1) {
                    $fiveCoins--;
                } else {
                    return false;
                }
            } else {
                if ($tenCoins >= 1 && $fiveCoins >= 1) {
                    $fiveCoins--;
                    $tenCoins--;
                } elseif ($tenCoins == 0 && $fiveCoins >= 3) {
                    $fiveCoins -= 3;
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}

$solution = new Solution();
$bills = [5,5,5,10,20]; // 7
$index = $solution->lemonadeChange($bills);
var_dump($index);