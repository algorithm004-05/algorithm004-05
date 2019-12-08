/*
 * @lc app=leetcode.cn id=1 lang=cpp
 *
 * [1] 两数之和
 */

// @lc code=start
// class Solution
// {
// public:
//     vector<int> twoSum(vector<int> &nums, int target)
//     {
//         int i = 0;
//         int j = 0;
//         for (int i = 0; i < nums.size(); i++)
//         {
//             for (int j = i + 1; j < nums.size(); j++)
//             {
//                 if (nums[j] == target - nums[i])
//                 {
//                     return {i, j};
//                 }
//             }
//         }
//         return {i, j};
//     }
// };

class Solution
{
public:
    vector<int> twoSum(vector<int> &numbers, int target)
    {
        unordered_map<int, int> hash;
        vector<int> result;
        for (int i = 0; i < numbers.size(); i++) {
            int numberToFind = target - numbers[i];

            if (hash.find(numberToFind) != hash.end()) {
                result.push_back(hash[numberToFind]);
                result.push_back(i);			
                return result;
            }

            hash[numbers[i]] = i;
        }
        return result;
    }
};

// typedef struct node{
//     int id;
//     int val;
//     bool operator < (const node& n) const {
//         return val < n.val;
//     }
// }node;

// class Solution {
// public:
//     vector<int> twoSum(vector<int>& nums, int target) {
//     node nodes[nums.size()];
//     int length = nums.size();
//     vector<int> temp; 
//     for (int i = 0; i < length; ++i) {
//         nodes[i].id = i;
//         nodes[i].val = nums[i];
//     }
//     sort(nodes, nodes + nums.size());
//     int lo = 0;
//     int hi = nums.size() - 1;
//     while (lo < hi) {
//         if (nodes[lo].val + nodes[hi].val == target)
//             break;
//         if (nodes[lo].val + nodes[hi].val < target)
//             ++lo;
//         if (nodes[lo].val + nodes[hi].val > target)
//             --hi;
//     } 
//     temp.push_back(min(nodes[lo].id, nodes[hi].id));
//     temp.push_back(max(nodes[lo].id, nodes[hi].id));
//     return temp;
//     }
// };
// @lc code=end
