class LeetCode_55_495 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[] {3,2,1,0,4}));
    }

    public static boolean canJump(int[] nums) {
        if(nums == null){
            return false;
        }
        //pos表示需要到达的位置
        int pos = nums.length - 1;
        for (int i = nums.length - 2 ; i >= 0 ; i--) {
            if(nums[i] + i >= pos){
                pos = i;
            }

        }
        return pos == 0;

    }
}
