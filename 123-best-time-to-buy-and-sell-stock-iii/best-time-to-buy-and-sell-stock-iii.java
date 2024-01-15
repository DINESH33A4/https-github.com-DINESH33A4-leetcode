class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
       for(int[][] i : dp)
            for(int[] j : i)
                Arrays.fill(j, -1);
        return helper(0, 1, 2, prices, dp);
    }   
    private static int helper(int i, int buy, int k, int[] prices, int[][][] dp){
        if(i==prices.length || k < 0)
            return 0;
        if(dp[i][buy][k]!=-1)
            return dp[i][buy][k];
        if(buy == 1){
            return dp[i][buy][k] = Math.max(-prices[i] + helper(i+1, 0, k-1, prices, dp), 
                                                      helper(i+1, 1, k, prices, dp));
        }
        else{
            return dp[i][buy][k] = Math.max(prices[i] + helper(i+1, 1, k, prices, dp),                                                    helper(i+1, 0, k, prices, dp));
        }
    }

}