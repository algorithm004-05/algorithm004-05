/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int b : bills) {
            if (b == 5) {
                five++;
            }
            else if(b  == 10 ) {
                if(five > 0) 
                {
                    five--;
                    ten++;
                }
                else {
                    return false;
                }
            }
            else if(b == 20) {
                if(five > 0 && ten > 0) {
                    ten--;
                    five--;
                }
                else if(five > 3) {
                    five = five - 3;
                } else {
                    return false;
                }
            }
            
        }
        return true;


    }
}
// @lc code=end

