/*
 * @lc app=leetcode.cn id=338 lang=cpp
 *
 * [338] 比特位计数
 */
// @lc code=start
class Solution
{
public:
    vector<int> countBits(int num)
    {
        vector<int> a;
        for(int i=0;i<=num;i++){
            if(i==0){
                a.push_back(0);
            }else{  
                int current = a.at(i/2) + i%2;
                a.push_back(current);
            }
        }
        return a;
    }
};
// @lc code=end

