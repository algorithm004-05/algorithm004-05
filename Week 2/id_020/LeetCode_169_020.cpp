// Author: liuwufang
// Date: 2019/10/20

#include <algorithm>
#include <vector>
#include <map>
using namespace std;

// https://leetcode-cn.com/problems/majority-element/
// https://leetcode.com/problems/majority-element/

// Question:
// 169. 求众数
// 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
// 你可以假设数组是非空的，并且给定的数组总是存在众数。

// Solution:
// 思路1:hash表记录法
// 1.create a hash table
// 2.for 0->nums.size() 
// 2.1 count the num

// 时间复杂度：O(N)
// 空间复杂度：O(N)

int majorityElement(vector<int>& nums) {
    // Hash table count
    // 1.create a hash table
    map<int, int> hashTable;
    for (int i = 0; i < nums.size(); ++i) 
        hashTable[nums[i]] = 0;
    // 2.for 0->nums.size() 
    // 2.1 count the num
    for (int i = 0; i < nums.size(); ++i) {
        hashTable[nums[i]]++;
        if (hashTable[nums[i]] > (nums.size() / 2)) return nums[i];
    }

    return -1;
}


// 思路2:摩尔投票法
// 寻找数组中超过一半的数字，这意味着数组中其他数字出现次数的总和都是比不上这个数字出现的次数
// 1.遍历数组，遇到候选数+1，反之-1.count为0则重新选择后候选数

// 时间复杂度：O(N)
// 空间复杂度：O(1)

int majorityElement2(vector<int>& nums) {
    int count = 1;
    int cur = nums[0];
    for (int i = 1; i < nums.size(); ++i) {
        if (count == 0) {
            cur = nums[i];
            count++;
            continue;
        }
        if (nums[i] == cur) count ++;
        else count--;
    }

    return cur;
}

void leetcode_test_15(void) {
    vector<int> nums{[3,2,3,1,1,1]};
    majorityElement(nums);   // 1
    majorityElement2(nums);   // 1
}