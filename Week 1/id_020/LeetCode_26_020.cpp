// Author: liuwufang
// Date: 2019/10/20

#include <vector>
using namespace std;

// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

// Question:
// 26. 删除排序数组中的重复项
// 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

// Solution:
// 思路1:快慢指针，快指针遍历，慢指针存储非重复值
// 时间复杂度：O(N)
// 空间复杂度：O(1)
int removeDuplicates(vector<int>& nums) {
    if (nums.size() <= 1) return nums.size();
    
    int j = 0;
    for (int i = 1; i < nums.size(); ++i) {
        if (nums[j] != nums[i]) nums[++j] = nums[i];
    }
    
    return j + 1;
}

// 思路2:快慢指针 + 优化
// 时间复杂度：O(N)
// 空间复杂度：O(1)
int removeDuplicates2(vector<int>& nums) {
    if (nums.empty()) return 0;
    
    int j = 0;
    for (int i = 1; i < nums.size(); ++i) {
        if (nums[j] != nums[i]) {
            j++;
            if (j != i) nums[j] = nums[i]; // 相邻，无需拷贝
        }
    }
    
    return j + 1;
}

void leetcode_test_26(void) {
    vector<int> nums{1, 1, 2, 3};

    removeDuplicates(nums);     //1,2,3
    removeDuplicates2(nums);    //1,2,3
}