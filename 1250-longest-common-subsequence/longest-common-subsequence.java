class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for(int[] i : dp)
            Arrays.fill(i, -1);
        return helper(m-1, n-1, text1, text2, dp);
    }
    private static int helper(int m, int n, String t1, String t2, int[][] dp){
        if(m<0||n<0)
            return 0;
        if(dp[m][n] != -1)
            return dp[m][n];
        if(t1.charAt(m)==t2.charAt(n))
            return dp[m][n] = 1 + helper(m-1, n-1, t1, t2, dp);
        else 
            return dp[m][n] = Math.max(helper(m-1, n, t1, t2, dp), helper(m, n-1, t1, t2, dp));
    }
}