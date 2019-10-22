//第一次尝试
class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $k
     * @return NULL
     */
    function rotate(&$nums, $k) {
        if($k<0) return $nums;
        for($i=0;$i<$k;$i++){
            array_splice($nums,0,0,array_pop($nums));
        }
    }
}
