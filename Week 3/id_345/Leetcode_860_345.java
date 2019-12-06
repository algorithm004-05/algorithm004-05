package xyz.isok.algorithm.leetcode.easy;

/**
 * https://leetcode-cn.com/problems/lemonade-change/description/
 */
public class No860LemonadeChange {

    private int total = 0;

    private int[] worth = {5, 10};

    private int[] index = {0, 1};

    private int[] stat = new int[2];

    public static void main(String[] args) {
//        int[] bills = {5,5,5,10,20};
//        int[] bills = {5,5,10,10,20};
        int[] bills = {5,5,5,5,20,20,5,5,20,5};
        System.out.println(new No860LemonadeChange().lemonadeChange(bills));
    }

    public boolean lemonadeChange(int[] bills) {
        for (int bill : bills) {
            if (bill > 5){
                if (!calc(bill - 5)){
                    return false;
                }
            }
            int idx = bill/5 - 1;
            if (idx == 0 || idx == 1) {
                stat[index[idx]] = stat[index[idx]] + 1;
                total += bill;
            }
        }
        return true;
    }

    private boolean calc(int cash){
        if (total < cash){
            return false;
        }
        for (int i = stat.length - 1; i >= 0; i--) {
            int num = cash/worth[i];
            if (num > 0){
                int count = stat[i];
                if (count >= num){
                    stat[i] -= num;
                    cash = cash - worth[i] * num;
                }
            }

            if (cash == 0){
                return true;
            }
        }

        return cash == 0;
    }

}
