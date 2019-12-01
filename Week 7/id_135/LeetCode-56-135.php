<?php
class Solution {

    /**
     * @param Integer[][] $intervals
     * @return Integer[][]
     */
    function merge($intervals) {
        if(count($intervals)<1) return [];
    // 默认二维数组排序，是根据一维数组的第一个值进行排序的
    sort($intervals);
    $j = 0;
    $ans[$j] = $intervals[0];
    for($i=1;$i<count($intervals);$i++){
        $start = $intervals[$i][0];
        $end = $intervals[$i][1];
        if($start<=$ans[$j][1]){//说明可以合并
            $ans[$j] = [$ans[$j][0],max($ans[$j][1],$end)];
        }else{
            $j++;
            $ans[$j] = $intervals[$i];
        }
    }
    }
}
