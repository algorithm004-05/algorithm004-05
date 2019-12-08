class Solution {
    public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n)
    {
        int k = nums1.size();
        nums1.erase(std::begin(nums1) + m, std::begin(nums1) + k);
        for (int i = 0; i < nums2.size(); ++i) {
            nums1.push_back(nums2[i]);
        }
        std::sort(nums1.begin(), nums1.end());
    }
};