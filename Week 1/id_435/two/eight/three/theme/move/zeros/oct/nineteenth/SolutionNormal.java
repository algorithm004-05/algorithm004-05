package no.two.eight.three.theme.move.zeros.oct.nineteenth;

public class SolutionNormal {
    public void moveZeroes(int[] nums) {

        // JAVA 中申请primitive类型的数据会自动初始化，
        // 此处的新数组 ans 全为0，省去了后边赋值为0的步骤
        int[] ans = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++)
        {
           if (nums[i] != 0)  {
               ans[j++] = nums[i];
           }
        }
        nums = ans;
    }
}
