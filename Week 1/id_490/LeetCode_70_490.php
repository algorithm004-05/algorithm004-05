<?php
/**
 * 题目名称：climbing-stairs 爬楼梯
 * 题目链接：https://leetcode-cn.com/problems/climbing-stairs/
 */

/**
 * @param Integer $n
 * @return Integer
 */
function climbStairs($n) {
    if ($n == 1) return 1;
    if ($n == 2) return 2;
    return climbStairs($n - 1) + climbStairs($n - 2);
}

/**
 * @param Integer $n
 * @return Integer
 */
function climbStairs2($n) {
    if ($n == 1) return 1;
    if ($n == 2) return 2;
    $dp = [];
    $dp[1] = 1;
    $dp[2] = 2;
    for ($i = 3; $i <= $n; $i++) {
    	$dp[$i] = $dp[$i - 1] + $dp[$i - 2];
    }
    return $dp[$n];
}


echo climbStairs2(50);