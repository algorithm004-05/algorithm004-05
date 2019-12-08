<?php
/**
 * 题目名称：generate-parentheses 括号生成
 * 题目链接：https://leetcode-cn.com/problems/generate-parentheses/
 */


/**
 * @param Integer $n
 * @return String[]
 */
function generateParenthesis($n) {
    $ans = [];
    recurGenerate(0, 0,  $n, "", $ans);
    return $ans;
}

function recurGenerate($open, $close, $max, $curr, &$ans) {
    // terminator
    if ($open == $max && $close == $max) {
        $ans[] = $curr;
        return;
    }
    
    // process current logic
    
    // drill down
    if ($open < $max) {
        recurGenerate($open + 1, $close, $max, $curr . "(", $ans);
    }
    if ($open > $close) {
        recurGenerate($open, $close + 1, $max, $curr . ")", $ans);
    }
    
    // restore current status
}

$ans = generateParenthesis(5);
var_dump($ans);
