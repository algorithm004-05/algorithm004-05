#!/anaconda3/bin/python
# -*- coding: utf-8 -*-

class Solution(object):

    @staticmethod
    def search(nums, target):
        start,end = 0, len(nums) - 1
        while start + 1 < end:
            mid = start + (end - start)//2
            if nums[mid] == target:
                return True
            if nums[start] < nums[mid]:
                if nums[start] <= target <= nums[mid]:
                    end = mid
                else:
                    start = mid
            elif nums[start] > nums[mid]:
                if nums[mid] <= target <= nums[end]:
                    start = mid
                else:
                    end = mid
            else:
                start += 1
        if nums[start] == target:
            return True
        if nums[end] == target:
            return True
        return False

if __name__ == '__main__':
    print(Solution.search([13,24,0,52,33,66],0))
