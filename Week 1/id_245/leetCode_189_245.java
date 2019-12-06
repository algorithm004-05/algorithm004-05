public void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for(int x=0; x<nums.length; x++){
            a[(x+k) % nums.length] = nums[x];
        }
        for(int x=0; x<nums.length; x++) {
            nums[x] = a[x];
        }
    }
