class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for(int i[] : dp)
            Arrays.fill(i, -1);
        return helper(m-1, n-1, word1, word2, dp);
    }
    private static int helper(int i, int j, String s, String t, int[][] dp){
        if(i<0)
            return j+1;
        if(j<0)
            return i+1;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(s.charAt(i) == t.charAt(j))
            return dp[i][j] = helper(i-1, j-1, s, t, dp);
        else
            return dp[i][j] = 1 + Math.min(helper(i-1, j, s, t, dp), Math.min(helper(i, j-1, s, t, dp), helper(i-1, j-1, s, t, dp)));
    }
}