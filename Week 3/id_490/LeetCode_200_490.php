<?php
/**
 * 题目名称：number-of-islands 岛屿数量
 * 题目链接：https://leetcode-cn.com/problems/number-of-islands/
 */

class Solution {
    private $grid;
    private $rows;
    private $cols;
    private $dirs = [[0, -1], [1, 0], [0, 1], [-1, 0]];
    private $marked = [];

    /**
     * 第一种解法：深度优先遍历，递归方式
     * @param String[][] $grid
     * @return Integer
     */
    function numIslands($grid) {
        $this->grid = $grid;
        $this->rows = count($grid);
        if ($this->rows == 0) {
            return 0;
        }
        $this->cols = count($this->grid[0]);
        $count = 0;
        for ($i = 0; $i < $this->rows; $i++) {
            for ($j = 0; $j < $this->cols; $j++) {
                if (empty($this->marked[$i][$j]) && $this->grid[$i][$j] == '1') {
                	$count++;
                    $this->dfs($i, $j);
                }
            }
        }
        
        return $count;
    }
    
    function dfs($i, $j) {
        if ($i < 0 || $i >= $this->rows || $j < 0 || $j >= $this->cols
           || !empty($this->marked[$i][$j]) || $this->grid[$i][$j] == '0') {
            return;
        }
        $this->marked[$i][$j] = true;

        for ($k = 0; $k < 4; $k++) {
            $newX = $i + $this->dirs[$k][0];
            $newY = $j + $this->dirs[$k][1];
            $this->dfs($newX, $newY);
        }
    }

    /**
     * @param String[][] $grid
     * @return Integer
     */
    function numIslandsBfs($grid) {
        $this->grid = $grid;
        $this->rows = count($grid);
        if ($this->rows == 0) {
            return 0;
        }
        $this->cols = count($this->grid[0]);
        $count = 0;
        for ($i = 0; $i < $this->rows; $i++) {
            for ($j = 0; $j < $this->cols; $j++) {
                if (empty($this->marked[$i][$j]) && $this->grid[$i][$j] == '1') {
                    $this->bfs($i, $j);
                    $count++;
                }
            }
        }
        
        return $count;
    }
    
  
    
    function bfs($i, $j) {
        $queue = [];
        $this->marked[$i][$j] = true;
        array_push($queue, $i * $this->cols + $j);
        while (!empty($queue)) {
            $cur = array_pop($queue);
            $curX = intval($cur / $this->cols);
            $curY = intval($cur % $this->cols);
            for ($k = 0; $k < 4; $k++) {
                $newX = $curX + $this->dirs[$k][0];
                $newY = $curY + $this->dirs[$k][1];
                if (($newX >=0 && $newX < $this->rows && $newY >= 0 && $newY < $this->cols) && empty($this->marked[$newX][$newY]) && $this->grid[$newX][$newY] == '1') {
                    $this->marked[$newX][$newY] = true;
                    array_push($queue, $newX * $this->cols + $newY);
                }
            }
        }
    }
}

$solution = new Solution();
$grid = [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]];
$nums = $solution->numIslands($grid);
var_dump($nums);