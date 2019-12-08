# 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
#
# 示例 1:
#
# 输入: [1,2,3,4,5,6,7] 和 k = 3
# 输出: [5,6,7,1,2,3,4]
# 解释:
# 向右旋转 1 步: [7,1,2,3,4,5,6]
# 向右旋转 2 步: [6,7,1,2,3,4,5]
# 向右旋转 3 步: [5,6,7,1,2,3,4]
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/rotate-array
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

####   思路1,暴力求解
class Solution:
    def rotate(self,nums:List[int],k:int)->None:
        for i in range(k):
            tmp = nums[-1]  #######  将数组最后一个数值先暂存起来，以免丢失
            for j in range(len(nums),1,-1):   ######## 从后面往前遍历,此行代码出错，说明j的循环遍历的边界一直不清晰，注意下标不要溢出！！！
                nums[j] = nums[j-1]
            nums[0] = tmp

###正确写法
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        for i in range(k):
            tmp = nums[-1]
            for j in range(len(nums) - 1, 0, -1):
                nums[j] = nums[j - 1]
            nums[0] = tmp



####  环状法 ######  这个解法其实还没弄懂，先将别人的代码copy过来，留存学习...
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        size = len(nums)
        k %= size
        count = start = 0 # start是当出现循环时最开始的点
        while count < size:
            target = start
            tmp = nums[start]
            while True:
                target = (target+k)%size
                tmp, nums[target] = nums[target], tmp
                count += 1
                if count>=size or target == start:
                    break    # 次数到了或者出现循环则跳出
            start += 1

######   总结 1. 下标溢出一直存在我写的代码之中，一不小心就越界，