class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function findMin($nums) {
        $left = 0;
        $right = count($nums) - 1;

        while ($left < $right) {
            if ($left + 1 == $right) {
                return $nums[$left] > $nums[$right] ? $nums[$right] : $nums[$left];
            }

            $mid = intval($left + ($right - $left) / 2);
            if ($nums[$left] > $nums[$mid] || $nums[$right] > $nums[$mid]) {
                $right = $mid;
            } else if ($nums[$right] < $nums[$mid] || $nums[$left] > $nums[$mid]) {
                $left = $mid;
            }
        }
        return $nums[$left];
    }
}
