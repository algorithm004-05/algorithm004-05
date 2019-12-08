//6,move-zeroes
    /*
     * 参考之前老师讲的题解，其中一个解法就是
     * 每有一个0，count就加1，之后的元素移动count次
     * 然后，count数表示0的个数，在数组最后替换
     * */
    public static void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
                continue;
            }
            nums[i - count] = nums[i];
        }
        for (int i = nums.length - count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
