<?php
/**
 * 题目名称：n-queens N皇后
 * 题目链接：https://leetcode-cn.com/problems/n-queens/
 */


/**
 * @param Integer $n
 * @return String[][]
 */
function solveNQueens($n) {
    $result = [];
    $cur = [];
    calcNQueens(0, $n, $cur, $result);
    $formatResult = printQueens($result, $n);
    return $formatResult;
}

function calcNQueens($row, $n, $cur, &$result) {
    if ($row == $n) {
        $result[] = $cur;
        $cur = [];
        return;
    }
    
    for ($column = 0; $column < $n; $column++) {
        if (isOk($row, $column, $cur, $n)) {
            $cur[$row] = $column;
            calcNQueens($row + 1, $n, $cur, $result);
        }
    }
}

function isOk($row, $column, $cur, $n) {
    $leftUp = $column - 1;
    $rightUp = $column + 1;
    
    for ($i = $row - 1; $i >= 0; --$i) {
        if ($cur[$i] == $column) return false;
        if ($leftUp >= 0 && $cur[$i] == $leftUp) return false;
        if ($rightUp < $n && $cur[$i] == $rightUp) return false;
        $leftUp--;
        $rightUp++;
    }
    return true;
}

function printQueens($result, $n) {
    $formatResult = [];
    foreach ($result as $value) {
        $queenResult = [];
        foreach ($value as $column) {
            $queenStr = '';
            for ($i=0; $i<$n; $i++) {
                if ($column == $i) {
                    $queenStr .= 'Q';
                } else {
                    $queenStr .= '.';
                }
            }
            $queenResult[] = $queenStr;
        }
        $formatResult[] = $queenResult;  
    }
    return $formatResult;
}

$ans = solveNQueens(4);
var_dump($ans);
