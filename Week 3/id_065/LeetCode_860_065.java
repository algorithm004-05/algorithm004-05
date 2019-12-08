/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for(int b : bills){
            if(b == 5) five ++;
            else if(b == 10) {
                if(five-- == 0) return false;
                ten++;
            }
            else {
                if(five > 0 && ten > 0){
                    five--; ten--;
                }
                else if(five > 2){
                    five -= 3;
                }
                else return false;
            }
        }
        return true;
    }
}
// @lc code=end

