<?php
/**
 * 题目名称：friend-circles 朋友圈
 * 题目链接：https://leetcode-cn.com/problems/friend-circles/
 */

class Solution {

    /**
     * 第一种解法：使用并查集
     * @param Integer[][] $M
     * @return Integer
     */
    function findCircleNum($M) {
        $parent = [];
        $len = count($M);
        for ($i = 0; $i < $len; $i++) {
            $parent[$i] = -1;
        }
        for ($i = 0; $i < $len; $i++) {
            for ($j = 0; $j < $len; $j++) {
                if ($M[$i][$j] == 1 && $i != $j) {
                    $this->union($parent, $i, $j);
                }
            }
        }
        $count = 0;
        for ($i = 0; $i < $len; $i++) {
            if ($parent[$i] == -1) {
                $count++;
            }
        }
        return $count;
    }

    function find(&$parent, $i) {
        if ($parent[$i] == -1) {
            return $i;
        }
        return $this->find($parent, $parent[$i]);
    }

    function union(&$parent, $x, $y) {
        $xset = $this->find($parent, $x);
        $yset = $this->find($parent, $y);
        if ($xset != $yset) {
            $parent[$xset] = $yset;
        }
    }


    /**
     * 第二种解法：深度优先搜索
     * @param Integer[][] $M
     * @return Integer
     */
    function findCircleNum2($M) {
        $len = count($M);
        $visited = [];
        for ($i = 0; $i < $len; $i++) {
            $visited[$i] = 0;
        }
        $count = 0;
        for ($i = 0; $i < $len; $i++) {
            if ($visited[$i] == 0) {
                $this->dfs($M, $visited, $i);
                $count++;
            }
        }
        return $count;
    }

    function dfs($M, &$visited, $i) {
        for ($j = 0; $j < count($M); $j++) {
            if ($M[$i][$j] == 1 && $visited[$j] == 0) {
                $visited[$j] = 1;
                $this->dfs($M, $visited, $j);
            }
        }
    }

}