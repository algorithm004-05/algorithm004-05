# @author:leacoder
# @des:   暴力循环  两数之和  O(N*N)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for index1,num1 in enumerate(nums):  #两层循环
            for index2,num2 in enumerate(nums[index1+1:]):
                if num1 + num2 == target:
                    return [index1,index1+index2+1]
        return []
            
  
  
# @author:leacoder
# @des:   和固定利用差值diff 两数之和 
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)-1):
            diff = target - nums[i]
            if diff in nums[i+1:]: 
                return [i,nums[i+1:].index(diff)+i+1]
        return []
	

	
	
# @author:leacoder
# @des:   字典模拟哈希两遍哈希 两数之和  O(n)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap={}
        for index,num in enumerate(nums):
            hashmap[num] = index
        # 哈希建立完成再检测
        for i,num in enumerate(nums):
            j = hashmap.get(target - num)   # 在 hashmap 中找 target - num
            if j is not None and i!=j:  # 能够找到 , 并且 不是 本身
                return [i,j]



# @author:leacoder
# @des:   字典模拟哈希一遍哈希 两数之和  O(n)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap={}
        # 边建立遍检测已建立部分是否存在， 有就立即返回
        for i,num in enumerate(nums):
            # hashmap[num] = i # 先存会有问题 
            j = hashmap.get(target - num)   # 在 hashmap 中找 target - num
            if j is not None and i!=j:  # 能够找到 , 并且 不是 本身
                return [i,j]
            hashmap[num] = i # 解决list中有重复值或target-num=num的情况 例如 [3,3] 6