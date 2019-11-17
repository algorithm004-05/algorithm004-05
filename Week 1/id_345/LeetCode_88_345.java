package xyz.isok.algorithm.leetcode.easy;

import java.util.Arrays;

public class No88MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        Solution.merge(nums1, m, nums2, n);
        Arrays.stream(nums1).mapToObj(i -> i + " ").forEach(System.out::print);
    }

    static class Solution {
        public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m-1, j = n-1, k = m + n - 1;
            while (i >= 0 || j >= 0){
                while (i >= 0 && (j < 0 || nums1[i] >= nums2[j])){
                    nums1[k] = nums1[i];
                    k--;
                    i--;
                }
                while (j >= 0 && (i < 0 || nums1[i] < nums2[j])){
                    nums1[k] = nums2[j];
                    k--;
                    j--;
                }
            }
        }
    }
}
