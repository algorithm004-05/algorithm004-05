<?php
class Solution {

    /**
	 * 从排序数组中删除重复项，并返回非重元素的个数
	 * @url https://leetcode.com/problems/remove-duplicates-from-sorted-array/
     * @param Integer[] $nums
     * @return Integer
     */
    function removeDuplicates(&$arr) {
        $i = 1;
        $j = 0;
        $len = count($arr);
        while($i < $len) {
            if($arr[$i] != $arr[$i-1])
            {
                $j++;
                $arr[$j] = $arr[$i];
            }
            $i++;	
        }
        return $j+1;
    }
}