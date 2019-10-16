<?php

/**
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


$result = twoSum([2, 7, 11, 15], 9);
var_dump($result);