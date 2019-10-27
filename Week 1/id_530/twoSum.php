<?php
class Solution {

    /**
	 * 数组任意俩元素求和
	 * @url https://leetcode.com/problems/two-sum/
     * @param Integer[] $arr
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($arr, $target) {
        for($i=0; $i<count($arr); $i++) {
			$diff = $target - $arr[$i];
			// array_search如果在数组中找到指定的键值，则返回对应的键名，否则返回 FALSE
			$index = array_search($diff, $arr);
			if($index !==false &&  $index != $i) {
				return [$i, $index];
			}
		}
		
		return [];
    }
}