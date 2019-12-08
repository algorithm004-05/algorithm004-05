package com.neutorn.algorithm;

/**
 * 删除排序数组中的重复项
 *
 * @author zhanght
 */
public class LeetCode_189_315 {
    // 第一步:花上1分钟时间仔细审题,分析要实现的关键内容
    // 题目内容:给定一个数组,将数组中的元素向右移动k个位置,其中k是非负数.提示至少有三种不同的解决方案.
    // 要点分析:这题目不给说明案例是根本想不到怎么处理的,说明案例是题目中的一部分.在原数组上进行处理.
    // 第二步,可能的解法:
    // 1.是否存在暴力破解法 2.数组存在的特殊解法(左右遍历中间靠拢,哈希表处理,双指针处理)
    // 1.暴力破解法,每挪动1次,进行循环复制处理,时间复杂度是O(k*n),空间复杂度是O(1)
    // 第三步:如果已经有思路,那么就开始进行编写代码 (第一步的各个解法时间复杂度分析不出来),如果没有思路,直接看其他人的处理方式
    // 编写代码需要考虑参数的边界条件内容

    public static int[] rotateM1(int[] nums, int k) {
        // 思考0个和1个的特殊处理
        if (nums.length == 0 || nums.length == 1) {
            return nums;
        }

        int lastIndexVal;
        for (int i = 0; i < k; i++) {
            lastIndexVal = nums[nums.length - 1];
            for (int j = nums.length - 1; j >= 1; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = lastIndexVal;
        }
        return nums;
    }

    // 第四步,编写特殊的正常的测试案例,进行算法测试
    // [],1
    // [1],10
    // [1,1,1,2,3,3,4,5,5,5], 4
    // 击败了33%的提交代码,执行效率有待提高的.有特殊的有效率的处理方式.

    // 方式二,使用Hash处理,将偏移的数据进行保存,根据K(index)和V(数组数据的形式处理)
    // 這種方式存在的問題就是k不能大於數組的長度,超過數組長度得到的結論就是錯誤的,已經驗證.
    // 同時這種數據不斷截取的方式對索引的處理需要非常細心,很容易出現索引越界

    // 學習使用Leet Code官方推薦的使用反轉方法,時間復雜度是o(n),空間復雜度是O(1)

    /**
     * 整體處理思路:<br/>
     * 先整體設計,然後進行分步驟處理.
     * 1.求解需要處理的偏移數據的個數
     * 2.將數組進行整體反轉
     * 3.處理便宜數據的反轉
     * 4.處理剩餘不需要偏轉數據的內容
     * @param nums 數組
     * @param k 偏移量
     * @return int[]
     */
    public static int[] rotateM2(int[] nums, int k) {
        // 1.先進性邊界條件的處理
        if (nums.length == 0 || nums.length == 1) {
            return nums;
        }
        // 1.求解需要處理的偏移數據的個數
        k = k % nums.length;
        // 2.將數組進行整體反轉
        reverse (nums, 0, nums.length - 1);
        // 3.處理便宜數據的反轉
        reverse (nums, 0, k - 1);
        // 4.處理剩餘不需要偏轉數據的內容
        reverse (nums, k, nums.length - 1);
        return nums;
    }

    /**
     * 將數組進行反轉
     * @param array 數組
     * @param start 開始索引
     * @param end 結束索引
     */
    private static void reverse (int[] array, int start, int end) {
        int temp;
        while (start < end) {
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            end--;
            start++;
        }
    }
}
