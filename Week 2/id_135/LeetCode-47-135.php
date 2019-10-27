<?php
class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer[][]
     */
    function permuteUnique($nums) {
        $this->solutions = array();
        sort($nums);

        $this->dfs($nums, array(), array(0));

        return $this->solutions;
    }

    function dfs($nums, $solution, $visited) {

        $flag = 0;
        $lastnum = 0;

        if (count($solution) == count($nums)) {
            $this->solutions[] = $solution;
            return;
        }
        for ($i=0; $i<count($nums);$i++) {
            if ($flag != 0 && $i > 0 && $nums[$i] == $lastnum) {
                continue;
            }

            if ($visited[$i] == 0) {
                $visited[$i] = 1;
                $solution[] = $nums[$i];
                $this->dfs($nums, $solution, $visited, $i+1);
                array_pop($solution);
                $visited[$i] = 0;
                $flag = 1;
                // 上一个num的值
                $lastnum = $nums[$i];
            }
        }
    }
}