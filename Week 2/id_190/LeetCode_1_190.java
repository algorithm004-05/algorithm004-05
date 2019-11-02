/**
 * 两个数的和
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            //判断nums中是否存在与nums[i]的和为target的元素
            int v = target - nums[i];
            if(map.containsKey(v)){
                //如果存在则返回两个数的下标
                return new int[]{map.get(v),i};
            }
            //否则将这个数和下标存入map中
            map.put(nums[i],i);
        }
        //如果没有 返回空
        return null;
    }


}