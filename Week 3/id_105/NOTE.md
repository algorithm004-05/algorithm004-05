# NOTE

  
#### 搜索最短路径
沉岛和扫雷没做。robot和jump没做。
单词接龙/最小基因变化/括号生成过遍数～～过遍数～～～

#### 柠檬水找零
该题自己先写了一遍，效率极差。看了别人的题解后发现，别人代码思路极简，直击问题本身核心。
把问题变简单，是解决问题的核心啊。

#### 关于二分查找
首先二分查找的对象必须是有序或者半有序的。 
对于半有序的数组如：[4, 5, 6, 7, 0, 1, 2]
1) 如果第一个元素的值 <= 中间元素的值：
   说明左边是有序的，否则右边是有序的。
2）如果左边是有序的：
   需要判断两种情况：中间值 >= 右边值，中间值 < 右边值
3) 对于右边是有序的：最小值肯定在这部分的最左边， 每次移动right的位置即可。
```java
public class LeetCode_153_105 {


    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= min) {
                min = nums[mid];
            }
            if (left == right) {
                break;
            }

            if (nums[0] <= nums[mid]) {//left ordered.
                if (nums[mid] >= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {//right ordered.
                right = mid;
            }
        }
        return min;
    }


    public static void main(String[] args) {
        LeetCode_153_105 l = new LeetCode_153_105();
        int min = l.findMin(new int[]{7, 8, 0, 1, 2, 3, 4, 5, 6});
        System.out.println(min);
        min = l.findMin(new int[]{3, 4, 5, 1, 2});
        System.out.println(min);

        min = l.findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
        System.out.println(min);
    }
}

```