<?php

class Solution
{


    public $dirs = [[0, 1], [0, -1], [1, 0], [-1, 0], [-1, -1], [-1, 1], [1, -1], [1, 1]];
    public $row = 0;
    public $columns = 0;

    /**
     * @param String[][] $board
     * @param Integer[] $click
     * @return String[][]
     */
    function updateBoard($board, $click)
    {

        $this->row = count($board);
        $this->columns = count($board[0]);

        if ($board[$click[0]][$click[1]] == 'M') {
            $board[$click[0]][$click[1]] = 'X';
            return $board;
        }
        return $this->dfs($board, $click[0], $click[1]);
    }

    function dfs($board, $x, $y)
    {

        $num = $this->countor($board, $x, $y);
        if ($num == 0) {
            $board[$x][$y] = 'B';
        } else {
            $board[$x][$y] = strval($num);
            return $board;
        }

        foreach ($this->dirs as $dir) {
            $newRow = $dir[0] + $x;
            $newCol = $dir[1] + $y;
            if ($newRow >= 0 && $newRow < $this->row && $newCol >= 0 && $newCol < $this->columns && $board[$newRow][$newCol] == 'E') {
                $board = $this->dfs($board, $newRow, $newCol);
            }
        }
        return $board;
    }

    function countor($board, $x, $y)
    {
        $num = 0;
        foreach ($this->dirs as $dir) {
            $newRow = $dir[0] + $x;
            $newCol = $dir[1] + $y;
            if ($newRow >= 0 && $newRow < $this->row && $newCol >= 0 && $newCol < $this->columns && $board[$newRow][$newCol] == 'M') {
                $num++;
            }
        }
        return $num;
    }
}