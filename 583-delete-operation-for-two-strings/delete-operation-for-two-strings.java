class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];
        for(int i = 1; i<=m; i++){
            curr = new int[n+1];
            for(int j = 1; j<=n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }
                else
                    curr[j] = Math.max(curr[j-1], prev[j]);
            }
            prev = curr;
        }
        return (m+n) - (curr[n]*2);
    }
}