package com.chenlei.geektime.leetcode.lesson10;

/**
 * 柠檬水找零
 * <pre>
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
 *
 * </pre>
 */
public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        //由于最大面值为 20
        //用于找零的面值为 5 元 和 10 元
        //能用10元找零的优先使用10元找零而不是2张五元
        int five = 0, ten = 0;

        for (int i = 0; i < bills.length; i++) {
            if(bills[i] == 5){
                five ++;
            }else if(bills[i] == 10){
                if(five == 0) return false; //没有零钱
                five --;
                ten ++;
            }else{
                if(five > 0 && ten > 0){  //有5元和10元时 为最优
                    five --;
                    ten --;
                }else if(five >=3 ){ //只有5元
                    five -= 3;
                }else{
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args){
        LemonadeChange lemonadeChange = new LemonadeChange();

        int[] bills = new int[]{5,5,5,10,20};
        boolean result = lemonadeChange.lemonadeChange(bills);
        int[] bills1 = new int[]{5,5,10,10,20};
        boolean result1 = lemonadeChange.lemonadeChange(bills1);

        System.out.println("result:"+result);
        System.out.println("result1:"+result1);
    }
}
