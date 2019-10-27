//第一次尝试
class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function removeDuplicates(&$nums) {
        $count = count($nums);
        $len = 0;
        for($i=0;$i<$count;$i++){
            if($nums[$i]===$nums[$i+1]){
                unset($nums[$i]);
            }else{
                $len++;
            }
        }
        return $len;
    }
}
