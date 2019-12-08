# NOTE
## lesson 9 深度优先 、广度优先搜索
搜索遍历：
1、每个节点都要访问一次；
2、每个节点仅访问一次；
3、节点访问顺序不限；
本质是将所有节点都访问一遍，按照访问顺序分为 DFS 、BFS 和 优先级优先
## lesson 10 贪心算法
是当下做局部最优判断，但现实生活中并不是最优解法；
动态规划，是最优判断 + 回退；

## lesson 11 二分查找
三个特点：
1、目标函数单调性（单调递增或递减）
2、存在上下界(存在 low , high , mid 位)
3、能够通过索引访问;
### homework:
`使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方`

解析：无序的地方即为翻转的地方；

```
public int search(int[] nums) {
       int left = 0,right = nums.length - 1;
       while ( left < right ) {
           //取中位数
           int mid  = (left + right ) >>> 1;
           //nums[i]，满足nums[i] < nums[i-1] and nums[i] < nums[i+1]
           //当nums[mid] > nums[right]时，一定满足mid < i <= right，因此left = mid + 1；
           //当nums[mid] < nums[right]时，一定满足left< i <= mid，因此right = mid；
           //当nums[mid] == nums[right]时，说明数组长度len(num) == 1（因为计算mid向下取整）；
           //当left = right也满足，但本题left == right时跳出循环。
           if(nums[mid] > nums[right]) {
               left = mid + 1;
           }else{
               right = mid;
           }
       }
       return nums[left];
    }
```

