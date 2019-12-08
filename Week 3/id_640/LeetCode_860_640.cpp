class Solution {
    public:
    bool lemonadeChange(vector<int>& bills)
    {
        int five = 0;
        int ten = 0;
        int twenty = 0;
        for (auto i : bills) {
            if (i == 5) {
                five++;
            }
            else if (i == 10) {
                ten++;
                five--;
            }
            else if (i == 20) {
                if (ten > 0) {
                    ten--;
                    five--;
                }
                else {
                    five = five - 3;
                }
            }
            if (five < 0)
                return false;
        }
        return true;
        //return five < 0 ? false : true;(错误)
    }
};
/*
Accepted
45/45 cases passed (16 ms)
Your runtime beats 89.42 % of cpp submissions
Your memory usage beats 66.87 % of cpp submissions (9.7 MB)
解题思路：贪心算法，5,10,20中10,20都是5的倍数，所以可以使用贪心算法。20先找10元再找5元，10元不够的情况下直接找5元。关键在于在每一次找钱结束后查看5的个数，如果个数小于0，说明这一次的找钱不可能完成，返回false。
*/