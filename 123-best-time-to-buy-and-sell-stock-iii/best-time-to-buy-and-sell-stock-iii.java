class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][4];
        for(int i = n-1; i>=0; i--){
            for(int k = 1; k<4; k++){
                dp[i][0][k] = Math.max(prices[i] + dp[i+1][1][k], dp[i+1][0][k]);
                dp[i][1][k] = Math.max(-prices[i] + dp[i+1][0][k-1], dp[i+1][1][k]);
            }
        }
        return dp[0][1][3];
        }
    //    for(int[][] i : dp)
    //         for(int[] j : i)
    //             Arrays.fill(j, -1);
    //     return helper(0, 1, 3, prices, dp);
    // }   
    // private static int helper(int i, int buy, int k, int[] prices, int[][][] dp){
    //     if(i==prices.length || k == 0)
    //         return 0;
    //     if(dp[i][buy][k]!=-1)
    //         return dp[i][buy][k];
    //     if(buy == 1){
    //         return dp[i][buy][k] = Math.max(-prices[i] + helper(i+1, 0, k-1, prices, dp), 
    //                                                   helper(i+1, 1, k, prices, dp));
    //     }
    //     else{
    //         return dp[i][buy][k] = Math.max(prices[i] + helper(i+1, 1, k, prices, dp),                                                    helper(i+1, 0, k, prices, dp));
    //     }
    // }

}