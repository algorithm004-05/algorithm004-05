package homework.week7;

import java.util.Arrays;

//https://leetcode-cn.com/problems/reverse-pairs/
public class LeetCode_493_590 {
    public int reversePairs(int[] nums) {
        return _merge(nums,0,nums.length-1);
    }

    private int _merge(int[] arrays, int begin, int end) {
        if (begin >= end) return 0;
        int mid = begin+(end-begin)/2;
        int result = _merge(arrays, begin, mid) + _merge(arrays, mid + 1, end);
        for (int i = begin, j = mid + 1; i <= mid; i++) {
            while (j <= end && arrays[i]/2.0 > arrays[j]) j++;
            result += j - (mid + 1);
        }

        Arrays.sort(arrays, begin, end + 1);
        return result;
    }
}
