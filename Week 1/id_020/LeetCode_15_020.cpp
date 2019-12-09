// Author: liuwufang
// Date: 2019/10/20

#include <vector>
#include <algorithm>
using namespace std;

// https://leetcode-cn.com/problems/3sum
// https://leetcode.com/problems/3sum

// Question:
// 283. 移动零
// 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

// tip:
// 答案中不可以包含重复的三元组

// Solution:
// 思路1:双指针夹逼法
// 1.先进行排序（快排O(N*logN)）；
// 2.第一层循环 遍历按住k，保证所有元素被遍历；
// 3.利用左右双指针，夹逼出符合条件的target值（target = 0 - nums[k]）；
// 4.左右指针和大于 target，右指针左移；左右指针和小于 target，左指针右移；
// 5.可以去掉重复元素，加快匹配效率

// 时间复杂度：O(N^2)
// 空间复杂度：O(1)

vector<vector<int> > threeSum(vector<int>& nums) {
    vector<vector<int> > vecRet;
    sort(nums.begin(), nums.end());
    for (int k = 0; k < nums.size(); k++) {
        int i = k + 1;
        int j = nums.size() - 1;
        int target = 0 - nums[k];
        
        while (i < j) {
            int sum_value = nums[i] + nums[j];
            if (sum_value > target) {
                j--;
            } else if (sum_value < target) {
                i++;
            } else {
                vector<int> temp(3, 0);
                temp[0] = nums[k];
                temp[1] = nums[i];
                temp[2] = nums[j];
                vecRet.push_back(temp);

                while(i < j && nums[i + 1] == nums[i]) ++i;
                while(i < j && nums[j - 1] == nums[j]) --j;
                i++;
                j--;
            }
        } 
        
        while(k < nums.size() - 1 && nums[k] == nums[k + 1]) ++k;
    }
    return vecRet;  
}

void leetcode_test_15(void) {
    vector<int> nums{-1, 0, 1, 2, -1, -4};
    threeSum(nums);   // {{-1,-1,2},{-1,0,1}}
}