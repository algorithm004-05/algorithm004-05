<?php
class Solution {

  /**
   * @param Integer[] $nums
   * @return NULL
   */
  function moveZeroes(&$nums) {
      $len = count($nums);
      $zero = 0;
      $notZero = $zero + 1;
      while ($zero < $len && $notZero < $len) {
          if ($nums[$zero] != 0) {
              $zero++;
              continue;
          }
          if ($nums[$notZero] == 0) {
              $notZero++;
              continue;
          }
          if ($zero > $notZero) {
              $notZero = $zero + 1;
              continue;
          }
          if ($nums[$zero] == 0 && $nums[$notZero] != 0) {
              $nums[$zero] = $nums[$notZero];
              $nums[$notZero] = 0;
          }
      }
  }
}