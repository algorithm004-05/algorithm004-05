package no.two.eight.three.theme.move.zeros.oct.nineteenth;

public class Solution {
    public void moveZeroes(int[] nums) {
       int j = 0;
       for (int i = 0; i < nums.length; i++ )
       {
           if (nums[i] != 0) {
               nums[j] = nums[i];
               j++;
           }
       }

       for (;j < nums.length; j++) {
           nums[j] = 0;
       }
    }
}