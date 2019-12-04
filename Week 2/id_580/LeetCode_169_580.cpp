class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int target = nums[0];
        int count = 1;
        for(int i = 1; i < nums.size(); i++)
            if(nums[i] != target) {
                count--;
                if(count == 0) {
                    target = nums[i];
                    count = 1;
                }
            }else count++;
      return target;
    }
};
