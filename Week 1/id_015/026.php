<?php
class Solution {

/**
 * @param Integer[] $nums
 * @return Integer
 */
function removeDuplicates(&$nums) {
    $notDup = 0;
    for ($i = 1; $i < count($nums); $i++) {
        if ($nums[$notDup] != $nums[$i]) {
            $notDup++;
            $nums[$notDup] = $nums[$i];
        }
    }
    return $notDup + 1;
}
}