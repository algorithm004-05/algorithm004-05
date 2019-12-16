<?php
class Solution {

    /**
     * @param String $s
     * @param Integer $k
     * @return String
     */
    function reverseStr($s, $k) {
        $total = $single = '';
        $arr = str_split($s, $k*2);

        foreach ($arr as $key => $value) {
            $len = strlen($value);
            if ($len < $k) {
                $single = strrev($value);
            } else {
                $singArr = str_split($value, $k);
                $single = strrev($singArr[0]) . $singArr[1];
            }
            $total .= $single;
        }

        return $total;
    }
}