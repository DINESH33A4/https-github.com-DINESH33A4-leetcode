class Solution {
    public long largestPerimeter(int[] nums) {
        long ans = 0;
        Arrays.sort(nums);
        long prefixSum = nums[0] + nums[1];
        int cnt = 2;
        for(int i = 2; i<nums.length; i++){
            if(nums[i] < prefixSum){
                prefixSum += nums[i];
                cnt++;
                ans = prefixSum;
            }
            else
                prefixSum += nums[i];
        }
        if(cnt == 2)
            return -1;
        return ans;
    }
}