/*
    * 1，20元找零分为两种：（1）10元和5元（2）3*5元
    * 2，所以分情况讨论，记录下5元和10元的个数
    * 3，如果10元有0张，那么肯定找零3张5元
    * 否则找零10元和5元，即10元-1，5元-1
    * 4，如果是10元，5元-1即可
    * 5，最后判断5元的数量，能够找零，必定大于等于0，小于0返回false
    * 然后编码即可
    * */
    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (five < 0) return false;
            if (bills[i] == 5) {
                five++;
            }
            if (bills[i] == 10) {
                five--; ten++;
            }
            if (bills[i] == 20) {
                if (ten == 0) five = five - 3;
                else {
                    five--; ten--;
                }
            }
        }
        if (five < 0)  return false;
        else return true;
    }
