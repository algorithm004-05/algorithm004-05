<?php
class Solution
{
    /**
     * hash
     * 执行用时 :4 ms, 在所有 php 提交中击败了95.74%的用户
     * @param String $s
     * @return Boolean
     */
    public function isValid($s)
    {
        if (strlen($s) % 2 != 0) {
            return false;
        }
        $temp = [];
        $arr = ['(' => ')', '{'=>'}', '[' => ']'];
        for ($i = 0; $i < strlen($s); $i++) {
            if (isset($arr[$s[$i]])) {
                $temp[] = $s[$i];
            } else {
                if ($arr[array_pop($temp)] != $s[$i]) {
                    return false;
                }
            }
        }
        if (!empty($temp)) {
            return false;
        }
        return true;
    }

    /**
     * 栈
     * 执行用时 :4 ms, 在所有 php 提交中击败了95.74%的用户
     * @param String $s
     * @return Boolean
     */
    public function isValidStack($s)
    {
        $eg = ["{" => "}", "[" => "]", "(" => ")"];
        $arr = [];
        for ($i = 0; $i < strlen($s); $i++) {
            $tmp = end($arr);
            if (isset($eg[$tmp]) && $eg[$tmp] == $s[$i]) {
                unset($arr[key($arr)]);
            } else {
                $arr[] = $s[$i];
            }
        }
        return count($arr) == 0;
    }
}
