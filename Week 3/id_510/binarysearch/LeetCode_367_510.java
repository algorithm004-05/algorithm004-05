

/**
 *
 * 有效的完全平方数
 *
 *
 *给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 * 示例 2：
 *
 * 输入：14
 * 输出：False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_367_510 {

    public static void main(String[] args) {
        LeetCode_367_510 t = new LeetCode_367_510();
        System.out.println(t.isPerfectSquare(1));
    }

    /**
     * 
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if(num < 0){
            return false;
        }
        if(num <= 1){
            return true;
        }
        int left = 0,right = num,mid = 0;
        while(left < right){
             mid = left + ((right - left)>>1);
            if(mid >= num/mid){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        if(left == num/left && 0 == num%left){
            return true;
        }
        return false;
    }
}
