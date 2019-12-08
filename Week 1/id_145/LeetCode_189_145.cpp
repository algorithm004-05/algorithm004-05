class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        if (nums.size() <= 1 || k==0) {
            return;
        }
        
        k = k%nums.size();
        int i=0, j=nums.size()-1;
        while (i<j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            ++i;
            --j;
        }
        
        i=0;
        j=k-1;
        while(i<j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            ++i;
            --j;
        }
        
        i=k;
        j=nums.size()-1;
        while(i<j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            ++i;
            --j;
        }
        
        
    }
};