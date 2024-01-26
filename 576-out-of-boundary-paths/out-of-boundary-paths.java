class Solution {
    static int mod = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove+1];
        for(int [][] i : dp)
            for(int[] j : i)
            Arrays.fill(j, -1);
        return helper(startRow, startColumn, maxMove, m, n, dp);
    }
    private static int helper(int row, int col, int maxMove, int m, int n, int[][][] dp){
        if(row>=m || col>=n || row<0 || col<0)
            return 1;
        if(maxMove == 0)
            return 0;
        if(dp[row][col][maxMove]!=-1)
            return dp[row][col][maxMove];
        
        int left = helper(row, col-1, maxMove-1, m, n, dp)%mod;
        int right = helper(row, col+1, maxMove-1, m, n, dp)%mod;
        int down = helper(row-1, col, maxMove-1, m, n, dp)%mod;
        int up = helper(row+1, col, maxMove-1, m, n, dp)%mod;

        return dp[row][col][maxMove] = ((left+right)%mod +(down+up)%mod)%mod;
    }
}