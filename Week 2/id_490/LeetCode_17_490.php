<?php
/**
 * 题目名称：letter-combinations-of-a-phone-number 电话号码的字母组合
 * 题目链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */


/**
 * @param String $digits
 * @return String[]
 */
function letterCombinations($digits) {
    $ans = [];
    var_dump($digits);
    $dict = ['2' => ['a', 'b', 'c'], '3' => ['d', 'e', 'f'], '4' => ['g', 'h', 'i'], '5' => ['j', 'k', 'l'], '6' => ['m', 'n', 'o'], '7' => ['p', 'q', 'r', 's'], '8' => ['t', 'u', 'v'], '9' => ['w', 'x', 'y', 'z']];
    if (strlen($digits) == 0) {
        return [];
    }

    recurGenerate($digits, 0, strlen($digits), '', $ans, $dict);
    return $ans;
}

function recurGenerate($digits, $level, $max, $curr, &$ans, $dict) {
    // terminator
    if ($level == $max) {
        $ans[] = $curr;
        return;
    }
    
    // process current logic
    $letters = $dict[substr($digits, $level, 1)];
    // drill down
    foreach ($letters as $letter) {
        recurGenerate($digits, $level + 1, $max, $curr . $letter, $ans, $dict);
    }
    
    
    // restore current status
}

$ans = letterCombinations('987');
var_dump($ans);
