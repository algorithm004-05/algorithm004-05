/**
 * https://leetcode-cn.com/problems/lemonade-change/description/
 */
public class LeetCode_860_100 {

    /**
     * 利用贪心算法求解
     * 每次需要找零时，先取余钱中的最大币值
     * 时间复杂度：O(N)
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int fiveNum = 0;
        int tenNum = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveNum++;
            } else if (bills[i] == 10) {
                if (fiveNum-- <= 0) {
                    return false;
                }
                tenNum++;
            } else {
                if(tenNum > 0) {
                    tenNum--;
                    if (fiveNum > 0) {
                        fiveNum--;
                    } else {
                        return false;
                    }
                } else {
                    if (fiveNum >= 3) {
                        fiveNum -= 3;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}