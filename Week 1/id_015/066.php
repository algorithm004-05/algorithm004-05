<?php
class Solution {
  // 1. 直接使用游标从尾部向前走
  /**
   * @param Integer[] $digits
   * @return Integer[]
   */
  function plusOne($digits) {
      $carry = 1;
      $len = count($digits);
      for ($i = $len - 1; $i >=0; $i--) {
          if ($carry == 0) {
              break;
          }
          if ($digits[$i] == 9) {
              $digits[$i] = 0;
          } else {
              $digits[$i]++;
              $carry = 0;
          }
      }
      if ($carry == 1) {
          $tmpDigits = [1];
          for ($j = 0; $j < $len; $j++) {
              $tmpDigits[] = $digits[$j];
          }
          return $tmpDigits;
      }
      return $digits;
  }
}