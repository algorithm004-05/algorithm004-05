/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 *
 * https://leetcode.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (41.72%)
 * Likes:    1028
 * Dislikes: 1801
 * Total Accepted:    458.4K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty array of digits representing a non-negative integer, plus
 * one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contain a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * 
 */

// @lc code=start

class Solution {
    public int[] plusOne(int[] digits) {

        Boolean plusone = true;

        for (int i = digits.length-1; i >= 0; i--){
            if ( plusone ) {
                int val = digits[i];
                if ( val + 1 <= 9 ) {
                    plusone = false;
                    digits[i] = val + 1;
                    break;
                }else{
                    if ( i!= 0 ){
                        digits[i] = 0;
                        plusone = true; 
                    }else{
                        digits[i] = 0;
                        digits = new int[digits.length + 1];
                        digits[0] = 1;
                        break;
                        
                    }

                }
                
            }
        }
    

        return digits;
        
    }
}



// @lc code=end

