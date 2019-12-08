//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组



//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Queue;
import java.util.Stack;

/**
 * 题目要求三种方法
 */
class Solution {

    //先取模，暴力求解  时间复杂度：O(kn) 空间：O(1)
    public void rotate1(int[] nums, int k) {
        if(k==0||nums==null||nums.length==1)    return;
        int a=k%nums.length;
        if(a==0)    return;
        for (int i = 0; i < a; i++) {
            int temp=nums[nums.length-1];
            for (int j = nums.length-1; j>=1; j--) {
                nums[j]=nums[j-1];
            }
            nums[0]=temp;
        }
    }

    //反转法 时间：O(n)  空间：O(1)
    public void rotate3(int[] nums, int k) {
        if(k==0||nums==null||nums.length==1)    return;
        k=k%nums.length;
        if(k==0)    return;
        reserve(nums,0,nums.length-1);
        reserve(nums,0,k-1);
        reserve(nums,k,nums.length-1);
    }
    private void reserve(int[] arr,int s,int e){
        while(s<e){
            int temp=arr[s];
            arr[s++]=arr[e];
            arr[e--]=temp;
        }
    }

    //取模，将尾部添加到头部   时间：O(n) 空间:O(n)
    public void rotate3(int[] nums, int k) {
        if(k==0||nums==null||nums.length==1)    return;
        int a=k%nums.length;
        if(a==0)    return;
        int[] arr=new int[nums.length];
        int s=nums.length-a;
        //添加尾部
        int j=0;
        for (int i = s; i < arr.length; i++) {
            arr[j++]=nums[i];
        }
        //添加头部
        for (int i = 0; i < s; i++) {
            arr[j++]=nums[i];
        }

        //重新赋值
        for (int i = 0; i < arr.length; i++) {
            nums[i]=arr[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
