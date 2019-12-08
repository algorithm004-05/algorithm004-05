/*
 * @lc app=leetcode.cn id=88 lang=cpp
 *
 * [88] 合并两个有序数组
 */

// @lc code=start

class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        if ( nums2.empty())
            return;
        int i = 0;
        int j = 0;
        while (i < m){
            if (nums1[i] > nums2[0])
            {
                for ( j =  n - 1; j >= 0 ; --j){
                    if (nums1[i] > nums2[j])
                    {
                        swap(nums1[i], nums2[j]);
                        break;
                    }
                }
            }
            if ( nums2[0] >= nums1[i] )
            i++;
        }
                 int k = 0; 
        for (int i = m ; i < m+n;  i++){
            nums1[i] = nums2[k];
            k++;
        }
    }
};

// @lc code=end

