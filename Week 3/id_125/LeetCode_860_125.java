/**
 * @Auther: 封玉书 FYS
 * @Date: 2019.11.2 16:22
 * @Description:
 */
public class A860 {

    public static void main(String[] args) {
        A860 a860 = new A860();

        int[] bills = new int[]{5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5};

        System.out.println(a860.lemonadeChange(bills));
    }

    /**
     * 每次拿到钱：总是赚5块。
     * 如果手上只有20，是无法找回10块的支付的
     * 空间 O(1)
     * 时间 O(n)
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int remaind = 0;

        int[] moneyArr = new int[3];

        for (int bill : bills) {

            int returnMoney = bill - 5;

            if (returnMoney > remaind) {
                return false;
            }


            switch (bill) {
                case 5:
                    moneyArr[0]++;
                    break;
                case 10:
                    moneyArr[1]++;
                    break;
                case 20:
                    moneyArr[2]++;
            }

            int i10 = returnMoney / 10;
            if (i10 > 0 && moneyArr[1] >= i10) {
                moneyArr[1] -= i10;
                returnMoney = returnMoney - 10 * i10;
            }

            int i5 = returnMoney / 5;
            if (i5 > 0 && moneyArr[0] >= i5) {
                moneyArr[0] -= i5;
                returnMoney = returnMoney - 5 * i5;
            }

            if (returnMoney != 0) {
                return false;
            }

            remaind += 5;

        }

        return true;
    }

}
