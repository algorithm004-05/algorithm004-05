class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer[][]
     */
    function permute($nums) {
        $allList = [];
        $this->backtrack(0,count($nums),$nums,$allList);
        return $allList;
    }
    
    function backtrack($start,$count,$nums,&$allList){
        if($start==$count){
            $allList[] = $nums;
        }else{
            for($i=$start;$i<$count;$i++){
                $this->swap($nums,$start,$i);
                $this->backtrack($start+1,$count,$nums,$allList);
                $this->swap($nums,$start,$i);
            }
        }
    }
    
    function swap(&$track,$i,$j){
        $temp = $arr[$i];
        $arr[$i] = $track[$j];
        $arr[$j] = $temp;
    }
}