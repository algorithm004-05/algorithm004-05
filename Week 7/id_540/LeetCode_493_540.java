package com.company;

public class LeetCode_493_540 {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] a, int start, int end) {
        if (end <= start) {
            return 0;
        }

        int mid = (start + end) >> 1;

        int leftCount = mergeSort(a, start, mid);
        int rightCount = mergeSort(a, mid + 1, end);

        int i = start, j = mid + 1, mergeCount = 0;
        while (i <= mid && j <= end) {
            if ((long)(a[i]) > (long)(a[j])*2) {
                mergeCount += mid + 1 - i;
                j++;
            } else {
                i++;
            }
        }

        mergeResult(a, start, mid, end);

        return leftCount + rightCount + mergeCount;
    }

    private void mergeResult(int[] a, int start, int mid, int end) {
        int resultSize = end - start + 1;
        int[] mergeResult = new int[resultSize];
        int i = start, x = start;
        int j = mid + 1, y = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            mergeResult[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        }

        while (i <= mid && j <= end) {
            mergeResult[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        }

        while (i <= mid) {
            mergeResult[k++] = a[i++];
        }

        while (j <= end) {
            mergeResult[k++] = a[j++];
        }

        System.arraycopy(mergeResult, 0, a, start, resultSize);
    }
}
