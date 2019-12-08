<?php
class Solution
{

    /**
     * 算法复杂度 O(n)
     * @param Integer $n
     * @return Integer
     */
    public function climbStairs($n)
    {
        $arr = [];
        $arr[0] = 1;
        $arr[1] = 1;
        for ($i=2; $i<= $n; $i++) {
            $arr[$i] = $arr[$i - 1] + $arr[$i - 2];
        }
        return $arr[$n];
    }
}
