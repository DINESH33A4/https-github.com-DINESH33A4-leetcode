class Solution {
    public int minFallingPathSum(int[][] matrix) {
        for(int i = 1; i<matrix.length; i++)
            for(int j = 0; j<matrix.length; j++){
                int a = matrix[i-1][j];
                if(j>0)
                    a = Math.min(a, matrix[i-1][j-1]);
                if(j<matrix.length-1)
                    a = Math.min(a, matrix[i-1][j+1]);
                matrix[i][j] += a;
            }
        int ans = Integer.MAX_VALUE;
        for(int i: matrix[matrix.length-1])
            ans = Math.min(ans, i);
        return ans;
    }
}