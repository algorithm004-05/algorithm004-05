/*
 * @lc app=leetcode.cn id=860 lang=cpp
 *
 * [860] 柠檬水找零
 */
#include<vector>
using namespace std;
// @lc code=start
class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        vector<int> amount;
        int n=0,m=0;
        if(bills[0]!=5||bills[1]==20){
            return false;
        }
        // amount.push_back(bills[0]);
        for( int i=0; i<bills.size();i++){
            if(bills[i]==5){
                n++;
            }else if(bills[i]==10){
                if(n){
                n--;
                m++;
                }else return false;
            }else
            {
                if(m){
                    if(n){
                    n--;
                    m--;
                    continue;
                    }
                }
                if(n>=3)n-=3;
                else return false;

            }
            

        }
        return true;
    }
};
// @lc code=end

