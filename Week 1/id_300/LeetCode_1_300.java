两数之和：

1.暴力求解
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        throw new RuntimeException("未查找到两数之和="+target);

    }
    
    
2.hash表
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
           if(map.get(nums[i]) != null){
               return new int[]{i,(map).get(nums[i])};
           }else{
               map.put(target-nums[i],i);
           }
        }
        throw new RuntimeException("未查找到两数之和="+target);

    }
}
