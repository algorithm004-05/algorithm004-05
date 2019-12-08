<?php
/**
 * 题目名称：valid-anagram 有效的字母异位词
 * 题目链接：https://leetcode-cn.com/problems/valid-anagram/
 */

/**
 * 第一种解法，先排序，再对比
 * @param String $s
 * @param String $t
 * @return Boolean
 */
function isAnagram($s, $t) {
    $sArr = str_split($s);
    $tArr = str_split($t);
    sort($sArr);
    sort($tArr);
    return  $sArr === $tArr;
}

/**
 * 第二种解法，使用哈希表
 * @param String $s
 * @param String $t
 * @return Boolean
 */
function isAnagram2($s, $t) {
    $sMap = [];
    foreach (str_split($s) as $c) {
        if (isset($sMap[$c])) {
            $sMap[$c] = $sMap[$c] + 1;
        } else {
            $sMap[$c] = 1;
        }
    }
    foreach (str_split($t) as $c) {
        if (isset($sMap[$c])) {
            $sMap[$c] = $sMap[$c] - 1;
        } else {
            $sMap[$c] = 1;
        }
    }

    foreach ($sMap as $value) {
        if ($value != 0)  return false;
    }

    return true;
}

