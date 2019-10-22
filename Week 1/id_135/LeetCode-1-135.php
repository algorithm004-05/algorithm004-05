<?php
class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($nums, $target) {
        $first = 0;
        $result = [];
        foreach ($nums as $key => $item) {
            $first = $item;
            $data = $target - $first;
            $newNum = array_slice($nums, $key + 1);
            $key1 = array_search($data, $newNum);
            if ($key1 !== false) {

                $result[] = $key;
                $result[] = $key1 + $key + 1;
            }
        }
        return $result;
    }
}