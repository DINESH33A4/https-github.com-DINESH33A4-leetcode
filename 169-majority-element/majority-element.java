class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length / 2 + 1;
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i : nums){
            m.put(i, m.getOrDefault(i, 0) + 1);
            if(m.get(i) >= n)
                return i;    
        }
        return 1;
    }
}