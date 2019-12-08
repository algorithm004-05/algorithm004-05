<?php
/**
 * 题目名称：decode-ways 解码方法
 * 题目链接：https://leetcode-cn.com/problems/decode-ways/
 */

 /**
 * @param String $s
 * @return Integer
 */
function numDecodings($s) {
    if (empty($s)) return 0;
    $arr = str_split($s);
    if ($arr[0] == '0') return 0;
    $pre = $curr = 1;
    for ($i = 1; $i < count($arr); $i++) {
        $tmp = $curr;
        if ($arr[$i] == '0') {
            if ($arr[$i - 1] == '1' || $arr[$i - 1] == '2') {
                $curr = $pre;
            } else {
                return 0;
            }
        } elseif ($arr[$i - 1] == '1' || ($arr[$i - 1] == '2' && $arr[$i] >= 1 && $arr[$i] <= 6)) {
            $curr = $curr + $pre;
        }
        $pre = $tmp;
    }
    return $curr;
}