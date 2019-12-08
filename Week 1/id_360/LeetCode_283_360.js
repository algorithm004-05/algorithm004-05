var moveZeroes = function(nums) {
    let j = 0
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
            nums[j] = nums[i]
            if (i != j) {
                nums[i] = 0
            }
            j++
        }
    }
};
