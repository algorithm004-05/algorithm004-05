class LeetCode_153_495 {
    public static void main(String[] args) {
        System.out.println(findMin(new int[] {4,5,6,7,0,1,2,3}));
    }

    public static int findMin(int[] nums) {
        int len=nums.length;
        int p1=0,p2=len-1;
        if(nums[0]<=nums[len-1])return nums[0];
        while(nums[p1]>nums[p2]){
            if(p2==0)return nums[0];
            p2--;

        }
        return nums[p2+1];
    }
}
