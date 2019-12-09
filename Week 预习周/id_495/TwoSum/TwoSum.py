#!/anaconda3/bin/python
# -*- coding: utf-8 -*-

class TwoSum(object):

    def twoSum(self, nums, target):
        """
        执行时间反而没有暴力法快
        """
        d = {}
        for i, num in enumerate(nums):
            if target - num in d:
                return [d[target - num],i]
            d[num] = i
        raise Exception("failed")

if __name__ == '__main__':
    print(TwoSum().twoSum([1,2,3,4,5],5))
