<?php
/**
 * 题目名称：evaluate-reverse-polish-notation 逆波兰表达式求值
 * 题目链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */

/**
 * 第一种解法：使用栈
 * @param String[] $tokens
 * @return Integer
 */
function evalRPN($tokens) {
    $ans = 0;
    $operators = ['+', '-', '*', '/'];
    $stack = [];
    if (count($tokens) == 1) {
        return intval($tokens[0]);
    }
    
    foreach ($tokens as $token) {
        if (in_array($token, $operators)) {
            $op1 = array_pop($stack);
            $op2 = array_pop($stack);
            if ($token == '+') {
                $ans = $op2 + $op1;
            } elseif ($token == '-') {
                $ans = $op2 - $op1;
            } elseif ($token == '*') {
                $ans = $op2 * $op1;
            } elseif ($token == '/') {
                $ans = intval($op2 / $op1);
            }
            array_push($stack, $ans);
        } else {
            array_push($stack, $token);
        }
    }
    
    return $ans;
}