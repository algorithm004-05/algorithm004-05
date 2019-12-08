<?php
/**
 * 题目名称：valid-parentheses 有效的括号
 * 题目链接：https://leetcode-cn.com/problems/valid-parentheses/
 */

/**
 * 第一种解法：使用栈
 * @param String $s
 * @return Boolean
 */
function isValid($s) {
    if (empty($s)) {
        return true;
    }
    $match = [')' => '(', '}' => '{', ']' => '['];
    $splitStr = str_split($s);
    $stack = [];
    foreach ($splitStr as $c) {
        if (isset($match[$c])) {
            if (empty($stack)) {
                array_push($stack, $c);
            } elseif ($stack[count($stack) - 1] == $match[$c]) {
                array_pop($stack);
            } else {
                return false;
            }
        } else {
            array_push($stack, $c);
        }
    }
    return empty($stack);
}
