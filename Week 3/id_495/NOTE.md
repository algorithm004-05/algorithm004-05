> 参考资料:
>
> 作者：powcai
>
> https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/er-fen-by-powcai-2/

---
### 作业: **寻找旋转排序数组中的最小值**
> **思路**:
>
> * 二分法, 二分法就是找与mid判断条件,这里我们选用right
>
> * 当nums[mid] > nums[right]说明在mid左半边的递增区域, 说明最小元素在> mid区域
>
> * 当nums[mid] <= nums[right说明在mid右半边的递增区域, 说明最小元素在<= mid区域
>
> **小技巧**:
>
> 一般是这样,
>
> * 当while left < right是循环外输出
>
> * 当while left <= right是循环里输出
>
> **代码**:
>  ```java
> class Solution {
>    public int findMin(int[] nums) {
>        int left = 0;
>        int right = nums.length - 1;
>        while (left < right) {
>            int mid = left + (right - left) / 2;
>            if (nums[mid] > nums[right]) left = mid + 1;
>            else right = mid;
>        }
>        return nums[left];
>    }
> }
> ```
---
### java.util.Arrays.sort() 源码学习笔记

> Arrays.sort有很多重载方法,其中:
>
> 针对 `public static void sort(int[] a, int fromIndex, int toIndex)`
>
> 这样带有`fromIndex`和`toIndex`的范围排序方法，都会有参数检查,依靠下面 这个方法:
>
> ```java
> private static void rangeCheck(int arrayLength, int fromIndex, int toIndex) {
>        if (fromIndex > toIndex) {
>            throw new IllegalArgumentException(
>                    "fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
>        }
>        if (fromIndex < 0) {
>            throw new ArrayIndexOutOfBoundsException(fromIndex);
>        }
>        if (toIndex > arrayLength) {
>            throw new ArrayIndexOutOfBoundsException(toIndex);
>        }
>    }
> ```
