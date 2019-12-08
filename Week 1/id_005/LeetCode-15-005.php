<?php
class Solution
{
    /**
     * 看题解的
     * 执行用时 :200 ms, 在所有 php 提交中击败了97.04%的用户
     * 算法复杂度 O(n²)
     * @param Integer[] $nums
     * @return Integer[][]
     */
    public function threeSumTwo($nums)
    {
        $count = count($nums);
        $result = [];
        sort($nums);
        for ($i = 0; $i < $count-2; $i++) {
            // 非复数跳出循环
            if ($nums[$i] > 0) {
                break;
            }
            // 与最大两个数相加小于 0 退出
            if ($nums[$i] + $nums[$count-2] + $nums[$count-1] < 0) {
                continue;
            }
            // 避免重复
            if ($nums[$i] == $nums[$i+1]) {
                continue;
            }
            $l = $i + 1;
            $r = $count - 1;

            while ($l < $r) {
                $temp = $nums[$i] + $nums[$l] + $nums[$r];

                if ($temp==0) {
                    $result[] = [$nums[$i], $nums[$l], $nums[$r]];

                    while ($l+1 < $r && $nums[$l] == $nums[$l+1]) {
                        $l +=1;// 避免重复
                    }
                    $l += 1;
                    while ($r-1> $l && $nums[$r] == $nums[$r-1]) {
                        $r -=1;// 避免重复
                    }
                    $r -= 1;
                } elseif ($temp > 0) {
                    $r -= 1;
                } else {
                    $l += 1;
                }
            }
        }
        return $result;
    }

    /**
     * 暴力破解(超时放弃)
     * @param Integer[] $nums
     * @return Integer[][]
     */
    public function threeSum($nums)
    {
        sort($nums);
        $nums = array_values($nums);
        $lent = count($nums)-1;
        $arr = [];
        for ($i = 0; $i <= $lent-2; $i++) {
            if ($nums[$i] <= 0) {
                for ($j = $i + 1; $j <= $lent; $j++) {
                    for ($k = $j + 1; $k <= $lent; $k++) {
                        if ($nums[$i] + $nums[$j] + $nums[$k] === 0) {
                            $temp = [$nums[$i], $nums[$j], $nums[$k]];
                            sort($temp);
                            if (!in_array($temp, $arr)) {
                                $arr[] = $temp;
                            };
                        }
                    }
                }
            }
        }
        return $arr;
    }
}
