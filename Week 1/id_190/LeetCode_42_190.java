class Solution {
    public int trap(int[] height) {
        //两侧的最大值
        int leftMax = 0 ;
        int rightMax = 0;
        //两侧的指针
        int left = 0 ;
        int right =  height.length-1;
        //最后的结果
        int sum = 0 ;
        while(left < right){
            //当左侧的高度小于右侧时 
            if(height[left] < height[right]){
                //当前高度大于最大高度 
                if(height[left] > leftMax){
                    //最大高度为当前高度
                    leftMax = height[left];
                }else{
                    //否则 增量为最大高度减当前高度
                    sum += leftMax - height[left];
                }
                left++; //指针右移
            }else{ //右侧高度大于等于左侧高度 逻辑相反
                if(height[right] > rightMax){
                    rightMax = height[right];
                }else{
                    sum += rightMax - height[right];
                }
                right--;
            }  
        }
        return sum;
    }
}
