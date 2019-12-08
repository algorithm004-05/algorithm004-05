<?php
class Solution {

    /**
     * @param String $s
     * @param String $t
     * @return Boolean
     */
    function isAnagram($s, $t) {
        if(strlen($s) != strlen($t))
            return false;

        $arr1 = str_split($s);
        $arr2 = str_split($t);
        sort($arr1);
        sort($arr2);

        return $arr1 == $arr2;
    }
}