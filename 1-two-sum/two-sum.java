class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(m.containsKey(nums[i])){
                if(nums[i] * 2 == target)
                    return new int[]{m.get(nums[i]), i} ;
            }
            m.put(nums[i], i);
        }
        Arrays.sort(nums);
        int l = 0;
        int h = nums.length-1;
        while(l<h){
            if(nums[l] + nums[h] == target)
                return new int[]{m.get(nums[l]),m.get(nums[h])};
            if(nums[l] + nums[h] < target)
                l++;
            else
                h--;
        }
        return new int[]{0,0};
    }
}