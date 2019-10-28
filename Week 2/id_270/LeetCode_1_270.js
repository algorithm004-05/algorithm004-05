let twoSum = function (nums, target) {
  let temp = [];
  let len = nums.length
  for (let i = 0; i < len; i++) {
    let diff = target - nums[i];
    if (temp[dif] !== undefined) {
      return [temp[diff], i];
    }
    temp[nums[i]] = i;
  }
};
