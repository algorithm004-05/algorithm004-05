<?php
class Solution
{

    /**
     * 算法复杂度 O(n)
     * 暴力解
     * @param Integer[] $digits
     * @return Integer[]
     */
    public function plusOne($digits)
    {
        $add = 0;
        $len = count($digits)-1;
        for ($i = $len; $i >= 0; $i--) {
            if ($i == $len) {
                $digits[$i] += 1;
            } else {
                $digits[$i] += $add;
            }

            if ($digits[$i] > 9) {
                $digits[$i] -= 10;
                $add = 1;
            } else {
                $add = 0;
            }
        }
        if ($add > 0) {
            array_unshift($digits, $add);
        }
        return $digits;
    }

    /**
     * @param Integer[] $digits
     * @return Integer[]
     */
    public function plusOneTwo($digits)
    {
        $length = count($digits);
        for ($i = $length -1; $i >= 0; $i--) {
            $digits[$i] = ++$digits[$i] % 10;
            if ($digits[$i] != 0) {
                return $digits;
            }
        }

        array_unshift($digits, 1);
        return $digits;
    }
}
