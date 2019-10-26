var removeDuplicates = function (nums) {
  let point = 1
  for (let i = 1; i < nums.length; i++) {
    if (nums[i] !== nums[i - 1]) {
      nums[point++] = nums[i]
    }
  }
  return point
};