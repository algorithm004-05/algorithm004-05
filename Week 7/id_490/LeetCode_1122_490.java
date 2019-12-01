/**
 * 题目名称：relative-sort-array 数组的相对排序
 * 题目链接：https://leetcode-cn.com/problems/relative-sort-array/
 */
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] m = new int[1001];
        int[] ref = new int[arr1.length];
        for (int i = 0; i < arr1.length; ++i) {
            m[arr1[i]]++;
        }
        int index = 0;
        for (int i = 0; i < arr2.length; ++i) {
            while (m[arr2[i]] > 0) {
                ref[index++] = arr2[i];
                m[arr2[i]]--;
            }
        }

        for (int i = 0; i < m.length; ++i) {
            while(m[i] > 0) {
                ref[index++] = i;
                m[i]--;
            }
        }

        return ref;
    }
}