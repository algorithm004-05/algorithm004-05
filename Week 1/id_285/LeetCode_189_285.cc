// Solutoin 1. 构建循环链表，移动头指针
// Solution 2. for + swap, 循环索引, 每个元素都要交换一遍
class Solution {
    public:
    void reverse(vector<int>& nums, int start, int end) {
        int t;
        while (start < end) {
            t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start ++;
            end--;
        }
    }

    void rotate(vector<int>& nums, int k) {
        k %= nums.size();
        reverse(nums, 0, nums.size()-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.size() - 1);
    }
};
