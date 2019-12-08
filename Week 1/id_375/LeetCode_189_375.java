class Solution {
    public void rotate(int[] nums, int k) {
        if (true) {
            withReverse(nums, k);
            return;
        }
        k = k % nums.length;
        if (k == 0) return;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i+=k) {
            for (int j = 0; j < k && i + j < nums.length; j++) {
                int next = (i + j + k) % nums.length;
                int tmp = temp[j];
                temp[j] = nums[next];
                nums[next] = tmp;
            }
        }
    }
    
    // optimize 1 : less memory
    private void lessMemory(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) return;
        boolean[] done = new boolean[k];
        for (int i = 0; i < k; i++) {
            if (done[i]) {
                continue;
            }
            int j = i;
            int last = nums[j];
            while (true) {
                if (j < k) {
                    if (done[j]) {
                        break;
                    } else {
                        done[j] = true;
                    }
                }
                j = (j + k) % nums.length;
                int temp = nums[j];
                nums[j] = last;
                last = temp;
            }
        }
    }
    
    // optimize 2 : with reverse
    private void withReverse(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
