<?php
class Solution
{
    /**
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
        for ($i=0; $i < strlen($s); $i++) {
            if (isset($arr[substr($s, $i, 1)])) {
                $temp[] = substr($s, $i, 1);
            } else {
                if ($arr[array_pop($temp)] != substr($s, $i, 1)) {
                    return false;
                }
            }
        }
        if (!empty($temp)) {
            return false;
        }
        return true;
    }
}
