<?php
class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function firstUniqChar($s) {
        $length = strlen($s);
        if($length == 1) return 0;
        $s = str_split($s);
        $arr = array_count_values($s);
        asort($arr);
        for($i = 0; $i < $length; $i++){
            if($arr[$s[$i]] == 1)
                return $i;
        }
        return -1;
    }
}