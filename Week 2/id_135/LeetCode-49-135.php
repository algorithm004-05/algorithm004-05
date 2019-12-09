<?php
class Solution {

    /**
     * @param String[] $strs
     * @return String[][]
     */
    function groupAnagrams($strs) {
        $map = [];
        foreach($strs as $str){
            $tmp_str = $this->format($str);
            $map[$tmp_str][] = $str;
        }
        return $map;
    }

    function format($str){
        $arr = str_split($str);
        sort($arr);
        return implode("",$arr);
    }
}