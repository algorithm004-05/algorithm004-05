/**
 * https://leetcode-cn.com/problems/relative-sort-array/
 */
public class LeetCode_1122_100 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int min = arr1[0];
        int max = arr1[0];
        for (int i = 0; i < arr1.length; i++) {
            min = Math.min(min, arr1[i]);
            max = Math.max(max, arr1[i]);
        }
        int[] temp = new int[max - min + 1];
        //填充计数
        for (int i = 0; i < arr1.length; i++) {
            temp[arr1[i] - min]++;
        }
        //冲arr2中获取填充至arr1中
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (temp[arr2[i] - min]-- > 0) {
                arr1[index++] = arr2[i];
            }
        }
        for (int i = 0; i < temp.length; i++) {
            while (temp[i]-- > 0) {
                arr1[index++] = i + min;
            }
        }
        return arr1;
    }
}