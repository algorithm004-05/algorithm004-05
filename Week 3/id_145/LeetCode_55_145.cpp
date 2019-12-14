
通过了74/75的case，最后一个应该是stack overflow，因为数组太长了，都贴不上。
class Solution {
public:
    bool canJump(vector<int>& nums) {
        if (nums.size() <= 1) {
            return true;
        }
        vector<int> visited_res(nums.size(), -1);
        return helper(nums, 0, visited_res);
    }
    
    bool helper(vector<int>& nums, int index, vector<int>& visited_res) {
        if (index >= nums.size()-1) {
            return true;
        }
        
        if (visited_res[index] != -1) {
            return visited_res[index] == 1;
        }
        
        bool ans = false;
        for (int i=1; i<=nums[index]; ++i) {
            ans = helper(nums, index+i, visited_res);
            if (ans) {
                visited_res[index] = 1;
                break;
            } else {
                visited_res[index] = 0;
            }
        }
        
        return ans;
    }
};