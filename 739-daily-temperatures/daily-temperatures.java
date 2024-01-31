class Solution {
    class pair{
        int idx, temp;
        public pair(int i, int t){
            this.idx = i;
            this.temp = t;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<pair> stk = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i = 0; i<n; i++){
            while(!stk.isEmpty() && stk.peek().temp < temperatures[i]){
                pair curr = stk.pop();
                ans[curr.idx] = (i-curr.idx);
            }
            stk.push(new pair(i,temperatures[i]));
        }
        return ans;
    }
}