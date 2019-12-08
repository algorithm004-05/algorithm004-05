package com.company;

import java.util.HashMap;

public class LeetCode_860_540 {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> cash = new HashMap<>();
        cash.put(5, 0);
        cash.put(10, 0);
        cash.put(20, 0);

        for (int bill : bills) {
            if (bill == 5) {
                cash.put(5, cash.get(5) + 1);
                continue;
            }

            int changeToPay = bill - 5;
            HashMap<Integer, Integer> changeBills = new HashMap();

            for (int i = 20; i >=5; i = i / 2) {
                changeBills.put(i, checkCashAvailable(cash, changeToPay, i));
                changeToPay = changeToPay - changeBills.get(i) * i;
            }

            if (changeToPay > 0) {
                return false;
            }

            for (int i = 20; i >=5; i = i / 2) {
                cash.put(i, cash.get(i) - changeBills.get(i));
            }

            cash.put(bill, cash.get(bill) + 1);
        }

        return true;
    }

    private int checkCashAvailable(HashMap<Integer, Integer> cash, int bill, int billType) {
        int billNeeded = bill / billType;
        return billNeeded > cash.get(billType) ? cash.get(billType) : billNeeded;
    }
}
