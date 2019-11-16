class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int> > ans;
        sort(nums.begin(), nums.end());
        helper(nums, 0, ans);
        return ans;
    }
    
    void helper(vector<int>& nums, int start, vector<vector<int> >& ans) {
        if (start == nums.size()) {
            vector<int> nums_copy(nums);
            ans.push_back(nums_copy);
            return;
        }
        
        for (int i=start; i<nums.size(); ++i) {
            int length = findLength(nums, i);
            i += (length-1);
            swap(nums[start], nums[i]);
            helper(nums, start+1, ans);
            swap(nums[start], nums[i]);
        }
    }
    
    int findLength(vector<int>& nums, int start) {
        int res = 0;
        for (int i=start; i < nums.size() && nums[i] == nums[start]; ++i) {
            ++res;
        }
        return res;
    }
};