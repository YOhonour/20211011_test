package days;

public class Day09 {//用状态数组存
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1] <= 0) dp[i] = nums[i];
            else dp[i] = (dp[i-1] + nums[i]);
        }
        int max = dp[0];
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }
    //用两个变量存，结果好像差不多
    public int maxSubArray2(int[] nums) {
        int dp_n_1 = nums[0],dp_n;
        int result = dp_n_1;
        for (int i = 1; i < nums.length; i++) {
            if (dp_n_1 <= 0) dp_n = nums[i];
            else dp_n = (dp_n_1 + nums[i]);
            if (result < dp_n) result = dp_n;
            dp_n_1 = dp_n;
        }
        return result;
    }
    public int maxValue(int[][] grid){
        int rows = grid.length;
        int column = grid[0].length;
        for (int n = 1; n < rows; n++){
            grid[n][0] = grid[n][0]+grid[n-1][0];
        }
        for (int m = 1; m < column; m++){
            grid[0][m] = grid[0][m]+grid[0][m-1];
        }
        for (int n = 1; n < rows; n++) {
            for (int m = 1; m < column; m++) {
                grid[n][m] = Math.max(grid[n][m-1],grid[n-1][m])+grid[n][m];
            }
        }
        return grid[rows-1][column-1];
    }
}
