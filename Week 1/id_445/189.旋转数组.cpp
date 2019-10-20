/*
 * @lc app=leetcode.cn id=189 lang=cpp
 *
 * [189] 旋转数组
 */
#include <vector>
using namespace std;
// @lc code=start
class Solution {
public:
///solution1
    // void rotate(vector<int>& nums, int k) {
    //     for (int i = 0; i < k; i++)
    //     {
    //         nums.insert(nums.begin(),nums.back());
    //         nums.pop_back();
    //     }
        
    // }
//solution 2
    //     void rotate(vector<int>& nums, int k) {
    //         k=k%nums.size();
    //     for (int i = 0; i < k; i++)
    //     {
    //         nums.insert(nums.begin(),nums.back());
    //         nums.pop_back();

    //     }
        
    // }


    //solution 3
    // void rotate(vector<int>& nums, int k);
    // void rotate(vector<int>& nums,int start,int end);
        void rotate(vector<int>& nums, int k) {
            int size=nums.size();
            k=k%size;
            if(size==1 || k==0)return;
            
        rotate(nums,0,size-1);
        rotate(nums,0,k-1);
        rotate(nums,k,size-1);
        
    }
        void rotate(vector<int>& nums,int start,int end){
        int temp=0;
        for (int i = start; i <= (start+end)/2; i++)
        {
            temp=nums[i];
            nums[i]=nums[end-i+start];
            nums[end-i+start]=temp;
        }
        
    }
};

// @lc code=end

