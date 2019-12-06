//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1 || n == 2 || n == 4 || n == 8 || n == 16 || n == 32 || n == 64 || n == 128 || n == 256 || n == 512 || n == 1024) {
            return true;
        }
        if ((n & (n - 1)) == 0) {
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
