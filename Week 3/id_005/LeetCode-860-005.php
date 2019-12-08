<?php
class Solution
{

    /**
     * 执行用时 :40 ms, 在所有 php 提交中击败了100%的用户
     * 暴力法
     * @param Integer[] $bills
     * @return Boolean
     */
    public function lemonadeChange($bills)
    {
        $five = 0;
        $ten = 0;
        foreach ($bills as $bill) {
            if ($bill == 5) {
                $five++;
            }
            if ($bill == 10) {
                if ($five > 0) {
                    $five--;
                    $ten++;
                } else {
                    return false;
                }
            }
            if ($bill == 20) {
                if ($ten > 0 && $five > 0) {
                    $ten--;
                    $five--;
                } elseif ($five >= 3) {
                    $five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
