//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int[] plusOne(int[] digits) {
            for(int i = digits.length -1 ; i >= 0; i--) {
                digits[i]++;
                digits[i] = digits[i] % 10;
                if(digits[i] != 0) {
            //若没有进位，则必然有一个digits[i]!=0 这样直接返回结果即可
                    return digits;
                }
            }
            //若全部循环完成则仍然没有返回。说明全部进位了，最后单独在头部加个1即可
            //因为进位不会超过1位-> 9 + 9 = 18 99+99 = 198 
            digits = new int[digits.length +1];
            digits[0] = 1;
            return digits;
        }
}
//leetcode submit region end(Prohibit modification and deletion)
