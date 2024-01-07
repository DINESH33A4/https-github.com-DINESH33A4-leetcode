class Solution {
     //   Bottom Up
    static int helper(int arr[]){
        int n = arr.length;

        ArrayList<HashMap<Long,Long>> dp = new ArrayList<>();
        long ans = 0;

        for(int i=0; i<n; i++){
            HashMap<Long,Long> map = new HashMap<>();
            dp.add(map);
            for(int j=0; j<i; j++){
                long diff = ((long)arr[i]-(long)arr[j]);
                HashMap<Long,Long> map1 = dp.get(j);
                if(map1.containsKey(diff)){
                    ans = ans+map1.get(diff);
                }
                map.put(diff,map.getOrDefault(diff,(long)0)+map1.getOrDefault(diff,(long)0)+1);
            }
        }
        return (int)ans;
    }
 
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n<3) return 0;
        return helper(nums);
    }
}