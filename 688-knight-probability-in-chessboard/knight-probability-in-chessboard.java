class Solution {
    // static double out=0.0, in = 0.0;
    public double knightProbability(int n, int k, int row, int colunn) {
        double[][][] dp = new double[n][n][k+1];
        for(double [][] i : dp)
            for(double[] j : i)
                Arrays.fill(j, -1.0);
        return 1.0 - helper(row, colunn, k, n, n, dp);
    }
    private static double helper(int row, int col, int k, int m, int n, double[][][] dp){
        if(row>=n || col>=n || row<0 || col<0)
            return 1.0;
        if(k == 0)
            return 0.0;
        if(dp[row][col][k]!=-1.0)
            return dp[row][col][k];
        // in+=1;
        double left = helper(row-2, col-1, k-1, m, n, dp) ;
        double left1 = helper(row-2, col+1, k-1, m, n, dp);
        double right = helper(row-1, col+2, k-1, m, n, dp);
        double right1 = helper(row-1, col-2, k-1, m, n, dp);
        double down = helper(row+1, col-2, k-1, m, n, dp);
        double down1 = helper(row+1, col+2, k-1, m, n, dp);
        double up = helper(row+2, col-1, k-1, m, n, dp);
        double up1 = helper(row+2, col+1, k-1, m, n, dp);

        return dp[row][col][k] = (left+left1+right+right1+down+down1+up+up1)/8.0;
    }
    
}