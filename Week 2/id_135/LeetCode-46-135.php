<?php
class Solution {

    private $numbers = [];

    /**
     * @param Integer[] $nums
     * @return Integer[][]
     */
    function permute($nums) {
        $n = count($nums);
        if($n == 0)
            return [[]];
        if($n == 1)
            return [[$nums[0]]];
        $this->numbers = $nums;
        return $this->generatePermutations($n);
    }
    private function generatePermutations($n) {
        if($n == 1)
            return [[$this->numbers[0]]];
        $retArray = [];
        $lastPermutations = $this->generatePermutations($n-1);
        $last = $this->numbers[$n-1];
        foreach($lastPermutations as $permutation){
            for($i=0; $i<$n; ++$i){
                $retArray[] = $this->insert($permutation, $i, $last);
            }
        }
        return $retArray;
    }

    private function insert($arr, $pos, $el) {
        $n = count($arr);
        $ret = [];
        $pushed = 0;
        for($i=0; $i<=$n; ++$i) {
            if($i == $pos){
                $ret[] = $el;
                ++$pushed;
            }
            else
                $ret[] = $arr[$i-$pushed];
        }
        return $ret;
    }
}