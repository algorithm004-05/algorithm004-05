package algorithm00405test.week1.job.done;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_66_510 {

    /**
     * 暴力
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        if (null == digits || 0 == digits.length){
            return null;
        }

        for (int i = digits.length -1; i >= 0 ; i--) {
            // 等于9 则进位1 当前位重置为0
            if (9 == digits[i]){
                digits[i] = 0;
            } else {
                // 小于9 直接加1返回
                digits[i] = digits[i]+1;
                return digits;
            }

            // 如果数组第一位也为9 而且走到这里说明有进位 则需要重新new一个大数组
            if (0 == i){
                digits = new int[digits.length+1];
                digits[0] =1;
                return digits;
            }
        }

        return null;
    }
}
