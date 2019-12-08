<?php

class Solution
{

    /**
     * @param String[][] $board
     * @return NULL
     */
    function solve(&$board)
    {
        if (empty($board)) return;
        $this->row = count($board);
        $this->col = count($board[0]);
        for ($i = 0; $i < $this->row; $i++) {
            $this->dfs($board, $i, 0);
            $this->dfs($board, $i, $this->col - 1);
        }
        for ($j = 0; $j < $this->col; $j++) {
            $this->dfs($board, 0, $j);
            $this->dfs($board, $this->row - 1, $j);
        }
        for ($i = 0; $i < $this->row; $i++) {
            for ($j = 0; $j < $this->col; $j++) {
                if ($board[$i][$j] == 'O') $board[$i][$j] = 'X';
                if ($board[$i][$j] == '-') $board[$i][$j] = 'O';
            }
        }
        return;
    }

    private $row, $col;

    function dfs(&$board, $i, $j)
    {
        if ($i < 0 || $j < 0 || $i > $this->row - 1 || $j > $this->col - 1 || $board[$i][$j] != 'O')
            return;
        $board[$i][$j] = '-';
        $this->dfs($board, $i - 1, $j);
        $this->dfs($board, $i + 1, $j);
        $this->dfs($board, $i, $j - 1);
        $this->dfs($board, $i, $j + 1);
        return;
    }
}