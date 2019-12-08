<?php
class Solution {

    /**
     * @param String $s
     * @param String $t
     * @return Boolean
     */
    function isAnagram($s, $t) {
        $hash = [];
        $count = strlen($s);
        $count2 = strlen($t);
        if ($count2!=$count) {
            return false;
        }

        for ($i=0;$i<$count;$i++) {
            if (!isset($hash[$s[$i]])) {
                $hash[$s[$i]] = 1;
            } else {
                $hash[$s[$i]] += 1;
            }
        }
        for ($i=0;$i<$count;$i++) {
            if(!isset($hash[$t[$i]])){
                return false;
            } elseif ($hash[$t[$i]] > 1) {
                $hash[$t[$i]] -= 1;
            } elseif ($hash[$t[$i]] == 1) {
                unset($hash[$t[$i]]);
            }
        }
        return true;

    }
}
