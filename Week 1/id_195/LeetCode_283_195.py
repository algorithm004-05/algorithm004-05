class Solution:
    def moveZeroes(self, nums):
        return self.moveZeroes_1(nums)

    def moveZeroes_1(self, nums):
        zero_ptr = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[zero_ptr], nums[i] = nums[i], nums[zero_ptr]
                zero_ptr += 1
        return nums

    def moveZeroes_2(self, nums):
        nums_new = [0] * len(nums)
        head = 0
        tail = len(nums) - 1
        for i in range(len(nums)):
            if nums[i] == 0:
                nums_new[tail] = nums[i]
                tail -= 1
            else:
                nums_new[head] = nums[i]
                head += 1
        return nums_new
if __name__ == '__main__':
    solve = Solution()
    testCase = [1, 0, 3, 5, 0, 0, 10]
    print(solve.moveZeroes_2(testCase))