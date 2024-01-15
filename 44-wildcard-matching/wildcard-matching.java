class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        int j = 0;
        while(j<n && p.charAt(j) == '*')
            dp[0][++j] = true;
            
        for(int i = 1; i<=m; i++){
            for(j = 1; j<=n; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                    dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1) == '*')
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
            }
        }
        return dp[m][n];
    }
    //     return helper(m-1, n-1, s, p, dp);
    // }
    // private static boolean helper(int i, int j, String s, String p, boolean[][] dp){
    //     if(i<0&&j<0)
    //         return true;
    //     if(i<0 && j>=0){
    //         for(int jj = 0; jj<=j; jj++)
    //             if(p.charAt(jj) != '*')
    //                 return false;
    //         return true;
    //     }
    //     if(i>=0 && j<0)
    //         return false;
    //     if(dp[i][j])
    //         return true;
    //     if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
    //         return dp[i][j] = helper(i-1, j-1, s, p, dp);
    //     }
    //     if(p.charAt(j) == '*'){
    //         return dp[i][j] = helper(i-1, j, s, p, dp) || helper(i, j-1, s, p, dp)  ;
    //     }
    //     return false;
    // }
}