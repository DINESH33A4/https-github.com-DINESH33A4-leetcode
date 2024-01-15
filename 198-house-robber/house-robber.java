class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums.length-1, dp, nums);
    }
    private static int helper(int i, int[] dp, int[] nums){
        if(i==0){
            return nums[0];
        }
        if(i<0)
            return 0;
        if(dp[i] != -1) 
            return dp[i];
        int take = nums[i] + helper(i-2, dp, nums);
        int notTake = helper(i-1, dp, nums);
        return dp[i] = Math.max(take, notTake);
    }
}