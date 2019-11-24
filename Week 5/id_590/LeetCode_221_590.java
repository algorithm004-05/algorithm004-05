package homework.week5;

//https://leetcode-cn.com/problems/maximal-square/
public class LeetCode_221_590 {
    public int maximalSquare(char[][] matrix) {
       //创建一个记录最大边长的变量
        int max_length = 0;

        //考虑每一个为1的元素,如果以元素值当成从该点往左上方构建正方形的长度
        //则其左方,上方,斜上方三个点的最小值+1可以形成一个该点往左上方构建的最大正方形
        int m = matrix.length, n = m>0?matrix[0].length:0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0 && j != 0 && matrix[i][j] == '1') {
                    matrix[i][j] = (char) ((Math.min(Math.min((int) matrix[i - 1][j], (int) matrix[i - 1][j - 1]), (int) matrix[i][j - 1])) + 1);
                    }
                int temp = matrix[i][j] - 48;
                if (temp > max_length) {
                    max_length = temp;
                }
            }
        }
        return max_length * max_length;
    }
}
