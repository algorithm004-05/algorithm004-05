/*
 * @lc app=leetcode.cn id=547 lang=cpp
 *
 * [547] 朋友圈
 */

// @lc code=start
class Solution
{
public:
    int findCircleNum(vector<vector<int>> &M)
    {
        if (M.empty())
            return 0;
        int s = M.size();
        int group = s;
        vector<int> parent(s, -1);
        for (int i = 0; i < s; i++)
            parent[i] = i;
        for (int i = 0; i < s; i++)
        {
            for (int j = i + 1; j < s; j++)
            {
                int xp = find(i, parent);
                int yp = find(j, parent);
                if (M[i][j])
                {
                    if (xp != yp)
                    {
                        parent[xp] = yp;
                        group--;
                    }
                }
            }
        }
        return group;
    }

    int find(int x, vector<int> &parent)
    {
         while (x != parent[x]){

//这个比单纯x= parent[x] 快
             parent[x] = parent[parent[x]];
             x = parent[x];
         }
         return x;
    }
};
// @lc code=end

