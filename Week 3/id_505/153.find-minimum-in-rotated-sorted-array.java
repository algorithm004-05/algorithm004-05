/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (43.69%)
 * Likes:    1322
 * Dislikes: 187
 * Total Accepted:    337.6K
 * Total Submissions: 770.8K
 * Testcase Example:  '[3,4,5,1,2]'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,4,5,1,2] 
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 * 
 * 
 */

// @lc code=start


class Solution {
    public int findMin(int[] nums) {

        if (nums.length == 0) return 0;

        int AL = 0;
        int AR = nums.length - 1;

        if (nums[AL] < nums[AR]) return nums[AL];

        while (AL < AR) {

            if (AL == AR) return nums[AL];

            int mid = AL + (AR - AL) / 2;

            if (nums[mid] < nums[AR]) {
                //在左边
                AR = mid;
            } else {
                //在右边
                AL = mid + 1;
            }
        }

        return nums[AL];


    }
}
// @lc code=end

