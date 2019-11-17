class LeetCode_45_495 {

    public static void main(String[] args) {
        System.out.println(jump(new int[] {2,3,1,1,4}));
    }

    public static int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int reach = 0;
        int nextreach = nums[0];
        int step = 0;
        for(int i = 0;i<nums.length;i++){
            nextreach = Math.max(i+nums[i],nextreach);
            if(nextreach >= nums.length-1) return (step+1);
            if(i == reach){
                step++;
                reach = nextreach;
            }
        }
        return step;
    }
}
