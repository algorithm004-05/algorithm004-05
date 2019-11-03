class Solution:
    def search(self, nums, target):
        start = 0
        end = len(nums) - 1
        while start <= end:
            mid = (start + end)//2
            if target == nums[mid]: return mid
            # 左半段是有序的
            if nums[start] <= nums[mid]:
            # target 在这段里
                if target >= nums[start] and target < nums[mid]:
                    end = mid - 1
                else:
                    start = mid + 1
                # 右半段是有序的
            else:
                if target > nums[mid] and target <= nums[end]:
                    start = mid + 1
                else:
                    end = mid - 1
        return -1
if __name__ == '__main__':
    s =Solution()
    nums = [4,5,6,7,1,2,3]
    print(s.search(nums,3))