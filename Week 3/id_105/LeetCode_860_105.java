package id_105;

import java.util.HashMap;
import java.util.Map;

/**
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 *
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *
 * 注意，一开始你手头没有任何零钱。
 *
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 *
 * 示例 1：
 *
 * 输入：[5,5,5,10,20]
 * 输出：true
 * 解释：
 * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 * 由于所有客户都得到了正确的找零，所以我们输出 true。
 * 示例 2：
 *
 * 输入：[5,5,10]
 * 输出：true
 * 示例 3：
 *
 * 输入：[10,10]
 * 输出：false
 * 示例 4：
 *
 * 输入：[5,5,10,10,20]
 * 输出：false
 * 解释：
 * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
 * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
 * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
 * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
 *  
 *
 * 提示：
 *
 * 0 <= bills.length <= 10000
 * bills[i] 不是 5 就是 10 或是 20 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lemonade-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_860_105 {


    /**
     * 效率极差
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {

        Map<Integer, Integer> hasMap = new HashMap<>();
        hasMap.put(5, 0);
        hasMap.put(10, 0);
        hasMap.put(20, 0);

        int[] amounts = new int[]{5, 10, 20};

        boolean flag = true;
        for (int bill : bills) {

            int payBack = bill - 5;
            if (payBack == 0) {
                hasMap.put(5, hasMap.get(5) + 1);
                continue;
            }

            Map<Integer, Integer> tmp = new HashMap<>();
            for (int i = amounts.length - 1; i >= 0; i--) {
                int needNums = payBack / amounts[i];
                int hasNums = hasMap.get(amounts[i]);
                if (needNums == 0 || hasNums == 0) {
                    continue;
                }
                if (hasNums >= needNums) {
                    tmp.put(amounts[i], needNums);
                    payBack = payBack - amounts[i] * needNums;
                } else {
                    tmp.put(amounts[i], hasNums);
                    payBack = payBack - amounts[i] * hasNums;
                }
            }

            if (payBack == 0) {
                for (Map.Entry<Integer, Integer> entry : tmp.entrySet()) {
                    int amount = entry.getKey();
                    int nums = entry.getValue();
                    hasMap.put(amount, hasMap.get(amount) - nums);
                }
                hasMap.put(bill, hasMap.get(bill) + 1);
                continue;
            }
            flag = false;
            break;

        }
        return flag;

    }

    /**
     * 效率极高
     * @param bills
     * @return
     */
    public boolean lemonadeChange2(int[] bills) {
        if (bills.length == 0) {
            return false;
        }

        int fiveNums = 0;
        int tenNums = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveNums++;
            } else if (bills[i] == 10) {
                tenNums++;
                fiveNums--;
            } else if (bills[i] == 20) {
                if (tenNums > 0) {
                    fiveNums--;
                    tenNums--;
                } else {
                    fiveNums = fiveNums - 3;
                }
            }
            if (fiveNums < 0) {
                return false;
            }
        }
        return true;
    }

    public void test() {
        boolean result = this.lemonadeChange(new int[]{5, 5, 5, 10, 20});
        System.out.println(result);
    }

}
