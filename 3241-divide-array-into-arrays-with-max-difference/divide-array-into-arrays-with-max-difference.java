class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] ans = new int[n/3][3];
        int a = 0;
        for(int i = 0; i<n; i+=3){
            if(Math.abs(nums[i] - nums[i+1]) > k ||   
               Math.abs(nums[i] - nums[i+2]) > k || 
               Math.abs(nums[i+2] - nums[i+1]) > k )
                return new int[0][0];
            else
                ans[a++] = new int[]{nums[i], nums[i+1], nums[i+2]};
        }
        return ans;
    }
}