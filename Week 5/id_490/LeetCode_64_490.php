<?php
/**
 * 题目名称：minimum-path-sum 最小路径和
 * 题目链接：https://leetcode-cn.com/problems/minimum-path-sum/
 */

/**
 * 第一种解法：二维动态规划
 * @param Integer[][] $grid
 * @return Integer
 */
function minPathSum($grid) {
    $row = count($grid);
    $column = count($grid[0]);
    $dp = [];
    for ($i = $row - 1; $i >= 0; $i--) {
        for ($j = $column - 1; $j >= 0; $j--) {
            if ($i == $row - 1 && $j != $column - 1) {
                $dp[$i][$j] = $grid[$i][$j] + $dp[$i][$j + 1];
            } elseif ($i != $row - 1 && $j == $column - 1) {
                $dp[$i][$j] = $grid[$i][$j] + $dp[$i + 1][$j];
            } elseif ($i != $row - 1 && $j != $column - 1) {
                $dp[$i][$j] = $grid[$i][$j] + min($dp[$i + 1][$j], $dp[$i][$j + 1]);
            } else {
                $dp[$i][$j] = $grid[$i][$j];
            }
        }
    }
    return $dp[0][0];
}

/**
 * 第二种解法：一维动态规划
 * @param Integer[][] $grid
 * @return Integer
 */
function minPathSum2($grid) {
    $row = count($grid);
    $column = count($grid[0]);
    $dp = [];
    for ($i = $row - 1; $i >= 0; $i--) {
        for ($j = $column - 1; $j >= 0; $j--) {
            if ($i == $row - 1 && $j != $column - 1) {
                $dp[$j] = $grid[$i][$j] + $dp[$j + 1];
            } elseif ($i != $row - 1 && $j == $column - 1) {
                $dp[$j] = $grid[$i][$j] + $dp[$j];
            } elseif ($i != $row - 1 && $j != $column - 1) {
                $dp[$j] = $grid[$i][$j] + min($dp[$j], $dp[$j + 1]);
            } else {
                $dp[$j] = $grid[$i][$j];
            }
        }
    }
    return $dp[0];
}