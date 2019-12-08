<?php
/**
 * 题目名称：longest-common-subsequence 最长公共子序列
 * 题目链接：https://leetcode-cn.com/problems/longest-common-subsequence/s
 */

/**
 * 第一种解法：动态规划
 * @param String $text1
 * @param String $text2
 * @return Integer
 */
function longestCommonSubsequence($text1, $text2) {
    $text1Arr = str_split($text1);
    $text2Arr = str_split($text2);
    $dp = [];
    for ($i = 0; $i < count($text1Arr); $i++) {
        for ($j = 0; $j < count($text2Arr); $j++) {
            if ($text1Arr[$i] == $text2Arr[$j]) {
                $dp[$i][$j] = $dp[$i - 1][$j - 1] + 1;
            } else {
                $dp[$i][$j] = max($dp[$i - 1][$j], $dp[$i][$j - 1]);
            }
        }
    }
    //echo $i . '-' . $j;
    return intval($dp[$i - 1][$j - 1]);
}