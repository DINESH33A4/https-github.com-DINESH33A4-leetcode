class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i : nums)
            sum+= i;
        if(sum-target<0 || (sum-target)%2==1)
            return 0;
        int tar = (sum-target)/2;
        int n = nums.length;
        int[][] dp = new int[n][tar+1];

        if(nums[0] == 0)
            dp[0][0] = 2;
        else
            dp[0][0] = 1;
        if(nums[0] <=  tar && nums[0] != 0)
            dp[0][nums[0]] = 1;
        
        for(int i = 1; i<n; i++){
            for(int j = 0; j<=tar; j++){
                int notTake = dp[i-1][j];
                int take = 0;
                if(nums[i] <= j)
                    take = dp[i-1][j - nums[i]];
                dp[i][j] = take+notTake;
            }
        }
        return dp[n-1][tar];
    }
    //     return helper(nums, 0, 0, target);
    // }

    // private int helper(int[] nums, int index, int curSum, int target) {
    //     if (index == nums.length) {
    //         if (curSum == target) {
    //             return 1; 
    //         } else {
    //             return 0; 
    //         }
    //     }
        
    //     int left = helper(nums, index + 1, curSum + nums[index], target); 
    //     int right = helper(nums, index + 1, curSum - nums[index], target);
    //     return left + right; 
    // }
}