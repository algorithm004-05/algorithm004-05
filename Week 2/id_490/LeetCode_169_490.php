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

/**
 * 第二种解法，使用分治思想
 * @param Integer[] $nums
 * @return Integer
 */
function majorityElement2($nums) {
    majorityElementRecur($nums, 0, count($nums) - 1);
}

function majorityElementRecur(&$nums, $low, $high) {
    // recursion teminator
    if ($low == $high) {
        return $nums[$low];
    }
    // prepare data
    $mid = intval(($high - $low) / 2 + $low);
        //var_dump($low, $high, $mid); if (is_float($mid)) die;

    // conquer subproblems
    $left = majorityElementRecur($nums, $low, $mid);
    $right = majorityElementRecur($nums, $mid + 1, $high);
    // process and generate the final result
    if ($left == $right) {
        return $left;
    }
    $leftCount = countInRange($nums, $left, $low, $high);
    $rightCount = countInRange($nums, $right, $low, $high);
    var_dump($leftCount, $rightCount);
    return  $leftCount > $rightCount ? $left : $right;
}

function countInRange($nums, $majority, $low, $high) {
    $count = 0;
    for($i=$low; $i<=$high; $i++) {
        if ($nums[$i] == $majority) $count++;
    }
    return $count;
}



$input = [2,2,1,1,1,2,2];
$ans = majorityElement2($input);
var_dump($ans);
