> # 第一周的学习笔记


### 学习心得
经过这一周的算法学习，感觉自己对代码的性能有了更深的理解。   
知道了如何去分析代码的时间复杂度，时间复杂度的分析对于编写高效的程序是很有必要的！  
就目前的自身学习情况来看，还有很多不足之处，有待提高。  
在做题的时候，大多数题目都是没有思路的，有的题虽然有了思路，但在分析的时候总是会卡在那。  
不知道是自己还不熟练呢，还是自己太笨了，做过的题，隔了一天再去做，有时候就是想不起来，  
可能是还没有理解消化题目本身吧，有时候又会把几种解法思路搞混淆了。ε=(´ο｀*)))唉！  
本来这两个月可以拿来学习其他多门课程，但为了能让自己写出高效的代码，特意把大部分时间都花
在算法学习上，真担心这两个月练了很多题，到头来又全部忘了。  



### 课后算法题思路  
> [1、LeetCode_26 删除排序数组中的重复项](#LeetCode_26)    
> [2、LeetCode_189 旋转数组](#LeetCode_189)   
> [3、LeetCode_21 合并两个有序链表](#LeetCode_21)    
> [4、LeetCode_1 两数之和](#LeetCode_1)    
> [5、LeetCode_283 移动零](#LeetCode_283)   
> [6、LeetCode_66 加一](#LeetCode_66)    
> [7、LeetCode_88 合并两个有序数组](#LeetCode_88)  
> [8、LeetCode_42 接雨水](#LeetCode_42)  



##### LeetCode_26 删除排序数组中的重复项 <a id='LeetCode_26'></a>    
看见题的时候就想到了用双指针的方法解题，但在纸上画图分析的时候，两个指针的移动有点混乱，结果没做出来，
看了题解，才知道是使用快慢指针。   

**方法： 快慢指针  时间：O(n)  空间：O(1)**

第一步： 定义快慢指针 f, s， 指向数组的第一个元素；   
第二步： 快指针遍历数组， 当`nums[f] == nums[s]`直接跳过；如果`nums[f] != nums[s]`，那么慢指针前移1位，
及 `s = s+1`，并且把快指针指向的数赋值给移动后的慢指针指向的位置 `nums[s] = nums[f]`；    
第三步： 遍历完后， `s+1` 就是移除重复数组的新长度， `return s+1` 即可。  

``` python
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        s = 0
        for f in range(0, len(nums)):
            if nums[f] != nums[s]:
                s += 1
                nums[s] = nums[f]
                
        return s + 1
```


##### LeetCode_189 旋转数组 <a id='LeetCode_189'></a> 
想到了两种解题思路，一种是暴力法，另一种是把数组拆分两段，再把前段拼在后段后面； 

**方法一： 暴力法， 循环嵌套  时间：O(k*n) 空间：O(1)**  

第一步： 获取数组长度，把数组最后一位数保存到临时变量temp中；  
第二步： 把其他元素都往右移动一位；  
第三步： 把最后一位数放到数组第一个位置上；
第四步： 重复以上步骤；

``` python
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        n = len(nums) - 1
        j = 0
        while j < k:
            i = n
            temp = nums[n]
            while i > 0:
                nums[i] = nums[i-1]
                i -= 1
            nums[0] = temp
            j += 1
```
*但！！！！该方法的时间复杂度太高了，在leetcode中是超时的*    
--------------------------------------------------------------
**方法二： 拆分对调  时间：O(n) 空间：O(n)**  

第一步： 计算拆分点，把数组拆分成两半；  
第二步： 前一半 和 后一半 对调；
第三步： 遍历对调后的数组赋值给nums；

``` python
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        split_index = len(nums) - k
        front_arr = nums[:split_index]
        after_arr = nums[split_index:]
        for i, num in enumerate(after_arr + front_arr):
            nums[i] = num
```
*这种方法，好像空间复杂度是O(n)不满足O(1)*   
----------------------------------------------------------------
**方法三： 反转法 时间：O(n) 空间：O(1)**

第一步： k % n 计算要得到结果的值需要移动几次，就是说如果n=3,k=4，那么其实数组元素向右移动3个位置后
又变回原来的数组，然后再向右移动1个位置，也就等同于数组元素只向右移动1位即可；所以 k%n=1，就是实际需要移动的次数；   
第二步： 反转整个数组；  
第三步： 反转前k-1个元素；  
第四步： 反转后面剩下的元素；  

``` python
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        k %= len(nums)
        self.reversal(nums, 0, len(nums)-1)
        self.reversal(nums, 0, k-1)
        self.reversal(nums, k, len(nums)-1)
    
    def reversal(self, nums: List[int], start: int, end: int) -> None:
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1
```

##### LeetCode_21 合并两个有序链表 <a id='LeetCode_21'></a> 
**方法一： 迭代法 时间：O(n) 空间：O(1)**

第一步： 创建一个新节点preHead， 和一个指针prev，指向preHead；  
第二步： 遍历链表，比较l1和l2的值大小，然后把prev.next指向小的节点，并把prev指针指向小的节点，假如当前l1节点比l2小，那么l1就进入下一个节点；  
第三步： 继续进行第二步的操作，直到退出循环；
第四步： prev.next 指向那个没有遍历完的链表的当前节点， 返回preHead.next；  

``` python
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        preHead = ListNode(-1)
        prev = preHead
        
        while l1 and l2:
            if l1.val < l2.val:
                prev.next = l1
                l1 = l1.next
            else:
                prev.next = l2
                l2 = l2.next
            prev = prev.next
            
        prev.next = l1 if l1 is not None else l2
        
        return preHead.next
```
---------------------------------------------------------------------------------
**递归法 时间：O(m+n) 空间：O(m+n)**
递归不太理解啊~~~
```python
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 is None:
            return l2
        elif l2 is None:
            return l1
        elif l1.val < l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2
```

##### LeetCode_1 两数之和 <a id='LeetCode_1'></a> 

**方法一： 暴力法 时间：O(n^2) 空间：O(1)**

``` python
 class Solution:
     def twoSum(self, nums: List[int], target: int) -> List[int]:
         for i in range(0, len(nums)-1):
             for j in range(i+1, len(nums)):
                 if nums[i] + nums[j] == target:
                     return [i, j]
```
-------------------------------------------------------------------------
**方法二： hashMap 时间：O(n) 空间：O(n)**

``` python
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dct = dict()
        for i in range(0, len(nums)):
            val = target - nums[i]
            if val in dct:
                return [dct[val], i]
            
            dct[nums[i]] = i
```


##### LeetCode_283 移动零 <a id='LeetCode_283'></a> 
**方法一: 统计法 时间：O(n) 空间：O(1)**

``` python
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        n = 0
        for i in range(0, len(nums)):
            if nums[i] != 0:
                nums[n] = nums[i]
                n += 1
        
        while n < len(nums):
            nums[n] = 0
            n += 1
```
----------------------------------------------------------------------
**方法二： 快慢指针法 时间：O(n) 空间：O(1)**

``` python
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        s = 0
        for f in range(0, len(nums)):
            if nums[f] != 0:
                nums[s], nums[f] = nums[f], nums[s]
                s += 1
```


##### LeetCode_66 加一 <a id='LeetCode_66'></a> 
**方法一： 数组转数字 时间：O(n) 空间：O(n)** 

``` python
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        length = len(digits)
        sum = 0

        for i in range(0, length):
            sum += 10**(length - i - 1) * digits[i]
        sum = list(str(sum+1))
        return list(  map(int, sum)  )
```
--------------------------------------------------------------------
**方法二： 使用内置函数 时间：O(n) 空间：O(n)**
``` python
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        sum = int(''.join(list(map(str, digits)))) + 1
        return list( map(int, list(str(sum))) )
```
--------------------------------------------------------------------
**方法三： 冒泡法 时间：O(n) 空间：O(1)**
``` python
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        i = len(digits)
        digits[i-1] += 1
        while i > 1:
            i -= 1
            if digits[i] >= 10:
                digits[i] = (digits[i]) % 10
                digits[i-1] += 1
        if digits[0] >= 10:
            digits[0] = digits[0] % 10
            digits.insert(0, 1)
        return digits
```


##### LeetCode_88 合并两个有序数组 <a id='LeetCode_88'></a>  
**方法一：合并后排序 时间：O( (m+n)log(m+n) ) 空间： O(1)**
``` python
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        i = 0
        while i < n:
            nums1[m+i] = nums2[i]
            i += 1
        nums1.sort()
```
--------------------------------------------------------------------------------------
**方法二： 使用切片 时间：O( (m+n)log(m+n) ) 空间： O(1)**
``` python
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        nums1[m:] = nums2[:n]
        nums1.sort()
```
--------------------------------------------------------------------------------------
**方法三： 双指针 前往后  时间：O(n + m)O(n+m) 空间：O(m)**
``` python
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        arr = nums1[:m]
        nums1[:] = []
        i = 0
        j = 0
        while i< m and j < n:
            if arr[i] < nums2[j]:
                nums1.append(arr[i])
                i += 1
            else:
                nums1.append(nums2[j])
                j += 1
        
        if i < m:
            nums1[i+j:] = arr[i:]
        if j < n:
            nums1[i+j:] = nums2[j:]
```

##### LeetCode_42 接雨水 <a id='LeetCode_42'></a>  
**栈 时间：O(n) 空间： O(n)**

``` python
class Solution:
    def trap(self, height: List[int]) -> int:
        stack = []
        area = 0
        for i in range(0, len(height)):
            while stack and height[i] > height[stack[-1]]:
                h = height[stack[-1]]
                stack.pop()
                if not stack:
                    break
                area += (min(height[i], height[stack[-1]]) - h) * (i - stack[-1] - 1)
                
            stack.append(i)
                
        return area
```
 