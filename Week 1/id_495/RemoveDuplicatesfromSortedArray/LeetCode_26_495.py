#!/anaconda3/bin/python

class LeetCode_26_495(object):

  @staticmethod
  def removeDuplicates(nums):
    """
    自己看的话，完全想不出来这个解法
    """
    if len(nums) <= 1:
      return len(nums)
    slow = 0
    for i in range(1, len(nums)):
      if nums[i] != nums[slow]:
        slow += 1
        nums[slow] = nums[i]
    return slow + 1

if __name__ == '__main__':
    print(LeetCode_26_495.removeDuplicates([1,2,2,3,3,4,5]))
