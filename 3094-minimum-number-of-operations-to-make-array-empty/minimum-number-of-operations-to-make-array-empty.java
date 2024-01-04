class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i : nums){
            if(!m.containsKey(i))
                m.put(i, 0);
            m.put(i, m.get(i)+1);
        }
        int ans = 0;
        // System.out.println(m);
        for(int i : m.keySet()){
            int a = m.get(i);

            if(a==1)
                return -1;
            int cnt = 0;
            if(a%3 == 0){
                cnt += a/3;
            }  
            else if(a%3 == 1){
                cnt += a/3;
                cnt++;
            }
            else if(a%3 == 2){
                cnt += a/3 + 1;
            }
            ans += cnt;
        }
        return ans;

    }
    // private static boolean chekc(int i){
    //     if(i==0)
    //         return true;
        
    // }
}