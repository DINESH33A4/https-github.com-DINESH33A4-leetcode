class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] i : dp)
            Arrays.fill(i, -1);
        return helper(0, 1, fee, prices, dp);
    }
    private static int helper(int i, int buy, int fee, int[] prices, int[][] dp){
        if(i==prices.length)
            return 0;
        if(dp[i][buy] != -1)
            return dp[i][buy];
        if(buy == 1){
            return dp[i][buy] = Math.max(-prices[i] - fee + helper(i+1, 0, fee, prices, dp), helper(i+1, 1, fee, prices, dp));
        }
        else{
            return dp[i][buy] = Math.max(prices[i] + helper(i+1, 1, fee, prices, dp), helper(i+1, 0, fee, prices, dp));
        }
    }
}