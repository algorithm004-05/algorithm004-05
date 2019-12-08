<?php
/**
 * 题目名称：valid-perfect-square 有效的完全平方数
 * 题目链接：https://leetcode-cn.com/problems/valid-perfect-square/
 */


 /**
 * 牛顿迭代法
 * @param Integer $x
 * @return Integer
 */
function mySqrt($x) {
    $a = $x;
    while ($a * $a > $x) {
        $a = intval(($a + $x / $a) / 2);
    }
    return intval($a);
}