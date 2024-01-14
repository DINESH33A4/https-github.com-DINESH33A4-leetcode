class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m<n)
            return 0;
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];
        prev[0] = curr[0] = 1;
        for(int i = 1; i<=m; i++){
            curr = new int[n+1];
            curr[0] = 1;
            for(int j = 1; j<=n; j++){
                if(s.charAt(i-1) == t.charAt(j-1))
                    curr[j] = prev[j-1] + prev[j];
                else
                    curr[j] = prev[j];
            }
            prev = curr;
        }
        return curr[n];

    }
    //     int[][] dp = new int[m+1][n+1];
    //     for(int i = 0; i<=m; i++)
    //         dp[i][0] = 1;
    //     for(int i = 1; i<=m; i++){
    //         for(int j = 1; j<=n; j++){
    //             if(s.charAt(i-1) == t.charAt(j-1))
    //                 dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
    //             else
    //                 dp[i][j] = dp[i-1][j];
    //         }
    //     }
    //     return dp[m][n];
    // }

    //     for(int[] i : dp)
    //         Arrays.fill(i, -1);
    //     return helper(m, n, s, t, dp);
    // }
    // private static int helper(int i, int j, String s, String t, int[][] dp){
    //     if(j==0)
    //         return 1;
    //     if(i==0)
    //         return 0;
    //     if(dp[i][j] != -1)
    //         return dp[i][j];
    //     if(s.charAt(i-1) == t.charAt(j-1)){
    //         return dp[i][j] = helper(i-1, j-1, s, t, dp) + helper(i-1, j, s, t, dp);
    //     }
    //     else
    //         return dp[i][j] = helper(i-1, j, s, t, dp);
    // }
}