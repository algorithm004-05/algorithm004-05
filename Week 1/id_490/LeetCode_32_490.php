<?php
/**
 * 题目名称：longest-valid-parentheses 最长有效括号
 * 题目链接：https://leetcode-cn.com/problems/longest-valid-parentheses/
 */

/**
 * 解法一：使用栈
 * @param String $s
 * @return Integer
 */
function longestValidParentheses($s) {
    $splitS = str_split($s);
    $stack = [-1];
    $maxLen = 0;
    foreach ($splitS as $index => $char) {
        if ($char == '(') {
            array_push($stack, $index);
        } else {
            array_pop($stack);
            if (empty($stack)) {
                array_push($stack, $index);
            } else {
                $maxLen = max($maxLen, $index - $stack[count($stack) - 1]);
            }
        }
        
    }
    
    return $maxLen;
}
