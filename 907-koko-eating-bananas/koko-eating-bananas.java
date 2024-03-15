class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long sum = 0;
        int min = Integer.MAX_VALUE, max = 0;
        for(int i : piles){
            sum += i;
            max = Math.max(i, max);
            min = Math.min(i, min);
        }
        // if(max == min)
        //     return ((int)(min / h)) + ((min % h == 0)?0:1);
        Arrays.sort(piles);
        for (int i = 0; i < piles.length / 2; i++) {
            int temp = piles[i];
            piles[i] = piles[piles.length - 1 - i];
            piles[piles.length - 1 - i] = temp;
        }
        int low = (int)Math.ceil(Math.min(min, (int)(sum/h)));
        if(low == 0)
            low++;
        int high = max, ans;
        ans = max;
        // System.out.println(low + " "+high);
        while(low <= high){
            int mid = (low + high) / 2;
            if(check(piles, mid, h)){
                ans = Math.min(mid, ans);
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    private static boolean check(int [] piles, int k, int h)
    {
        for(int i = 0; i<piles.length; i++){
            int val = (int)(piles[i] / k);
            if(piles[i] % k != 0)
                val++;
            h -= val;
            if(h<0)
                return false;
        }
        return true;
    }
}