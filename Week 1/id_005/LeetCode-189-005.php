<?php
class Solution
{

    /**
     * 看题解的方式：环状替换
     * 算法复杂度 O(n)
     * 执行用时 :16 ms, 在所有 php 提交中击败了95.27%的用户
     * @param Integer[] $nums
     * @param Integer $k
     * @return NULL
     */
    public function rotatePrev(&$nums, $k)
    {
        $len = count($nums);
        $k = $k % $len;
        $count = 0;// 移动次数
        for ($i = 0; $count < $len; $i++) {
            $current = $i;
            $prev = $nums[$i]; // 当前值
            do {
                $next = ($current + $k) % $len;// 当前值移动的位置
                $temp = $nums[$next]; // 临时存储当前值移动的位置上的元素
                $nums[$next] = $prev;// 把当前值放上去
                $prev = $temp;// 下一个要移动的值
                $current = $next; // 下一个要移动的值的位置
                $count++;
            } while ($i != $current);// 直到回到最初的位置
        }
    }

    /**
     * 看题解的方式：三次反转 第一次反转整个数组 第二次反转前面 K 个数字 第三次反转后面 K 个数字
     * 算法复杂度 O(n)
     * 执行用时 :16 ms, 在所有 php 提交中击败了95.27%的用户
     * @param Integer[] $nums
     * @param Integer $k
     * @return NULL
     */
    public function rotateReverse(&$nums, $k)
    {
        $l = count($nums);
        $k %= $l;
        $nums = $this->reverse($nums, 0, $l - 1);
        $nums = $this->reverse($nums, 0, $k - 1);
        $nums = $this->reverse($nums, $k, $l - 1);
    }

    public function reverse($nums, $start, $end)
    {
        while ($start < $end) {
            $temp = $nums[$start];
            $nums[$start] = $nums[$end];
            $nums[$end] = $temp;
            $start++;
            $end--;
        }
        return $nums;
    }

    /**
     * 循环一遍整个数组后移，再把露出来的部分平移到头部
     * 执行用时 :28 ms, 在所有 php 提交中击败了51.35%的用户(依旧很惨)
     * 算法复杂度 O(n)
     * @param Integer[] $nums
     * @param Integer $k
     * @return NULL
     */
    public function rotate(&$nums, $k)
    {
        $len = count($nums);
        if ($len <= 1 || $k <= 0) {
            return $nums;
        }
        if ($k > $len) {
            $k = $k % $len;
        }

        $j = $k;
        for ($i = $len-1; $i >= 0; $i--) {
            $nums[$i+$k] = $nums[$i];
            if ($j > $i) {
                $nums[$i] = $nums[$len-1+$j];
                unset($nums[$len-1+$j]);
                $j--;
            }
        }
    }

    /**
     * 拿到题目最初的做法，将最后 k 个值移到头部
     * 执行用时 :1356 ms, 在所有 php 提交中击败了5.00%的用户(太惨了再见)
     * @param Integer[] $nums
     * @param Integer $k
     * @return NULL
     */
    public function rotateFirst(&$nums, $k)
    {
        while ($k > 0) {
            array_unshift($nums, array_pop($nums));
            $k--;
        }
    }
}
