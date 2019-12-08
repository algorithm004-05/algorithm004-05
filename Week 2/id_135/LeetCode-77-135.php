<?php
class Solution {

    /**
     * @param Integer $n
     * @param Integer $k
     * @return Integer[][]
     */
    function combine($n, $k) {
        $this->n = $n;
        $this->k = $k;
        $this->backtrack(1,[]);
        return $this->arr;
    }

    private $n,$k,$arr;

    function backtrack($first,$comb){
        if($this->k == count($comb)){
            $this->arr[] = $comb;
        }
        for($i = $first;$i<$this->n+1;$i++){
            array_push($comb,$i);
            $this->backtrack($i+1,$comb);
            array_pop($comb);
        }
    }
}