<?php
class Solution
{
    /**
     * 看题解的
     * 算法复杂度 O(n)
     * 执行用时 :4 ms, 在所有 php 提交中击败了100%的用户
     * @param Integer[] $nums1
     * @param Integer $m
     * @param Integer[] $nums2
     * @param Integer $n
     * @return NULL
     */
    public function merge(&$nums1, $m, $nums2, $n)
    {
        $index1 = $m-1;// 指向 nums1 最后一个非空值
        $index2 = $n-1;// 指向 nums2 最后一个非空值
        $count_index = $m + $n-1;// 指针指向 nums1 最后一个空值
        while ($index1 >= 0 || $index2 >= 0) {
            if ($index1 < 0) {
                $nums1[$count_index--] = $nums2[$index2--];
            } elseif ($index2 < 0) {
                $nums1[$count_index--] = $nums1[$index1--];
            } elseif ($nums1[$index1] > $nums2[$index2]) { // 借助排序数组这一特性，对比两遍最大的值从后向前依次填入
                $nums1[$count_index--] = $nums1[$index1--];
            } else {
                $nums1[$count_index--] = $nums2[$index2--];
            }
        }
    }
}
