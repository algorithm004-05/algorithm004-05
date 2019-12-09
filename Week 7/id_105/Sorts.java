package id_105;

import java.util.Arrays;

/**
 * 排序算法动画
 * https://www.cnblogs.com/onepixel/p/7674659.html
 */
public class Sorts {

    /**
     * 选择排序
     * 在序列中找到最大（小）元素放在最前面， 然后再剩余未排序序列中继续找最大（小）元素放在最前面。
     */
    public static int[] selectionSort(int[] arr) {

        if (arr.length == 0) return arr;
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

    /**
     * 冒泡排序，两两交换。一轮结束后最后一个为最大。
     * @param arr
     * @return
     */
    public static int[] bubleSort(int[] arr) {
        for (int length = arr.length - 1; length >= 0; length--) {
            for (int i = 1; i <= arr.length - 1; i++) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
        }
        return arr;
    }


    /**
     * 插入排序， 当前元素和之前的部分比较。一轮结束后， 最小的在最前面
     * @param arr
     * @return
     */
    public static int[] insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }


    /**
     * 计数排序
     * @param arr
     * @return
     */
    public static int[] countSort(int[] arr) {

        int maxValueIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[maxValueIndex]) {
                maxValueIndex = i;
            }
        }

        int[] tempArr = new int[arr[maxValueIndex] + 1];
        for (int i = 0; i < arr.length; i++) {
            tempArr[arr[i]]++;
        }


        int sortIndex = 0;
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] > 0) {
                arr[sortIndex++] = i;
            }
        }
        return arr;

    }


    public static void main(String[] args) {
        int[] arr = new int[]{9, 5, 6, 7, 8, 4, 1, 3, 2};
        System.out.println(Arrays.toString(selectionSort(arr)));
        System.out.println(Arrays.toString(bubleSort(arr)));
        System.out.println(Arrays.toString(insertSort(arr)));
        System.out.println(Arrays.toString(countSort(arr)));
    }


}
