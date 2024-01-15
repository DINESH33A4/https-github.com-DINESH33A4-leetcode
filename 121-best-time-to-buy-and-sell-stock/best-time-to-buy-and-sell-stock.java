import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int[] max = new int[prices.length];
        int m = 0;
        for(int i = prices.length-1; i>=0; i--){
            m = Math.max(m, prices[i]);
            max[i] = m;
        }
        for(int i= 0; i<prices.length; i++){
            ans = Math.max(ans, max[i]-prices[i]);
        }
        return ans;

    }
}