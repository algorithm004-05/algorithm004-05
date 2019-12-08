<?php
/**
 * 题目名称：valid-sudoku 有效的数独
 * 题目链接：https://leetcode-cn.com/problems/valid-sudoku/
 */

/**
 * @param String[][] $board
 * @return Boolean
 */
function isValidSudoku($board) {
    $rows = [];
    $columns = [];
    $boxes = [];

    for ($i = 0; $i < 9; $i++) {
        for ($j = 0; $j < 9; $j++) {
            $boxIndex = intval($i / 3) * 3 + intval($j / 3);
            $num = $board[$i][$j];
            if ($num == '.') continue;
            $rows[$i][$num] = $rows[$i][$num] + 1;
            $columns[$j][$num] = $columns[$j][$num] + 1;
            $boxes[$boxIndex][$num] = $boxes[$boxIndex][$num] + 1;
        
            if ($rows[$i][$num] >= 2 || $columns[$j][$num] >= 2 || $boxes[$boxIndex][$num] >= 2) {
                return false;
            }
        }
    }
    return true;
}