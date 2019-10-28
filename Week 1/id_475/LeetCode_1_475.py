# 两数之和

# 法一：暴力法: 二重循环，时间复杂度为O(n^2)
class Solution():
    def twoSum(self,nums,target):
        for i in range(len(nums)):
            j = target - nums[i]
            for x in range(i+1, len(nums)):
                if nums[x] == j:
                    return [i,x]

# 法二：哈希表法：用字典模拟哈希表，字典的key值记录target - nums[i],value值记录索引i,时间复杂度为O(n)
class Solution():
    def twoSum(self,nums,target):
        if len(nums) <= 1:
            return 
        else:
            buff_dict = {}
            for i in range(len(nums)):
                if nums[i] in buff_dict:
                    return [buff_dict[nums[i]], i]
                else:
                    buff_dict[target - nums[i]] = i
                    