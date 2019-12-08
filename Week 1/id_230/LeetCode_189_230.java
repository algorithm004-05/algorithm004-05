 //2,计算机的位左移右移
    public static void rotate(int[] nums, int k) {
        int index = k % nums.length;
        if (nums.length <= 1) {
            return;
        }
        int[] newNum = new int[nums.length + index];
        //1,创建新的数组
        for (int i = 0; i < index; i++) {
            newNum[i] = 0;
        }
        for (int i = index; i < nums.length + index; i++) {
            newNum[i] = nums[i - index];
        }
        System.out.println(Arrays.toString(newNum));
        //2,将“溢出”的部分补到对应位置
        for (int i = 0; i < index; i++) {
            int tmp = newNum[i];
            newNum[i] = newNum[newNum.length - index + i];
            newNum[newNum.length - index + i] = tmp;
        }
        System.out.println(Arrays.toString(newNum));
        //3,用新的替换旧的
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNum[i];
        }
    }
