package homework.week3;

import java.util.HashMap;

//https://leetcode-cn.com/problems/lemonade-change/description/
public class LeetCode_860_590 {
    public HashMap<Integer, Integer> wallet = new HashMap<>();

    public boolean lemonadeChange(int[] bills) {
        wallet.put(5, 0);
        wallet.put(10, 0);
        wallet.put(20, 0);
        //遍历买东西的数组
        for (int i = 0; i < bills.length; i++) {
            if (!_takeMoneyForChange(bills, i)) {
                return false;
            }
        }
        return true;
    }


    private boolean _takeMoneyForChange(int[] bills, int index) {
        //1.如果钱包里的钱小于(当前给的钱-5),那么肯定找不起,返回false
        if (index * 5 < bills[index] - 5) {
            return false;
        }
        //2.如果钱包里的钱可以满足找零需求,那么步骤应当是尽量用10凑大头,最后用5去补零头,如果凑的齐,就将wallet中的数
        //减掉,然后在钱包里放入bills[index];  如果凑不够,就返回false
        int check = bills[index] - 5;

        int count_10 = check / 10;

        if (wallet.get(10) >= count_10) {
            wallet.put(10, wallet.get(10) - count_10);
            int count_5 = (check - count_10 * 10) / 5;
            if (count_5 <= wallet.get(5)) {
                wallet.put(5, wallet.get(5) - count_5);
                wallet.put(bills[index], wallet.get(bills[index]) + 1);
            } else {
                return false;
            }
        } else {
            //当前钱包里的10不足需要兑换的10的整数位
            int remaining = check - wallet.get(10) * 10;
            wallet.put(10, 0);
            if (remaining > wallet.get(5) * 5) {
                return false;
            } else {
                wallet.put(5, wallet.get(5) - remaining / 5);
                wallet.put(bills[index], wallet.get(bills[index]) + 1);
            }
        }
        return true;

    }
}
