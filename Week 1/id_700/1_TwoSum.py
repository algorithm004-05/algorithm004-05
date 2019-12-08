# 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
#
# 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/two-sum
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

####  思路1. 暴力求解，双重循环，超出时间限制

class Solution:
    def twoSum(self,nums:List[int],target:int)->List[int]:
        for i in range(len(nums)-1):
            for j in range(1,len(nums)):
                if nums[i] + nums[j] == target :
                    return i,j


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)-1):
            j =i+1
            while j < len(nums):
                if nums[i] +nums[j] ==target:
                    return i,j




#####  思路2 哈希表求解，代码学习中....

def twoSum(nums, target):
    hashmap={}
    for ind,num in enumerate(nums):
        hashmap[num] = ind
    for i,num in enumerate(nums):
        j = hashmap.get(target - num)
        if j is not None and i!=j:
            return [i,j]

#####   参考作者：lao-la-rou-yue-jiao-yue-xiang
#######   链接：https://leetcode-cn.com/problems/two-sum/solution/xiao-bai-pythonji-chong-jie-fa-by-lao-la-rou-yue-j/
