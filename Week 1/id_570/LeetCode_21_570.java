class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        // 替换位
        int k = 0;
        // 非重复元素
        int j = 0;
        for(int i=0; i< nums.length; i++) {
            if(i==0){
                continue;
            }
            if (nums[i] == nums[i-1]) {
                if(k == 0) {
                    k = i;
                }
                continue;
            } else if (k != 0) {
                nums[k] = nums[i];
                k++;
            } else {
                continue;
            }
        }
        if(k == 0) {
            return nums.length
        } else {
            return k - 1;
        }
    }
}