public static  void moveZeroes(int[] nums) {
        int y = 0;
        for(int x=0; x<nums.length; x++){
            if(nums[x] != 0){
                nums[y] = nums[x];
                if(y != x){
                    nums[x] = 0;
                }
                y++;
            }
        }
    }
