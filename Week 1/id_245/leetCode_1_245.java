public int[] twoSumTest(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int x=0; x<nums.length; x++){
            if(map.containsKey(target-nums[x])){
                return new int[] {map.get(target-nums[x]),x};
            }
            map.put(nums[x],x);
        }
        return null;
    }
