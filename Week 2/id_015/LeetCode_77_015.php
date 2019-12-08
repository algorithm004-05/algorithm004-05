<?php
class Solution {
    private $result;
    /**
     * @param Integer $n
     * @param Integer $k
     * @return Integer[][]
     */
    function combine($n, $k) {
        $this->getSubCombine($n, $k, []);
        return $this->result;
    }

    function getSubCombine($n, $k, $ans) {
        if ($n < $k) {
            return;
        }
        if ($k == 0) {
            $this->result[] = $ans;
            return;
        }
        $this->getSubCombine($n-1, $k, $ans);
        $ans1 = $ans;
        $ans1[] = $n;
        $this->getSubCombine($n-1, $k-1, $ans1);
    }
}
