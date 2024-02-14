class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n  = nums.length;
        int[] ans = new int[n];
        int a = 0;
        int b = 1;
        boolean positive = false;
        for(int i = 0; i<n; i++){
            if(nums[i] > 0){
                ans[a] = nums[i];
                a+=2;
            }
            else{
                ans[b] = nums[i];
                b+=2;
            }
        }
        return ans;
    }
}