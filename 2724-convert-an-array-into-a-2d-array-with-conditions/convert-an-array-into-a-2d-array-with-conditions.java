class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<n; i++){
            boolean flag = false;
            int size = ans.size();
            int k = 0;
            while(k<size){
                if(!ans.get(k).contains(nums[i])){
                    ans.get(k).add(nums[i]);
                    flag = true;
                    break;
                }
                else{
                    k++;
                }
            }
            if(flag == false){
                ans.add(new ArrayList<>());
                ans.get(ans.size()-1).add(nums[i]);
            }
        }
        return ans;
    }
}