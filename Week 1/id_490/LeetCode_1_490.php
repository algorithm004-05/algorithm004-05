<?php
/**
 * 题目名称：two-sum 两数之和
 * 题目链接：https://leetcode-cn.com/problems/two-sum/
 */

/**
 * 第一种解法：暴力求解，双重循环，时间复杂度O(n^2)
 * @param Integer[] $nums
 * @param Integer $target
 * @return Integer[]
 */
function twoSum($nums, $target) {
	$len = count($nums);
    for ($i=0; $i<$len - 1; $i++) {
    	for ($j=$i+1; $j<$len-1; $j++) {
    		if ($nums[$i] + $nums[$j] == $target) {
    			return [$i, $j];
    		}
    	}
    }
}

/**
 * 第二种解法：一遍hash，时间复杂度O(n)
 * @param Integer[] $nums
 * @param Integer $target
 * @return Integer[]
 */
function twoSum2($nums, $target) {
	$len = count($nums);
	$map = [];
    for ($i=0; $i<$len; $i++) {
    	$match = $target - $nums[$i];
		if (isset($map[$match])) {
			return [$map[$match], $i];
		}   
		$map[$nums[$i]] = $i;	
    }
}



$result = twoSum2([2, 7, 11, 15, 30, 25, 4, 9, 80, 74, 32, 1], 3);
var_dump($result);