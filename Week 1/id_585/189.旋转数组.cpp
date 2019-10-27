/*
 * @lc app=leetcode.cn id=189 lang=cpp
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public:
    void rotate(vector<int>& nums, int k) {
        k = k % nums.size();
        int size = nums.size();
        int temp = nums[0];
        int temp1 = 0;
        int count = 0;
        int next =  0;
        for (int start = 0; count <size ; start++){
            if (size<=1 ||  k==0 )
                break;
            int current = start ;
            temp = nums[start] ;
            do{
                next = (current+k)%size;
                temp1 = nums[next];
                nums[next]=temp;
                temp = temp1;
                current = next;
                count++;
            }while(start != current);
            }
    }
};

// @lc code=end

