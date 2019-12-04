// Author: liuwufang
// Date: 2019/10/20

#include <vector>
using namespace std;

// https://leetcode-cn.com/problems/move-zeroes/
// https://leetcode.com/problems/move-zeroes/

// Question:
// 283. 移动零
// 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
// tip:
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。

// Solution:
// 思路1:双指针
// 1.i指针用来遍历，j指针用来拷贝
// 2.将剩余的数组元素置0

// 时间复杂度：O(N)
// 空间复杂度：O(1)
void moveZeroes(vector<int>& nums) {
    int j = 0;
    int size = nums.size();

    for (int i = 0; i < size; i++) {
        if (0 != nums[i]) nums[j++] = nums[i];
    }

    for (; j < size; j++) {
        nums[j] = 0;
    }
}

// 思路 2:双指针 + 优化
// 1.i 指针用来遍历，j 指针用来拷贝
// 2.将剩余的数组元素置 0
// 3.优化前面未出现 0 的情况

// 时间复杂度：O(N)
// 空间复杂度：O(1)
void moveZeroes2(vector<int>& nums) {
    int j = 0;
    int size = nums.size();
    while (0 != nums[j]) {
        j++;
        if (j == size) return;
    }
    
    for (int i = j + 1; i < size; i++) {
        if (0 != nums[i]) nums[j++] = nums[i];
    }

    for (; j < size; j++) {
        nums[j] = 0;
    }
}

void leetcode_test_283(void) {
    vector<int> nums{0, 1, 0, 3, 12};

    moveZeroes(nums);   // 1,3,12,0,0
    moveZeroes2(nums);  // 1,3,12,0,0
}