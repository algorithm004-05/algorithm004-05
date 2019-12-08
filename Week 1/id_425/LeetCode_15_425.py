class Solution:
    def threeSum(self, nums) :
        nums.sort()
        returnList =[]
        for k in range(len(nums)-2):
            if nums[k]>0:break
            if k>0 and nums[k] == nums[k-1]:continue
            i ,j= k+1,len(nums)-1
            while i < j:
                s = nums[i]+nums[j]+nums[k]
                if s < 0: 
                # 判断如果nums[i] == nums[i+1]则需要继续移动，且该移动不能超过len(nums)
                    i +=1
                    while i < j and nums[i]==nums[i-1]: i+=1
                elif s>0:
                    j -=1
                    while j > i and nums[j]==nums[j+1]: j -=1
                else:
                    print(s)
                    print([nums[k],nums[i],nums[j]])
                    returnList.append([nums[k],nums[i],nums[j]])
                    i+=1
                    j-=1
                    while i < j and nums[i]==nums[i-1]: i+=1
                    while j > i and nums[j]==nums[j+1]: j -=1
        return returnList
if __name__ == "__main__":
    s = Solution()
    nums = [-1,0,1,2,-1,-4]
    List = s.threeSum(nums)
    print('结果',List)