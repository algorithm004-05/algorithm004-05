<?php
class Solution {
  /**
   * @param Integer[] $nums1
   * @param Integer $m
   * @param Integer[] $nums2
   * @param Integer $n
   * @return NULL
   */
  function merge(&$nums1, $m, $nums2, $n) {
      // 插入位置
      $insert = $m + $n - 1;
      while ($m > 0 && $n > 0) {
          if ($nums1[$m-1] >= $nums2[$n-1]) {
              $nums1[$insert] = $nums1[$m-1];
              $m--;
          } else {
              $nums1[$insert] = $nums2[$n-1];
              $n--;
          }
          $insert--;
      }
      if ($m == 0 && $n > 0) {
          for ($i = 0; $i < $n; $i++) {
              $nums1[$i] = $nums2[$i];
          }
      }
  }
}