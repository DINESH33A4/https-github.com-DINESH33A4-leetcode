class Solution {
    public int minInsertions(String s) {
        StringBuilder one = new StringBuilder(s);
        one = one.reverse();
        int m = s.length();
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        for(int i = 1; i<=m; i++){
            curr = new int[m+1];
            for(int j = 1; j<=m; j++){
                if(one.charAt(j-1) == s.charAt(i-1)){
                    curr[j] = prev[j-1] + 1;
                }
                else
                    curr[j] = Math.max(curr[j-1], prev[j]);
            }
            prev = curr;
        }
        int x = curr[m];
        return m-x;
    }
}