<?php
class Solution
{

    /**
     * 执行用时 :36 ms, 在所有 php 提交中击败了100%的用户
     * 暴力法
     * @param String[] $strs
     * @return String[][]
     */
    public function groupAnagrams($strs)
    {
        $result = [];
        foreach ($strs as $str) {
            $temp = str_split($str);
            sort($temp);
            $key = implode('', $temp);
            $result[$key][] = $str;
        }
        return array_values($result);
    }
}
