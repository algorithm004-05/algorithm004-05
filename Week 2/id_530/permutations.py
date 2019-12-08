"""
77. Permutations
题目：给定一组不同的整数，返回所有可能的排列。
"""
def permute(self, nums):
    """
    :type nums: List[int]
    :rtype: List[List[int]]
    """
    result=[]

    def permute2(a, l, r):
        if l == r:
            l1=list(a)
            result.append(l1)
        else:
             for i in range(l, r + 1):
                    a[l],a[i]=a[i],a[l]
                    permute2(a, l + 1, r)
                    a[l],a[i]=a[i],a[l]

    permute2(nums,0,len(nums)-1)
    return result
