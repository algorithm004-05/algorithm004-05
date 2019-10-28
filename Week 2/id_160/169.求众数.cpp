/*
 * @lc app=leetcode.cn id=169 lang=cpp
 *
 * [169] 求众数
 */

// @lc code=start
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        return majority(nums, 0, nums.size() - 1);
    }
private:
    int majority(vector<int>& nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int m = l + (r - l) / 2, lm = majority(nums, l, m), rm = majority(nums, m + 1, r);
        if (lm == rm) {
            return lm;
        }
        return count(nums.begin() + l, nums.begin() + r + 1, lm) > count(nums.begin() + l, nums.begin() + r + 1, rm) ? lm : rm;
    }
}; 

// class Solution {
// public:
//     int majorityElement(vector<int>& nums) {
//         int counter = 0, majority;
//         for (int num : nums) {
//             if (!counter) {
//                 majority = num;
//             }
//             counter += num == majority ? 1 : -1;
//         }
//         return majority;
//     }
// };

// class Solution {
// public:
//     int majorityElement(vector<int>& nums) {
//         unordered_map<int, int> counter;
//         for (int num : nums) {
//             if (++counter[num] > nums.size() / 2) {
//                 return num;
//             }
//         }
//         return 0;
//     }
// };

// class Solution {
// public:
//     int majorityElement(vector<int>& nums) {
//         int majority = 0;
//         for (unsigned int i = 0, mask = 1; i < 32; i++, mask <<= 1) {
//             int bits = 0;
//             for (int num : nums) {
//                 if (num & mask) {
//                     bits++;
//                 }
//             }
//             if (bits > nums.size() / 2) {
//                 majority |= mask;
//             }
//         }
//         return majority;
//     }
// };


// @lc code=end

