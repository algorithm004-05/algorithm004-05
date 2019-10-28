/*
 * @lc app=leetcode.cn id=169 lang=cpp
 *
 * [169] 求众数
 */

// @lc code=start
//思路1：map，将所有数存在一个map中，如果出现，次数加一，判断是否大于n/2
//the time complexity is O(n)
//sort and check every number one by one, O(n^2logn)
//devide and conquer
//boyer-moore
//2. devide and conquer?
class Solution {
//private:
//    int countNumber(const vector<int> &nums, int target, int low , int high){
//        int count = 0;
//        //注意这里的 <= 
//        for(int i = low; i <= high; i++){
//            if(nums[i] == target) count++;
//        }
//            return count;
//    }
private:
    int recursion(const vector<int> &nums, int low, int high ){
        if(low == high) return nums[low];

        int mid = (high+low)/2 ;
        int left = recursion(nums, low, mid);
        int right = recursion(nums, mid + 1, high);
        
        if (left == right ) return left;
       //return countNumber(nums, left ,low, mid) >  countNumber(nums, right , mid + 1, high) ? left : right;
     //  return countNumber(nums, left ,low, high) >  countNumber(nums, right , low, high) ? left : right;
      //可以用count函数代替 但是效率没有自己写的高？
       return count(nums.begin() + low ,nums.begin() + high + 1, left) > count(nums.begin() + low + 1, nums.begin() + high + 1, right) ? left : right;
      
    }

public:
    int majorityElement(vector<int>& nums) {

        return recursion(nums, 0, nums.size() - 1);
        
    }
};
// @lc code=end

