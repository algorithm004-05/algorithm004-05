<?php
/**
 * 题目名称：majority-element 求众数
 * 题目链接：https://leetcode-cn.com/problems/majority-element/
 */


/**
 * 第一种解法：循环遍历，借助额外空间存储每个元素出现次数，时间复杂度O(n),空间复杂度O(n)
 * @param Integer[] $nums
 * @return Integer
 */
function majorityElement($nums) {
    $len = count($nums);
    $dict = [];
    foreach ($nums as $num) {
        if (isset($dict[$num])) {
            $dict[$num] = $dict[$num] + 1;
        } else {
            $dict[$num] = 1;
        }
        if ($dict[$num] > $len / 2) {
            return $num;
        }
    }
}

$input = [2,2,1,1,1,2,2];
$ans = majorityElement($input);
var_dump($ans);
