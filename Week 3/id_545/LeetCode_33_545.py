## 搜索旋转排序数组
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        lo, hi = 0, len(nums)

        while lo < hi:
            mid = (lo + hi) >> 1
            
            if (nums[mid] < nums[0]) == ( target < nums[0]):
                if (nums[mid] < target):
                    lo = mid + 1
                elif (nums[mid] > target):
                    hi = mid
                else:
                    return mid
            elif target < nums[0]:
                lo = mid + 1
            else:
                hi = mid

        return -1