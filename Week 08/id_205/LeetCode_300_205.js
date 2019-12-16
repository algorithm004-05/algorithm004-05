var lengthOfLIS = function(nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        let dp = [];
        dp[0] = 1;
        let maxans = 1;
        for (let i = 1; i < nums.length; i++) {
            let maxval = 0;
            for (let j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
};
