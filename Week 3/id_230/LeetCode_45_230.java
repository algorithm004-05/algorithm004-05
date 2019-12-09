 /*
    * 这题自己没有做出来，看了题解，
    * 解法的思路就是找每一能跳最远的距离m，与当前位置之间
    * 哪一个位置还能跳更远
    * */
    public static int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if( i == end){ //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
