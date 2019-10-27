class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int j = 0;
        int t;
        for( int i = 0; i < nums.size(); i++){

            if(nums[i] != 0){
                //swap(nums[j], nums[i]);
                t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                j++;
            }
        }
    }
};
