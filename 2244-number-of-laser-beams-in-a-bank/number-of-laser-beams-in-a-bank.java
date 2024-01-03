class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int curr = 0;
        int ans = 0;
        for(String i : bank){
            for(int j=0; j<i.length(); j++){
                if(i.charAt(j) == '1')
                    curr++;
            }
            if(curr == 0)
                continue;
            if(prev == 0)
                prev = curr;
            else{
                ans += prev * curr;
                prev = curr;
            }
            curr = 0;
        }
        return ans;
        
    }
}