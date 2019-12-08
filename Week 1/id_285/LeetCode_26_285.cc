// Solution 1. for ... copy
// Solution 2. 两个索引辅助
// Solution 3. 

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size()==0) {
            return 0;
        }
        int j = 0;
        for (int i=1; i<nums.size();i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }
};
