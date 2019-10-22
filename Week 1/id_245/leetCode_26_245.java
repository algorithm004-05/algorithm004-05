public int removeDuplicates(int[] nums) {
        int y=0;
        for(int x=1; x<nums.length;x++){
            if(nums[x] != nums[y]) {
                y++;
                nums[y] = nums[x];
            }
        }
        return y+1;
    }
