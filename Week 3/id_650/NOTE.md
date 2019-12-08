# 第三周总结-二分查找无序位置

`[4, 5, 6, 0, 2, 3]`

如上一个数组，如果想用二分查找出开始无序的`index`，

1. 首先先把二分查找模板写出来：

```python

left, right = 0, len(array) - 1
while left <= right:
    mid = (left + right) // 2
    if array[mid] == target:
        return mid
    elif array[mid] < target:
        left = mid + 1
    else:
        right = mid - 1
```

2. 找到条件判断点

模板的判断是mid是否等于具体的某个值，也就是我们要查找的值，但是这里需要查临界点。
看最上面的那个数组，0是临界点，刚开始想这个位置有啥特殊的，满足什么条件，先是想到了
**0这个位置是小于他的前一位，也小于他的后一位**

3. left右移和right左移条件

如果mid这个位置不满足2中的条件，那么他如果比left（也就是最左边）的值大，则left要往右移。
因为如果存在这个无序点，最左边的值肯定比临界点（因为临界点其实是数据的最小值）的值大，有因为数组半有序，所以只要不到临界点
那么mid的值就比最左边大，也就是说临界点在mid的右边。**如果临界点在mid左边，那么mid肯定要比最左边的值小**

4. 这些条件找清楚了，把模板一改代码也就出来了。

```python
def search_rotated(nums):

    left, right = 0, len(nums) - 1
    while right - left >= 2:
        mid = (left + right) // 2

        if nums[mid-1] > nums[mid] and nums[mid] < nums[mid+1]:
            return mid
        elif nums[mid] > nums[left]:
            left = mid
        else:
            right = mid - 1

    if right - left == 0:
        return -1
    if right - left == 1:
        if nums[left] > nums[right]:
            return right
        return -1
```

上面代码是第一版，因为有判断mid的前一个和后一个（mid-1, mid+1），所以导致必须left和right
差不能小于2（最少三个元素），代码比较复杂一些。

5. 优化

基于上面的条件： **0这个位置是小于他的前一位，也小于他的后一位**
可以转换为，临界点的上一个元素是大于临界点的（如果没有临界点，数组就单调递增下去了）
所以代码优化为

```python
def search_rotated(nums):
    left, right = 0, len(nums) - 1
    if nums[left] < nums[right]:
                return 0
    while left < right:
        mid = (left + right) // 2
        if nums[mid] > nums[mid+1]:
            return mid+1
        elif nums[mid] > nums[left]:
            left = mid + 1
        else:
            right = mid - 1

    return -1
```
