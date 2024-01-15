class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int[][] dp = new int[n+1][2];
        int[] curr = new int[2];
        int[] front = new int[2];
        for(int i = n-1; i>=0; i--){
            curr = new int[2];
            curr[0] = Math.max(prices[i] + front[1], front[0]);
            curr[1] = Math.max(-prices[i] + front[0], front[1]);
            front  = curr;
        }
        return curr[1];
    }
    //    for(int[] i : dp)
    //         Arrays.fill(i, -1);
    //     return helper(0, 1, prices, dp);
    // }   
    // private static int helper(int i, int buy, int[] prices, int[][] dp){
    //     if(i==prices.length)
    //         return 0;
    //     if(dp[i][buy]!=-1)
    //         return dp[i][buy];
    //     if(buy == 1){
    //         return dp[i][buy] = Math.max(-prices[i] + helper(i+1, 0, prices, dp), 
    //                                                   helper(i+1, 1, prices, dp));
    //     }
    //     else{
    //         return dp[i][buy] = Math.max(prices[i] + helper(i+1, 1, prices, dp),                                                      helper(i+1, 0, prices, dp));
    //     }
    // }

}