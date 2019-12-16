/**
     *
     * @param nums
     * @return
     * //12, 14, 15, 8, 9, 10, 2, 3, 4, 5
     * //2, 3, 6, 5, 7
     * //3, 5, 6,4
     * 1, 如何计算出最长的序列，原来有个maxans存储
     * 2，maxval这个值的作用？保存每一次循环中的最大值
     * dp这个数组存储的是什么？每一个变量的含义，或者说它们的作用是什么？
     * 3，只nums[i] > nums[j]，也就是说如果是3，
     * 这里只考虑了i，如果nums[3] = 5， 那么nums[2] = 4，
     * 【 2, 6，3，4】
     * 这时如果nums[1] = 6，请问，如何能避免把nums[1]算到序列中，
     * 这是如何做到的？
     * 2)[2, 3, 6, 5]这个序列是如何得到3的呢？
     * 记住，dp[i]是存放的是以i为结尾的升序列，
     * 显然，对于dp[3],需要借助
     * 4，最后，请你自己在纸上完成手动循环，
     * 查看每一次循环后的dp[i]和maxans的值，
     * 再来理解这种解法
     */
    /*
    * 6, 5, 7, 3, 9, 4
    * 9如何排除5和3的呢？
    * */
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    //这句并不会像自己想的那样，大于就+1，不是这样的
                    //自己思考陷入的误区，
                    //自己理解为只要nums[i] > nums[j]，就会+1
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
