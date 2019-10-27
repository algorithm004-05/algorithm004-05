# 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
#
# 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。


####  思路1，暴力求解法
class Solution:
    def twoSum(self,nums:List[int],target:int)->List[int]:
        for i in range(0,len(nums)-1):
            for j in range(1,len(nums)):
                if nums[i]+nums[j] == target:
                    return i,j



#######
#####  思路2 哈希表求解，代码学习中....

def twoSum(nums, target):
    hashmap={}
    for ind,num in enumerate(nums):
        hashmap[num] = ind
    for i,num in enumerate(nums):
        j = hashmap.get(target - num)
        if j is not None and i!=j:
            return [i,j]

def  twoSum(nums,target):
    hashmap ={}
    for ind,num in enumerate(nums):  ###### 第一步 将下标及值形成键值对，存入hashmap中，值为键，下标为值
        hashmap[num] = ind
    for i,num in enumerate(nums):
        j = hashmap.get(target - num)   ####  hashmap.get(k) 函数，获得hashmap[k]的值，若没有，返回None，
        if j is not None and i != j:   #####  判断当 i ！= j 时，不重复，返会i,j 即为要求的下标
            return [i,j]

def  twoSum(nums,target):
     hashmap = {}
     for ind,num in enumerate(nums):
         hashmap[num] = ind
     for i, num in enumerate(nums):
         j = hashmap.get(target-num)
         if j is not None and j != i:
             return [i,j]

def  twoSum(nums,target):
    hashmap ={}
    for ind,num in enumerate(nums):
        hashmap[num] = ind
    for i, num in enumerate(nums):
        j = hashmap.get(target-num)
        if j is not None and j !=i:
            retur [i,j]