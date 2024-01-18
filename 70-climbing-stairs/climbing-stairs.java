class Solution {
    public int climbStairs(int n) {
        int a = 1;
        int b = 2;
        int c = a + b;
        while(--n > 0){
            c = a + b;
            a = b;
            b = c;
        }   
        return a;
    }
}