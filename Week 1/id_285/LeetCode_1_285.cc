class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        std::map<int,int> m;
        std::map<int,int>::iterator iter;
        std::vector<int> rc;
        
        for (int i=0; i<nums.size(); i++) {
            int complement = target - nums[i];
            if (m.find(complement) != m.end()) {
                rc.push_back(m.find(complement)->second);
                rc.push_back(i);
                return rc;
            }
            m[nums[i]] = i;
        }
        return rc;
    }
};
