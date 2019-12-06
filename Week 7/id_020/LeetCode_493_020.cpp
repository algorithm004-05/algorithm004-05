// Author: liuwufang
// Date: 2019/11/24

#include <vector>
#include <algorithm>
using namespace std;

// https://leetcode-cn.com/problems/number-of-1-bits/
// https://leetcode.com/problems/number-of-1-bits/

// Question:
// 493. 翻转对
// 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
// 你需要返回给定数组中的重要翻转对的数量。

// 示例 1:
// 输入: [1,3,2,3,1]
// 输出: 2

// Solution:
int count = 0;
void merge(vector<int>& nums, int l, int mid, int r) {
    int i = l;
    int j = mid + 1;

    while(i <= mid && j <= r){
        if((long)nums[i] > (long) 2 * nums[j]){
            count += (mid - i + 1);
            j++;
        }else{
            i++;
        }
    }

    sort(nums.begin() + l, nums.begin() + r + 1);
}

void mergeSort(vector<int>&nums, int l, int r) {
    if (l >= r) return;
    int mid = (l + r) >> 1;
    mergeSort(nums, l, mid);
    mergeSort(nums, mid + 1, r);
    merge(nums, l, mid, r);
    // checkCount(nums, l, mid, r);
}

int reversePairs(vector<int>& nums) {
    if(!nums.size()) return 0;
    mergeSort(nums, 0, nums.size() - 1);
    return count;
}

void leetcode_test_493(void) {
    vector<int> nums = {1,3,2,3,1};
    reversePairs(nums);
}
