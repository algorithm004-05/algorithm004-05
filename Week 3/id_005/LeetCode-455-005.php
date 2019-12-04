<?php
class Solution
{

    /**
     * 执行用时 :72 ms, 在所有 php 提交中击败了92.11%的用户
     * 暴力法 排序完
     * @param Integer[] $g
     * @param Integer[] $s
     * @return Integer
     */
    public function findContentChildren($g, $s)
    {
        sort($g);
        sort($s);
        $i = 0;
        for ($j = 0; $i < count($g) && $j < count($s); $j++) {
            if ($g[$i] <= $s[$j]) {
                $i++;
            }
        }
        return $i;
    }
}
